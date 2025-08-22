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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.validation;

import org.eclipse.jface.dialogs.IInputValidator;

public class QuantitationReferenceInputValidator implements IInputValidator {

	private String[] items = new String[]{};

	public QuantitationReferenceInputValidator(String[] list) {

		if(list != null) {
			items = list;
		} else {
			items = new String[]{};
		}
	}

	@Override
	public String isValid(String target) {

		if(target == null || target.isEmpty()) {
			return "The quantitation reference must be not empty.";
		}

		for(String item : items) {
			if(item.equals(target)) {
				return "The quantitation reference exists already.";
			}
		}
		return null;
	}
}