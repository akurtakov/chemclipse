/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.support.ui.l10n.SupportMessages;
import org.eclipse.swt.widgets.Composite;

public class SpinnerFieldEditorOddNumber extends SpinnerFieldEditorBounded {

	public SpinnerFieldEditorOddNumber(String name, String labelText, int min, int max, Composite parent) {

		super(name, labelText, min, max, parent);
		setIncrement(2);
	}

	public SpinnerFieldEditorOddNumber(String name, String labelText, int min, int max, int strategy, Composite parent) {

		super(name, labelText, min, max, strategy, parent);
		setIncrement(2);
	}

	@Override
	protected boolean doCheckState() {

		int value = getIntValue();
		if(value % 2 == 0) {
			setErrorMessage(SupportMessages.errorMessageOdd);
			return false;
		}
		return super.doCheckState();
	}
}
