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
package org.eclipse.chemclipse.xxd.classification.ui.provider;

import org.eclipse.chemclipse.xxd.classification.model.ClassificationDictionary;
import org.eclipse.chemclipse.xxd.classification.model.ClassificationRule;
import org.eclipse.chemclipse.xxd.classification.validators.ClassificationRuleValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class ClassificationRuleInputValidator implements IInputValidator {

	private ClassificationRuleValidator validator = new ClassificationRuleValidator();
	private ClassificationDictionary dictionary = new ClassificationDictionary();

	public ClassificationRuleInputValidator(ClassificationDictionary dictionary) {

		if(dictionary != null) {
			this.dictionary = dictionary;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			ClassificationRule classificationRule = validator.getSetting();
			if(dictionary.contains(classificationRule)) {
				return "The rule already exists.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}