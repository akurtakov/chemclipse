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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.core.PeakType;
import org.eclipse.chemclipse.msd.model.core.IChromatogramPeakMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * The chromatogram and peak will be initialized in DefaultPeakTestCase.<br/>
 * The peak has 15 scans, starting at a retention time of 1500 milliseconds (ms)
 * and ends at a retention time of 15500 ms.<br/>
 * The chromatogram has 17 scans, starting at a retention time of 500 ms and
 * ends at a retention time of 16500 ms. It has a background of 1750 units.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramPeak_3_Test extends ChromatogramPeakTestCase {

	private IChromatogramPeakMSD peak;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		peak = new ChromatogramPeakMSD(getPeakModel(), getChromatogram());
	}

	@Test
	public void testPeakType_1() {

		assertEquals(PeakType.DEFAULT, peak.getPeakType());
	}

	@Test
	public void testPeakType_2() {

		peak.setPeakType(null);
		assertEquals(PeakType.DEFAULT, peak.getPeakType());
	}

	@Test
	public void testPeakType_3() {

		peak.setPeakType(PeakType.BB);
		assertEquals(PeakType.BB, peak.getPeakType());
	}

	@Test
	public void testPeakType_4() {

		peak.setPeakType(PeakType.DD);
		assertEquals(PeakType.DD, peak.getPeakType());
	}

	@Test
	public void testPeakType_5() {

		peak.setPeakType(PeakType.MM);
		assertEquals(PeakType.MM, peak.getPeakType());
	}
}
