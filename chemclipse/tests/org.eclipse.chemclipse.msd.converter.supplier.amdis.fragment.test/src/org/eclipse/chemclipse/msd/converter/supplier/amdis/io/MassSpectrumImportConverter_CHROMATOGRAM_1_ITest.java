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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.model.IVendorLibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumImportConverter_CHROMATOGRAM_1_ITest extends ImportConverterMslTestCase {

	@Override
	@BeforeAll
	public void setUp() throws IOException {

		importFile = new File(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM);
		super.setUp();
	}

	@Test
	public void testImport_1() {

		assertEquals(279, massSpectra.size());
	}

	@Test
	public void testImport_2() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(20);
		assertNotNull(ms);
		assertEquals("11.4966 min, OP17760", ms.getLibraryInformation().getName());
		assertEquals("OP17760-N1020", ms.getLibraryInformation().getCasNumber());
		assertEquals("11.4966 min, OP17760", ms.getLibraryInformation().getComments());
		assertEquals(689796, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(45, ms.getNumberOfIons());
		assertEquals(26.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(12.0f, ms.getLowestIon().getAbundance(), 0);
		assertEquals(41.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_3() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(132);
		assertNotNull(ms);
		assertEquals("29.2365 min, OP17760", ms.getLibraryInformation().getName());
		assertEquals("OP17760-N1132", ms.getLibraryInformation().getCasNumber());
		assertEquals("29.2365 min, OP17760", ms.getLibraryInformation().getComments());
		assertEquals(1754190, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(94, ms.getNumberOfIons());
		assertEquals(17.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(7.0f, ms.getLowestIon().getAbundance(), 0);
		assertEquals(67.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_4() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(279);
		assertNotNull(ms);
		assertEquals("60.7763 min, OP17760", ms.getLibraryInformation().getName());
		assertEquals("OP17760-N1279", ms.getLibraryInformation().getCasNumber());
		assertEquals("60.7763 min, OP17760", ms.getLibraryInformation().getComments());
		assertEquals(3646578, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(121, ms.getNumberOfIons());
		assertEquals(29.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(72.0f, ms.getLowestIon().getAbundance(), 0);
		assertEquals(67.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_5() {

		IScanMSD massSpectrum;
		List<Integer> numberOfIons = new ArrayList<>();
		numberOfIons.add(0); // first is 0, because massSpectra starts
								// with index 1
		numberOfIons.add(6);
		numberOfIons.add(12);
		numberOfIons.add(11);
		numberOfIons.add(6);
		numberOfIons.add(10);
		numberOfIons.add(27);
		numberOfIons.add(28);
		numberOfIons.add(27);
		numberOfIons.add(30);
		numberOfIons.add(39);
		numberOfIons.add(30);
		numberOfIons.add(37);
		numberOfIons.add(33);
		numberOfIons.add(48);
		numberOfIons.add(31);
		for(int i = 1; i <= 15; i++) {
			massSpectrum = massSpectra.getMassSpectrum(i);
			assertEquals((int)numberOfIons.get(i), massSpectrum.getNumberOfIons());
		}
	}
}
