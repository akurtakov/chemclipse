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

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
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
public class AmdisMSPReader_6_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File(TestPathHelper.TESTFILE_IMPORT_PEAKS_6_MSP);
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
		assertEquals(73, massSpectrum.getNumberOfIons());
		assertEquals(37.1d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(3789.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(280.15d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(5340.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(104.05d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(427584.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(2025957.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Demo1", libraryInformation.getName());
		assertEquals("", libraryInformation.getFormula());
		assertEquals(0.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("", libraryInformation.getCasNumber());
		assertEquals("", libraryInformation.getComments());
	}

	@Test
	public void test3() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(2);
		assertEquals(153, massSpectrum.getNumberOfIons());
		assertEquals(15.05d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(19421.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(313.1d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(1958.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(308.1d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(446528.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(2272266.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Demo2", libraryInformation.getName());
		assertEquals("", libraryInformation.getFormula());
		assertEquals(0.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("", libraryInformation.getCasNumber());
		assertEquals("", libraryInformation.getComments());
	}

	@Test
	public void test4() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(3);
		assertEquals(150, massSpectrum.getNumberOfIons());
		assertEquals(17.05d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(1752.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(369.15d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(2231.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(248.15d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(479104.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(1986783.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Demo3", libraryInformation.getName());
		assertEquals("", libraryInformation.getFormula());
		assertEquals(0.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("", libraryInformation.getCasNumber());
		assertEquals("", libraryInformation.getComments());
	}
}
