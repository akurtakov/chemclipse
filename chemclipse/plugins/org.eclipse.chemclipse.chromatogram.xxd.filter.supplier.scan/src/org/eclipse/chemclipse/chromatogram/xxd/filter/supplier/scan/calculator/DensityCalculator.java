/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.calculator;

import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.core.DensityOperation;
import org.eclipse.chemclipse.numeric.statistics.Calculations;

public class DensityCalculator {

	private static final int MAX_MODIFICATIONS = 999;
	private static final int MILLISECONDS_PER_SECOND = 1000;

	public DensityOperation calculateScanModification(int scansPerSecond, int scanIntervalCurrent) {

		DensityOperation densityOperation = DensityOperation.NONE;
		if(scansPerSecond > 0 && scansPerSecond <= MILLISECONDS_PER_SECOND) {
			/*
			 * Increase/Decrease Density
			 */
			double scanIntervalTarget = calculateTargetInterval(scansPerSecond);
			double factor = scanIntervalCurrent / (scanIntervalTarget * 1.0d);
			if(factor > 1) {
				float increase = Math.round(factor);
				if(increase >= 2) {
					densityOperation = DensityOperation.INCREASE_ADD;
					densityOperation.setModifications(validateScanModifications(Math.round(increase)));
				} else {
					densityOperation = DensityOperation.INCREASE_ADJUST;
				}
			} else if(factor < 1) {
				/*
				 * Decrease Density
				 */
				factor = 1.0d / factor;
				float decrease = Math.round(factor);
				if(decrease >= 2) {
					densityOperation = DensityOperation.DECREASE_REMOVE;
					densityOperation.setModifications(validateScanModifications(Math.round(decrease)) * -1);
				} else {
					densityOperation = DensityOperation.DECREASE_ADJUST;
				}
			}
		}

		return densityOperation;
	}

	public int[] adjustRetentionTimes(int[] times, int scansPerSecond) {

		int[] retentionTimes = null;
		if(times.length > 0) {
			int size = times.length;
			int scanIntervalCurrent = calculateScanInterval(times);
			if(scanIntervalCurrent > 0) {
				DensityOperation densityOperation = calculateScanModification(scansPerSecond, scanIntervalCurrent);
				if(!DensityOperation.NONE.equals(densityOperation)) {
					if(densityOperation.getModifications() >= 0) {
						int scanIntervalTarget = (int)(Math.round(calculateTargetInterval(scansPerSecond)));
						scanIntervalCurrent = adjustScanInterval(scanIntervalCurrent, scanIntervalTarget);
						int halfWidth = scanIntervalTarget / 2;
						retentionTimes = new int[size];
						for(int i = 0; i < size; i++) {
							int time = times[i];
							int delta = time % scanIntervalCurrent;
							if(delta <= halfWidth) {
								retentionTimes[i] = time - delta;
							} else {
								int timeStep = time + scanIntervalCurrent;
								int deltaStep = timeStep % scanIntervalCurrent;
								retentionTimes[i] = timeStep - deltaStep;
							}
						}
					}
				}
			}
		}

		if(retentionTimes == null) {
			retentionTimes = new int[0];
		}

		return retentionTimes;
	}

	public int adjustScanInterval(int scanIntervalSource, int scanInterval) {

		int result = 0;
		if(scanInterval > 0) {
			if(scanIntervalSource == scanInterval) {
				result = scanIntervalSource;
			} else {
				int delta = scanIntervalSource % scanInterval;
				if(delta == 0) {
					result = scanIntervalSource;
				} else {
					result = (scanIntervalSource + scanInterval) - delta;
				}
			}
		}

		return result;
	}

	public int calculateScanInterval(int[] retentionTimes) {

		int scanInterval = 0;
		int size = retentionTimes.length - 1;
		if(size >= 2) {
			int[] retentionTimeDeltas = new int[size];
			for(int i = 0; i < size; i++) {
				retentionTimeDeltas[i] = retentionTimes[i + 1] - retentionTimes[i];
			}
			scanInterval = Calculations.getMedian(retentionTimeDeltas);
		}

		return scanInterval;
	}

	private double calculateTargetInterval(int scansPerSecond) {

		return MILLISECONDS_PER_SECOND * 1d / scansPerSecond;
	}

	private int validateScanModifications(int scanModification) {

		int modifications = 1;
		if(scanModification > MAX_MODIFICATIONS) {
			modifications = MAX_MODIFICATIONS;
		} else {
			modifications = scanModification - 1;
		}

		return modifications;
	}
}