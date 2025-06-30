/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import org.eclipse.chemclipse.model.core.IChromatogram;

public class ChromatogramSupport {

	private static final int DEFAULT_SCAN_DELAY = 0;
	private static final int DEFAULT_SCAN_INTERVAL = 100;

	public static void calculateScanIntervalAndDelay(IChromatogram chromatogram) {

		int startRetentionTime = chromatogram.getStartRetentionTime();
		int stopRetentionTime = chromatogram.getStopRetentionTime();
		float deltaRetentionTime = stopRetentionTime - startRetentionTime;
		int numberOfScans = chromatogram.getNumberOfScans();
		/*
		 * Delay
		 */
		int scanDelay = DEFAULT_SCAN_DELAY;
		if(startRetentionTime > 0) {
			scanDelay = startRetentionTime;
		}
		/*
		 * Interval
		 */
		int scanInterval = DEFAULT_SCAN_INTERVAL;
		if(numberOfScans >= 1 && deltaRetentionTime > 0) {
			float calculation = deltaRetentionTime / (numberOfScans - 1) / 10.0f;
			scanInterval = Math.round(calculation) * 10;
		}
		/*
		 * Adjust the retention times.
		 */
		chromatogram.setScanDelay(scanDelay);
		chromatogram.setScanInterval(scanInterval);
	}
}