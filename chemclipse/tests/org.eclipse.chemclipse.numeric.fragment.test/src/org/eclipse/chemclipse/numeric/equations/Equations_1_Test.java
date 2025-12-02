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

import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.junit.jupiter.api.Test;

/**
 * Check the compilation of a linear equation.
 */
public class Equations_1_Test {

	@Test
	public void testCreateLinearEquation_1() {

		IPoint p1 = new Point(5.0d, 10.0d);
		IPoint p2 = new Point(7.0d, 3.0d);
		LinearEquation eq = Equations.createLinearEquation(p1, p2);
		assertEquals(27.5d, eq.calculateY(0), 0, "X=0");
	}

	@Test
	public void testCreateLinearEquation_2() {

		IPoint p1 = new Point(5.0d, 10.0d);
		IPoint p2 = new Point(7.0d, 3.0d);
		LinearEquation eq = Equations.createLinearEquation(p1, p2);
		assertEquals("org.eclipse.chemclipse.numeric.equations.LinearEquation[f(x)=-3.5x + 27.5]", eq.toString());
	}

	@Test
	public void testGetSlope_1() {

		IPoint p1 = new Point(5.0d, 10.0d);
		IPoint p2 = new Point(7.0d, 3.0d);
		assertEquals(-3.5d, Equations.calculateSlope(p1, p2), 0);
	}

	@Test
	public void testGetSlope_2() {

		IPoint p1 = null;
		IPoint p2 = new Point(7.0d, 3.0d);
		assertEquals(0.0d, Equations.calculateSlope(p1, p2), 0);
	}

	@Test
	public void testGetSlope_3() {

		IPoint p1 = new Point(5.0d, 10.0d);
		IPoint p2 = null;
		assertEquals(0.0d, Equations.calculateSlope(p1, p2), 0);
	}
}
