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
package org.eclipse.chemclipse.msd.model.support;

import java.util.List;

import org.eclipse.chemclipse.model.support.CalculationType;
import org.eclipse.chemclipse.numeric.statistics.Calculations;

abstract class CombinedMassSpectrumCalculator implements ICombinedMassSpectrumCalculator {

	protected double calculateSumIntensity(List<Double> intensities, CalculationType calculationType) {

		double sum = 0.0d;
		if(intensities != null) {
			int size = intensities.size();
			double[] values = new double[size];
			for(int i = 0; i < size; i++) {
				values[i] = intensities.get(i);
			}
			/*
			 * Add an option here to calculate the sum,
			 * mean or median signal.
			 */
			switch(calculationType) {
				case SUM:
					sum = Calculations.getSum(values);
					break;
				case MEAN:
					sum = Calculations.getMean(values);
					break;
				case MEDIAN:
					sum = Calculations.getMedian(values);
					break;
			}
		}
		return sum;
	}
}
