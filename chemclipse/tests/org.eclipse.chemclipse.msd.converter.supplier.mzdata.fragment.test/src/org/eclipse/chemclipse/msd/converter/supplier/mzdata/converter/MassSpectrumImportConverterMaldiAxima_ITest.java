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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.ZoneId;
import java.util.Date;

import org.eclipse.chemclipse.msd.converter.supplier.mzdata.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.mzdata.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.mzdata.model.VendorMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.StandaloneMassSpectrum;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumImportConverterMaldiAxima_ITest {

	private IStandaloneMassSpectrum standaloneMassSpectrum;

	@BeforeAll
	public void setUp() {

		File importFile = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_MALDI_AXIMA_CFR));
		MassSpectrumImportConverter converter = new MassSpectrumImportConverter();
		IProcessingInfo<IMassSpectra> processingInfo = converter.convert(importFile, new NullProgressMonitor());
		VendorMassSpectra massSpectra = (VendorMassSpectra)processingInfo.getProcessingResult();
		standaloneMassSpectrum = (StandaloneMassSpectrum)massSpectra.getMassSpectrum(1);
	}

	@Test
	public void testOperator() {

		assertEquals("Mike Ashton, Kratos Analytical Limited", standaloneMassSpectrum.getOperator());
	}

	@Test
	public void testInstrument() {

		assertEquals("AXIMA-CFR", standaloneMassSpectrum.getInstrument());
	}

	@Test
	public void testEditHistory() {

		assertEquals("Kompact 2.7.0a1", standaloneMassSpectrum.getEditHistory().get(0).getEditor());
		Date date = standaloneMassSpectrum.getEditHistory().get(0).getDate();
		assertEquals(2003, date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear());

		assertEquals("deisotoped: true", standaloneMassSpectrum.getEditHistory().get(0).getDescription());
		assertEquals("chargeDeconvolved: false", standaloneMassSpectrum.getEditHistory().get(1).getDescription());
		assertEquals("peakThreshold: 0", standaloneMassSpectrum.getEditHistory().get(2).getDescription());
		assertEquals("peakProcessing: centroided", standaloneMassSpectrum.getEditHistory().get(3).getDescription());
	}

	@Test
	public void testNumberOfIons() {

		assertEquals(134, standaloneMassSpectrum.getNumberOfIons());
	}
}
