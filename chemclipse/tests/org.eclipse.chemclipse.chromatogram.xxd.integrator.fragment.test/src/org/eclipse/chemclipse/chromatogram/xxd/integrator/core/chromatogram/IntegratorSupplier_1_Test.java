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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.core.chromatogram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IntegratorSupplier_1_Test {

	private ChromatogramIntegratorSupplier supplier;

	@BeforeAll
	public void setUp() {

		supplier = new ChromatogramIntegratorSupplier();
		supplier.setId("org.eclipse.chemclipse.test");
		supplier.setDescription("This is a description.");
		supplier.setIntegratorName("Integrator Name");
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
	public void testGetFilterName_1() {

		assertEquals("Integrator Name", supplier.getIntegratorName());
	}
}
