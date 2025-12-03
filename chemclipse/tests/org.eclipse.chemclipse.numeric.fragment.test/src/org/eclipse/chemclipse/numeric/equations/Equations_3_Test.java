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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Check the compilation of a quadratic equation by multiple x,y value pairs
 * using GaussJordan fitting.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Equations_3_Test {

	private IPoint[] points;

	@BeforeAll
	public void setUp() {

		points = new IPoint[4];
		points[0] = new Point(4.0d, 4.0d);
		points[1] = new Point(7.0d, 1.0d);
		points[2] = new Point(6.0d, 3.0d);
		points[3] = new Point(2.0d, 5.0d);
	}

	@Test
	public void testCreateLinearEquation_1() {

		IQuadraticEquation eq = Equations.createQuadraticEquation(points);
		assertEquals(4.371859296482454d, eq.calculateY(0), 0, "X=0");
	}

	@Test
	public void testCreateLinearEquation_2() {

		IQuadraticEquation eq = Equations.createQuadraticEquation(points);
		assertEquals("org.eclipse.chemclipse.numeric.equations.QuadraticEquation[f(x)=-0.1432160804020076x^2 + 0.5552763819095254x + 4.371859296482454]", eq.toString());
	}

	@Test
	public void testCreateLinearEquation_3() {

		IQuadraticEquation equation = Equations.createQuadraticEquation(points);
		assertEquals(7.793890860025901d, equation.getApexValueForX(Apex.POSITIVE), 0);
	}

	@Test
	public void testCreateLinearEquation_4() {

		IQuadraticEquation eq = Equations.createQuadraticEquation(points);
		assertEquals(-3.9166978775698498d, eq.getApexValueForX(Apex.NEGATIVE), 0);
	}
}