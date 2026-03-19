/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - port to validation API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.validators;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTrace;
import org.eclipse.chemclipse.support.util.ValueParserSupport;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class TargetTraceValidator extends ValueParserSupport implements IValidator<String> {

	public static final String EXAMPLE_SINGLE = "water:18";

	public static final String WHITE_SPACE = " ";
	public static final String SEPARATOR_TOKEN = ";";
	public static final String SEPARATOR_ENTRY = ":";

	private static final String ERROR_MESSAGE = "";
	private static final String ERROR_TOKEN = "The item must not contain: " + SEPARATOR_TOKEN;

	private int mz = 0;
	private String name = "";

	@Override
	public IStatus validate(String value) {

		clear();
		String message = null;
		if(value == null) {
			message = ERROR_MESSAGE;
		} else {
			String text = value.trim();
			if(text.contains(SEPARATOR_TOKEN)) {
				message = ERROR_TOKEN;
			} else if(text.isEmpty() || text.isBlank()) {
				message = ERROR_MESSAGE;
			} else {
				String[] values = text.trim().split("\\" + SEPARATOR_ENTRY); // The pipe needs to be escaped.
				if(values.length >= 2) {
					mz = parseInteger(values, 1);
					if(mz <= 0) {
						message = "Please type in a valid named trace.";
					} else {
						name = parseString(values, 0);
					}
				}
			}
		}

		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}

	private void clear() {

		mz = 0;
		name = "";
	}

	public TargetTrace getSetting() {

		return new TargetTrace(mz, name);
	}
}