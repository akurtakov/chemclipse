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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Equals test.
 * 
 * @author Philip Wenig
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Ion_5_Test {

	private Ion ion1;
	private Ion ion2;

	@BeforeAll
	public void setUp() {

		ion1 = new Ion(5.2f, 4756.3f);
		ion2 = new Ion(2.2f, 4527.3f);
	}

	@Test
	public void testEquals_1() {

		assertNotEquals(ion1, ion2);
	}

	@Test
	public void testEquals_2() {

		assertNotEquals(ion2, ion1);
	}

	@Test
	public void testEquals_3() {

		assertEquals(ion1, ion1);
	}

	@Test
	public void testEquals_4() {

		assertNotNull(ion1);
	}

	@Test
	public void testEquals_5() {

		assertNotEquals(ion2, new Object());
	}

	@Test
	public void testCompareTo_1() {

		assertTrue(1 <= ion1.compareTo(ion2));
	}

	@Test
	public void testCompareTo_2() {

		assertTrue(-1 >= ion2.compareTo(ion1));
	}
}
