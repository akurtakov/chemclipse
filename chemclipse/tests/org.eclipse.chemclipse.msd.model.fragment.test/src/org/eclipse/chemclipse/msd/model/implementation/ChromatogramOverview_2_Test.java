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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Date;

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.signals.ITotalScanSignalExtractor;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalExtractor;
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
public class ChromatogramOverview_2_Test {

	private IChromatogramOverview chromatogramOverview;
	private Date date;
	private ITotalScanSignalExtractor totalIonSignalExtractor;

	@BeforeAll
	public void setUp() {

		IChromatogramMSD chromatogram = new ChromatogramMSD();
		// ------------------------------Scan 1
		IScanMSD supplierMassSpectrum = new ScanMSD();
		supplierMassSpectrum.setRetentionTime(7896);
		IIon ion = new Ion(IIon.TIC_ION, 470746.9f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
		// ------------------------------Scan 1
		chromatogramOverview = chromatogram;
		date = new Date();
		chromatogramOverview.setDate(date);
		chromatogramOverview.setFile(new File(""));
		chromatogramOverview.setMiscInfo("This is a test chromatogram.");
		chromatogramOverview.setOperator("eselmeister");
		chromatogramOverview.setScanDelay(5500);
		chromatogramOverview.setScanInterval(1500);

		totalIonSignalExtractor = new TotalScanSignalExtractor(chromatogram);
	}

	@Test
	public void testGetMinSignal_1() {

		assertEquals(470746, (int)chromatogramOverview.getMinSignal(), 0);
	}

	@Test
	public void testGetMaxSignal_1() {

		assertEquals(470746, (int)chromatogramOverview.getMaxSignal(), 0);
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(7896, chromatogramOverview.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(7896, chromatogramOverview.getStopRetentionTime());
	}

	@Test
	public void testGetScanDelay_1() {

		assertEquals(5500, chromatogramOverview.getScanDelay());
	}

	@Test
	public void testGetScanInterval_1() {

		assertEquals(1500, chromatogramOverview.getScanInterval());
	}

	@Test
	public void testGetNumberOfScans_1() {

		assertEquals(1, chromatogramOverview.getNumberOfScans());
	}

	@Test
	public void testGetName_1() {

		assertEquals("", chromatogramOverview.getName());
	}

	@Test
	public void testGetFile_1() {

		assertEquals(new File(""), chromatogramOverview.getFile());
	}

	@Test
	public void testGetOperator_1() {

		assertEquals("eselmeister", chromatogramOverview.getOperator());
	}

	@Test
	public void testGetDate_1() {

		assertTrue(chromatogramOverview.getDate() != null);
	}

	@Test
	public void testGetDate_2() {

		assertEquals(date.toString(), chromatogramOverview.getDate().toString());
	}

	@Test
	public void testGetMiscInfo_1() {

		assertEquals("This is a test chromatogram.", chromatogramOverview.getMiscInfo());
	}

	@Test
	public void testGetTotalIonSignals_1() {

		ITotalScanSignals signals = totalIonSignalExtractor.getTotalScanSignals();
		assertEquals(1, signals.size());
	}

	@Test
	public void testGetTotalIonSignal_1() {

		assertEquals(470746.9f, chromatogramOverview.getTotalSignal(), 0);
	}
}
