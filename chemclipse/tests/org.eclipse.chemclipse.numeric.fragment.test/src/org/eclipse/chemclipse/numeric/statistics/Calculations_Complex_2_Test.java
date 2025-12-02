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
 *******************************************************************************/
package org.eclipse.chemclipse.numeric.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.numeric.statistics.model.UnivariateStatistics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Calculations_Complex_2_Test {

	private double[] values;

	@BeforeAll
	public void setUp() {

		values = new double[13];
		values[0] = 735.0d;
		values[1] = 504.0d;
		values[2] = 561.0d;
		values[3] = 504.0d;
		values[4] = 400.0d;
		values[5] = 420.0d;
		values[6] = 501.0d;
		values[7] = 443.0d;
		values[8] = 430.0d;
		values[9] = 337.0d;
		values[10] = 345.0d;
		values[11] = 304.0d;
		values[12] = 381.0d;
	}

	@Test
	public void testCalculations_Complex_1() {

		/*
		 * Set up the statistics object;
		 */
		UnivariateStatistics statistics = new UnivariateStatistics(values);
		assertEquals(values.length, statistics.getSampleSize());
		assertEquals(451.1538d, statistics.getMean(), 1E-4d);
		assertEquals(12973.47d, statistics.getVariance(), 1E-2d);
		assertEquals(113.9012d, statistics.getStandardDeviation(), 1E-3d);
		assertEquals(430d, statistics.getMedian(), 0);
		assertEquals(0.2524663d, statistics.getRelativeStandardDeviation(), 1E-7d);
	}
}