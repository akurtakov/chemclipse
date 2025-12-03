/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.TotalScanSignal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * HashCode and equals test.
 * 
 * @author Philip Wenig
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TotalIonSignal_4_Test {

	private ITotalScanSignal totalIonSignal1;
	private ITotalScanSignal totalIonSignal2;

	@BeforeAll
	public void setUp() {

		totalIonSignal1 = new TotalScanSignal(5720, 1245.5f, 25476.45f);
		totalIonSignal2 = new TotalScanSignal(5720, 1245.5f, 25476.45f);
	}

	@Test
	public void testHashCode_1() {

		assertEquals(totalIonSignal1.hashCode(), totalIonSignal2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertEquals(totalIonSignal2.hashCode(), totalIonSignal1.hashCode());
	}

	@Test
	public void testEquals_1() {

		assertEquals(totalIonSignal1, totalIonSignal2);
	}

	@Test
	public void testEquals_2() {

		assertEquals(totalIonSignal2, totalIonSignal1);
	}

	@Test
	public void testEquals_3() {

		assertNotNull(totalIonSignal1);
	}

	@Test
	public void testEquals_4() {

		assertNotNull(totalIonSignal2);
	}

	@Test
	public void testEquals_5() {

		assertEquals(totalIonSignal1, totalIonSignal1);
	}

	@Test
	public void testEquals_6() {

		assertEquals(totalIonSignal2, totalIonSignal2);
	}

	@Test
	public void testEquals_7() {

		assertNotEquals(totalIonSignal1, new Object());
	}

	@Test
	public void testEquals_8() {

		assertNotEquals(totalIonSignal2, new Object());
	}
}
