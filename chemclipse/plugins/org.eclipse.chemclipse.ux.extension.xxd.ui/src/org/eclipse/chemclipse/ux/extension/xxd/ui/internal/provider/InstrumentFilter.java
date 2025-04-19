/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import org.eclipse.chemclipse.model.instruments.Instrument;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class InstrumentFilter extends ViewerFilter {

	private String searchText;
	private boolean caseSensitive;

	public void setSearchText(String searchText, boolean caseSensitive) {

		this.searchText = searchText;
		this.caseSensitive = caseSensitive;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if(searchText == null || searchText.equals("")) {
			return true;
		}
		//
		if(element instanceof Instrument instrument) {
			String identifier = instrument.getIdentifier();
			String name = instrument.getName();
			String desciption = instrument.getDescription();
			//
			if(!caseSensitive) {
				searchText = searchText.toLowerCase();
				identifier = identifier.toLowerCase();
				name = name.toLowerCase();
				desciption = desciption.toLowerCase();
			}
			//
			if(identifier.contains(searchText)) {
				return true;
			}
			//
			if(name.contains(searchText)) {
				return true;
			}
			//
			if(desciption.contains(searchText)) {
				return true;
			}
		}
		//
		return false;
	}
}
