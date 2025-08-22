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
package org.eclipse.chemclipse.ux.extension.xxd.ui.traces;

import org.eclipse.chemclipse.support.util.NamedTraceListUtil;
import org.eclipse.chemclipse.support.validators.TraceValidator;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NamedTraceValidator implements IValidator<Object> {

	private static final String ERROR = "Please enter a correct identifier.";

	private TraceValidator traceValidator = new TraceValidator();

	private String identifier = "";
	private String traces = "";

	@Override
	public IStatus validate(Object value) {

		String message = null;

		if(value == null) {
			message = ERROR;
		} else {
			if(value instanceof String) {
				String[] values = value.toString().trim().split("\\" + NamedTraceListUtil.SEPARATOR_ENTRY);
				String identifier = values.length > 0 ? values[0].trim() : "";
				String traces = values.length > 1 ? values[1].trim() : "";

				if("".equals(identifier)) {
					message = ERROR;
				} else {
					this.identifier = identifier;
					IStatus status = traceValidator.validate(traces);
					if(status.isOK()) {
						this.traces = traces;
					} else {
						message = status.getMessage();
					}
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

	public String getIdentifier() {

		return identifier;
	}

	public String getTraces() {

		return traces;
	}
}
