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
package org.eclipse.chemclipse.msd.model.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AbstractIon_2_Test {

	private double exactIon;

	@BeforeAll
	public void setUp() throws Exception {

		exactIon = 28.78749204f;
	}

	@Test
	public void testGetIon_1() {

		double ion = AbstractIon.getIon(exactIon, 1);
		assertEquals(28.8d, ion, 0);
	}

	@Test
	public void testGetIon_2() {

		double ion = AbstractIon.getIon(exactIon, 2);
		assertEquals(28.79d, ion, 0);
	}

	@Test
	public void testGetIon_3() {

		double ion = AbstractIon.getIon(exactIon, 3);
		assertEquals(28.787d, ion, 0);
	}

	@Test
	public void testGetIon_4() {

		double ion = AbstractIon.getIon(exactIon, 4);
		assertEquals(28.7875d, ion, 0);
	}

	@Test
	public void testGetIon_5() {

		double ion = AbstractIon.getIon(exactIon, 5);
		assertEquals(28.78749d, ion, 0);
	}

	@Test
	public void testGetIon_6() {

		double ion = AbstractIon.getIon(exactIon, 6);
		assertEquals(28.787493d, ion, 0);
	}

	@Test
	public void testGetIon_7() {

		double ion = AbstractIon.getIon(exactIon, 0);
		assertEquals(28.8d, ion, 0);
	}

	@Test
	public void testGetIon_8() {

		double ion = AbstractIon.getIon(exactIon, -1);
		assertEquals(28.8d, ion, 0);
	}

	@Test
	public void testGetIon_9() {

		double ion = AbstractIon.getIon(exactIon, 7);
		assertEquals(28.8d, ion, 0);
	}
}
