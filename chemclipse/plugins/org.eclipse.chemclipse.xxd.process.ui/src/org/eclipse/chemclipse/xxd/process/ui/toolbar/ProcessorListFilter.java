/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.ui.toolbar;

import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class ProcessorListFilter extends ViewerFilter {

	private String searchText;
	private boolean caseSensitive;

	public void setSearchText(String searchText, boolean caseSensitive) {

		this.searchText = searchText;
		this.caseSensitive = caseSensitive;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		/*
		 * Pre-Condition
		 */
		if(searchText == null || searchText.equals("")) {
			return true;
		}

		if(element instanceof Processor processor) {
			IProcessSupplier<?> processSupplier = processor.getProcessSupplier();

			if(!caseSensitive) {
				searchText = searchText.toLowerCase();
			}

			if(isMatch(processSupplier.getName())) {
				return true;
			}

			for(DataCategory dataCategory : processSupplier.getSupportedDataTypes()) {
				if(isMatch(dataCategory.name())) {
					return true;
				}
			}

			if(isMatch(processSupplier.getDescription())) {
				return true;
			}
		}

		return false;
	}

	private boolean isMatch(String term) {

		return getSearchTerm(term).contains(searchText);
	}

	private String getSearchTerm(String term) {

		return !caseSensitive ? term.toLowerCase() : term;
	}
}
