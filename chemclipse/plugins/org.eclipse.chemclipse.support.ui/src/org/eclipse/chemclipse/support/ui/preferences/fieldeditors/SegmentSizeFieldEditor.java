/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.ui.preferences.fieldeditors;

import org.eclipse.chemclipse.support.model.SegmentWidth;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty.Validation;
import org.eclipse.swt.widgets.Composite;

public class SegmentSizeFieldEditor extends ExtendedIntegerFieldEditor {

	public SegmentSizeFieldEditor(String name, String labelText, Composite parent) {

		super(name, labelText, 5, 19, Validation.ODD_NUMBER, parent);
	}

	@Override
	public int getIntValue() throws NumberFormatException {

		return SegmentWidth.getAdjustedSetting(getStringValue());
	}
}
