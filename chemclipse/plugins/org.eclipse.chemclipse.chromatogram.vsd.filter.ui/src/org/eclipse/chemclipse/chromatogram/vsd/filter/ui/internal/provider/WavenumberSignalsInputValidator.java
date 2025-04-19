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
package org.eclipse.chemclipse.chromatogram.vsd.filter.ui.internal.provider;

import org.eclipse.chemclipse.chromatogram.vsd.filter.model.WavenumberSignal;
import org.eclipse.chemclipse.chromatogram.vsd.filter.model.WavenumberSignals;
import org.eclipse.chemclipse.chromatogram.vsd.filter.validators.WavenumberSignalsValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

public class WavenumberSignalsInputValidator implements IInputValidator {

	private WavenumberSignalsValidator validator = new WavenumberSignalsValidator();
	private WavenumberSignals wavenumberSignals;

	public WavenumberSignalsInputValidator(WavenumberSignals wavenumberSignals) {

		this.wavenumberSignals = wavenumberSignals;
	}

	@Override
	public String isValid(String input) {

		IStatus status = validator.validate(input);
		if(status.isOK()) {
			WavenumberSignal wavenumberSignal = validator.getSetting();
			if(wavenumberSignals.contains(wavenumberSignal)) {
				return "The wavenumber exists already.";
			}
		} else {
			return status.getMessage();
		}
		//
		return null;
	}
}