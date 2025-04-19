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

public class DetectorSlope_2_Test extends TestCase {

	private IDetectorSlope slope;
	private IPoint p1, p2;
	private int retentionTime;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		p1 = new Point(1000, 2500);
		p2 = new Point(2000, 4500);
		retentionTime = 1500;
		slope = new DetectorSlope(p1, p2, retentionTime);
	}

	@Override
	protected void tearDown() throws Exception {

		p1 = null;
		p2 = null;
		slope = null;
		super.tearDown();
	}

	public void testGetSlope_1() {

		assertEquals("GetSlope", 2.0d, slope.getSlope());
	}
}
