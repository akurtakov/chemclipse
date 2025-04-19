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

public class Trace_Generic_01_Test extends TraceTestCase {

	public void test1() {

		TraceGeneric trace = TraceFactory.parseTrace("427.240", TraceGeneric.class);
		assertEquals(427, trace.getTrace());
		assertEquals(1.0d, trace.getScaleFactor());
		assertEquals("427", trace.toString());
	}

	public void test2() {

		TraceGeneric trace = TraceFactory.parseTrace("427.240 (x8.3)", TraceGeneric.class);
		assertEquals(427, trace.getTrace());
		assertEquals(8.3d, trace.getScaleFactor());
		assertEquals("427 (x8.3)", trace.toString());
	}

	public void test3() {

		TraceGeneric trace = TraceFactory.parseTrace("400.01627±10ppm", TraceGeneric.class);
		assertEquals(400, trace.getTrace());
		assertEquals(1.0d, trace.getScaleFactor());
		assertEquals("400", trace.toString());
	}

	public void test4() {

		TraceGeneric trace = TraceFactory.parseTrace("400.01627±10ppm (x8.3)", TraceGeneric.class);
		assertEquals(400, trace.getTrace());
		assertEquals(8.3d, trace.getScaleFactor());
		assertEquals("400 (x8.3)", trace.toString());
	}

	public void test5() {

		TraceGeneric trace = TraceFactory.parseTrace("400.01627+-10ppm", TraceGeneric.class);
		assertEquals(400, trace.getTrace());
		assertEquals(1.0d, trace.getScaleFactor());
		assertEquals("400", trace.toString());
	}

	public void test6() {

		TraceGeneric trace = TraceFactory.parseTrace("400.01627+-10ppm (x8.3)", TraceGeneric.class);
		assertEquals(400, trace.getTrace());
		assertEquals(8.3d, trace.getScaleFactor());
		assertEquals("400 (x8.3)", trace.toString());
	}

	public void test7() {

		TraceGeneric trace = TraceFactory.parseTrace("139 > 111.0 @12", TraceGeneric.class);
		assertEquals(111, trace.getTrace()); // Daughter m/z
		assertEquals(1.0d, trace.getScaleFactor());
		assertEquals("111", trace.toString());
	}

	public void test8() {

		TraceGeneric trace = TraceFactory.parseTrace("139 > 111.0 @12 (x9.4)", TraceGeneric.class);
		assertEquals(111, trace.getTrace()); // Daughter m/z
		assertEquals(9.4d, trace.getScaleFactor());
		assertEquals("111 (x9.4)", trace.toString());
	}
}