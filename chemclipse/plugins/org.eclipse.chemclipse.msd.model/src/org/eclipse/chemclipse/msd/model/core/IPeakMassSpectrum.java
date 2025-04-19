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
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.core;

/**
 * More informations about the class structure of mass spectra are stored in {@link IScanMSD}.
 */
public interface IPeakMassSpectrum extends IRegularMassSpectrum {

	/**
	 * Adds an {@link IPeakIon} instance to the peak mass spectrum.<br/>
	 * See description addIon in {@link IScanMSD}.
	 * 
	 * @param peakIon
	 * @param checked
	 */
	void addIon(IPeakIon peakIon, boolean checked);

	/**
	 * Adds an {@link IPeakIon} instance to the peak mass spectrum.<br/>
	 * See description addIon in {@link IScanMSD}.
	 * 
	 * @param peakIon
	 */
	void addIon(IPeakIon peakIon);
}