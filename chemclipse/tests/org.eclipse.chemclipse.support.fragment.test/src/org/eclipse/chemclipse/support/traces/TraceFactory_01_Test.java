/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TraceFactory_01_Test {

	@Test
	public void test01() {

		assertEquals(null, TraceFactory.determineTraceType(null));
	}

	@Test
	public void test02() {

		assertEquals(null, TraceFactory.determineTraceType(""));
	}

	@Test
	public void test03() {

		assertEquals(null, TraceFactory.determineTraceType("  "));
	}

	@Test
	public void test04() {

		assertEquals(TraceTandemMSD.class, TraceFactory.determineTraceType("139 > 111.0 @12"));
	}

	@Test
	public void test05() {

		assertEquals(TraceTandemMSD.class, TraceFactory.determineTraceType("139 > 111.0 @12 (x5.8)"));
	}

	@Test
	public void test06() {

		assertEquals(TraceHighResMSD.class, TraceFactory.determineTraceType("400.01627±10ppm"));
	}

	@Test
	public void test07() {

		assertEquals(TraceHighResMSD.class, TraceFactory.determineTraceType("400.01627±10ppm (x4.7)"));
	}

	@Test
	public void test08() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627±0.02"));
	}

	@Test
	public void test09() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627±0.02 (x2.9)"));
	}

	@Test
	public void test10() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627+-0.02"));
	}

	@Test
	public void test11() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627+-0.02 (x2.9)"));
	}

	@Test
	public void test12() {

		assertEquals(TraceHighResMSD.class, TraceFactory.determineTraceType("400.01627+-10ppm"));
	}

	@Test
	public void test13() {

		assertEquals(TraceHighResMSD.class, TraceFactory.determineTraceType("400.01627+-10ppm (x4.7)"));
	}

	@Test
	public void test14() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627±0.02"));
	}

	@Test
	public void test15() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627±0.02 (x2.9)"));
	}

	@Test
	public void test16() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627+-0.02"));
	}

	@Test
	public void test17() {

		assertEquals(TraceGenericDelta.class, TraceFactory.determineTraceType("400.01627+-0.02 (x2.9)"));
	}

	@Test
	public void test18() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("0 - 0"));
	}

	@Test
	public void test19() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("55 - 120"));
	}

	@Test
	public void test20() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("18 28 32 84 207"));
	}

	@Test
	public void test21() {

		/*
		 * Invalid (mixed space and range)
		 * But it can't be validated here. It will be validated when parsing traces
		 */
		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("18 28 32 55 - 65 84 207"));
	}

	@Test
	public void test22() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("69"));
	}

	@Test
	public void test23() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("69.5"));
	}

	@Test
	public void test24() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("79 (x10.5)"));
	}

	@Test
	public void test25() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("79 (x8)"));
	}

	@Test
	public void test26() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("79.4 (x8))"));
	}

	@Test
	public void test27() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("427.240"));
	}

	@Test
	public void test28() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("279.092 (x5.3)"));
	}

	@Test
	public void test29() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("200"));
	}

	@Test
	public void test30() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("427.240"));
	}

	@Test
	public void test31() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("279.092 (x5.3)"));
	}

	@Test
	public void test32() {

		assertEquals(TraceGeneric.class, TraceFactory.determineTraceType("1801 (x1.6)"));
	}
}