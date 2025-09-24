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
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.parts;

import java.util.List;

import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IEvaluation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt.ExtendedFeatureStatListUI;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class FeatureStatTablePart extends AbstractPartPCA<ExtendedFeatureStatListUI> {

	@Inject
	public FeatureStatTablePart(Composite parent) {

		super(parent);
	}

	@Focus
	private void onFocus() {

		super.setFocus();
		getControl().updateSelection();
	}

	@Override
	protected ExtendedFeatureStatListUI createControl(Composite parent) {

		return new ExtendedFeatureStatListUI(parent, SWT.NONE);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected boolean updateData(List<Object> objects, String topic) {

		if(objects.size() == 1) {
			if(isUnloadEvent(topic)) {
				getControl().setInput(null);
				unloadData();
				return false;
			} else if(isUpdateSelection(topic)) {
				Object object = objects.get(0);
				if(object instanceof IEvaluation evaluation) {
					getControl().setInput(evaluation);
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

		return false;
	}
}
