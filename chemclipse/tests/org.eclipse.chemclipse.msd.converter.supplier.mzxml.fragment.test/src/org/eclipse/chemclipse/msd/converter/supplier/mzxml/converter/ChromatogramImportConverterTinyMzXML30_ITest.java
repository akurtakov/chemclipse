/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramImportConverterTinyMzXML30_ITest {

	private IVendorChromatogram chromatogram;

	@BeforeAll
	public void setUp() {

		File importFile = new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_TINY_MZXML30));
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
		assertEquals("ReAdW.exe 1.2", chromatogram.getEditHistory().get(0).getEditor());
	}

	@Test
	public void testNumberOfScans() {

		assertEquals(2, chromatogram.getNumberOfScans());
	}

	@Test
	public void testFirstScan() {

		IVendorScan massSpectrum = (IVendorScan)chromatogram.getScan(1);
		assertEquals(977, massSpectrum.getNumberOfIons(), "Ions");
		assertEquals(Polarity.POSITIVE, massSpectrum.getPolarity(), "Polarity");
		assertEquals(353430, massSpectrum.getRetentionTime());
	}

	@Test
	public void testSecondScan() {

		IVendorScan massSpectrum = (IVendorScan)chromatogram.getScan(2);
		assertEquals((short)2, massSpectrum.getMassSpectrometer());
		assertEquals(43, massSpectrum.getNumberOfIons(), "Ions");
		assertEquals(Polarity.POSITIVE, massSpectrum.getPolarity(), "Polarity");
		assertEquals(356680, massSpectrum.getRetentionTime());

		IIonTransition ionTransition = massSpectrum.getIons().iterator().next().getIonTransition();
		assertEquals(35, ionTransition.getCollisionEnergy(), 0);
		assertEquals(445, ionTransition.getQ1Ion());
		assertEquals(-2.0, ionTransition.getQ3Ion(), 0);
	}
}
