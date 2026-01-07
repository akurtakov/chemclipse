/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the interface IChromatogramOverview with 1 scan.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramOverview_5_Test {

	private IChromatogramOverview chromatogramOverview;
	private float RT_FACTOR = 1000.0f * 60.0f;

	@BeforeAll
	public void setUp() {

		IChromatogramMSD chromatogram = new ChromatogramMSD();
		// ------------------------------Scan 1 - 200
		for(int i = 1; i <= 200; i++) {
			IScanMSD supplierMassSpectrum = new ScanMSD();
			IIon ion = new Ion(IIon.TIC_ION, 4500.0f);
			supplierMassSpectrum.addIon(ion);
			chromatogram.addScan(supplierMassSpectrum);
		}
		// ------------------------------Scan 1 - 200
		chromatogramOverview = chromatogram;
		chromatogramOverview.setScanDelay(5500);
		chromatogramOverview.setScanInterval(1500);
		chromatogramOverview.recalculateRetentionTimes();
	}

	@Test
	public void testGetScanNumber_1() {

		float min = 12736 / RT_FACTOR;
		assertEquals(5, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_2() {

		float min = 5501 / RT_FACTOR;
		assertEquals(1, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_3() {

		float min = 5500 / RT_FACTOR;
		assertEquals(1, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_4() {

		float min = 5499 / RT_FACTOR;
		assertEquals(0, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_5() {

		float min = 0 / RT_FACTOR;
		assertEquals(0, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_6() {

		float min = -1 / RT_FACTOR;
		assertEquals(0, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_7() {

		assertEquals(304000, chromatogramOverview.getStopRetentionTime());
		assertEquals(200, chromatogramOverview.getNumberOfScans());
		float min = 304000 / RT_FACTOR;
		assertEquals(200, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_9() {

		float min = 125637 / RT_FACTOR;
		assertEquals(81, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_10() {

		float min = 218499 / RT_FACTOR;
		assertEquals(142, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_11() {

		float min = 48000 / RT_FACTOR;
		assertEquals(29, chromatogramOverview.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_12() {

		float min = 299000 / RT_FACTOR;
		assertEquals(196, chromatogramOverview.getScanNumber(min));
	}
}
