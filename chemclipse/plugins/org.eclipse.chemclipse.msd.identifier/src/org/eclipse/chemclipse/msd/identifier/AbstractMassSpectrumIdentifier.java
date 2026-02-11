/*******************************************************************************
 * Copyright (c) 2010, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.identifier;

import org.eclipse.chemclipse.model.exceptions.ValueMustNotBeNullException;
import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;

public abstract class AbstractMassSpectrumIdentifier implements IMassSpectrumIdentifier {

	/**
	 * Validates that the peak is not null.<br/>
	 * If yes, an exception will be thrown.
	 */
	public void validateMassSpectrum(IScanMSD massSpectrum) throws ValueMustNotBeNullException {

		if(massSpectrum == null) {
			throw new ValueMustNotBeNullException("The mass spectrum must not be null.");
		}
	}

	/**
	 * Throws an exception if the settings are null.
	 */
	public void validateSettings(IIdentifierSettings identifierSettings) throws ValueMustNotBeNullException {

		if(identifierSettings == null) {
			throw new ValueMustNotBeNullException("The identifier settings must not be null.");
		}
	}
}
