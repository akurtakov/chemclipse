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
public class AmdisMSPReader_2_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() throws IOException {

		File file = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_IMPORT_PEAKS_2_MSP);
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
		assertEquals(25, massSpectrum.getNumberOfIons());
		assertEquals(42.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(80.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(171.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(20.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(120.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(2364.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Peak1", libraryInformation.getName());
		assertEquals("CCCHHH", libraryInformation.getFormula());
		assertEquals(169.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("111-22-3", libraryInformation.getCasNumber());
		assertEquals("Comment1", libraryInformation.getComments());
	}

	@Test
	public void test3() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(2);
		assertEquals(47, massSpectrum.getNumberOfIons());
		assertEquals(27.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(220.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(203.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(10.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(154.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(4275.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Peak2", libraryInformation.getName());
		assertEquals("CCCNNN", libraryInformation.getFormula());
		assertEquals(203.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("222-33-4", libraryInformation.getCasNumber());
		assertEquals("Comment2", libraryInformation.getComments());
	}

	@Test
	public void test4() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(3);
		assertEquals(69, massSpectrum.getNumberOfIons());
		assertEquals(15.0d, massSpectrum.getLowestIon().getIon(), 0);
		assertEquals(35.0f, massSpectrum.getLowestIon().getAbundance(), 0);
		assertEquals(159.0d, massSpectrum.getHighestIon().getIon(), 0);
		assertEquals(4.0f, massSpectrum.getHighestIon().getAbundance(), 0);
		assertEquals(106.0d, massSpectrum.getHighestAbundance().getIon(), 0);
		assertEquals(999.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
		assertEquals(0, massSpectrum.getRetentionTime());
		assertEquals(0.0f, massSpectrum.getRetentionIndex(), 0);
		assertEquals(2963.0f, massSpectrum.getTotalSignal(), 0);

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectrum;
		ILibraryInformation libraryInformation = libraryMassSpectrum.getLibraryInformation();
		assertEquals("Peak3", libraryInformation.getName());
		assertEquals("CCCOOO", libraryInformation.getFormula());
		assertEquals(155.0d, libraryInformation.getMolWeight(), 0);
		assertEquals("333-44-5", libraryInformation.getCasNumber());
		assertEquals("Comment3", libraryInformation.getComments());
	}
}
