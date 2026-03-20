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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.services;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.service.TargetTracesSerializationService;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.swt.TargetTracesEditor;
import org.eclipse.chemclipse.support.ui.services.IAnnotationWidgetService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TargetTracesAnnotationService extends TargetTracesSerializationService implements IAnnotationWidgetService {

	private TargetTracesEditor targetTracesEditor;

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		targetTracesEditor = new TargetTracesEditor(parent, SWT.NONE);
		targetTracesEditor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 200;
		gridData.widthHint = 500;
		targetTracesEditor.setLayoutData(gridData);

		if(currentSelection instanceof String text) {
			targetTracesEditor.load(text);
		}

		return targetTracesEditor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return targetTracesEditor.getRetentionIndexAssigner();
	}
}
