/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.model.core;

import java.math.BigDecimal;

import org.eclipse.chemclipse.model.core.IComplexSignal;

/**
 * The {@link ISpectrumSignal} consists of an acquisition time and an intensity
 *
 * @author Christoph Läubrich
 *
 */
public interface ISpectrumSignal extends IComplexSignal {

	/**
	 *
	 * @return the frequency in Hz
	 */
	BigDecimal getFrequency();

	/**
	 * The absorptive intensity (also known as the "real part" of the signal)
	 *
	 * @return the intensity
	 */
	Number getAbsorptiveIntensity();

	/**
	 * The dispersive intensity (also knows as the "imaginary part" of the signal)
	 *
	 * @return the intensity
	 */
	Number getDispersiveIntensity();

	@Override
	default double getX() {

		return getFrequency().doubleValue();
	}

	@Override
	default double getY() {

		return getAbsorptiveIntensity().doubleValue();
	}

	@Override
	default double getImaginaryY() {

		return getDispersiveIntensity().doubleValue();
	}
}
