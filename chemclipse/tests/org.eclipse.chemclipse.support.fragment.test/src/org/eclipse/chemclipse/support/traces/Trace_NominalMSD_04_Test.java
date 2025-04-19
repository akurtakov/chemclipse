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

public class Trace_NominalMSD_04_Test extends TraceTestCase {

	private TraceNominalMSD trace;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		trace = TraceFactory.parseTrace("79 (x10.5)", TraceNominalMSD.class);
	}

	public void testNull() {

		assertNotNull(trace);
	}

	public void testMZ() {

		assertEquals(79, trace.getMZ());
	}

	public void testScaleFactor() {

		assertEquals(10.5d, trace.getScaleFactor());
	}

	public void testString() {

		assertEquals("79 (x10.5)", trace.toString());
	}
}