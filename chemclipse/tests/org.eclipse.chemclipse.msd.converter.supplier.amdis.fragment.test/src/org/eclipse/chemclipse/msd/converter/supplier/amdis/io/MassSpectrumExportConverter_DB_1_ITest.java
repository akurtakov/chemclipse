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
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.amdis.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.amdis.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.model.IVendorLibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumExportConverter_DB_1_ITest extends MassSpectrumExportConverterTestCase {

	@Override
	@BeforeAll
	public void setUp() {

		exportFile = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTDIR_EXPORT) + File.separator + TestPathHelper.TESTFILE_EXPORT_DB_1_MSL);
		importFile = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTDIR_EXPORT) + File.separator + TestPathHelper.TESTFILE_EXPORT_DB_1_MSL);
		super.setUp();
	}

	@Override
	@AfterAll
	public void tearDown() {

		super.tearDown();
	}

	@Test
	public void testExport_1() {

		IIon ion;
		IScanMSD ms = new ScanMSD();
		for(int i = 1; i <= 6; i++) {
			ion = new Ion(i, i * 10);
			ms.addIon(ion);
		}
		exportConverter.convert(exportFile, ms, false, new NullProgressMonitor());
		IProcessingInfo<IMassSpectra> processingInfo = importConverter.convert(importFile, new NullProgressMonitor());
		massSpectra = processingInfo.getProcessingResult();
		IVendorLibraryMassSpectrum amdisMS = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(1);
		assertNotNull(amdisMS);
		assertEquals("NO IDENTIFIER AVAILABLE", amdisMS.getLibraryInformation().getName());
		assertEquals("", amdisMS.getLibraryInformation().getCasNumber());
		assertEquals("", amdisMS.getLibraryInformation().getComments());
		assertEquals(0, amdisMS.getRetentionTime());
		assertEquals(0.0f, amdisMS.getRetentionIndex(), 0);
		assertEquals(6, amdisMS.getNumberOfIons());
		assertEquals(1.0d, amdisMS.getLowestIon().getIon(), 0);
		assertEquals(167.0f, amdisMS.getLowestIon().getAbundance(), 0);
		assertEquals(6.0d, amdisMS.getHighestAbundance().getIon(), 0);
		assertEquals(1000.0f, amdisMS.getHighestAbundance().getAbundance(), 0);
	}
}
