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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Segment_3_Test {

	private ISegment segment;
	private IPoint p1;
	private IPoint p2;
	private IPoint p3;
	private IPoint p4;

	@BeforeAll
	public void setUp() {

		p1 = new Point(1, 2);
		p2 = new Point(10, 20);
		p3 = new Point(100, 200);
		p4 = new Point(1000, 2000);
		segment = new Segment(p1, p2, p3, p4);
	}

	@Test
	public void testPoint_1() {

		assertEquals(1.0d, segment.getChromatogramBaselinePoint1().getX(), 0);
		assertEquals(2.0d, segment.getChromatogramBaselinePoint1().getY(), 0);
	}

	@Test
	public void testPoint_2() {

		assertEquals(10.0d, segment.getChromatogramBaselinePoint2().getX(), 0);
		assertEquals(20.0d, segment.getChromatogramBaselinePoint2().getY(), 0);
	}

	@Test
	public void testPoint_3() {

		assertEquals(100.0d, segment.getPeakBaselinePoint1().getX(), 0);
		assertEquals(200.0d, segment.getPeakBaselinePoint1().getY(), 0);
	}

	@Test
	public void testPoint_4() {

		assertEquals(1000.0d, segment.getPeakBaselinePoint2().getX(), 0);
		assertEquals(2000.0d, segment.getPeakBaselinePoint2().getY(), 0);
	}
}
