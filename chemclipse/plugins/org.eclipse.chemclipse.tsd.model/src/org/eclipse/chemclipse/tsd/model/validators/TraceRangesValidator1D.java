/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.model.validators;

import org.eclipse.chemclipse.support.util.ValueParserSupport;
import org.eclipse.chemclipse.tsd.model.core.TraceRange1D;
import org.eclipse.chemclipse.tsd.model.core.TraceRanges1D;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class TraceRangesValidator1D extends ValueParserSupport implements IValidator<Object> {

	@Override
	public IStatus validate(Object value) {

		String message = null;
		if(value == null) {
			message = "The trace ranges are empty.";
		} else {
			if(value instanceof TraceRanges1D traceRanges) {
				for(TraceRange1D traceRange : traceRanges) {
					if(traceRange.getRetentionTimeColumn1Start() < 0) {
						message = "The retention time start is < 0.";
					} else if(traceRange.getRetentionTimeColumn1Stop() < 0) {
						message = "The retention time start is < 0.";
					}
				}
			} else {
				message = "The settings class is not of type: " + TraceRanges1D.class.getName();
			}
		}

		if(message != null) {
			return ValidationStatus.error(message);
		} else {
			return ValidationStatus.ok();
		}
	}
}