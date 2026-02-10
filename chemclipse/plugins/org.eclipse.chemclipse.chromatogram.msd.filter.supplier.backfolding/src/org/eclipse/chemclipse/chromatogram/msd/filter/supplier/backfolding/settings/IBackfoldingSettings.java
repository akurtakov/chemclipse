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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings;

public interface IBackfoldingSettings {

	/**
	 * Returns the number of backfolding runs.
	 */
	int getNumberOfBackfoldingRuns();

	/**
	 * Sets the number of backfolding runs.<br/>
	 * The number must not exceed MIN_BACKFOLDING_RUNS and MAX_BACKFOLDING_RUNS.
	 */
	void setNumberOfBackfoldingRuns(int numberOfBackfoldingRuns);

	/**
	 * Determines how much the retention time for each ion value could be
	 * shifted.
	 */
	int getMaximumRetentionTimeShift();

	/**
	 * Sets how much the retention time for each ion value could be shifted. The
	 * maximumRetentionTimeShift must not exceed MIN_RETENTION_TIME_SHIFT and
	 * MAX_RETENTION_TIME_SHIFT.
	 */
	void setMaximumRetentionTimeShift(int maximumRetentionTimeShift);
}
