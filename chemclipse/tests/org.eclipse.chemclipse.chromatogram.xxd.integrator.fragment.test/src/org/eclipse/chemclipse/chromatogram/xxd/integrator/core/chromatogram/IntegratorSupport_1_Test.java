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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IntegratorSupport_1_Test {

	private ChromatogramIntegratorSupport support;

	@BeforeAll
	public void setUp() {

		support = new ChromatogramIntegratorSupport();
		ChromatogramIntegratorSupplier supplier = new ChromatogramIntegratorSupplier();
		supplier.setId("net.first.supplier");
		supplier.setDescription("Integrator Description");
		supplier.setIntegratorName("Test Integrator Name");
		support.add(supplier);
	}

	@Test
	public void testGetAvailableIntegratorIds_1() {

		assertDoesNotThrow(() -> {
			List<String> ids = support.getAvailableIntegratorIds();
			assertEquals("net.first.supplier", ids.get(0));
		});
	}

	@Test
	public void testGetIntegratorId_1() {

		assertDoesNotThrow(() -> {
			String name = support.getIntegratorId(0);
			assertEquals("net.first.supplier", name);
		});
	}

	@Test
	public void testGetIntegratorSupplier_1() {

		assertDoesNotThrow(() -> {
			IChromatogramIntegratorSupplier supplier = support.getIntegratorSupplier("net.first.supplier");
			assertNotNull(supplier);
			assertEquals("Test Integrator Name", supplier.getIntegratorName());
		});
	}

	@Test
	public void testGetIntegratorNames_1() {

		assertDoesNotThrow(() -> {
			String[] names = support.getIntegratorNames();
			assertEquals(1, names.length);
			assertEquals("Test Integrator Name", names[0]);
		});
	}
}
