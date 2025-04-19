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
package org.eclipse.chemclipse.chromatogram.msd.peak.support;

import org.eclipse.chemclipse.chromatogram.peak.detector.support.DetectorSlope;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.IDetectorSlope;
import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;

import junit.framework.TestCase;

/**
 * ISlope has already been tested in org.eclipse.chemclipse.numeric. Only the
 * IFirstDerivativeSlope additions needs to be tested.
 * 
 * @author eselmeister
 */
public class DetectorSlope_1_Test extends TestCase {

	private IDetectorSlope slope;
	private IPoint p1, p2;
	private int retentionTime;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		p1 = new Point(5.0d, 10.0d);
		p2 = new Point(7.0d, 3.0d);
		retentionTime = 57000;
		slope = new DetectorSlope(p1, p2, retentionTime);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetSlope_1() {

		assertEquals("Slope", -3.5d, slope.getSlope());
	}

	public void testGetRetentionTime_1() {

		assertEquals("RetentionTime", 57000, slope.getRetentionTime());
	}
}
