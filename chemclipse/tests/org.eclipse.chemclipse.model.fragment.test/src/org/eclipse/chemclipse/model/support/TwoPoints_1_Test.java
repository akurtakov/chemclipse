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
package org.eclipse.chemclipse.model.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.eclipse.chemclipse.numeric.equations.LinearEquation;
import org.eclipse.chemclipse.numeric.exceptions.PointIsNullException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TwoPoints_1_Test {

	private IPoint p1;
	private IPoint p2;
	private ITwoPoints points;

	@BeforeAll
	public void setUp() throws PointIsNullException {

		p1 = new Point(5.0d, 10.0d);
		p2 = new Point(7.0d, 3.0d);
		points = new TwoPoints(p1, p2);
	}

	@Test
	public void testGetLinearEquation_1() {

		LinearEquation eq = points.getLinearEquation();
		assertEquals(27.5d, eq.calculateY(0), 0, "X=0");
	}

	@Test
	public void testGetSlope_1() {

		LinearEquation eq = points.getLinearEquation();
		double slope = points.getSlope();
		assertEquals(eq.getA(), slope, 0);
	}

	@Test
	public void testGetPoint_1() {

		assertEquals(5.0d, points.getPoint1().getX(), 0);
	}

	@Test
	public void testGetPoint_2() {

		assertEquals(10.0d, points.getPoint1().getY(), 0);
	}

	@Test
	public void testGetPoint_3() {

		assertEquals(7.0d, points.getPoint2().getX(), 0);
	}

	@Test
	public void testGetPoint_4() {

		assertEquals(3.0d, points.getPoint2().getY(), 0);
	}
}
