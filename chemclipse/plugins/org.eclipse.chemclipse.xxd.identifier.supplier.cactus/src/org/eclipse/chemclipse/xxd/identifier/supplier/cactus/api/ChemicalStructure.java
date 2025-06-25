/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.identifier.supplier.cactus.api;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;

public class ChemicalStructure {

	private static String structure = "https://cactus.nci.nih.gov/chemical/structure/";

	private ChemicalStructure() {

	}

	public static String getURL(ILibraryInformation libraryInformation) {

		String url = null;
		String smiles = libraryInformation.getSmiles().trim();
		if(!smiles.isEmpty()) {
			url = structure + URLEncoder.encode(smiles, StandardCharsets.UTF_8);
		}
		if(url == null) {
			String inchiKey = libraryInformation.getInChIKey().trim();
			if(!inchiKey.isEmpty()) {
				url = structure + URLEncoder.encode(inchiKey, StandardCharsets.UTF_8);
			}
		}
		if(url == null) {
			String name = libraryInformation.getName().trim().toLowerCase();
			if(!name.isEmpty() && !name.equals("unknown")) {
				url = structure + URLEncoder.encode(name, StandardCharsets.UTF_8);
			}
		}
		return url;
	}
}
