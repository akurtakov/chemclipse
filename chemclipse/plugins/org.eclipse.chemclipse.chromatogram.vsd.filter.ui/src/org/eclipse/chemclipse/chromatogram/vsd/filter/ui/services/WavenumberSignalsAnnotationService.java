/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.vsd.filter.ui.services;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.chromatogram.vsd.filter.service.WavenumberSignalsSerializationService;
import org.eclipse.chemclipse.chromatogram.vsd.filter.ui.swt.WavenumberSignalsEditor;
import org.eclipse.chemclipse.ux.extension.ui.methods.IAnnotationWidgetService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class WavenumberSignalsAnnotationService extends WavenumberSignalsSerializationService implements IAnnotationWidgetService {

	private AtomicReference<WavenumberSignalsEditor> editorControl = new AtomicReference<>();

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		WavenumberSignalsEditor wavenumberSignalsEditor = new WavenumberSignalsEditor(parent, SWT.NONE);
		wavenumberSignalsEditor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 250;
		gridData.widthHint = 500;
		wavenumberSignalsEditor.setLayoutData(gridData);

		if(currentSelection instanceof String text) {
			wavenumberSignalsEditor.load(text);
		}

		editorControl.set(wavenumberSignalsEditor);
		return wavenumberSignalsEditor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return editorControl.get().getWavenumberSignals();
	}
}
