/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.fieldeditors;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.ux.extension.xxd.ui.ranges.TimeRangeLabels;
import org.eclipse.chemclipse.ux.extension.xxd.ui.ranges.TimeRangesSettingsEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class TimeRangesFieldEditor extends FieldEditor {

	private AtomicReference<TimeRangesSettingsEditor> editorControl = new AtomicReference<>();
	/*
	 * If null, then the default is used.
	 */
	private TimeRangeLabels timeRangeLabels;

	public TimeRangesFieldEditor(String name, String labelText, Composite parent) {

		this(name, labelText, null, parent);
	}

	public TimeRangesFieldEditor(String name, String labelText, TimeRangeLabels timeRangeLabels, Composite parent) {

		this.timeRangeLabels = timeRangeLabels;
		init(name, labelText);
		createControl(parent);
	}

	@Override
	public int getNumberOfControls() {

		return 2;
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {

		getLabelControl(parent);

		TimeRangesSettingsEditor editor = new TimeRangesSettingsEditor(parent, null, null, timeRangeLabels);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 600;
		gridData.heightHint = 400;
		editor.getControl().setLayoutData(gridData);

		editorControl.set(editor);
	}

	@Override
	protected void doLoad() {

		editorControl.get().load(getPreferenceStore().getString(getPreferenceName()));
	}

	@Override
	protected void doLoadDefault() {

		editorControl.get().load(getPreferenceStore().getDefaultString(getPreferenceName()));
	}

	@Override
	protected void doStore() {

		getPreferenceStore().setValue(getPreferenceName(), editorControl.get().getValues());
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {

		Control control = editorControl.get().getControl();
		GridData gridData = (GridData)control.getLayoutData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = (numColumns >= 2) ? numColumns - 1 : 1;
	}
}