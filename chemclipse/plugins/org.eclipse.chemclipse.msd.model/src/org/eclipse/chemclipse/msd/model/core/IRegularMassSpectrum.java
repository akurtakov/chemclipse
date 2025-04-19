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
 * Alexander Kerner - implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core;

/**
 * More informations about the class structure of mass spectra are stored in {@link IScanMSD}.
 */
public interface IRegularMassSpectrum extends IScanMSD {

	/**
	 * Returns the mass spectrometer number that recorded the mass spectrum.
	 * 1 = MS1
	 * 2 = MS2
	 * 3 = ...
	 * 
	 * @return short
	 */
	short getMassSpectrometer();

	/**
	 * Sets the mass spectrometer (MS1, MS2, ...).
	 * 
	 * @param massSpectrometer
	 */
	void setMassSpectrometer(short massSpectrometer);

	MassSpectrumType getMassSpectrumType();

	void setMassSpectrumType(MassSpectrumType massSpectrumType);

	double getPrecursorIon();

	void setPrecursorIon(double precursorIon);

	double getPrecursorBasePeak();

	void setPrecursorBasePeak(double precursorBasePeak);

	Polarity getPolarity();

	void setPolarity(Polarity polarity);
}