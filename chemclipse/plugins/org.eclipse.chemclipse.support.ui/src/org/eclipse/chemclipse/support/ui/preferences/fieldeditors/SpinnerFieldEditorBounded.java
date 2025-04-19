/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.preferences.fieldeditors;

import org.eclipse.swt.widgets.Composite;

public class SpinnerFieldEditorBounded extends SpinnerFieldEditor2 {

	private int min;
	private int max;

	public SpinnerFieldEditorBounded(String name, String labelText, int min, int max, int strategy, Composite parent) {
		super(name, labelText, strategy, parent);
		this.min = min;
		this.max = max;
	}

	public SpinnerFieldEditorBounded(String name, String labelText, int min, int max, Composite parent) {
		super(name, labelText, parent);
		this.min = min;
		this.max = max;
	}

	public void setIncrement(int value) {

		spinner.setIncrement(value);
	}

	@Override
	protected boolean doCheckState() {

		int value = getIntValue();
		if(value < min || value > max) {
			setErrorMessage("Invalid min/max values: " + min + ", " + max);
			return false;
		}
		return super.doCheckState();
	}
}
