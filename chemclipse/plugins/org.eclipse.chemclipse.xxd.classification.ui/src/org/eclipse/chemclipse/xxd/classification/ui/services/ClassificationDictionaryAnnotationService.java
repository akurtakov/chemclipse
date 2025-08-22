/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 * Philip Wenig - width hint
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.classification.ui.services;

import org.eclipse.chemclipse.ux.extension.ui.methods.IAnnotationWidgetService;
import org.eclipse.chemclipse.xxd.classification.service.ClassificationDictionarySerializationService;
import org.eclipse.chemclipse.xxd.classification.ui.swt.ClassificationDictionaryEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class ClassificationDictionaryAnnotationService extends ClassificationDictionarySerializationService implements IAnnotationWidgetService {

	private ClassificationDictionaryEditor classificationDictionaryEditor;

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		classificationDictionaryEditor = new ClassificationDictionaryEditor(parent, SWT.NONE);
		classificationDictionaryEditor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 200;
		gridData.widthHint = 500;
		classificationDictionaryEditor.setLayoutData(gridData);

		if(currentSelection instanceof String text) {
			classificationDictionaryEditor.load(text);
		}

		return classificationDictionaryEditor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return classificationDictionaryEditor.getClassificationDictionary();
	}
}
