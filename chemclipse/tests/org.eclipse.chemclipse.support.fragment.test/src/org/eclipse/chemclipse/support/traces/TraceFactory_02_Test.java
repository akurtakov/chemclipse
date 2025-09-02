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
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TraceFactory_02_Test {

	@Test
	public void test01() {

		assertEquals("'null'", TraceFactory.validate(null));
	}

	@Test
	public void test02() {

		assertNull(TraceFactory.validate(""));
	}

	@Test
	public void test03() {

		assertNull(TraceFactory.validate("  "));
	}

	@Test
	public void test04() {

		assertNull(TraceFactory.validate("139 > 111.0 @12"));
	}

	@Test
	public void test05() {

		assertNull(TraceFactory.validate("139 > 111.0 @12 (x5.8)"));
	}

	@Test
	public void test06() {

		assertNull(TraceFactory.validate("400.01627±10ppm"));
	}

	@Test
	public void test07() {

		assertNull(TraceFactory.validate("400.01627±10ppm (x4.7)"));
	}

	@Test
	public void test08() {

		assertNull(TraceFactory.validate("400.01627±0.02"));
	}

	@Test
	public void test09() {

		assertNull(TraceFactory.validate("400.01627±0.02 (x2.9)"));
	}

	@Test
	public void test10() {

		assertNull(TraceFactory.validate("0 - 0"));
	}

	@Test
	public void test11() {

		assertNull(TraceFactory.validate("55 - 120"));
	}

	@Test
	public void test12() {

		assertNull(TraceFactory.validate("18 28 32 84 207"));
	}

	@Test
	public void test13() {

		assertNull(TraceFactory.validate("18 28 32 55 - 65 84 207"));
	}

	@Test
	public void test13a() {

		assertNull(TraceFactory.validate("18 28 32 55 - 65 84 92 - 96 207"));
	}

	@Test
	public void test14() {

		assertNull(TraceFactory.validate("18, 28, 32, 55 - 65, 84, 207"));
	}

	@Test
	public void test14a() {

		assertNull(TraceFactory.validate("18, 28, 32, 55 - 65, 84, 92 - 96, 207"));
	}

	@Test
	public void test15() {

		assertNull(TraceFactory.validate("69"));
	}

	@Test
	public void test16() {

		assertNull(TraceFactory.validate("69.5"));
	}

	@Test
	public void test17() {

		assertNull(TraceFactory.validate("79 (x10.5)"));
	}

	@Test
	public void test18() {

		assertNull(TraceFactory.validate("79 (x8)"));
	}

	@Test
	public void test19() {

		assertNull(TraceFactory.validate("79.4 (x8))"));
	}

	@Test
	public void test20() {

		assertNull(TraceFactory.validate("427.240"));
	}

	@Test
	public void test21() {

		assertNull(TraceFactory.validate("279.092 (x5.3)"));
	}

	@Test
	public void test22() {

		assertNull(TraceFactory.validate("200"));
	}

	@Test
	public void test23() {

		assertNull(TraceFactory.validate("427.240"));
	}

	@Test
	public void test24() {

		assertNull(TraceFactory.validate("1800.4"));
	}

	@Test
	public void test25() {

		assertNull(TraceFactory.validate("1800.5"));
	}

	@Test
	public void test26() {

		assertNull(TraceFactory.validate("1801"));
	}

	@Test
	public void test27() {

		assertNull(TraceFactory.validate("1801 (x1.6)"));
	}

	@Test
	public void test28() {

		assertNull(TraceFactory.validate("1801.203"));
	}

	@Test
	public void test29() {

		assertNull(TraceFactory.validate("1801.2903 (x1.6)"));
	}

	@Test
	public void test30() {

		assertNull(TraceFactory.validate("279.1 (x5.32)"));
	}

	@Test
	public void test31() {

		assertNull(TraceFactory.validate("400.1 (x5.32)"));
	}

	@Test
	public void test32() {

		assertNull(TraceFactory.validate("1800.1 (x5.32)"));
	}
}