/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.preferences.fieldeditors;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class PasswordFieldEditor extends StringFieldEditor {

	public PasswordFieldEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);
	}

	public PasswordFieldEditor(String name, String labelText, int width, Composite parent) {
		super(name, labelText, width, parent);
	}

	public PasswordFieldEditor(String name, String labelText, int width, int strategy, Composite parent) {
		super(name, labelText, width, strategy, parent);
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {

		super.doFillIntoGrid(parent, numColumns);
		getTextControl().setEchoChar('*');
	}
}
