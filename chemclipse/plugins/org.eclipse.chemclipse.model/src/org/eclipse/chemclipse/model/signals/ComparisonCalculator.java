/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.signals;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.linear.ArrayRealVector;

public class ComparisonCalculator {

	/**
	 * Calculate the cosine similarity of both arrays.
	 * There is no need to nominalize the data to unit vector.
	 * This is done automatically when running the comparison.
	 * 
	 * @param unknown
	 * @param reference
	 * @return double
	 */
	public double calculateMatch(double[] unknown, double[] reference) {

		ArrayRealVector vectorUnknown = new ArrayRealVector(unknown);
		ArrayRealVector vectorReference = new ArrayRealVector(reference);

		return calculateCosine(vectorUnknown, vectorReference);
	}

	private double calculateCosine(ArrayRealVector vectorUnknown, ArrayRealVector vectorReference) {

		try {
			return vectorUnknown.unitVector().cosine(vectorReference.unitVector());
		} catch(MathArithmeticException | DimensionMismatchException e) {
			return 0;
		}
	}
}