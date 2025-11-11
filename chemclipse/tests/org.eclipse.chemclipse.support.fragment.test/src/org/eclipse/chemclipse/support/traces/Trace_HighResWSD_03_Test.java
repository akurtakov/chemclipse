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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Trace_HighResWSD_03_Test {

	private TraceHighResWSD trace;

	@BeforeAll
	public void setUp() {

		trace = TraceFactory.parseTrace("400.01627±0.02", TraceHighResWSD.class);
	}

	@Test
	public void testWavelength() {

		assertEquals(400.01627d, trace.getWavelength(), 0);
	}

	@Test
	public void testDelta() {

		assertEquals(0.02d, trace.getDelta(), 0);
	}

	@Test
	public void testUseRange() {

		assertTrue(trace.isUseRange());
	}

	@Test
	public void testStartWavelength() {

		assertEquals(399.99627d, trace.getStartWavelength(), 0.0000000001d);
	}

	@Test
	public void testStopWavelength() {

		assertEquals(400.03627d, trace.getStopWavelength(), 0.0000000001d);
	}

	@Test
	public void testScaleFactor() {

		assertEquals(1.0d, trace.getScaleFactor(), 0);
	}

	@Test
	public void testString() {

		assertEquals("400.01627±0.02", trace.toString());
	}
}