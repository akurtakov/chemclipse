/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model;

import java.util.List;

public interface IPeakIdentificationBatchJob {

	String getName();

	/**
	 * Returns the list of peak input entries.
	 */
	List<IPeakInputEntry> getPeakInputEntries();

	/**
	 * Returns the list of peak output entries.
	 */
	List<IPeakOutputEntry> getPeakOutputEntries();

	/**
	 * Returns the peak integrator.
	 */
	IPeakIntegrationEntry getPeakIntegrationEntry();

	/**
	 * Sets the peak integrator.
	 */
	void setPeakIntegrationEntry(IPeakIntegrationEntry peakIntegrationEntry);

	/**
	 * Returns the peak identifier.
	 */
	IPeakIdentificationEntry getPeakIdentificationEntry();

	/**
	 * Sets the peak identifier.
	 */
	void setPeakIdentificationEntry(IPeakIdentificationEntry peakIdentificationEntry);

	/**
	 * Returns the report folder.
	 */
	String getReportFolder();

	/**
	 * Set the report folder.
	 */
	void setReportFolder(String reportFolder);

	/**
	 * Override the reports.
	 */
	boolean isOverrideReport();

	/**
	 * Sets whether to override reports or not.
	 */
	void setOverrideReport(boolean overrideReport);
}
