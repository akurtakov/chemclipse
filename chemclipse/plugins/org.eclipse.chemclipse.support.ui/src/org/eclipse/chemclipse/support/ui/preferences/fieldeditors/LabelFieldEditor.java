/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - dispose internal label on dispose of the editor
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.preferences.fieldeditors;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This editor can be used to show a label in the preference page.
 * 
 * @author Dr. Philip Wenig
 */
public class LabelFieldEditor extends FieldEditor {

	private Label label;
	private static final String LABEL_X = "LABELX";

	public LabelFieldEditor(String labelText, Composite parent) {
		super(LABEL_X, labelText, parent);
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {

		GridData gridData = (GridData)this.label.getLayoutData();
		gridData.horizontalSpan = numColumns;
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {

		this.label = getLabelControl(parent);
		GridData gridData = new GridData();
		gridData.horizontalSpan = numColumns;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessVerticalSpace = false;
		this.label.setLayoutData(gridData);
	}

	@Override
	protected void doLoad() {

	}

	@Override
	protected void doLoadDefault() {

	}

	@Override
	protected void doStore() {

	}

	@Override
	public int getNumberOfControls() {

		return 1;
	}

	@Override
	public void dispose() {

		this.label.dispose();
		super.dispose();
	}
}
