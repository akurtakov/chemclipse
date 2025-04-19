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

public class Trace_HighResWSD_02_Test extends TraceTestCase {

	private TraceHighResWSD trace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		trace = TraceFactory.parseTrace("279.092 (x5.3)", TraceHighResWSD.class);
	}

	public void testWavelength() {

		assertEquals(279.092d, trace.getWavelength());
	}

	public void testDelta() {

		assertEquals(0.0d, trace.getDelta());
	}

	public void testUseRange() {

		assertFalse(trace.isUseRange());
	}

	public void testStartWavelength() {

		assertEquals(279.092d, trace.getStartWavelength(), 0.0000000001d);
	}

	public void testStopWavelength() {

		assertEquals(279.092d, trace.getStopWavelength(), 0.0000000001d);
	}

	public void testScaleFactor() {

		assertEquals(5.3d, trace.getScaleFactor());
	}

	public void testString() {

		assertEquals("279.092 (x5.3)", trace.toString());
	}
}