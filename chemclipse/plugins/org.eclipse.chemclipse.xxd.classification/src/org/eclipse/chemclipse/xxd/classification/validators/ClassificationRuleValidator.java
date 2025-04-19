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

import org.eclipse.chemclipse.support.util.ValueParserSupport;
import org.eclipse.chemclipse.xxd.classification.model.ClassificationRule;
import org.eclipse.chemclipse.xxd.classification.model.Reference;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class ClassificationRuleValidator extends ValueParserSupport implements IValidator<Object> {

	private String searchExpression = "";
	private String classification = "";
	private Reference reference = Reference.NAME;

	@Override
	public IStatus validate(Object value) {

		String message = null;
		if(value == null) {
			message = "Value can't be null";
		} else {
			if(value instanceof String text) {
				text = text.trim();
				if(text.isEmpty()) {
					message = "Entry can't be empty";
				} else {
					/*
					 * Extract the name
					 */
					String[] values = text.trim().split("\\" + '|'); // The pipe needs to be escaped.
					if(values.length > 1) {
						/*
						 * Evaluation
						 */
						searchExpression = parseString(values, 0);
						if(searchExpression.isBlank()) {
							message = "Rule can't be blank.";
						}
						//
						classification = parseString(values, 1);
						if(classification.isBlank()) {
							message = "A classification name needs to be set.";
						}
						//
						try {
							reference = Reference.valueOf(parseString(values, 2));
						} catch(Exception e) {
							reference = Reference.NAME;
						}
					} else {
						message = "Please enter rule and classification split by a pipe e.g. *ane | Alkane";
					}
				}
			} else {
				message = "Value has to be a string.";
			}
		}
		//
		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}

	public ClassificationRule getSetting() {

		ClassificationRule setting = new ClassificationRule();
		setting.setSearchExpression(searchExpression);
		setting.setClassification(classification);
		setting.setReference(reference);
		//
		return setting;
	}
}
