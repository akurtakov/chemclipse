/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.io.ImportConverterMslTestCase;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.model.IVendorLibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Encoding_1_ITest extends ImportConverterMslTestCase {

	@Override
	@BeforeAll
	public void setUp() {

		importFile = new File(TestPathHelper.TESTFILE_IMPORT_ENCODING_MSL);
		super.setUp();
	}

	@Test
	public void testImport_1() {

		assertEquals(2, massSpectra.size());
	}

	@Test
	public void testImport_2() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(1);
		IVendorLibraryMassSpectrum libraryMassSpectrum = (massSpectrum instanceof IVendorLibraryMassSpectrum vendorLibraryMassSpectrum) ? vendorLibraryMassSpectrum : null;
		assertNotNull(libraryMassSpectrum);
		assertEquals("Propylphenyl acetate te te", libraryMassSpectrum.getLibraryInformation().getName());
	}

	@Test
	public void testImport_3() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(2);
		IVendorLibraryMassSpectrum libraryMassSpectrum = (massSpectrum instanceof IVendorLibraryMassSpectrum vendorLibraryMassSpectrum) ? vendorLibraryMassSpectrum : null;
		assertNotNull(libraryMassSpectrum);
		assertEquals("Lauryl acetate etate te te", libraryMassSpectrum.getLibraryInformation().getName());
	}
}