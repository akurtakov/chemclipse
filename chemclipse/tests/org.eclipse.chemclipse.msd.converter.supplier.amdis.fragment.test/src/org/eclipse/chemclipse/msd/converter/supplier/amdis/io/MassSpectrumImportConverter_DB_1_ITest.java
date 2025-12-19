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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.msd.converter.supplier.amdis.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.model.IVendorLibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumImportConverter_DB_1_ITest extends ImportConverterMslTestCase {

	@Override
	@BeforeAll
	public void setUp() {

		importFile = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_DB_1));
		super.setUp();
	}

	@Test
	public void testImport_1() {

		assertEquals(6, massSpectra.size());
	}

	@Test
	public void testImport_2() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(1);
		assertNotNull(ms);
		assertEquals("0.5203 min, OP17760", ms.getLibraryInformation().getName());
		assertEquals("OP17760-N1001", ms.getLibraryInformation().getCasNumber());
		assertEquals("0.5203 min, OP17760", ms.getLibraryInformation().getComments());
		assertEquals(31218, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(6, ms.getNumberOfIons());
		assertEquals(16.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(13.0f, ms.getLowestIon().getAbundance(), 0);
		assertEquals(28.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_3() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(6);
		assertNotNull(ms);
		assertEquals("1.5763 min, OP17760", ms.getLibraryInformation().getName());
		assertEquals("OP17760-N1006", ms.getLibraryInformation().getCasNumber());
		assertEquals("1.5763 min, OP17760", ms.getLibraryInformation().getComments());
		assertEquals(94578, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(27, ms.getNumberOfIons());
		assertEquals(15.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(29.0f, ms.getLowestIon().getAbundance(), 0);
		assertEquals(41.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_4() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(4);
		assertNotNull(ms);
		assertEquals("1.3982 min, OP17760", ms.getLibraryInformation().getName());
		assertEquals("OP17760-N1004", ms.getLibraryInformation().getCasNumber());
		assertEquals("1.3982 min, OP17760", ms.getLibraryInformation().getComments());
		assertEquals(83892, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(6, ms.getNumberOfIons());
		assertEquals(16.0d, ms.getLowestIon().getIon(), 0);
		assertEquals(20.0f, ms.getLowestIon().getAbundance(), 0);
		assertEquals(44.0d, ms.getHighestAbundance().getIon(), 0);
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
		for(int i = 1; i <= massSpectra.size(); i++) {
			massSpectrum = massSpectra.getMassSpectrum(i);
			assertEquals((int)numberOfIons.get(i), massSpectrum.getNumberOfIons());
		}
	}
}
