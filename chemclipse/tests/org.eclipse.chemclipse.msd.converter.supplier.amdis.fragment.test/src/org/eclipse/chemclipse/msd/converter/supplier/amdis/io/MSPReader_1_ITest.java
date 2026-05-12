/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.eclipse.chemclipse.msd.model.core.ILibraryMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MSPReader_1_ITest {

	private IMassSpectra massSpectra;

	@BeforeAll
	public void setUp() throws IOException {

		MSPReader reader = new MSPReader();
		File file = new File("testData/files/import/msp/Synonyms.MSP");
		massSpectra = reader.read(file, new NullProgressMonitor());
	}

	@Test
	public void testRead_1() {

		assertNotNull(massSpectra);
	}

	@Test
	public void testRead_2() {

		assertEquals(1, massSpectra.size());
	}

	@Test
	public void testRead_3() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(1);
		assertNotNull(massSpectrum);
	}

	@Test
	public void testRead_4() {

		IScanMSD massSpectrum = massSpectra.getMassSpectrum(1);
		assertTrue(massSpectrum instanceof ILibraryMassSpectrum);
	}

	@Test
	public void testRead_5() {

		ILibraryMassSpectrum libraryMassSpectrum = (ILibraryMassSpectrum)massSpectra.getMassSpectrum(1);
		Set<String> synonyms = libraryMassSpectrum.getLibraryInformation().getSynonyms();
		assertEquals(6, synonyms.size());
		assertTrue(synonyms.contains("test1"));
		assertTrue(synonyms.contains("test2"));
		assertTrue(synonyms.contains("test4"));
		assertTrue(synonyms.contains("test6"));
		assertTrue(synonyms.contains("UN 500"));
		assertTrue(synonyms.contains("UN 600"));
	}
}
