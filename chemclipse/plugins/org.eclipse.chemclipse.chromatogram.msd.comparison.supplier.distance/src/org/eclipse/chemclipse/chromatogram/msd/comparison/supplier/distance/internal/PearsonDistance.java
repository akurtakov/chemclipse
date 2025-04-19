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
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class PearsonDistance implements DistanceMeasure {

	private static final long serialVersionUID = -376787276211043721L;

	@Override
	public double compute(double[] a, double[] b) {

		PearsonsCorrelation correlation = new PearsonsCorrelation();
		double pearsonCorrelation = correlation.correlation(a, b);
		return 1 - pearsonCorrelation; // Pearson distance D1
	}
}
