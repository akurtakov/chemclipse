/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core;

import java.io.Serializable;

public interface IScanSignalFSD extends Serializable {

	float TOTAL_INTENSITY = 0.0f;

	/**
	 * Returns the wavelength in nanometer (nm) scale.
	 * 
	 * @return float
	 */
	float getWavelength();

	/**
	 * Sets the wavelength in nanometer (nm) scale.
	 * 
	 */
	void setWavelength(float wavelength);

	/**
	 * Returns the emission units (EU) of the wavelength.
	 * 
	 * @return float
	 */
	float getFluorescence();

	/**
	 * Sets an fluorescence value for the wavelength.
	 * 
	 * @param fluorescence
	 */
	void setFluorescence(float fluorescence);
}
