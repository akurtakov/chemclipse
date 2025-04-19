/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.identifier.peak;

import org.eclipse.chemclipse.model.exceptions.ValueMustNotBeNullException;
import org.eclipse.chemclipse.model.identifier.IIdentifierSettings;
import org.eclipse.chemclipse.msd.model.core.IChromatogramPeakMSD;

public abstract class AbstractPeakIdentifierMSD implements IPeakIdentifierMSD {

	/**
	 * Validates that the peak is not null.<br/>
	 * If yes, an exception will be thrown.
	 *
	 * @param peak
	 * @throws ValueMustNotBeNullException
	 */
	public void validatePeak(IChromatogramPeakMSD peak) throws ValueMustNotBeNullException {

		if(peak == null) {
			throw new ValueMustNotBeNullException("The peak must not be null.");
		}
	}

	/**
	 * Throws an exception if the settings are null.
	 *
	 * @param identifierSettings
	 * @throws ValueMustNotBeNullException
	 */
	public void validateSettings(IIdentifierSettings identifierSettings) throws ValueMustNotBeNullException {

		if(identifierSettings == null) {
			throw new ValueMustNotBeNullException("The identifier settings must not be null.");
		}
	}
}
