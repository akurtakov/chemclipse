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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core;

import java.io.Serializable;

import org.eclipse.chemclipse.model.core.ISignal;

// Fluorescence Spectroscopy Signal
public interface ISignalFSD extends ISignal, Serializable {

	float getWavelength();

	void setWavelength(float wavelength);

	double getIntensity();

	void setIntensity(double intensity);
}
