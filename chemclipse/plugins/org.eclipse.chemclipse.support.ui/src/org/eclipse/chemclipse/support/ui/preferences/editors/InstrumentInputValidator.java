/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.preferences.editors;

import org.eclipse.chemclipse.support.l10n.SupportMessages;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.widgets.List;

public class InstrumentInputValidator implements IInputValidator {

	private String[] items;

	public InstrumentInputValidator() {

		items = new String[]{};
	}

	public InstrumentInputValidator(List list) {

		if(list != null) {
			items = list.getItems();
		} else {
			items = new String[]{};
		}
	}

	@Override
	public String isValid(String newInstrument) {

		if(newInstrument.equals("")) {
			return SupportMessages.labelTypeInInstrument;
		} else {
			for(String item : items) {
				if(item.equals(newInstrument)) {
					return SupportMessages.labelInstrumentExists;
				}
			}
		}
		return null;
	}
}
