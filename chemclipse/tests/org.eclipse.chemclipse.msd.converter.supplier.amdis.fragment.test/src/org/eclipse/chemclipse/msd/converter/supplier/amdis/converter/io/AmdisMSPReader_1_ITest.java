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

import org.eclipse.chemclipse.converter.PathResolver;
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
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class AmdisMSPReader_1_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() throws IOException {

		File file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_IMPORT_PEAKS_1_MSP);
		MSPReader reader = new MSPReader();
		massSpectra = reader.read(file, new NullProgressMonitor());
	}

	@Test
	public void test1() {

		assertEquals(2, massSpectra.size());
	}

	@Test
	public void test2() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(1);
		assertEquals(37, massSpectrum.getNumberOfIons());
		assertEquals(42.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(17.98f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(108.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(244.78f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(93.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(3439.7798f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Test1", libraryInformation.getName());
		assertEquals("CHO", libraryInformation.getFormula());
		assertEquals(100.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("44444", libraryInformation.getCasNumber());
		assertEquals("Demo1", libraryInformation.getComments());
	}

	@Test
	public void test3() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(2);
		assertEquals(45, massSpectrum.getNumberOfIons());
		assertEquals(26.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(0.70f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(131.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(9.79f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(43.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(1543.4396f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Test2", libraryInformation.getName());
		assertEquals("CHO", libraryInformation.getFormula());
		assertEquals(100.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("44444", libraryInformation.getCasNumber());
		assertEquals("Demo2", libraryInformation.getComments());
	}
}
