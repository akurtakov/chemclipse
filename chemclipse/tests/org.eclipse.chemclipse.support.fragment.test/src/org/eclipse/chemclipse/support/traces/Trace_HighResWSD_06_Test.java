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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.support.traces;

public class Trace_HighResWSD_06_Test extends TraceTestCase {

	private TraceHighResWSD trace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		trace = TraceFactory.parseTrace("400.01627+-0.02 (x2.9)", TraceHighResWSD.class);
	}

	public void testWavelength() {

		assertEquals(400.01627d, trace.getWavelength());
	}

	public void testDelta() {

		assertEquals(0.02d, trace.getDelta());
	}

	public void testUseRange() {

		assertTrue(trace.isUseRange());
	}

	public void testStartWavelength() {

		assertEquals(399.99627d, trace.getStartWavelength(), 0.0000000001d);
	}

	public void testStopWavelength() {

		assertEquals(400.03627d, trace.getStopWavelength(), 0.0000000001d);
	}

	public void testScaleFactor() {

		assertEquals(2.9d, trace.getScaleFactor());
	}

	public void testString() {

		assertEquals("400.01627±0.02 (x2.9)", trace.toString());
	}
}