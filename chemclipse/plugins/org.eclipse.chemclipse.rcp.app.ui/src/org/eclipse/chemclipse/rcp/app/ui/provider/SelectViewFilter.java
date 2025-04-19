/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.rcp.app.ui.provider;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class SelectViewFilter extends ViewerFilter {

	private static final Logger logger = Logger.getLogger(SelectViewFilter.class);
	private String searchPattern;
	private boolean caseInsensitive;

	public void setCaseInsensitive(boolean caseInsensitive) {

		this.caseInsensitive = caseInsensitive;
	}

	public boolean isCaseInsensitive() {

		return caseInsensitive;
	}

	public void setSearchPattern(String searchPattern) {

		this.searchPattern = (caseInsensitive) ? searchPattern.toLowerCase() : searchPattern;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if(searchPattern == null || searchPattern.equals("")) {
			return true;
		}
		if(element instanceof MPart part) {
			String partLabel = part.getLabel();
			if(partLabel != null) {
				String label = (caseInsensitive) ? partLabel.toLowerCase() : partLabel;
				if(label.contains(searchPattern)) {
					return true;
				}
			} else {
				logger.warn("Please add a part label: " + part.getElementId());
			}
		}
		return false;
	}
}
