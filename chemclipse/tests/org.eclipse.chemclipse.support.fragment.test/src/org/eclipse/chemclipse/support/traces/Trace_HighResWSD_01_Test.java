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

public class Trace_HighResWSD_01_Test extends TraceTestCase {

	private TraceHighResWSD trace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		trace = TraceFactory.parseTrace("427.240", TraceHighResWSD.class);
	}

	public void testWavelength() {

		assertEquals(427.240d, trace.getWavelength());
	}

	public void testDelta() {

		assertEquals(0.0d, trace.getDelta());
	}

	public void testUseRange() {

		assertFalse(trace.isUseRange());
	}

	public void testStartWavelength() {

		assertEquals(427.240d, trace.getStartWavelength(), 0.0000000001d);
	}

	public void testStopWavelength() {

		assertEquals(427.240d, trace.getStopWavelength(), 0.0000000001d);
	}

	public void testScaleFactor() {

		assertEquals(1.0d, trace.getScaleFactor());
	}

	public void testString() {

		assertEquals("427.24", trace.toString());
	}
}