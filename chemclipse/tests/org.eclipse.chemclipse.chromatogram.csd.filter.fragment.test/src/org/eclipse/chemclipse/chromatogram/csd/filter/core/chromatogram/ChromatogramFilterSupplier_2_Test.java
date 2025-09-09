/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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

import org.junit.jupiter.api.Test;

public class ChromatogramFilterSupplier_2_Test {

	private ChromatogramFilterSupplierCSD supplier = new ChromatogramFilterSupplierCSD();

	@Test
	public void testGetId_1() {

		assertEquals("", supplier.getId(), "Id");
	}

	@Test
	public void testGetDescription_1() {

		assertEquals("", supplier.getDescription(), "Description");
	}

	@Test
	public void testGetFilterName_1() {

		assertEquals("", supplier.getFilterName(), "Filter Name");
	}
}
