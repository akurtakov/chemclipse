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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.identifier.LibraryInformation;
import org.eclipse.chemclipse.msd.model.core.IRegularLibraryMassSpectrum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegularLibraryMassSpectrum_2_Test {

	private IRegularLibraryMassSpectrum massSpectrum;

	@BeforeEach
	public void setUp() {

		massSpectrum = new RegularLibraryMassSpectrum();
		ILibraryInformation libraryInformation = new LibraryInformation();
		libraryInformation.setCasNumber("01-33-XX");
		libraryInformation.setComments("test substance comment");
		libraryInformation.setName("Test Substance");
		massSpectrum.setLibraryInformation(libraryInformation);
	}

	@Test
	public void testGetName_1() {

		assertEquals("Test Substance", massSpectrum.getLibraryInformation().getName());
	}

	@Test
	public void testGetName_2() {

		massSpectrum.getLibraryInformation().setName("Philip");
		assertEquals("Philip", massSpectrum.getLibraryInformation().getName());
	}

	@Test
	public void testGetName_3() {

		massSpectrum.getLibraryInformation().setName(null);
		assertEquals("Test Substance", massSpectrum.getLibraryInformation().getName());
	}

	@Test
	public void testGetComments_1() {

		assertEquals("test substance comment", massSpectrum.getLibraryInformation().getComments());
	}

	@Test
	public void testGetComments_2() {

		massSpectrum.getLibraryInformation().setComments("Here are the test comments");
		assertEquals("Here are the test comments", massSpectrum.getLibraryInformation().getComments());
	}

	@Test
	public void testGetComments_3() {

		massSpectrum.getLibraryInformation().setComments(null);
		assertEquals("test substance comment", massSpectrum.getLibraryInformation().getComments());
	}

	@Test
	public void testGetCasNumber_1() {

		assertEquals("01-33-XX", massSpectrum.getLibraryInformation().getCasNumber());
	}

	@Test
	public void testGetCasNumber_2() {

		massSpectrum.getLibraryInformation().setCasNumber("56-38-XX");
		assertEquals("56-38-XX", massSpectrum.getLibraryInformation().getCasNumber());
	}

	@Test
	public void testGetCasNumber_3() {

		massSpectrum.getLibraryInformation().setCasNumber(null);
		assertEquals("01-33-XX", massSpectrum.getLibraryInformation().getCasNumber());
	}
}
