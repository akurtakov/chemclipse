/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.noise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorSupport_1_Test {

	private CalculatorSupport calculatorSupport = new CalculatorSupport();

	@Test
	public void testAcceptSegment_1() {

		double[] values = new double[13];
		values[0] = 20;
		values[1] = 10;
		values[2] = 20;
		values[3] = 10;
		values[4] = 10;
		values[5] = 20;
		values[6] = 10;
		values[7] = 10;
		values[8] = 20;
		values[9] = 10;
		values[10] = 10;
		values[11] = 20;
		values[12] = 10;
		double mean = 13.8461538461538;
		assertTrue(calculatorSupport.acceptSegment(values, mean), "9 crossings");
	}

	@Test
	public void testAcceptSegment_2() {

		double[] values = new double[13];
		values[0] = 20;
		values[1] = 10;
		values[2] = 20;
		values[3] = 10;
		values[4] = 10;
		values[5] = 20;
		values[6] = 10;
		values[7] = 10;
		values[8] = 20;
		values[9] = 10;
		values[10] = 10;
		values[11] = 10;
		values[12] = 10;
		double mean = 13.0769230769231;
		assertTrue(calculatorSupport.acceptSegment(values, mean), "7 crossings");
	}

	@Test
	public void testAcceptSegment_3() {

		double[] values = new double[13];
		values[0] = 10;
		values[1] = 10;
		values[2] = 20;
		values[3] = 10;
		values[4] = 10;
		values[5] = 20;
		values[6] = 10;
		values[7] = 10;
		values[8] = 20;
		values[9] = 10;
		values[10] = 10;
		values[11] = 10;
		values[12] = 10;
		double mean = 12.3076923076923;
		assertFalse(calculatorSupport.acceptSegment(values, mean), "6 crossings");
	}

	@Test
	public void testAcceptSegment_4() {

		double[] values = new double[13];
		values[0] = 10;
		values[1] = 10;
		values[2] = 10;
		values[3] = 10;
		values[4] = 10;
		values[5] = 20;
		values[6] = 10;
		values[7] = 10;
		values[8] = 20;
		values[9] = 10;
		values[10] = 10;
		values[11] = 10;
		values[12] = 10;
		double mean = 11.5384615384615;
		assertFalse(calculatorSupport.acceptSegment(values, mean), "4 crossings");
	}
}
