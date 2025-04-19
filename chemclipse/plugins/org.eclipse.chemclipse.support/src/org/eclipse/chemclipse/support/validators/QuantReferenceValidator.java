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
package org.eclipse.chemclipse.support.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class QuantReferenceValidator implements IValidator<Object> {

	private static final String ERROR = "Please enter quantitation reference, e.g.: Styrene";
	//
	private String name = "";

	@Override
	public IStatus validate(Object value) {

		String message = null;
		if(value == null) {
			message = ERROR;
		} else {
			if(value instanceof String text) {
				name = text.trim();
				if(name.isEmpty()) {
					message = ERROR;
				}
			} else {
				message = ERROR;
			}
		}
		//
		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}

	public String getName() {

		return name;
	}
}