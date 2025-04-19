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

public class Trace_HighResMSD_02_Test extends TraceTestCase {

	private TraceHighResMSD trace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		trace = TraceFactory.parseTrace("279.092 (x5.3)", TraceHighResMSD.class);
	}

	public void testMZ() {

		assertEquals(279.092d, trace.getMZ());
	}

	public void testDelta() {

		assertEquals(0.0d, trace.getDelta());
	}

	public void testUseRange() {

		assertFalse(trace.isUseRange());
	}

	public void testStartMZ() {

		assertEquals(279.092d, trace.getStartMZ(), 0.0000000001d);
	}

	public void testStopMZ() {

		assertEquals(279.092d, trace.getStopMZ(), 0.0000000001d);
	}

	public void testScaleFactor() {

		assertEquals(5.3d, trace.getScaleFactor());
	}

	public void testString() {

		assertEquals("279.092 (x5.3)", trace.toString());
	}
}