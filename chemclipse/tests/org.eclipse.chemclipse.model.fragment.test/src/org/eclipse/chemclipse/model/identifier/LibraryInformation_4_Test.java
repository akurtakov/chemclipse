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

import junit.framework.TestCase;

public class LibraryInformation_4_Test extends TestCase {

	private ILibraryInformation libraryInformation;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		libraryInformation = new LibraryInformation();
	}

	@Override
	protected void tearDown() throws Exception {

		libraryInformation = null;
		super.tearDown();
	}

	public void test_1() {

		assertEquals("", libraryInformation.getContributor());
	}

	public void test_2() {

		libraryInformation.setContributor(null);
		assertEquals("", libraryInformation.getContributor());
	}

	public void test_3() {

		libraryInformation.setContributor("ChemClipse");
		assertEquals("ChemClipse", libraryInformation.getContributor());
	}
}
