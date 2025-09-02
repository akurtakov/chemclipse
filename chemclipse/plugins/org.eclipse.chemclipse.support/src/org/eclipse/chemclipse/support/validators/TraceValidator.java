/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.support.traces.TraceFactory;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class TraceValidator extends AbstractTraceValidatorLegacy {

	private static final String ERROR = "Please enter valid traces, e.g.: 320.1 400";

	@Override
	public IStatus validate(Object value) {

		setTraces("");
		String message = null;
		if(value == null) {
			message = ERROR;
		} else {
			if(value instanceof String content) {
				/*
				 * The traces are parsed dynamically.
				 * Backward compatibility is ensured via the TraceFactory.
				 */
				String invalidInput = TraceFactory.validate(content);
				if(invalidInput != null) {
					message = "The following input is invalid: " + invalidInput;
				} else {
					setTraces(content);
				}
			} else {
				message = ERROR;
			}
		}

		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}
}