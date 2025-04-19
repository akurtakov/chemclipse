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

import org.eclipse.chemclipse.chromatogram.peak.detector.support.IRawPeak;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.RawPeak;

import junit.framework.TestCase;

/**
 * Tests the raw peak.
 * 
 * @author eselmeister
 */
public class RawPeak_6_Test extends TestCase {

	IRawPeak rawPeak;
	int startScan;
	int maximumScan;
	int stopScan;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		startScan = 16;
		stopScan = 20;
		maximumScan = 15;
		rawPeak = new RawPeak(startScan, maximumScan, stopScan);
	}

	@Override
	protected void tearDown() throws Exception {

		rawPeak = null;
		super.tearDown();
	}

	public void testGetStartScan_1() {

		assertEquals("StartScan", 0, rawPeak.getStartScan());
	}

	public void testGetMaximumScan_1() {

		assertEquals("MaximumScan", 0, rawPeak.getMaximumScan());
	}

	public void testGetStopScan_1() {

		assertEquals("StopScan", 0, rawPeak.getStopScan());
	}
}
