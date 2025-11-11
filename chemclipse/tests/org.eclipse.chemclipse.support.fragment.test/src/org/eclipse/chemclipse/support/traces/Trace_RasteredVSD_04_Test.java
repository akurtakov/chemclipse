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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Trace_RasteredVSD_04_Test {

	private TraceRasteredVSD trace;

	@BeforeAll
	public void setUp() {

		trace = TraceFactory.parseTrace("1801 (x1.6)", TraceRasteredVSD.class);
	}

	@Test
	public void testNull() {

		assertNotNull(trace);
	}

	@Test
	public void testWavenumber() {

		assertEquals(1801, trace.getWavenumber());
	}

	@Test
	public void testScaleFactor() {

		assertEquals(1.6d, trace.getScaleFactor(), 0);
	}

	@Test
	public void testString() {

		assertEquals("1801 (x1.6)", trace.toString());
	}
}