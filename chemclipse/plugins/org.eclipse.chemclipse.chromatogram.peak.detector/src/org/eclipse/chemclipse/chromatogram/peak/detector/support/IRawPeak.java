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
package org.eclipse.chemclipse.chromatogram.peak.detector.support;

import org.eclipse.chemclipse.model.core.PeakPosition;
import org.eclipse.chemclipse.model.core.PeakType;

public interface IRawPeak extends PeakPosition {

	/**
	 * Returns the start scan of the raw peak.
	 * 
	 * @return int
	 */
	int getStartScan();

	/**
	 * Returns the peak maximum.
	 * 
	 * @return int
	 */
	int getMaximumScan();

	/**
	 * Returns the retention time at peak maximum.
	 * 
	 * @return int
	 */
	int getRetentionTimeAtMaximum();

	/**
	 * Sets the retention time at peak maximum.<br/>
	 * The retention time must be >= 0.
	 * 
	 * @param retentionTime
	 */
	void setRetentionTimeAtMaximum(int retentionTime);

	/**
	 * Returns the stop scan of the peak.
	 * 
	 * @return int
	 */
	int getStopScan();

	@Override
	default PeakType getPeakType() {

		return PeakType.DEFAULT;
	}

	@Override
	default int getPeakStart() {

		return getStartScan() - 1;
	}

	@Override
	default int getPeakMaximum() {

		return getMaximumScan() - 1;
	}

	@Override
	default int getPeakEnd() {

		return getStopScan() - 1;
	}
}
