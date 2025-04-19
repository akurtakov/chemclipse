/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.core;

import junit.framework.TestCase;

public class ChromatogramClassifierSupplier_1_Test extends TestCase {

	private ChromatogramClassifierSupplier supplier;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		supplier = new ChromatogramClassifierSupplier();
		supplier.setId("org.eclipse.chemclipse.test");
		supplier.setDescription("This is a description.");
		supplier.setClassifierName("Classifier Name");
	}

	@Override
	protected void tearDown() throws Exception {

		supplier = null;
		super.tearDown();
	}

	public void testGetId_1() {

		assertEquals("Id", "org.eclipse.chemclipse.test", supplier.getId());
	}

	public void testGetDescription_1() {

		assertEquals("Description", "This is a description.", supplier.getDescription());
	}

	public void testGetClassifierName_1() {

		assertEquals("Classifier Name", "Classifier Name", supplier.getClassifierName());
	}
}
