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

import org.eclipse.chemclipse.model.service.TimeRangesSerializationService;
import org.eclipse.chemclipse.ux.extension.ui.methods.IAnnotationWidgetService;
import org.eclipse.chemclipse.ux.extension.xxd.ui.ranges.TimeRangesEditorUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = {IAnnotationWidgetService.class}, configurationPolicy = ConfigurationPolicy.OPTIONAL)
public class TimeRangesAnnotationService extends TimeRangesSerializationService implements IAnnotationWidgetService {

	private TimeRangesEditorUI timeRangesEditor;

	@Override
	public Control createWidget(Composite parent, String description, Object currentSelection) {

		timeRangesEditor = new TimeRangesEditorUI(parent, SWT.NONE);
		timeRangesEditor.setToolTipText(description);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 200;
		gridData.widthHint = 500;
		timeRangesEditor.setLayoutData(gridData);

		if(currentSelection instanceof String) {
			timeRangesEditor.load((String)currentSelection);
		}

		return timeRangesEditor;
	}

	@Override
	public Object getValue(Object currentSelection) {

		return timeRangesEditor.getTimeRanges();
	}
}
