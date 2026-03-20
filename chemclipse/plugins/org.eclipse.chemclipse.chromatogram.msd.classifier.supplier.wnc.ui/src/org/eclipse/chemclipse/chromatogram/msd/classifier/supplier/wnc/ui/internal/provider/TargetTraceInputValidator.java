/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.ui.internal.provider;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTrace;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTraces;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.validators.TargetTraceValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class TargetTraceInputValidator implements IInputValidator {

	private TargetTraceValidator validator = new TargetTraceValidator();
	private TargetTraces targetTraces = new TargetTraces();

	public TargetTraceInputValidator(TargetTraces targetTraces) {

		if(targetTraces != null) {
			this.targetTraces = targetTraces;
		}
	}

	@Override
	public String isValid(String target) {

		IStatus status = validator.validate(target);
		if(status.isOK()) {
			TargetTrace setting = validator.getSetting();
			if(targetTraces.containsValue(setting)) {
				return "The element already exists.";
			}
		} else {
			return status.getMessage();
		}
		return null;
	}
}