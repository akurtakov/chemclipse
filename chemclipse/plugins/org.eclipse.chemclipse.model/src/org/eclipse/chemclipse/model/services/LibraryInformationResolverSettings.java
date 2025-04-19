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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.services;

public class LibraryInformationResolverSettings {

	private ResolverOption resolverOption = ResolverOption.SYNONYM;
	boolean caseSensitive = true;
	boolean searchExact = true;

	public ResolverOption getResolverOption() {

		return resolverOption;
	}

	public void setResolverOption(ResolverOption resolverOption) {

		this.resolverOption = resolverOption;
	}

	public boolean isCaseSensitive() {

		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {

		this.caseSensitive = caseSensitive;
	}

	public boolean isSearchExact() {

		return searchExact;
	}

	public void setSearchExact(boolean searchExact) {

		this.searchExact = searchExact;
	}
}