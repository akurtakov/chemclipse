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
public class ChromatogramOverview_3_Test {

	private ChromatogramMSD chrom;
	private IChromatogramOverview chromatogram;
	private IScanMSD supplierMassSpectrum;
	private IIon ion;

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

		assertEquals(5, chromatogram.getScanNumber(12736));
	}

	@Test
	public void testGetScanNumber_2() {

		assertEquals(1, chromatogram.getScanNumber(5501));
	}

	@Test
	public void testGetScanNumber_3() {

		assertEquals(1, chromatogram.getScanNumber(5500));
	}

	@Test
	public void testGetScanNumber_4() {

		assertEquals(0, chromatogram.getScanNumber(5499));
	}

	@Test
	public void testGetScanNumber_5() {

		assertEquals(0, chromatogram.getScanNumber(0));
	}

	@Test
	public void testGetScanNumber_6() {

		assertEquals(0, chromatogram.getScanNumber(-1));
	}

	@Test
	public void testGetScanNumber_7() {

		assertEquals(304000, chromatogram.getStopRetentionTime());
		assertEquals(200, chromatogram.getNumberOfScans());
		assertEquals(200, chromatogram.getScanNumber(304000));
	}

	@Test
	public void testGetScanNumber_9() {

		assertEquals(81, chromatogram.getScanNumber(125637));
	}

	@Test
	public void testGetScanNumber_10() {

		assertEquals(142, chromatogram.getScanNumber(218499));
	}

	@Test
	public void testGetScanNumber_11() {

		assertEquals(29, chromatogram.getScanNumber(48000));
	}

	@Test
	public void testGetScanNumber_12() {

		assertEquals(196, chromatogram.getScanNumber(299000));
	}
}
