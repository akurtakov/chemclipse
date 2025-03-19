/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core.implementation;

import org.eclipse.chemclipse.fsd.model.core.IScanSignalFSD;

public abstract class AbstractScanSignalFSD implements IScanSignalFSD {

	private static final long serialVersionUID = -6938779317853349082L;

	private static final int MAX_PRECISION = 6;

	private float wavelength;
	private float fluorescence;

	@Override
	public float getWavelength() {

		return wavelength;
	}

	@Override
	public void setWavelength(float wavelength) {

		this.wavelength = wavelength;
	}

	@Override
	public float getFluorescence() {

		return fluorescence;
	}

	@Override
	public void setFluorescence(float fluorescence) {

		this.fluorescence = fluorescence;
	}

	public static int getWavelength(double wavelength) {

		return (int)Math.round(wavelength);
	}

	public static double getWavelength(double wavelength, int precision) {

		if(precision <= 0 || precision > MAX_PRECISION) {
			precision = 1;
		}
		double factor = Math.pow(10, precision);
		return Math.round(wavelength * factor) / factor;
	}
}
