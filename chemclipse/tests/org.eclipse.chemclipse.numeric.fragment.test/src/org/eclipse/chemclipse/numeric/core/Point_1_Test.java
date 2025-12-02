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
package org.eclipse.chemclipse.numeric.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Point_1_Test {

	private IPoint point;
	private double x = 25.3;
	private double y = 457.7;

	@BeforeEach
	public void setUp() {

		point = new Point(x, y);
	}

	@Test
	public void testPointX_1() {

		assertEquals(x, point.getX(), 0);
	}

	@Test
	public void testPointX_2() {

		assertEquals(x, point.getX(), 0);
		x = 3682.234;
		point.setX(x);
		assertEquals(x, point.getX(), 0);
	}

	@Test
	public void testPointY_1() {

		assertEquals(y, point.getY(), 0);
	}

	@Test
	public void testPointY_2() {

		assertEquals(y, point.getY(), 0);
		y = 8273.3;
		point.setY(y);
		assertEquals(y, point.getY(), 0);
	}
}
