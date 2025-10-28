/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.services;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.tsd.model.services.TraceRangesSerializationService1D;
import org.eclipse.chemclipse.ux.extension.ui.methods.IAnnotationWidgetService;
import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.editors.TraceRangesEditor1D;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TraceRanges1DAnnotationService extends TraceRangesSerializationService1D implements IAnnotationWidgetService {

	private AtomicReference<TraceRangesEditor1D> traceRangesEditorControl = new AtomicReference<>();

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		TraceRangesEditor1D traceRangesEditor = new TraceRangesEditor1D(parent, SWT.NONE);
		traceRangesEditor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 200;
		gridData.widthHint = 500;
		traceRangesEditor.setLayoutData(gridData);

		if(currentSelection instanceof String) {
			traceRangesEditor.load((String)currentSelection);
		}

		traceRangesEditorControl.set(traceRangesEditor);
		return traceRangesEditor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return traceRangesEditorControl.get().getTraceRanges();
	}
}