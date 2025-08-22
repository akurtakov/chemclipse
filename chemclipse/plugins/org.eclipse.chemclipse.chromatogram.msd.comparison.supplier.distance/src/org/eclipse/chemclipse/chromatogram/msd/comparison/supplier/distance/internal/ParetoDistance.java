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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.comparison.supplier.distance.internal;

import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class ParetoDistance implements DistanceMeasure {

	private static final long serialVersionUID = -4594150285363092416L;

	private double power = 0.75;

	public ParetoDistance(double power) {

		this.power = power;
	}

	@Override
	public double compute(double[] x, double[] y) {

		if(x.length != y.length || x.length == 0) {
			throw new IllegalArgumentException("Arrays must be non-empty and of the same length");
		}
		double covXY = new Covariance().covariance(x, y);
		double covXX = new Covariance().covariance(x, x);
		double sigmaX = new StandardDeviation().evaluate(x);
		double sigmaY = new StandardDeviation().evaluate(y);
		double rXY = covXY / (Math.pow(sigmaX * sigmaY, power));
		double rXX = covXX / (Math.pow(sigmaX * sigmaX, power));
		if(rXX == 0) {
			throw new ArithmeticException("Scaled self-correlation is zero, cannot divide by zero.");
		}
		double scaledCorrelation = rXY / rXX;
		return 1 - scaledCorrelation;
	}
}