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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Date;

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.signals.ITotalScanSignalExtractor;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalExtractor;
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

	private ChromatogramMSD chrom;
	private IChromatogramOverview chromatogram;
	private IScanMSD supplierMassSpectrum;
	private IIon ion;
	private Date date;
	private ITotalScanSignalExtractor totalIonSignalExtractor;

	@BeforeAll
	public void setUp() {

		chrom = new ChromatogramMSD();
		// ------------------------------Scan 1
		supplierMassSpectrum = new ScanMSD();
		supplierMassSpectrum.setRetentionTime(7896);
		ion = new Ion(IIon.TIC_ION, 470746.9f);
		supplierMassSpectrum.addIon(ion);
		chrom.addScan(supplierMassSpectrum);
		// ------------------------------Scan 1
		chromatogram = chrom;
		date = new Date();
		chromatogram.setDate(date);
		chromatogram.setFile(new File(""));
		chromatogram.setMiscInfo("This is a test chromatogram.");
		chromatogram.setOperator("eselmeister");
		chromatogram.setScanDelay(5500);
		chromatogram.setScanInterval(1500);

		totalIonSignalExtractor = new TotalScanSignalExtractor(chrom);
	}

	@Test
	public void testGetMinSignal_1() {

		assertEquals(470746, (int)chromatogram.getMinSignal(), 0);
	}

	@Test
	public void testGetMaxSignal_1() {

		assertEquals(470746, (int)chromatogram.getMaxSignal(), 0);
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(7896, chromatogram.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(7896, chromatogram.getStopRetentionTime());
	}

	@Test
	public void testGetScanDelay_1() {

		assertEquals(5500, chromatogram.getScanDelay());
	}

	@Test
	public void testGetScanInterval_1() {

		assertEquals(1500, chromatogram.getScanInterval());
	}

	@Test
	public void testGetNumberOfScans_1() {

		assertEquals(1, chromatogram.getNumberOfScans());
	}

	@Test
	public void testGetName_1() {

		assertEquals("", chromatogram.getName());
	}

	@Test
	public void testGetFile_1() {

		assertEquals(new File(""), chromatogram.getFile());
	}

	@Test
	public void testGetOperator_1() {

		assertEquals("eselmeister", chromatogram.getOperator());
	}

	@Test
	public void testGetDate_1() {

		assertTrue(chromatogram.getDate() != null);
	}

	@Test
	public void testGetDate_2() {

		assertEquals(date.toString(), chromatogram.getDate().toString());
	}

	@Test
	public void testGetMiscInfo_1() {

		assertEquals("This is a test chromatogram.", chromatogram.getMiscInfo());
	}

	@Test
	public void testGetTotalIonSignals_1() {

		ITotalScanSignals signals = totalIonSignalExtractor.getTotalScanSignals();
		assertEquals(1, signals.size());
	}

	@Test
	public void testGetTotalIonSignal_1() {

		assertEquals(470746.9f, chromatogram.getTotalSignal(), 0);
	}
}
