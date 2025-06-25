/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.identifier.supplier.wikidata.query;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.eclipse.chemclipse.logging.core.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QueryStructuralFormula {

	private static final Logger logger = Logger.getLogger(QueryStructuralFormula.class);

	public static String fromName(String name) {

		String select = Wikidata.PROP + Wikidata.RDFS + Wikidata.SKOS + Wikidata.WIKIBASE + Wikidata.BIGDATA + Wikidata.WDT + //
				"SELECT ?item ?itemLabel ?pic\n" + //
				"WHERE {\n" + //
				"  {\n" + //
				"    ?item rdfs:label \"" + name + "\"@en.\n" + //
				"  }\n" + //
				"  UNION\n" + //
				"  {\n" + //
				"    ?item skos:altLabel \"" + name + "\"@en.\n" + //
				"  }\n" + //
				"  ?item wdt:P117 ?pic\n" + //
				"  SERVICE wikibase:label { bd:serviceParam wikibase:language \"en\". }\n" + //
				"}";
		return query(select);
	}

	public static String fromCAS(String cas) {

		String select = Wikidata.PROP + Wikidata.STATEMENT + Wikidata.WIKIBASE + Wikidata.BIGDATA + Wikidata.WDT + //
				"SELECT ?item ?itemLabel ?pic WHERE {\n" + //
				"  ?item p:P231 ?_cas.\n" + //
				"  ?_cas (ps:P231) \"" + cas + "\".\n" + //
				"  ?item wdt:P117 ?pic\n" + //
				"  SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\" }\n" //
				+ "}";
		return query(select);
	}

	public static String fromSMILES(String smiles) {

		String select = Wikidata.PROP + Wikidata.STATEMENT + Wikidata.WIKIBASE + Wikidata.BIGDATA + Wikidata.WDT + //
				"SELECT ?item ?itemLabel ?pic WHERE {\n" + //
				"  ?item p:P233 ?_smiles.\n" + //
				"  ?_smiles (ps:P233) \"" + smiles + "\".\n" + //
				"  ?item wdt:P117 ?pic\n" + //
				"  SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\" }\n" //
				+ "}";
		return query(select);
	}

	public static String fromInChI(String inchi) {

		String select = Wikidata.PROP + Wikidata.STATEMENT + Wikidata.WIKIBASE + Wikidata.BIGDATA + Wikidata.WDT + //
				"SELECT ?item ?itemLabel ?pic WHERE {\n" + //
				"  ?item p:P234 ?_inchi.\n" + //
				"  ?_inchi (ps:P234) \"" + inchi + "\".\n" + //
				"  ?item wdt:P117 ?pic\n" + //
				"  SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\" }\n" //
				+ "}";
		return query(select);
	}

	public static String fromInChIKey(String inchiKey) {

		String select = Wikidata.PROP + Wikidata.STATEMENT + Wikidata.WIKIBASE + Wikidata.BIGDATA + Wikidata.WDT + //
				"SELECT ?item ?itemLabel ?pic WHERE {\n" + //
				"  ?item p:P235 ?_inchiKey.\n" + //
				"  ?_inchiKey (ps:P235) \"" + inchiKey + "\".\n" + //
				"  ?item wdt:P117 ?pic\n" + //
				"  SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\" }\n" //
				+ "}";
		return query(select);
	}

	private QueryStructuralFormula() {

	}

	private static String query(String queryString) {

		try {
			String url = Wikidata.ENDPOINT + "?query=" + java.net.URLEncoder.encode(queryString, "UTF-8");
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Accept", "application/json").build();
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.body());
			JsonNode bindings = root.path("results").path("bindings");
			for(JsonNode binding : bindings) {
				JsonNode picNode = binding.path("pic").path("value");
				if(!picNode.isMissingNode()) {
					return picNode.asText();
				}
			}
		} catch(UnsupportedEncodingException e) {
			logger.error(e);
		} catch(IOException e) {
			logger.error(e);
		} catch(InterruptedException e) {
			logger.error(e);
		}
		return null;
	}
}
