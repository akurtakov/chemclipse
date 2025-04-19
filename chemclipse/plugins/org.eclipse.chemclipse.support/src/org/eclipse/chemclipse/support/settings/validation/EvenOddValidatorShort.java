/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.settings.validation;

import org.eclipse.chemclipse.support.settings.ShortSettingsProperty.Validation;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class EvenOddValidatorShort implements IValidator<Object> {

	private Validation validation;
	private String fieldName;

	public EvenOddValidatorShort(String fieldName, Validation validation) {

		this.fieldName = fieldName;
		this.validation = validation;
	}

	@Override
	public IStatus validate(Object value) {

		if(value instanceof Number number) {
			short shortValue = number.shortValue();
			if(validation == Validation.ODD_NUMBER_INCLUDING_ZERO) {
				if(shortValue == 0) {
					return ValidationStatus.ok();
				}
				if(shortValue % 2 == 0) {
					return ValidationStatus.error(fieldName + " must be odd or zero.");
				}
			}
			if(validation == Validation.ODD_NUMBER) {
				if(shortValue % 2 == 0) {
					return ValidationStatus.error(fieldName + " must be odd.");
				}
			} else if(validation == Validation.EVEN_NUMBER) {
				if(shortValue % 2 != 0) {
					return ValidationStatus.error(fieldName + " must be even.");
				}
			}
			return ValidationStatus.ok();
		}
		return ValidationStatus.error(fieldName + " must be a number.");
	}
}
