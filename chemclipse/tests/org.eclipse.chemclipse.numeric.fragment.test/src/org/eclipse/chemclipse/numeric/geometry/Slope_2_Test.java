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
package org.eclipse.chemclipse.numeric.geometry;

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
public class Slope_2_Test {

	private ISlope slope1, slope2;
	private IPoint p1, p2;

	@BeforeAll
	public void setUp() {

		p1 = new Point(5.0d, 10.0d);
		p2 = new Point(7.0d, 3.0d);
		slope1 = new Slope(p1, p2);
		slope2 = new Slope(p1, p2);
	}

	@Test
	public void testEquals_1() {

		assertEquals(slope1, slope2);
	}

	@Test
	public void testEquals_2() {

		assertEquals(slope2, slope1);
	}

	@Test
	public void testEquals_3() {

		assertNotNull(slope1);
	}

	@Test
	public void testEquals_4() {

		assertNotEquals(slope1, new Object());
	}

	@Test
	public void hashCode_1() {

		assertEquals(slope1.hashCode(), slope2.hashCode());
	}
}
