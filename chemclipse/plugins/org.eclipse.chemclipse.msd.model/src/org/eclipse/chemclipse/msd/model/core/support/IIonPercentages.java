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
package org.eclipse.chemclipse.msd.model.core.support;

import java.util.List;

import org.eclipse.chemclipse.msd.model.core.IScanMSD;

public interface IIonPercentages {

	int MAX_PERCENTAGE = 100;

	/**
	 * Returns the stored mass spectrum.
	 * 
	 * @return IMassSpectrum
	 */
	IScanMSD getMassSpectrum();

	/**
	 * Returns the percentage amount for the given ion.<br/>
	 * The total signal of the mass spectrum is equal 100% (or MAX_PERCENTAGE).<br/>
	 * Each single mass spectrum has a lower value.
	 * 
	 * @param ion
	 * @return float
	 */
	float getPercentage(int ion);

	/**
	 * Returns the summed percentage for the given ions.<br/>
	 * The total signal of the mass spectrum is equal 100% (or MAX_PERCENTAGE).<br/>
	 * Each single mass spectrum has a lower value.
	 * 
	 * @param ions
	 * @return float
	 */
	float getPercentage(List<Integer> ions);
}
