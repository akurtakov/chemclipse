/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Lorenz Gerber - data update on focus
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.parts;

import java.util.List;

import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt.ExtendedScorePlot2D;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class ScorePlot2DPart extends AbstractPartPCA<ExtendedScorePlot2D> {

	@Inject
	public ScorePlot2DPart(Composite parent) {

		super(parent);
	}

	@Override
	public void setFocus() {

		ExtendedScorePlot2D control = getControl();
		if(control != null) {
			control.setFocus();
		}
	}

	@Override
	protected ExtendedScorePlot2D createControl(Composite parent) {

		return new ExtendedScorePlot2D(parent, SWT.NONE);
	}

	@Override
	protected boolean updateData(List<Object> objects, String topic) {

		if(objects.size() == 1) {
			if(isUnloadEvent(topic)) {
				getControl().setInput(null);
				unloadData();
				return false;
			} else if(isUpdateColorSchemeEvent(topic) || isUpdateLabelsEvent(topic) || isUpdateGroupsEvent(topic)) {
				getControl().updatePlot();
				return false;
			} else {
				Object object = objects.get(0);
				if(object instanceof EvaluationPCA evaluationPCA) {
					getControl().setInput(evaluationPCA);
					return true;
				} else {
					getControl().setInput(null);
					unloadData();
					return false;
				}
			}
		}

		return false;
	}
}