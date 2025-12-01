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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.DetectorSlope;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.DetectorSlopes;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.IDetectorSlope;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.IDetectorSlopes;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Testing calculateMovingAverage
 * 
 * @author Philip Wenig
 */
@TestInstance(Lifecycle.PER_CLASS)
public class DetectorSlopes_3_Test {

	private IDetectorSlope slope;
	private IDetectorSlopes slopes;
	private IPoint p1, p2;
	private int retentionTime;
	private List<Float> abundances;
	private ITotalScanSignals signals;

	@BeforeAll
	public void setUp() throws Exception {

		abundances = new ArrayList<Float>();
		abundances.add(21563.38028f);
		abundances.add(21718.30986f);
		signals = EasyMock.createMock(ITotalScanSignals.class);
		EasyMock.expect(signals.getStartScan()).andStubReturn(1);
		EasyMock.expect(signals.getStopScan()).andStubReturn(abundances.size());
		EasyMock.replay(signals);
		slopes = new DetectorSlopes(signals);
		for(int i = 1; i < abundances.size(); i++) {
			retentionTime = i * 1000;
			p1 = new Point(retentionTime, abundances.get(i - 1));
			p2 = new Point((i + 1) * 1000, abundances.get(i));
			slope = new DetectorSlope(p1, p2, retentionTime);
			slopes.add(slope);
		}
	}

	@Test
	public void testSize_1() {

		assertEquals(1, slopes.size());
	}

	// -----------------------------------------------WindowSize.SCANS_3
	@Test
	public void testCalculateMovingAverage_1() {

		slopes.calculateMovingAverage(3);
		slope = slopes.getDetectorSlope(1);
		assertEquals(0.1549296875, slope.getSlope(), 0);
		assertEquals(1000, slope.getRetentionTime());
	}
}
