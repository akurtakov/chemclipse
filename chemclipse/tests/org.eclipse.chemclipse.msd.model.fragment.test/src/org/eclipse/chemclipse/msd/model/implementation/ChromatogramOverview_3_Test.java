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
public class ChromatogramOverview_3_Test {

	private IChromatogramOverview chromatogramOverview;

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

		assertEquals(5, chromatogramOverview.getScanNumber(12736));
	}

	@Test
	public void testGetScanNumber_2() {

		assertEquals(1, chromatogramOverview.getScanNumber(5501));
	}

	@Test
	public void testGetScanNumber_3() {

		assertEquals(1, chromatogramOverview.getScanNumber(5500));
	}

	@Test
	public void testGetScanNumber_4() {

		assertEquals(0, chromatogramOverview.getScanNumber(5499));
	}

	@Test
	public void testGetScanNumber_5() {

		assertEquals(0, chromatogramOverview.getScanNumber(0));
	}

	@Test
	public void testGetScanNumber_6() {

		assertEquals(0, chromatogramOverview.getScanNumber(-1));
	}

	@Test
	public void testGetScanNumber_7() {

		assertEquals(304000, chromatogramOverview.getStopRetentionTime());
		assertEquals(200, chromatogramOverview.getNumberOfScans());
		assertEquals(200, chromatogramOverview.getScanNumber(304000));
	}

	@Test
	public void testGetScanNumber_9() {

		assertEquals(81, chromatogramOverview.getScanNumber(125637));
	}

	@Test
	public void testGetScanNumber_10() {

		assertEquals(142, chromatogramOverview.getScanNumber(218499));
	}

	@Test
	public void testGetScanNumber_11() {

		assertEquals(29, chromatogramOverview.getScanNumber(48000));
	}

	@Test
	public void testGetScanNumber_12() {

		assertEquals(196, chromatogramOverview.getScanNumber(299000));
	}
}
