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

public class QueryEntity {

	private static final Logger logger = Logger.getLogger(QueryEntity.class);

	public static String fromCAS(String cas) {

		String select = Wikidata.PROP + Wikidata.STATEMENT + Wikidata.WIKIBASE + Wikidata.BIGDATA + Wikidata.WDT + //
				"SELECT DISTINCT ?item WHERE {\n" //
				+ "  SERVICE wikibase:label { bd:serviceParam wikibase:language \"en\". }\n" //
				+ "  {\n" //
				+ "    SELECT DISTINCT ?item WHERE {\n" //
				+ "      ?item p:P231 ?cas.\n" //
				+ "      ?cas (ps:P231) \"" + cas + "\".\n" //
				+ "    }\n" //
				+ "  }\n" //
				+ "}"; //
		return query(select);
	}

	// TODO: case insensitive query that is not super slow
	public static String fromName(String name) {

		String select = Wikidata.PROP + Wikidata.BIGDATA + Wikidata.SCHEMA + Wikidata.WIKIBASE + Wikidata.WD + Wikidata.WDT + //
				"SELECT distinct ?item WHERE { \n" + //
				"  ?item ?label \"" + name.toLowerCase() + "\"@en . \n" + //
				"  ?item wdt:P31 wd:Q113145171 . \n" + //
				"  ?article schema:about ?item . \n" + //
				"  ?article schema:inLanguage \"en\" . \n" + //
				"  SERVICE wikibase:label { bd:serviceParam wikibase:language \"en\". }\n" + //
				"}";
		return query(select);
	}

	private static String query(String queryString) {

		String url;
		try {
			url = Wikidata.ENDPOINT + "?query=" + java.net.URLEncoder.encode(queryString, "UTF-8");
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Accept", "application/json").build();
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.body());
			JsonNode bindings = root.path("results").path("bindings");
			for(JsonNode binding : bindings) {
				JsonNode picNode = binding.path("item").path("value");
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
