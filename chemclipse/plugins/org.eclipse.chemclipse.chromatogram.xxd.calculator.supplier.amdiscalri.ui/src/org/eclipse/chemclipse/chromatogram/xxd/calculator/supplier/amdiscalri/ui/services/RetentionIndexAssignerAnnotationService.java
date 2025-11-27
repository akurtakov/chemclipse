/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.services;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.service.RetentionIndexAssignerSerializationService;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.ui.swt.RetentionIndexAssignerEditor;
import org.eclipse.chemclipse.support.ui.services.IAnnotationWidgetService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class RetentionIndexAssignerAnnotationService extends RetentionIndexAssignerSerializationService implements IAnnotationWidgetService {

	private RetentionIndexAssignerEditor editor;

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		editor = new RetentionIndexAssignerEditor(parent, SWT.NONE);
		editor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 250;
		gridData.widthHint = 500;
		editor.setLayoutData(gridData);

		if(currentSelection instanceof String text) {
			editor.load(text);
		}

		return editor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return editor.getRetentionIndexAssigner();
	}
}
