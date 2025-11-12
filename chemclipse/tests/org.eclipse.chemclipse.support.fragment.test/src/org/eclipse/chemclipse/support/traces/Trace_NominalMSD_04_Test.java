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
public class Trace_NominalMSD_04_Test {

	private TraceNominalMSD trace;

	@BeforeAll
	public void setUp() {

		trace = TraceFactory.parseTrace("79 (x10.5)", TraceNominalMSD.class);
	}

	@Test
	public void testNull() {

		assertNotNull(trace);
	}

	@Test
	public void testMZ() {

		assertEquals(79, trace.getMZ());
	}

	@Test
	public void testScaleFactor() {

		assertEquals(10.5d, trace.getScaleFactor(), 0);
	}

	@Test
	public void testString() {

		assertEquals("79 (x10.5)", trace.toString());
	}
}