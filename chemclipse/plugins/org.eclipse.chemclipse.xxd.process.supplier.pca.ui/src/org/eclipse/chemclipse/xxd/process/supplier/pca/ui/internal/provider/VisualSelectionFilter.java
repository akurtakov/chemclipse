/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.provider;

import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Feature;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class VisualSelectionFilter extends ViewerFilter {

	private boolean selected = false;
	private List<IVariable> highlightedVariables = Collections.emptyList();

	public void setMode(boolean selected) {

		this.selected = selected;
	}

	public void setHighlightedVariables(List<IVariable> highlightedVariables) {

		this.highlightedVariables = highlightedVariables != null ? highlightedVariables : Collections.emptyList();
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if(!selected) {
			return true;
		}
		if(element instanceof Feature feature) {
			IVariable variable = feature.getVariable();
			return highlightedVariables.stream().anyMatch(v -> v.getValue().equals(variable.getValue()));
		}
		return true;
	}
}
