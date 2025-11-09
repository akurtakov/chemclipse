/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IdentificationTarget_1_Test {

	private IdentificationTarget identificationTarget;

	@BeforeAll
	public void setUp() {

		ILibraryInformation libraryInformation = new LibraryInformation();
		IComparisonResult comparisonResult = new ComparisonResult(100.0f, 100.0f, 0.0f, 0.0f);
		identificationTarget = new IdentificationTarget(libraryInformation, comparisonResult);
	}

	@Test
	public void test1() {

		assertEquals("", identificationTarget.getIdentifier());
	}

	@Test
	public void test2() {

		identificationTarget.setIdentifier("");
		assertEquals("", identificationTarget.getIdentifier());
	}

	@Test
	public void test3() {

		identificationTarget.setIdentifier("ChemClipse");
		assertEquals("ChemClipse", identificationTarget.getIdentifier());
	}

	@Test
	public void test4() {

		assertEquals(false, identificationTarget.isVerified());
	}

	@Test
	public void test5() {

		identificationTarget.setVerified(false);
		assertEquals(false, identificationTarget.isVerified());
	}

	@Test
	public void test6() {

		identificationTarget.setVerified(true);
		assertEquals(true, identificationTarget.isVerified());
	}
}
