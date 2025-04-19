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
package org.eclipse.chemclipse.msd.model.support;

import java.util.Map;

import junit.framework.TestCase;

public class CondenseMassSpectrumCalculator_3_Test extends TestCase {

	private CondenseMassSpectrumCalculator calculator;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		calculator = new CondenseMassSpectrumCalculator(false);
		calculator.add(18.1d, 1000.0d);
		calculator.add(18.1d, 1100.0d);
		calculator.add(18.4d, 1200.0d);
		calculator.add(18.4d, 1300.0d);
		calculator.add(18.9d, 1400.0d);
	}

	@Override
	protected void tearDown() throws Exception {

		calculator = null;
		super.tearDown();
	}

	public void test1() {

		Map<Double, Double> mappedTraces = calculator.getMappedTraces();
		assertEquals(3, mappedTraces.size());
		assertTrue(mappedTraces.containsKey(18.1d));
		assertEquals(2100.0d, mappedTraces.get(18.1d));
		assertTrue(mappedTraces.containsKey(18.4d));
		assertEquals(2500.0d, mappedTraces.get(18.4d));
		assertTrue(mappedTraces.containsKey(18.9d));
		assertEquals(1400.0d, mappedTraces.get(18.9d));
	}
}
