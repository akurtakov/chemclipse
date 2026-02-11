/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.core;

import java.util.List;

public interface IChromatogramIntegrationSupport {

	/**
	 * Returns the integrator description.
	 */
	String getIntegratorDescription();

	/**
	 * Sets the integrator description.
	 */
	void setIntegratorDescription(String integratorDescription);

	/**
	 * Returns the integrated area of the chromatogram.
	 */
	double getChromatogramIntegratedArea();

	/**
	 * Returns the integrated area of the background.
	 */
	double getBackgroundIntegratedArea();

	/**
	 * Returns the integrated area of the peaks.
	 */
	double getPeakIntegratedArea();

	/**
	 * Sets the integration results.
	 */
	void setIntegratedArea(List<IIntegrationEntry> chromatogramIntegrationEntries, List<IIntegrationEntry> backgroundIntegrationEntries, String integratorDescription);

	/**
	 * Returns the list of integration entries for the chromatographic area.
	 */
	List<IIntegrationEntry> getChromatogramIntegrationEntries();

	/**
	 * Returns the list of integration entries for the background area.
	 */
	List<IIntegrationEntry> getBackgroundIntegrationEntries();

	/**
	 * Removes all background integration entries.
	 */
	void removeAllBackgroundIntegrationEntries();

	/**
	 * Removes all chromatogram integration entries.
	 */
	void removeAllChromatogramIntegrationEntries();
}
