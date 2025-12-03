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

import org.eclipse.chemclipse.model.signals.ITotalScanSignalExtractor;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalExtractor;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.xic.ExtractedIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Add 3 scans and remove the second one.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_6_Test {

	private IChromatogramMSD chromatogram;
	private Date date;
	private ITotalScanSignalExtractor totalIonSignalExtractor;
	private IExtractedIonSignalExtractor extractedIonSignalExtractor;

	@BeforeAll
	public void setUp() {

		chromatogram = new ChromatogramMSD();
		// ------------------------------Scan 1
		IScanMSD supplierMassSpectrum = new ScanMSD();
		supplierMassSpectrum.setRetentionTime(7896);
		IIon ion = new Ion(45.4f, 65883.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(104.3f, 12502453.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(86.2f, 302410.3f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
		// ------------------------------Scan 1
		// ------------------------------Scan 2
		supplierMassSpectrum = new RegularMassSpectrum();
		supplierMassSpectrum.setRetentionTime(8542);
		ion = new Ion(47.8f, 1423.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(56.3f, 896.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(106.2f, 589634.3f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
		// ------------------------------Scan 2
		// ------------------------------Scan 3
		supplierMassSpectrum = new RegularMassSpectrum();
		supplierMassSpectrum.setRetentionTime(9214);
		ion = new Ion(60.8f, 78954.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(102.3f, 4527823.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(99.6f, 3072410.3f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
		// ------------------------------Scan 3
		chromatogram.removeScan(2);
		date = new Date();
		chromatogram.setDate(date);
		chromatogram.setFile(new File(""));
		chromatogram.setMiscInfo("This is a test chromatogram.");
		chromatogram.setOperator("eselmeister");
		chromatogram.setScanDelay(5500);
		chromatogram.setScanInterval(1500);

		totalIonSignalExtractor = new TotalScanSignalExtractor(chromatogram);
		extractedIonSignalExtractor = new ExtractedIonSignalExtractor(chromatogram);
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
	public void testGetOperator_1() {

		assertEquals("eselmeister", chromatogram.getOperator());
	}

	@Test
	public void testGetFile_1() {

		assertEquals(new File(""), chromatogram.getFile());
	}

	@Test
	public void testGetName_1() {

		assertEquals("", chromatogram.getName());
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
	public void testGetNumberOfScans_1() {

		assertEquals(2, chromatogram.getNumberOfScans());
	}

	@Test
	public void testGetNumberOfScanIons_1() {

		assertEquals(6, chromatogram.getNumberOfScanIons());
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(7896, chromatogram.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(9214, chromatogram.getStopRetentionTime());
	}

	@Test
	public void testGetMinSignal_1() {

		assertEquals(7679188, chromatogram.getMinSignal(), 0);
	}

	@Test
	public void testGetMaxSignal_1() {

		assertEquals(12870746, chromatogram.getMaxSignal(), 0);
	}

	@Test
	public void testGetMiscInfo_1() {

		assertEquals("This is a test chromatogram.", chromatogram.getMiscInfo());
	}

	@Test
	public void testGetTotalIonSignals_1() {

		ITotalScanSignals signals = totalIonSignalExtractor.getTotalScanSignals();
		assertEquals(2, signals.size());
	}

	@Test
	public void testGetTotalIonSignal_1() {

		assertEquals(20549934, chromatogram.getTotalSignal(), 0);
	}

	@Test
	public void testGetExtractedIonSignals_1() {

		IExtractedIonSignals signals = extractedIonSignalExtractor.getExtractedIonSignals();
		assertEquals(2, signals.size());
	}

	@Test
	public void testGetExtractedIonSignals_2() {

		IExtractedIonSignals signals = extractedIonSignalExtractor.getExtractedIonSignals(14.2f, 105.6f);
		assertEquals(2, signals.size());
	}
}
