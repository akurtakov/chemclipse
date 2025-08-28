/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.core.support;

import java.util.List;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IScan;

public class PeakSupport {

	public static IPeak selectNearestPeak(List<? extends IPeak> peaks, IPeak peak, boolean useRetentionIndex) {

		if(useRetentionIndex) {
			return selectNearestPeakByRetentionIndex(peaks, Math.round(peak.getPeakModel().getPeakMaximum().getRetentionIndex()));
		} else {
			return selectNearestPeakByRetentionTime(peaks, peak.getPeakModel().getRetentionTimeAtPeakMaximum());
		}
	}

	public static IPeak selectNearestPeakByRetentionTime(List<? extends IPeak> peaks, int retentionTime) {

		return selectNearestPeak(peaks, retentionTime, false);
	}

	public static IPeak selectNearestPeakByRetentionIndex(List<? extends IPeak> peaks, int retentionIndex) {

		return selectNearestPeak(peaks, retentionIndex, true);
	}

	private static IPeak selectNearestPeak(List<? extends IPeak> peaks, int coordinate, boolean useRetentionIndex) {

		IPeak nearestPeak = null;
		for(IPeak peak : peaks) {
			if(nearestPeak == null) {
				nearestPeak = peak;
			} else {
				IScan scanNearest = nearestPeak.getPeakModel().getPeakMaximum();
				IScan scan = peak.getPeakModel().getPeakMaximum();
				int deltaNearest = Math.abs(coordinate - (useRetentionIndex ? Math.round(scanNearest.getRetentionIndex()) : scanNearest.getRetentionTime()));
				int deltaCurrent = Math.abs(coordinate - (useRetentionIndex ? Math.round(scan.getRetentionIndex()) : scan.getRetentionTime()));
				if(deltaCurrent <= deltaNearest) {
					nearestPeak = peak;
				}
			}
		}

		return nearestPeak;
	}
}