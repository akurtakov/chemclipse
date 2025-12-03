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
package org.eclipse.chemclipse.numeric.equations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class LinearEquations_2_Test {

	private LinearEquation eq1;
	private LinearEquation eq2;

	@BeforeAll
	public void setUp() {

		IPoint p11 = new Point(1, 4);
		IPoint p12 = new Point(8, 14);
		eq1 = Equations.createLinearEquation(p11, p12);
		eq2 = Equations.createLinearEquation(p11, p12);
	}

	@Test
	public void testEquals_1() {

		assertEquals(eq1, eq2);
	}

	@Test
	public void testEquals_2() {

		assertEquals(eq2, eq1);
	}

	@Test
	public void testEquals_3() {

		assertNotNull(eq1);
	}

	@Test
	public void testEquals_4() {

		assertNotEquals(eq1, new Object());
	}

	@Test
	public void testHashCode_1() {

		assertEquals(eq1.hashCode(), eq2.hashCode());
	}
}
