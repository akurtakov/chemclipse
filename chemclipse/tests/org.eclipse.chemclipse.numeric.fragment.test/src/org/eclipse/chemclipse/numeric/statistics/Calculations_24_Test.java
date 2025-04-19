/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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

public class Calculations_24_Test extends TestCase {

	private int[] values;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		values = new int[]{-1};
	}

	@Override
	protected void tearDown() throws Exception {

		values = null;
		super.tearDown();
	}

	public void testGetMean_1() {

		int min = Calculations.getMin(values);
		assertEquals(-1, min);
	}

	public void testGetMean_2() {

		int max = Calculations.getMax(values);
		assertEquals(-1, max);
	}
}
