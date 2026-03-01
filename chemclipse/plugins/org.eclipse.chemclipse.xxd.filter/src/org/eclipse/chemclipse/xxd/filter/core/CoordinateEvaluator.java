/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.eclipse.chemclipse.xxd.filter.model.RangeOption;

public class CoordinateEvaluator {

	public static boolean isMatchPeak(IPeak peak, CoordinateOption coordinateOption, RangeOption rangeOption, double coordinateValue) {

		if(peak != null) {
			IPeakModel peakModel = peak.getPeakModel();
			return isMatchScan(peakModel.getPeakMaximum(), coordinateOption, rangeOption, coordinateValue);
		}

		return false;
	}

	public static boolean isMatchScan(IScan scan, CoordinateOption coordinateOption, RangeOption rangeOption, double coordinateValue) {

		if(scan != null) {
			/*
			 * Use -1 as 0 is a valid retention time,
			 * in most cases when GC-FID is used.
			 */
			double targetValue = -1;
			switch(coordinateOption) {
				case RETENTION_TIME_MS:
					targetValue = scan.getRetentionTime();
					break;
				case RETENTION_TIME_MIN:
					targetValue = scan.getRetentionTime() / IChromatogramOverview.MINUTE_CORRELATION_FACTOR;
					break;
				case RETENTION_INDEX:
					/*
					 * The retention index is 0 by default if not set.
					 * Allowing 0 could lead to an empty chromatogram.
					 */
					double retentionIndex = scan.getRetentionIndex();
					if(retentionIndex > 0) {
						targetValue = retentionIndex;
					}
					break;
				default:
					break;
			}
			/*
			 * Validate
			 */
			if(targetValue > -1) {
				return isMatch(targetValue, rangeOption, coordinateValue);
			}
		}

		return false;
	}

	public static boolean isMatch(double targetValue, RangeOption rangeOption, double coordinateValue) {

		boolean isMatch = false;
		switch(rangeOption) {
			case EQUALS:
				isMatch = (targetValue == coordinateValue);
				break;
			case LOWER:
				isMatch = (targetValue < coordinateValue);
				break;
			case LOWER_EQUALS:
				isMatch = (targetValue <= coordinateValue);
				break;
			case HIGHER:
				isMatch = (targetValue > coordinateValue);
				break;
			case HIGHER_EQUALS:
				isMatch = (targetValue >= coordinateValue);
				break;
			default:
				break;
		}

		return isMatch;
	}
}