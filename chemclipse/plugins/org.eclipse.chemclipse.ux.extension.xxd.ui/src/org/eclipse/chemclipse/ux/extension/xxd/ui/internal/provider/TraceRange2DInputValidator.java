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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.provider;

import org.eclipse.chemclipse.tsd.model.core.TraceRange2D;
import org.eclipse.chemclipse.tsd.model.core.TraceRanges2D;
import org.eclipse.chemclipse.tsd.model.validators.TraceRange2DValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class TraceRange2DInputValidator implements IInputValidator {

	private TraceRange2DValidator validator = new TraceRange2DValidator();
	private TraceRanges2D traceRanges = new TraceRanges2D();

	public TraceRange2DInputValidator(TraceRanges2D traceRanges) {

		if(traceRanges != null) {
			this.traceRanges = traceRanges;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			TraceRange2D traceRange = validator.getSetting();
			if(traceRanges.contains(traceRange)) {
				return "The trace range exists already.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}