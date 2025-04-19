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
package org.eclipse.chemclipse.numeric.statistics;

import junit.framework.TestCase;

/**
 * Testing median.
 * 
 * @author eselmeister
 */
public class Calculations_19_Test extends TestCase {

	private int[] values;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		values = new int[13];
		values[0] = 735;
		values[1] = 504;
		values[2] = 561;
		values[3] = 504;
		values[4] = 400;
		values[5] = 420;
		values[6] = 501;
		values[7] = 443;
		values[8] = 430;
		values[9] = 337;
		values[10] = 345;
		values[11] = 304;
		values[12] = 381;
	}

	@Override
	protected void tearDown() throws Exception {

		values = null;
		super.tearDown();
	}

	public void testGetMean_1() {

		int mean = Calculations.getMean(values);
		assertEquals("mean", 451, mean);
	}

	public void testGetMean_2() {

		values = null;
		int mean = Calculations.getMean(values);
		assertEquals("mean", 0, mean);
	}

	public void testGetMedian_1() {

		int median = Calculations.getMedian(values);
		assertEquals("median", 430, median);
	}

	public void testGetMedian_2() {

		values = null;
		int median = Calculations.getMedian(values);
		assertEquals("median", 0, median);
	}
}
