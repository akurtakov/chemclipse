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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Trace_HighResWSD_02_Test {

	private TraceHighResWSD trace;

	@BeforeAll
	public void setUp() {

		trace = TraceFactory.parseTrace("279.092 (x5.3)", TraceHighResWSD.class);
	}

	@Test
	public void testWavelength() {

		assertEquals(279.092d, trace.getWavelength(), 0);
	}

	@Test
	public void testDelta() {

		assertEquals(0.0d, trace.getDelta(), 0);
	}

	@Test
	public void testUseRange() {

		assertFalse(trace.isUseRange());
	}

	@Test
	public void testStartWavelength() {

		assertEquals(279.092d, trace.getStartWavelength(), 0.0000000001d);
	}

	@Test
	public void testStopWavelength() {

		assertEquals(279.092d, trace.getStopWavelength(), 0.0000000001d);
	}

	@Test
	public void testScaleFactor() {

		assertEquals(5.3d, trace.getScaleFactor(), 0);
	}

	@Test
	public void testString() {

		assertEquals("279.092 (x5.3)", trace.toString());
	}
}