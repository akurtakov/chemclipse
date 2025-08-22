/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.classification.validators;

import org.eclipse.chemclipse.xxd.classification.model.ClassificationDictionary;
import org.eclipse.chemclipse.xxd.classification.model.ClassificationRule;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class ClassificationDictionaryValidator implements IValidator<Object> {

	private static final String REGULAR_EXPRESSION = "([a-zA-Z0-9,'-\\{\\[\\]\\}\\(\\)\\s*]+{2,})";

	@Override
	public IStatus validate(Object value) {

		String message = null;
		if(value == null) {
			message = "The classification dictionary is empty.";
		} else {
			if(value instanceof ClassificationDictionary dictionary) {
				for(ClassificationRule rule : dictionary) {
					if(rule.getSearchExpression().isEmpty()) {
						message = "The match expressions is empty.";
					} else if(!rule.getSearchExpression().matches(REGULAR_EXPRESSION)) {
						message = "The search expression must only contain alphanumeric characters and brackets.";
					}
					if(rule.getClassification().isEmpty()) {
						message = "The match classification is empty.";
					} else if(!rule.getClassification().matches(REGULAR_EXPRESSION)) {
						message = "The match classification must only contain alphanumeric characters and brackets.";
					}
				}
			} else {
				message = "The settings class is not of type: " + ClassificationDictionary.class.getName();
			}
		}

		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}
}
