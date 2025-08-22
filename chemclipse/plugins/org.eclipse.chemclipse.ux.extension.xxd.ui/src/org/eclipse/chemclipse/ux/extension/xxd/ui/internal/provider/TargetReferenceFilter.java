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

import org.eclipse.chemclipse.model.targets.ITargetDisplaySettings;
import org.eclipse.chemclipse.model.targets.ITargetReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class TargetReferenceFilter extends ViewerFilter {

	private String searchText;
	private boolean caseSensitive;

	private ITargetDisplaySettings targetDisplaySettings;

	public void setTargetDisplaySettings(ITargetDisplaySettings targetDisplaySettings) {

		this.targetDisplaySettings = targetDisplaySettings;
	}

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

		if(element instanceof ITargetReference targetReference && targetDisplaySettings != null) {
			String libraryField = targetReference.getTargetLabel(targetDisplaySettings.getLibraryField());

			if(!caseSensitive) {
				searchText = searchText.toLowerCase();
				libraryField = libraryField.toLowerCase();
			}

			if(libraryField.contains(searchText)) {
				return true;
			}
		}

		return false;
	}
}
