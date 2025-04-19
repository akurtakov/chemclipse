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
package org.eclipse.chemclipse.support.ui.preferences.editors;

import org.eclipse.chemclipse.support.ui.l10n.SupportMessages;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.widgets.List;

public class IonInputValidator implements IInputValidator {

	private String[] items;

	public IonInputValidator() {

		items = new String[]{};
	}

	public IonInputValidator(List list) {

		if(list != null) {
			items = list.getItems();
		} else {
			items = new String[]{};
		}
	}

	@Override
	public String isValid(String newText) {

		/*
		 * Test if the input is an integer value.<br/> If yes, return null,
		 * otherwise throw a failure description.
		 */
		try {
			String ionList[] = newText.trim().split("-"); //$NON-NLS-1$
			if(ionList.length == 1) {
				String ion = String.valueOf(Integer.parseInt(ionList[0].trim()));
				/*
				 * 0 = TIC must be not added.
				 */
				if(ion.equals("0")) { //$NON-NLS-1$
					return SupportMessages.ticMustNotBeAdded;
				}
			} else if(ionList.length == 2) {
				String ion1 = String.valueOf(Integer.parseInt(ionList[0].trim()));
				String ion2 = String.valueOf(Integer.parseInt(ionList[1].trim()));
				/*
				 * 0 = TIC must be not added.
				 */
				if(ion1.equals("0") || ion2.equals("0")) { //$NON-NLS-1$ //$NON-NLS-2$
					return SupportMessages.ticMustNotBeAdded;
				}
			} else {
				return SupportMessages.inputMustBeValidRange;
			}
		} catch(NumberFormatException e) {
			return SupportMessages.inputMustBeIntegerOrIntegerRange;
		}
		/*
		 * Test if 0 (TIC) still exists.
		 */
		for(String item : items) {
			if(item.equals("0")) { //$NON-NLS-1$
				return SupportMessages.removeTICbeforeAddingIonValues;
			}
		}
		/*
		 * Test if the ion value already exists.
		 */
		for(String item : items) {
			if(item.equals(newText)) {
				return SupportMessages.ionValueAlreadyExists;
			}
		}
		return null;
	}
}
