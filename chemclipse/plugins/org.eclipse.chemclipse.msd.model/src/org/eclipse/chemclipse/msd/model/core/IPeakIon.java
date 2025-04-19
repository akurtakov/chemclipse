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

public interface IPeakIon extends IIon {

	/**
	 * Returns the uncertainty factor of the ion.<br/>
	 * A factor of 0.0f mean 0%, a factor of 1.0f means 100%.<br/>
	 * 100% means, that this ions belongs surely to the corresponding
	 * mass spectrum.
	 * 
	 * @return float
	 */
	float getUncertaintyFactor();

	/**
	 * Sets the uncertainty factor of the ion.<br/>
	 * A factor of 0.0f mean 0%, a factor of 1.0f means 100%.<br/>
	 * 100% means, that this ions belongs surely to the corresponding
	 * mass spectrum.
	 * 
	 * @param uncertaintyFactor
	 */
	void setUncertaintyFactor(float uncertaintyFactor);

	/**
	 * Returns the peak ion type.
	 * 
	 * @return PeakIonType
	 */
	PeakIonType getPeakIonType();

	/**
	 * Sets the peak ion type.
	 * 
	 * @param peakIonType
	 */
	void setPeakIonType(PeakIonType peakIonType);
}
