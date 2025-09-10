/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.converter;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.mzxml.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.IVendorChromatogram;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.IVendorScan;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.VendorChromatogram;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIonTransition;
import org.eclipse.chemclipse.msd.model.core.Polarity;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChromatogramImportConverterTinyMzXML20_ITest {

	private static IVendorChromatogram chromatogram;

	@BeforeClass
	public static void setUp() {

		File importFile = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_TINY1_MZXML20));
		ChromatogramImportConverter converter = new ChromatogramImportConverter();
		IProcessingInfo<IChromatogramMSD> processingInfo = converter.convert(importFile, new NullProgressMonitor());
		chromatogram = (VendorChromatogram)processingInfo.getProcessingResult();
	}

	@Test
	public void testInstrument() {

		assertEquals("ThermoFinnigan LCQ Deca", chromatogram.getInstrument());
		assertEquals("ESI", chromatogram.getIonisation());
		assertEquals("Ion Trap", chromatogram.getMassAnalyzer());
		assertEquals("EMT", chromatogram.getMassDetector());
		assertEquals("Xcalibur 1.3 alpha 8", chromatogram.getSoftware());
	}

	@Test
	public void testEditHistory() {

		assertEquals("conversion", chromatogram.getEditHistory().get(0).getDescription());
		assertEquals("Thermo2mzXML 1", chromatogram.getEditHistory().get(0).getEditor());
	}

	@Test
	public void testNumberOfScans() {

		assertEquals("NumberOfScans", 2, chromatogram.getNumberOfScans());
	}

	@Test
	public void testTotalSignal() {

		assertEquals("Total Signal", 1.7440164E7, chromatogram.getTotalSignal(), 0);
	}

	@Test
	public void testMaxIonAbundance() {

		assertEquals("Max Signal", 301045.0f, chromatogram.getMaxIonAbundance(), 0);
	}

	@Test
	public void testFirstScan() {

		IVendorScan massSpectrum = (IVendorScan)chromatogram.getScan(1);
		assertEquals("Ions", 1313, massSpectrum.getNumberOfIons());
		assertEquals("Polarity", Polarity.POSITIVE, massSpectrum.getPolarity());
		assertEquals("RT", 353430, massSpectrum.getRetentionTime());
	}

	@Test
	public void testSecondScan() {

		IVendorScan massSpectrum = (IVendorScan)chromatogram.getScan(2);
		assertEquals("Ions", 43, massSpectrum.getNumberOfIons());
		assertEquals("RT", 356680, massSpectrum.getRetentionTime());
		assertEquals("Polarity", Polarity.POSITIVE, massSpectrum.getPolarity());
		assertEquals("MS", 2, massSpectrum.getMassSpectrometer());
		assertEquals("Precursor", 445.3500061035156, massSpectrum.getPrecursorIon(), 0);

		IIonTransition ionTransition = massSpectrum.getHighestIon().getIonTransition();
		assertEquals("CE", 35, ionTransition.getCollisionEnergy(), 0);
		assertEquals("Q1", 445, ionTransition.getQ1Ion(), 0);
		assertEquals("Q2", 531.1, ionTransition.getQ3Ion(), 0);
	}
}
