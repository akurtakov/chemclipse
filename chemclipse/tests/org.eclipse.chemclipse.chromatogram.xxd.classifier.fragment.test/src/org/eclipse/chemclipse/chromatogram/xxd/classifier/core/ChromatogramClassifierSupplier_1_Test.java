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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramClassifierSupplier_1_Test {

	private ChromatogramClassifierSupplier supplier;

	@BeforeAll
	public void setUp() throws Exception {

		supplier = new ChromatogramClassifierSupplier();
		supplier.setId("org.eclipse.chemclipse.test");
		supplier.setDescription("This is a description.");
		supplier.setClassifierName("Classifier Name");
	}

	@Test
	public void testGetId_1() {

		assertEquals("org.eclipse.chemclipse.test", supplier.getId());
	}

	@Test
	public void testGetDescription_1() {

		assertEquals("This is a description.", supplier.getDescription());
	}

	@Test
	public void testGetClassifierName_1() {

		assertEquals("Classifier Name", supplier.getClassifierName());
	}
}
