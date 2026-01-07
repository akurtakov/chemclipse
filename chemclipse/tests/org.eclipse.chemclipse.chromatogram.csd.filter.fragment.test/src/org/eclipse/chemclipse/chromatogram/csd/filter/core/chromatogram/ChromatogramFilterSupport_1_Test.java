/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.csd.filter.core.chromatogram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.exceptions.NoChromatogramFilterSupplierAvailableException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramFilterSupport_1_Test {

	private ChromatogramFilterSupportCSD support;

	@BeforeAll
	public void setUp() {

		support = new ChromatogramFilterSupportCSD();
		ChromatogramFilterSupplierCSD supplier = new ChromatogramFilterSupplierCSD();
		supplier.setId("net.first.supplier");
		supplier.setDescription("Filter Description");
		supplier.setFilterName("Test Filter Name");
		support.add(supplier);
	}

	@Test
	public void testGetAvailableFilterIds_1() throws NoChromatogramFilterSupplierAvailableException {

		List<String> ids = support.getAvailableFilterIds();
		assertEquals("net.first.supplier", ids.get(0), "getId");
	}

	@Test
	public void testGetIntegratorId_1() throws NoChromatogramFilterSupplierAvailableException {

		String name = support.getFilterId(0);
		assertEquals("net.first.supplier", name, "Name");

	}

	@Test
	public void testGetIntegratorSupplier_1() throws NoChromatogramFilterSupplierAvailableException {

		IChromatogramFilterSupplierCSD supplier;
		supplier = support.getFilterSupplier("net.first.supplier");
		assertNotNull(supplier);
		assertEquals("Test Filter Name", supplier.getFilterName(), "Name");
	}

	@Test
	public void testGetIntegratorNames_1() throws NoChromatogramFilterSupplierAvailableException {

		String[] names = support.getFilterNames();
		assertEquals(1, names.length, "length");
		assertEquals("Test Filter Name", names[0], "name");
	}
}
