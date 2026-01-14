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
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.IVendorMassSpectra;
import org.eclipse.chemclipse.msd.converter.supplier.mzxml.model.VendorMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.MassSpectrumType;
import org.eclipse.chemclipse.msd.model.core.Polarity;
import org.eclipse.chemclipse.msd.model.implementation.StandaloneMassSpectrum;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumImportConverterTinyCentroidedMzXML30_ITest {

	private IStandaloneMassSpectrum standaloneMassSpectrum;

	@BeforeAll
	public void setUp() throws IOException {

		File importFile = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_IMPORT_TINY1_CENTROIDED_MZXML30);
		MassSpectrumImportConverter converter = new MassSpectrumImportConverter();
		IProcessingInfo<IMassSpectra> processingInfo = converter.convert(importFile, new NullProgressMonitor());
		IVendorMassSpectra massSpectra = (VendorMassSpectra)processingInfo.getProcessingResult();
		standaloneMassSpectrum = (StandaloneMassSpectrum)massSpectra.getMassSpectrum(1);
	}

	@Test
	public void testInstrument() {

		assertEquals("FooBar FooBar Model1", standaloneMassSpectrum.getInstrument());
	}

	@Test
	public void testMassSpectrum() {

		assertEquals(Polarity.POSITIVE, standaloneMassSpectrum.getPolarity());
		assertEquals(MassSpectrumType.CENTROID, standaloneMassSpectrum.getMassSpectrumType());
	}

	@Test
	public void testIons() {

		assertEquals(5, standaloneMassSpectrum.getNumberOfIons());
		assertEquals(1, standaloneMassSpectrum.getLowestIon().getIon());
		assertEquals(6, standaloneMassSpectrum.getLowestIon().getAbundance());
		assertEquals(5, standaloneMassSpectrum.getHighestIon().getIon());
		assertEquals(10, standaloneMassSpectrum.getHighestIon().getAbundance());
	}
}
