/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - get rid of JavaFX, feature selection
 * Lorenz Gerber - update feature table selection from loading plot
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.parts;

import java.util.List;

import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt.ExtendedFeatureListUI;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class FeatureTablePart extends AbstractPartPCA<ExtendedFeatureListUI> {

	@Inject
	public FeatureTablePart(Composite parent) {

		super(parent);
	}

	@Focus
	private void onFocus() {

		super.setFocus();
		getControl().updateSelection();
	}

	@Override
	protected ExtendedFeatureListUI createControl(Composite parent) {

		return new ExtendedFeatureListUI(parent, SWT.NONE);
	}

	@Override
	protected boolean updateData(List<Object> objects, String topic) {

		if(objects.size() == 1) {
			if(isUnloadEvent(topic)) {
				getControl().setInput(null);
				unloadData();
				return false;
			} else if(isUpdateSelection(topic)) {
				Object object = objects.get(0);
				if(object instanceof EvaluationPCA evaluationPCA) {
					getControl().setInput(evaluationPCA);
					return true;
				}
			} else if(isUpdateResultEvent(topic)) {
				Object object = objects.get(0);
				if(object instanceof EvaluationPCA evaluationPCA) {
					getControl().setInput(evaluationPCA);
					getControl().updateSelection();
					return true;
				}
			}
		}
		//
		return false;
	}
}
