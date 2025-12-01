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

import org.eclipse.chemclipse.chromatogram.peak.detector.support.IRawPeak;
import org.eclipse.chemclipse.chromatogram.peak.detector.support.RawPeak;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Tests the raw peak.
 * 
 * @author Philip Wenig
 */
@TestInstance(Lifecycle.PER_CLASS)
public class RawPeak_7_Test {

	IRawPeak rawPeak;
	int startScan;
	int maximumScan;
	int stopScan;

	@BeforeAll
	public void setUp() throws Exception {

		startScan = 14;
		stopScan = 20;
		maximumScan = 21;
		rawPeak = new RawPeak(startScan, maximumScan, stopScan);
	}

	@Test
	public void testGetStartScan_1() {

		assertEquals(0, rawPeak.getStartScan());
	}

	@Test
	public void testGetMaximumScan_1() {

		assertEquals(0, rawPeak.getMaximumScan());
	}

	@Test
	public void testGetStopScan_1() {

		assertEquals(0, rawPeak.getStopScan());
	}
}
