/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mzml.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.mzml.converter.model.IVendorMassSpectra;
import org.eclipse.chemclipse.msd.converter.supplier.mzml.converter.model.VendorMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.Polarity;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumImportConverterCentroided110_ITest {

	private IVendorMassSpectra massSpectra;

	@BeforeAll
	public void setUp() {

		File importFile = new File("testData/files/import/tiny1-centroided.mzML1.1.mzML");
		MassSpectrumImportConverter converter = new MassSpectrumImportConverter();
		IProcessingInfo<IMassSpectra> processingInfo = converter.convert(importFile, new NullProgressMonitor());
		massSpectra = (VendorMassSpectra)processingInfo.getProcessingResult();
	}

	@Test
	public void testIons() {

		assertEquals(2, massSpectra.getList().size());
	}

	@Test
	public void testFirstSpectrum() {

		IStandaloneMassSpectrum standaloneMassSpectrum = (IStandaloneMassSpectrum)massSpectra.getMassSpectrum(1);
		assertEquals(Polarity.POSITIVE, standaloneMassSpectrum.getPolarity());
		assertEquals(5, standaloneMassSpectrum.getNumberOfIons());
		assertEquals(5, standaloneMassSpectrum.getNumberOfIons());
		assertEquals(1, standaloneMassSpectrum.getLowestIon().getIon());
		assertEquals(6, standaloneMassSpectrum.getLowestIon().getAbundance());
		assertEquals(5, standaloneMassSpectrum.getHighestIon().getIon());
		assertEquals(10, standaloneMassSpectrum.getHighestIon().getAbundance());
	}

	@Test
	public void testSecondSpectrum() {

		IStandaloneMassSpectrum standaloneMassSpectrum = (IStandaloneMassSpectrum)massSpectra.getMassSpectrum(2);
		assertEquals(Polarity.POSITIVE, standaloneMassSpectrum.getPolarity());
		assertEquals(5, standaloneMassSpectrum.getNumberOfIons());
		assertEquals(5, standaloneMassSpectrum.getNumberOfIons());
		assertEquals(1, standaloneMassSpectrum.getLowestIon().getIon());
		assertEquals(10, standaloneMassSpectrum.getLowestIon().getAbundance());
		assertEquals(5, standaloneMassSpectrum.getHighestIon().getIon());
		assertEquals(6, standaloneMassSpectrum.getHighestIon().getAbundance());
	}
}
