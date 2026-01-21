/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt.ExtendedScoreTable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.inject.Inject;

public class ScoreTablePart extends AbstractPartPCA<ExtendedScoreTable> {

	@Inject
	public ScoreTablePart(Composite parent) {

		super(parent);
	}

	@Override
	protected ExtendedScoreTable createControl(Composite parent) {

		return new ExtendedScoreTable(parent, SWT.NONE);
	}

	@Override
	protected boolean updateData(List<Object> objects, String topic) {

		if(objects.size() == 1) {
			if(isUnloadEvent(topic)) {
				getControl().setInput(null);
				unloadData();
				return false;
			} else if(isUpdateColorSchemeEvent(topic) || isUpdateLabelsEvent(topic) || isUpdateGroupsEvent(topic)) {
				getControl().updateTable();
				return false;
			} else {
				Object object = objects.get(0);
				if(object instanceof EvaluationPCA) {
					getControl().setInput((EvaluationPCA)object);
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
