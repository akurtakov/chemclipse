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
public class AmdisMSPReader_3_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() throws IOException {

		File file = new File("testData/files/import/msp/Peaks3.MSP");
		MSPReader reader = new MSPReader();
		massSpectra = reader.read(file, new NullProgressMonitor());
	}

	@Test
	public void test1() {

		assertEquals(1, massSpectra.size());
	}

	@Test
	public void test2() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(1);
		assertEquals(87, massSpectrum.getNumberOfIons());
		assertEquals(14.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(8.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(305.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(5.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(82.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(6186.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Demo1", libraryInformation.getName());
		assertEquals("CNN", libraryInformation.getFormula());
		assertEquals(303.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("111-222-55", libraryInformation.getCasNumber());
		assertEquals("", libraryInformation.getComments());
	}
}
