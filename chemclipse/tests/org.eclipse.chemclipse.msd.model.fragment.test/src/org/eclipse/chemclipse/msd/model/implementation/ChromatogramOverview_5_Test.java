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

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
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

	private ChromatogramMSD chrom;
	private IChromatogramOverview chromatogram;
	private IScanMSD supplierMassSpectrum;
	private IIon ion;
	private float RT_FACTOR = 1000.0f * 60.0f;

	@BeforeAll
	public void setUp() {

		chrom = new ChromatogramMSD();
		// ------------------------------Scan 1 - 200
		for(int i = 1; i <= 200; i++) {
			supplierMassSpectrum = new ScanMSD();
			ion = new Ion(IIon.TIC_ION, 4500.0f);
			supplierMassSpectrum.addIon(ion);
			chrom.addScan(supplierMassSpectrum);
		}
		// ------------------------------Scan 1 - 200
		chromatogram = chrom;
		chromatogram.setScanDelay(5500);
		chromatogram.setScanInterval(1500);
		chromatogram.recalculateRetentionTimes();
	}

	@Test
	public void testGetScanNumber_1() {

		float min = 12736 / RT_FACTOR;
		assertEquals(5, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_2() {

		float min = 5501 / RT_FACTOR;
		assertEquals(1, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_3() {

		float min = 5500 / RT_FACTOR;
		assertEquals(1, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_4() {

		float min = 5499 / RT_FACTOR;
		assertEquals(0, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_5() {

		float min = 0 / RT_FACTOR;
		assertEquals(0, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_6() {

		float min = -1 / RT_FACTOR;
		assertEquals(0, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_7() {

		assertEquals(304000, chromatogram.getStopRetentionTime());
		assertEquals(200, chromatogram.getNumberOfScans());
		float min = 304000 / RT_FACTOR;
		assertEquals(200, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_9() {

		float min = 125637 / RT_FACTOR;
		assertEquals(81, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_10() {

		float min = 218499 / RT_FACTOR;
		assertEquals(142, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_11() {

		float min = 48000 / RT_FACTOR;
		assertEquals(29, chromatogram.getScanNumber(min));
	}

	@Test
	public void testGetScanNumber_12() {

		float min = 299000 / RT_FACTOR;
		assertEquals(196, chromatogram.getScanNumber(min));
	}
}
