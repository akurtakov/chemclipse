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

import java.io.IOException;

import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.model.IVendorLibraryMassSpectrum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrumImportConverter_DB_2_ITest extends ImportConverterMslTestCase {

	@Override
	@BeforeAll
	public void setUp() throws IOException {

		importFile = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_IMPORT_DB_2);
		super.setUp();
	}

	@Test
	public void testImport_1() {

		assertEquals(8, massSpectra.size());
	}

	@Test
	public void testImport_2() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(1);
		assertNotNull(ms);
		assertEquals("1,3,5-Trimethylbenzol", ms.getLibraryInformation().getName());
		assertEquals("0", ms.getLibraryInformation().getCasNumber());
		assertEquals("Converted", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(2, ms.getNumberOfIons());
		assertEquals(101.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(608.0f, ms.getHighestIon().getAbundance(), 0);
		assertEquals(100.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(1000.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_3() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(6);
		assertNotNull(ms);
		assertEquals("Decahydronapthalin (cis/trans) 1. Isomer", ms.getLibraryInformation().getName());
		assertEquals("0", ms.getLibraryInformation().getCasNumber());
		assertEquals("Converted", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(2, ms.getNumberOfIons());
		assertEquals(101.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(608.0f, ms.getHighestIon().getAbundance(), 0);
		assertEquals(100.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(1000.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_4() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(4);
		assertNotNull(ms);
		assertEquals("Isopropylmyristat (wrs.)", ms.getLibraryInformation().getName());
		assertEquals("0", ms.getLibraryInformation().getCasNumber());
		assertEquals("Converted", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(2, ms.getNumberOfIons());
		assertEquals(101.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(608.0f, ms.getHighestIon().getAbundance(), 0);
		assertEquals(100.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(1000.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_5() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(7);
		assertNotNull(ms);
		assertEquals("unbekannt (???THF-derivate?) Oligomeren-reihe RT:2085/2550/3015/3470/3910/nach4200", ms.getLibraryInformation().getName());
		assertEquals("0", ms.getLibraryInformation().getCasNumber());
		assertEquals("Converted", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(2, ms.getNumberOfIons());
		assertEquals(101.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(608.0f, ms.getHighestIon().getAbundance(), 0);
		assertEquals(100.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(1000.0f, ms.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testImport_6() {

		IVendorLibraryMassSpectrum ms = (IVendorLibraryMassSpectrum)massSpectra.getMassSpectrum(8);
		assertNotNull(ms);
		assertEquals("Abbaupeak Irgacure 819 (RT: bei C23)", ms.getLibraryInformation().getName());
		assertEquals("0", ms.getLibraryInformation().getCasNumber());
		assertEquals("Converted", ms.getLibraryInformation().getComments());
		assertEquals(0, ms.getRetentionTime());
		assertEquals(0.0f, ms.getRetentionIndex(), 0);
		assertEquals(2, ms.getNumberOfIons());
		assertEquals(101.0d, ms.getHighestIon().getIon(), 0);
		assertEquals(608.0f, ms.getHighestIon().getAbundance(), 0);
		assertEquals(100.0d, ms.getHighestAbundance().getIon(), 0);
		assertEquals(1000.0f, ms.getHighestAbundance().getAbundance(), 0);
	}
}
