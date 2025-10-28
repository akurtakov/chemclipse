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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.ui.internal.provider;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class LibraryInformationFilter extends ViewerFilter {

	private String searchText;
	private boolean caseSensitive;

	public void setSearchText(String searchText, boolean caseSensitive) {

		this.searchText = caseSensitive ? searchText : searchText.toLowerCase();
		this.caseSensitive = caseSensitive;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if(searchText == null || searchText.isBlank()) {
			return true;
		} else {
			if(element instanceof ILibraryInformation libraryInformation) {
				/*
				 * Match Fields
				 */
				if(contains(libraryInformation.getName())) {
					return true;
				}

				if(contains(libraryInformation.getCasNumber())) {
					return true;
				}

				if(contains(libraryInformation.getSmiles())) {
					return true;
				}

				if(contains(libraryInformation.getInChI())) {
					return true;
				}

				if(contains(libraryInformation.getComments())) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean contains(String field) {

		String content = caseSensitive ? field : field.toLowerCase();
		return content.contains(searchText);
	}
}