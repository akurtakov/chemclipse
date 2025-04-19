/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Dr. Janos Binder - initial API and implementation
 * Philip Wenig - reduce compiler warnings
 *******************************************************************************/
package org.eclipse.chemclipse.numeric.statistics.model;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class UnivariateStatistics implements IUnivariateStatistics {

	private final int sampleSize;
	private final double[] abundances;
	private final Mean mean;
	private final Variance variance;
	private final StandardDeviation sd;
	private final Percentile percentile;

	public UnivariateStatistics(int sampleSize, double[] abundances, Mean mean, Variance variance, StandardDeviation sd, Percentile percentile) {

		this.sampleSize = sampleSize;
		this.abundances = abundances;
		this.mean = mean;
		this.variance = variance;
		this.sd = sd;
		this.percentile = percentile;
	}

	public UnivariateStatistics(double[] abundances) {

		this(abundances.length, abundances, new Mean(), new Variance(), new StandardDeviation(), new Percentile());
		mean.setData(abundances);
		variance.setData(abundances);
		sd.setData(abundances);
		percentile.setData(abundances);
	}

	@Override
	public int getSampleSize() {

		return sampleSize;
	}

	@Override
	public double getMean() {

		return mean.evaluate();
	}

	@Override
	public double getVariance() {

		return variance.evaluate();
	}

	@Override
	public double getStandardDeviation() {

		return sd.evaluate();
	}

	@Override
	public double[] getValues() {

		return abundances;
	}

	@Override
	public double getMedian() {

		percentile.setQuantile(50.0d);
		return percentile.evaluate();
	}

	@Override
	public double getRelativeStandardDeviation() {

		double std = sd.evaluate();
		double m = mean.evaluate();
		return std / m;
	}
}