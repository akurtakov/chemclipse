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

public class Trace_TandemMSD_01_Test extends TraceTestCase {

	private TraceTandemMSD trace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		trace = TraceFactory.parseTrace("139 > 111.0 @12", TraceTandemMSD.class);
	}

	public void testNull() {

		assertNotNull(trace);
	}

	public void testParentMZ() {

		assertEquals(139, trace.getParentMZ());
	}

	public void testDaughterMZ() {

		assertEquals(111.0, trace.getDaughterMZ());
	}

	public void testCollisionEnergy() {

		assertEquals(12, trace.getCollisionEnergy());
	}

	public void testScaleFactor() {

		assertEquals(1.0d, trace.getScaleFactor());
	}

	public void testString() {

		assertEquals("139 > 111.0 @12", trace.toString());
	}
}