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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.ui.services;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.service.FileHeaderDataSerializationService;
import org.eclipse.chemclipse.model.ui.swt.FileHeaderDataEditor;
import org.eclipse.chemclipse.support.ui.services.IAnnotationWidgetService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class FileHeaderDataAnnotationService extends FileHeaderDataSerializationService implements IAnnotationWidgetService {

	private AtomicReference<FileHeaderDataEditor> control = new AtomicReference<>();

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		FileHeaderDataEditor fileHeaderDataEditor = new FileHeaderDataEditor(parent, SWT.NONE);
		fileHeaderDataEditor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.widthHint = 500;
		fileHeaderDataEditor.setLayoutData(gridData);

		if(currentSelection instanceof String) {
			fileHeaderDataEditor.load((String)currentSelection);
		}

		control.set(fileHeaderDataEditor);
		return fileHeaderDataEditor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return control.get().getFileHeaderData();
	}
}