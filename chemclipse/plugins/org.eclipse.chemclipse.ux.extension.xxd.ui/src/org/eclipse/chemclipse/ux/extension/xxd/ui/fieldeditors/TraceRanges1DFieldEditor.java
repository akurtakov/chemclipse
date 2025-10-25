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
package org.eclipse.chemclipse.ux.extension.xxd.ui.fieldeditors;

import org.eclipse.chemclipse.ux.extension.xxd.ui.swt.editors.TraceRangesEditor1D;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class TraceRanges1DFieldEditor extends FieldEditor {

	private TraceRangesEditor1D editor;

	public TraceRanges1DFieldEditor(String name, String labelText, Composite parent) {

		init(name, labelText);
		createControl(parent);
	}

	@Override
	public int getNumberOfControls() {

		return 1;
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {

		getLabelControl(parent);
		editor = new TraceRangesEditor1D(parent, SWT.NONE);
		editor.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	@Override
	protected void doLoad() {

		String entries = getPreferenceStore().getString(getPreferenceName());
		editor.load(entries);
	}

	@Override
	protected void doLoadDefault() {

		String entries = getPreferenceStore().getDefaultString(getPreferenceName());
		editor.load(entries);
	}

	@Override
	protected void doStore() {

		getPreferenceStore().setValue(getPreferenceName(), editor.save());
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {

		Control control = editor;
		GridData gridData = (GridData)control.getLayoutData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = (numColumns >= 2) ? numColumns - 1 : 1;
	}
}