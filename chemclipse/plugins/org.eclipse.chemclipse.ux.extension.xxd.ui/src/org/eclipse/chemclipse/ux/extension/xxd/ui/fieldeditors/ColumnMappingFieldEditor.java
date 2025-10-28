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

import org.eclipse.chemclipse.model.columns.SeparationColumnMapping;
import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.editors.ColumnMappingEditorUI;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ColumnMappingFieldEditor extends FieldEditor {

	private AtomicReference<ColumnMappingEditorUI> editorControl = new AtomicReference<>();
	private SeparationColumnMapping separationColumnMapping = new SeparationColumnMapping();

	public ColumnMappingFieldEditor(String name, String labelText, Composite parent) {

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

		ColumnMappingEditorUI editor = new ColumnMappingEditorUI(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 600;
		gridData.heightHint = 400;
		editor.setLayoutData(gridData);

		editorControl.set(editor);
	}

	@Override
	protected void doLoad() {

		separationColumnMapping.load(getPreferenceStore().getString(getPreferenceName()));
		setInput();
	}

	@Override
	protected void doLoadDefault() {

		separationColumnMapping.loadDefault(getPreferenceStore().getDefaultString(getPreferenceName()));
		setInput();
	}

	@Override
	protected void doStore() {

		getPreferenceStore().setValue(getPreferenceName(), separationColumnMapping.save());
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {

		Control control = editorControl.get();
		GridData gridData = (GridData)control.getLayoutData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = (numColumns >= 2) ? numColumns - 1 : 1;
	}

	private void setInput() {

		editorControl.get().setInput(separationColumnMapping);
	}
}