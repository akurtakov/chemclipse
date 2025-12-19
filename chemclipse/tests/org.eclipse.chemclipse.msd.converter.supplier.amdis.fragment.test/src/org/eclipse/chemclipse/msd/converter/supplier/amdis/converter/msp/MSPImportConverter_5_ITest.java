/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.amdis.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.io.ImportConverterMspTestCase;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.model.IVendorLibraryMassSpectrum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MSPImportConverter_5_ITest extends ImportConverterMspTestCase {

	@Override
	@BeforeAll
	public void setUp() {

		importFile = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_GOLMDB_TEST_MSP));
		super.setUp();
	}

	@Test
	public void testImport_1() {

		assertEquals(3, massSpectra.size());
	}

	@Test
	public void testImport_2() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(1);
		assertNotNull(ms);
		assertEquals("M000000_A097001-101-xxx_NA_959,45_PRED_VAR5_ALK_Unknown#bth-pae-001", ms.getLibraryInformation().getName());
		assertEquals("", ms.getLibraryInformation().getCasNumber());
		assertEquals("consensus spectrum of 1 spectra per analyte, MPIMP ID and isotopomer, with majority threshold = 60%", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0, ms.getRelativeRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0); // 959,45 - a comma was used
		assertEquals(50, ms.getNumberOfIons());

		assertEquals(77.0d, ms.getBasePeak(), 0);
		assertEquals(1000.0f, ms.getBasePeakAbundance(), 0);

		assertEquals(70.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(10.0f, ms.getLowestIon().getAbundance(), 0);

		assertEquals(231.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(5.0f, ms.getHighestIon().getAbundance(), 0);
	}

	@Test
	public void testImport_3() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(2);
		assertNotNull(ms);
		assertEquals("M000880_A098001-101-xxx_NA_986,97_TRUE_VAR5_ALK_Glycine, N,N-dimethyl- (1TMS)", ms.getLibraryInformation().getName());
		assertEquals("1118-68-9", ms.getLibraryInformation().getCasNumber());
		assertEquals("consensus spectrum of 1 spectra per analyte, MPIMP ID and isotopomer, with majority threshold = 60%", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0, ms.getRelativeRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0); // -> 986,97 - a comma was used
		assertEquals(52, ms.getNumberOfIons());

		assertEquals(160.0d, ms.getBasePeak(), 0);
		assertEquals(1000.0f, ms.getBasePeakAbundance(), 0);

		assertEquals(70.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(81.0f, ms.getLowestIon().getAbundance(), 0);

		assertEquals(177.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(18.0f, ms.getHighestIon().getAbundance(), 0);
	}

	@Test
	public void testImport_4() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(3);
		assertNotNull(ms);
		assertEquals("M001213_A098002-101-xxx_NA_988_TRUE_VAR5_ALK_Propane-1,2-diol (2TMS)", ms.getLibraryInformation().getName());
		assertEquals("17887-27-3", ms.getLibraryInformation().getCasNumber());
		assertEquals("consensus spectrum of 3 spectra per analyte, MPIMP ID and isotopomer, with majority threshold = 60%", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0, ms.getRelativeRetentionTime());
		assertEquals(988.0f, ms.getRetentionIndex(), 0);
		assertEquals(61, ms.getNumberOfIons());

		assertEquals(117.0d, ms.getBasePeak(), 0);
		assertEquals(1000.0f, ms.getBasePeakAbundance(), 0);

		assertEquals(70.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(6.0f, ms.getLowestIon().getAbundance(), 0);

		assertEquals(219.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(1.0f, ms.getHighestIon().getAbundance(), 0);
	}
}
