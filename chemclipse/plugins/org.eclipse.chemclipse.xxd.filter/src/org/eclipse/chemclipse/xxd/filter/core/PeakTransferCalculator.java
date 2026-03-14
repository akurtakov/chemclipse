/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.support.RetentionIndexMap;

public class PeakTransferCalculator {

	public List<? extends IPeak> getSourcePeaks(IChromatogramSelection chromatogramSelection) {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		int startRetentionTime = chromatogramSelection.getStartRetentionTime();
		int stopRetentionTime = chromatogramSelection.getStopRetentionTime();

		return chromatogram.getPeaks(startRetentionTime, stopRetentionTime);
	}

	public List<IPeak> getSinkPeaks(IPeak peak, int coordinateOffset, RetentionIndexMap retentionIndexMap, IChromatogram referenceChromatogram) {

		List<IPeak> peaks = new ArrayList<>();

		boolean useRetentionIndex = retentionIndexMap != null;
		IPeakModel peakModel = peak.getPeakModel();
		int coordinateStart = peakModel.getStartRetentionTime();
		int coordinateStop = peakModel.getStopRetentionTime();
		if(useRetentionIndex) {
			coordinateStart = Math.round(retentionIndexMap.getRetentionIndex(coordinateStart));
			coordinateStop = Math.round(retentionIndexMap.getRetentionIndex(coordinateStop));
		}
		/*
		 * Offset
		 */
		coordinateStart += coordinateOffset;
		coordinateStop += coordinateOffset;
		/*
		 * Select Peaks
		 */
		for(IPeak referencePeak : referenceChromatogram.getPeaks()) {
			IPeakModel referencePeakModel = referencePeak.getPeakModel();
			IScan referencePeakMaximum = referencePeakModel.getPeakMaximum();
			int peakValue = useRetentionIndex ? Math.round(referencePeakMaximum.getRetentionIndex()) : referencePeakMaximum.getRetentionTime();
			if(peakValue >= coordinateStart && peakValue <= coordinateStop) {
				peaks.add(referencePeak);
			}
		}

		return peaks;
	}
}