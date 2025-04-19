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
package org.eclipse.chemclipse.xxd.identifier.supplier.wikidata.identifier;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.identifier.targets.ITargetIdentifierSupplier;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.cas.CasSupport;
import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.chemclipse.xxd.identifier.supplier.wikidata.query.QueryEntity;

public class WikidataExternalTargetIdentifier implements ITargetIdentifierSupplier {

	private static final Logger logger = Logger.getLogger(WikidataExternalTargetIdentifier.class);

	@Override
	public String getId() {

		return "org.eclipse.chemclipse.xxd.identifier.supplier.wikidata.identifier";
	}

	@Override
	public String getDescription() {

		return "Click to open the corresponding Wikidata entry in a web browser.";
	}

	@Override
	public String getIdentifierName() {

		return "Wikidata";
	}

	@Override
	public Class<? extends IIdentifierSettings> getSettingsClass() {

		return null;
	}

	@Override
	public URL getURL(ILibraryInformation libraryInformation) {

		String uri = null;
		String cas = libraryInformation.getCasNumber().trim();
		if(cas != null && !cas.isEmpty() && !CasSupport.CAS_DEFAULT.equals(cas)) {
			uri = QueryEntity.fromCAS(cas);
		}
		if(uri == null) {
			String name = libraryInformation.getName().trim();
			if(!name.isEmpty()) {
				uri = QueryEntity.fromName(name);
			}
		}
		if(uri != null) {
			try {
				return new URI(uri).toURL();
			} catch(MalformedURLException e) {
				logger.warn(e);
			} catch(URISyntaxException e) {
				logger.warn(e);
			}
		}
		return null;
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		return null;
	}
}
