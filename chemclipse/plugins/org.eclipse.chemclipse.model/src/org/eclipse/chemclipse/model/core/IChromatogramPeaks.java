/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - use IRetentionTimeRange instead of ChromatogramSelection
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

import java.util.List;

import org.eclipse.chemclipse.model.support.IRetentionTimeRange;

public interface IChromatogramPeaks {

	/**
	 * returns all peaks that are inside the given retention time, that means the retention time is within the start/stop retention time of the peak
	 * 
	 * @return a list of peaks at the given retention time, ordered by the start retention time of the peak
	 */
	List<? extends IChromatogramPeak> getPeaks(int startRetentionTime, int stopRetentionTime);

	/**
	 * Returns a list.
	 * Modification does not change the chromatogram peak list.
	 */
	List<? extends IChromatogramPeak> getPeaks();

	/**
	 * Returns a list.
	 * Modification does not change the chromatogram peak list.
	 */
	default List<? extends IChromatogramPeak> getPeaks(IRetentionTimeRange range) {

		if(range == null) {
			return getPeaks();
		}
		return getPeaks(range.getStartRetentionTime(), range.getStopRetentionTime());
	}
}
