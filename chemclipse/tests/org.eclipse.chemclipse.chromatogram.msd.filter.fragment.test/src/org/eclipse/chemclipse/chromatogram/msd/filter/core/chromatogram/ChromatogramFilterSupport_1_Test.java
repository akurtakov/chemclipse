/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramFilterSupport_1_Test {

	private ChromatogramFilterSupportMSD support;
	private ChromatogramFilterSupplierMSD supplier;

	@BeforeAll
	public void setUp() throws Exception {

		support = new ChromatogramFilterSupportMSD();
		supplier = new ChromatogramFilterSupplierMSD();
		supplier.setId("net.first.supplier");
		supplier.setDescription("Filter Description");
		supplier.setFilterName("Test Filter Name");
		support.add(supplier);
	}

	@Test
	public void testGetAvailableFilterIds_1() {

		assertDoesNotThrow(() -> {
			List<String> ids = support.getAvailableFilterIds();
			assertEquals("net.first.supplier", ids.get(0));
		});
	}

	@Test
	public void testGetIntegratorId_1() {

		assertDoesNotThrow(() -> {
			String name = support.getFilterId(0);
			assertEquals("net.first.supplier", name);
		});
	}

	@Test
	public void testGetIntegratorSupplier_1() {

		assertDoesNotThrow(() -> {
			IChromatogramFilterSupplierMSD supplier = support.getFilterSupplier("net.first.supplier");
			assertNotNull(supplier);
			assertEquals("Test Filter Name", supplier.getFilterName());
		});
	}

	@Test
	public void testGetIntegratorNames_1() {

		assertDoesNotThrow(() -> {
			String[] names = support.getFilterNames();
			assertEquals(1, names.length);
			assertEquals("Test Filter Name", names[0]);
		});
	}
}
