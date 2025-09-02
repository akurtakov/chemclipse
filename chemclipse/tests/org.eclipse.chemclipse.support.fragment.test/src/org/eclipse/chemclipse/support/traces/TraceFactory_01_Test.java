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

		assertEquals(TraceEmpty.class, TraceFactory.getTraceType(null, DetectorType.AUTO));
	}

	@Test
	public void test02() {

		assertEquals(TraceEmpty.class, TraceFactory.getTraceType("", DetectorType.AUTO));
	}

	@Test
	public void test03() {

		assertEquals(TraceEmpty.class, TraceFactory.getTraceType("  ", DetectorType.AUTO));
	}

	@Test
	public void test04() {

		assertEquals(TraceTandemMSD.class, TraceFactory.getTraceType("139 > 111.0 @12", DetectorType.MSD));
	}

	@Test
	public void test05() {

		assertEquals(TraceTandemMSD.class, TraceFactory.getTraceType("139 > 111.0 @12 (x5.8)", DetectorType.MSD));
	}

	@Test
	public void test06() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627±10ppm", DetectorType.MSD));
	}

	@Test
	public void test07() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627±10ppm (x4.7)", DetectorType.MSD));
	}

	@Test
	public void test08() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627±0.02", DetectorType.MSD));
	}

	@Test
	public void test09() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627±0.02 (x2.9)", DetectorType.MSD));
	}

	@Test
	public void test10() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627+-0.02", DetectorType.MSD));
	}

	@Test
	public void test11() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627+-0.02 (x2.9)", DetectorType.MSD));
	}

	@Test
	public void test12() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627+-10ppm", DetectorType.MSD));
	}

	@Test
	public void test13() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("400.01627+-10ppm (x4.7)", DetectorType.MSD));
	}

	@Test
	public void test14() {

		assertEquals(TraceHighResWSD.class, TraceFactory.getTraceType("400.01627±0.02", DetectorType.WSD));
	}

	@Test
	public void test15() {

		assertEquals(TraceHighResWSD.class, TraceFactory.getTraceType("400.01627±0.02 (x2.9)", DetectorType.WSD));
	}

	@Test
	public void test16() {

		assertEquals(TraceHighResWSD.class, TraceFactory.getTraceType("400.01627+-0.02", DetectorType.WSD));
	}

	@Test
	public void test17() {

		assertEquals(TraceHighResWSD.class, TraceFactory.getTraceType("400.01627+-0.02 (x2.9)", DetectorType.WSD));
	}

	@Test
	public void test18() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("0 - 0", DetectorType.MSD));
	}

	@Test
	public void test19() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("55 - 120", DetectorType.MSD));
	}

	@Test
	public void test20() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("18 28 32 84 207", DetectorType.MSD));
	}

	@Test
	public void test21() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("18 28 32 55 - 65 84 207", DetectorType.MSD));
	}

	@Test
	public void test21a() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("18, 28, 32, 55 - 65, 84, 207", DetectorType.MSD));
	}

	@Test
	public void test22() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("69", DetectorType.MSD));
	}

	@Test
	public void test23() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("69.5", DetectorType.MSD));
	}

	@Test
	public void test24() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("79 (x10.5)", DetectorType.MSD));
	}

	@Test
	public void test25() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("79 (x8)", DetectorType.MSD));
	}

	@Test
	public void test26() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("79.4 (x8))", DetectorType.MSD));
	}

	@Test
	public void test27() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("427.240", DetectorType.MSD));
	}

	@Test
	public void test28() {

		assertEquals(TraceHighResMSD.class, TraceFactory.getTraceType("279.092 (x5.3)", DetectorType.MSD));
	}

	@Test
	public void test29() {

		assertEquals(TraceRasteredWSD.class, TraceFactory.getTraceType("200", DetectorType.WSD));
	}

	@Test
	public void test30() {

		assertEquals(TraceHighResWSD.class, TraceFactory.getTraceType("427.240", DetectorType.WSD));
	}

	@Test
	public void test31() {

		assertEquals(TraceHighResWSD.class, TraceFactory.getTraceType("279.092 (x5.3)", DetectorType.WSD));
	}

	@Test
	public void test32() {

		assertEquals(TraceRasteredVSD.class, TraceFactory.getTraceType("1800.4", DetectorType.VSD));
	}

	@Test
	public void test33() {

		assertEquals(TraceRasteredVSD.class, TraceFactory.getTraceType("1800.5", DetectorType.VSD));
	}

	@Test
	public void test34() {

		assertEquals(TraceRasteredVSD.class, TraceFactory.getTraceType("1801", DetectorType.VSD));
	}

	@Test
	public void test35() {

		assertEquals(TraceRasteredVSD.class, TraceFactory.getTraceType("1801 (x1.6)", DetectorType.VSD));
	}

	@Test
	public void test36() {

		assertEquals(TraceGenericDelta.class, TraceFactory.getTraceType("1801.203", DetectorType.VSD));
	}

	@Test
	public void test37() {

		assertEquals(TraceGenericDelta.class, TraceFactory.getTraceType("1801.2903 (x1.6)", DetectorType.VSD));
	}

	@Test
	public void test38() {

		assertEquals(TraceNominalMSD.class, TraceFactory.getTraceType("279.1 (x5.32)", DetectorType.MSD));
	}

	@Test
	public void test39() {

		assertEquals(TraceRasteredWSD.class, TraceFactory.getTraceType("400.1 (x5.32)", DetectorType.WSD));
	}

	@Test
	public void test40() {

		assertEquals(TraceRasteredVSD.class, TraceFactory.getTraceType("1800.1 (x5.32)", DetectorType.VSD));
	}
}