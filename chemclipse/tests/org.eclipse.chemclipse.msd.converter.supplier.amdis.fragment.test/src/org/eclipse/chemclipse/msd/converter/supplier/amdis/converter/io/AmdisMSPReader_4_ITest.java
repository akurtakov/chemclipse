/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.io.MSPReader;
import org.eclipse.chemclipse.msd.model.core.ILibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AmdisMSPReader_4_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File("testData/files/import/msp/Peaks4.MSP");
		MSPReader reader = new MSPReader();
		massSpectra = reader.read(file, new NullProgressMonitor());
	}

	@Test
	public void test1() {

		assertEquals(3, massSpectra.size());
	}

	@Test
	public void test2() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(1);
		if(massSpectrum instanceof ILibraryMassSpectrum libraryMassSpectrum) {
			ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
			assertEquals("Demo1", libraryInformation.getName());
			assertEquals("CHO", libraryInformation.getFormula());
			assertEquals(0.0d, libraryInformation.getMolWeight(), 0);
			assertEquals("", libraryInformation.getCasNumber());
			assertEquals("Comment1", libraryInformation.getComments());
		} else {
			/*
			 * It must be a library mass spectrum.
			 */
			assertTrue(false);
		}
		assertEquals(131, massSpectrum.getNumberOfIons());
		assertEquals(41.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(4804.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(362.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(300.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(360.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(9999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(144811.0f, massSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void test3() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(2);
		if(massSpectrum instanceof ILibraryMassSpectrum libraryMassSpectrum) {
			ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
			assertEquals("Demo2", libraryInformation.getName());
			assertEquals("COH", libraryInformation.getFormula());
			assertEquals(0.0d, libraryInformation.getMolWeight(), 0);
			assertEquals("", libraryInformation.getCasNumber());
			assertEquals("Comment2", libraryInformation.getComments());
		} else {
			/*
			 * It must be a library mass spectrum.
			 */
			assertTrue(false);
		}
		assertEquals(170, massSpectrum.getNumberOfIons());
		assertEquals(24.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(100.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(306.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(20.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(82.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(9999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(84929.0f, massSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void test4() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(3);
		assertEquals(23, massSpectrum.getNumberOfIons());
		assertEquals(37.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(210.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(180.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(260.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(120.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(9999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(29859.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Demo3", libraryInformation.getName());
		assertEquals("OHC", libraryInformation.getFormula());
		assertEquals(0.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("", libraryInformation.getCasNumber());
		assertEquals("Comment3", libraryInformation.getComments());
	}
}
