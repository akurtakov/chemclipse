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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class RawPeak_4_Test {

	IRawPeak rawPeak1, rawPeak2;
	int startScan;
	int maximumScan;
	int stopScan;

	@BeforeAll
	public void setUp() throws Exception {

		startScan = 5;
		stopScan = 20;
		maximumScan = 15;
		rawPeak1 = new RawPeak(startScan, maximumScan, stopScan);
		rawPeak2 = new RawPeak(startScan, 16, stopScan);
	}

	@Test
	public void testEquals_1() {

		assertNotEquals(rawPeak1, rawPeak2);
	}

	@Test
	public void testEquals_2() {

		assertNotEquals(rawPeak2, rawPeak1);
	}

	@Test
	public void testEquals_3() {

		assertNotNull(rawPeak1);
	}

	@Test
	public void testEquals_4() {

		assertNotEquals(rawPeak1, new Object());
	}
}
