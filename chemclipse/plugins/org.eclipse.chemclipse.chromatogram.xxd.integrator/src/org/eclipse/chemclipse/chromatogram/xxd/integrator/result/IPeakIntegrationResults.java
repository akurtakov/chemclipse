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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import java.util.List;

public interface IPeakIntegrationResults {

	/**
	 * Adds a {@link IPeakIntegrationResult}.
	 * 
	 * @param peakIntegrationResult
	 */
	void add(IPeakIntegrationResult peakIntegrationResult);

	/**
	 * Removes a {@link IPeakIntegrationResult}.
	 * 
	 * @param peakIntegrationResult
	 */
	void remove(IPeakIntegrationResult peakIntegrationResult);

	/**
	 * Returns the size of the result list.
	 * 
	 * @return
	 */
	int size();

	/**
	 * Returns the {@link IPeakIntegrationResult} from the position i.<br/>
	 * The index starts at position 0.
	 * 
	 * @param i
	 * @return {@link IPeakIntegrationResult}
	 */
	IPeakIntegrationResult getPeakIntegrationResult(int i);

	/**
	 * Returns the peak integration result list.
	 * 
	 * @return
	 */
	List<IPeakIntegrationResult> getPeakIntegrationResultList();

	/**
	 * Returns a list of peak integration results which have the same integrated
	 * ion.
	 * 
	 * @param ion
	 * @return List
	 */
	List<IPeakIntegrationResult> getPeakIntegrationResultList(int ion);

	/**
	 * Returns a peak integration results list, which stores results that
	 * contain the given ion.
	 * 
	 * @param ion
	 * @return
	 */
	List<IPeakIntegrationResult> getPeakIntegrationResultThatContains(int ion);

	/**
	 * Returns the summed area of all stored integration results.
	 * 
	 * @return
	 */
	double getTotalPeakArea();
}
