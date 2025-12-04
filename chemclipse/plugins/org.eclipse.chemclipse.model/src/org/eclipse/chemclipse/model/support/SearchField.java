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
package org.eclipse.chemclipse.model.support;

import java.util.Arrays;
import java.util.List;

public enum SearchField {

	ALL(Arrays.asList("all")), //
	NAME(Arrays.asList("name")), //
	REFERENCE_IDENTIFIER(Arrays.asList("ref", "id")), //
	FORMULA(Arrays.asList("formula")), //
	SMILES(Arrays.asList("smiles")), //
	INCHI(Arrays.asList("inchi")), //
	INCHI_KEY(Arrays.asList("inchikey")), //
	CAS(Arrays.asList("cas")), //
	COMMENTS(Arrays.asList("comment", "comments")), //
	SYNONYMS(Arrays.asList("synonym", "synonyms")), //
	DATABASE(Arrays.asList("database", "db")), //
	FLAVOR_ODOR(Arrays.asList("odor")), //
	FLAVOR_MATRIX(Arrays.asList("matrix")), //
	FLAVOR_SOLVENT(Arrays.asList("solvent"));

	private List<String> keywords;

	private SearchField(List<String> keywords) {

		this.keywords = keywords;
	}

	public List<String> keywords() {

		return keywords;
	}
}