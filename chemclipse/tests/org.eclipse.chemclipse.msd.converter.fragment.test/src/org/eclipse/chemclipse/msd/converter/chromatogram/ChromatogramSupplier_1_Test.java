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
package org.eclipse.chemclipse.msd.converter.chromatogram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.converter.chromatogram.ChromatogramSupplier;
import org.junit.jupiter.api.Test;

/**
 * Testing all methods of ChromatogramSupplier and its specification.
 */
public class ChromatogramSupplier_1_Test {

	private ChromatogramSupplier supplier = new ChromatogramSupplier();

	@Test
	public void testId_1() {

		assertEquals("", supplier.getId());
		supplier.setId(null);
		assertEquals("", supplier.getId());
		supplier.setId("org.eclipse.chemclipse.msd.converter.supplier.agilent");
		assertEquals("org.eclipse.chemclipse.msd.converter.supplier.agilent", supplier.getId());
		supplier.setId("");
		assertEquals("", supplier.getId());
	}

	@Test
	public void testDescription_1() {

		assertEquals("", supplier.getDescription());
		supplier.setDescription(null);
		assertEquals("", supplier.getDescription());
		supplier.setDescription("This is the agilent data format.");
		assertEquals("This is the agilent data format.", supplier.getDescription());
		supplier.setDescription("");
		assertEquals("", supplier.getDescription());
	}

	@Test
	public void testFilterName_1() {

		assertEquals("", supplier.getDescription());
		supplier.setDescription(null);
		assertEquals("", supplier.getDescription());
		supplier.setDescription("This is the agilent data format.");
		assertEquals("This is the agilent data format.", supplier.getDescription());
		supplier.setDescription("");
		assertEquals("", supplier.getDescription());
	}

	@Test
	public void testFileExtension_1() {

		assertEquals("", supplier.getFileExtension());
		supplier.setFileExtension(null);
		assertEquals("", supplier.getFileExtension());
		supplier.setFileExtension("MS");
		assertEquals("MS", supplier.getFileExtension());
		supplier.setFileExtension(".MS");
		assertEquals(".MS", supplier.getFileExtension());
		supplier.setFileExtension("");
		assertEquals("", supplier.getFileExtension());
	}

	@Test
	public void testFileName_1() {

		assertEquals("", supplier.getFileName());
		supplier.setFileName(null);
		assertEquals("", supplier.getFileName());
		supplier.setFileName("DATA");
		assertEquals("DATA", supplier.getFileName());
		supplier.setFileName("");
		assertEquals("", supplier.getFileName());
	}

	@Test
	public void testDirectoryExtension_1() {

		assertEquals("", supplier.getDirectoryExtension());
		supplier.setDirectoryExtension(null);
		assertEquals("", supplier.getDirectoryExtension());
		supplier.setDirectoryExtension("D");
		assertEquals(".D", supplier.getDirectoryExtension());
		supplier.setDirectoryExtension(".D");
		assertEquals(".D", supplier.getDirectoryExtension());
		supplier.setDirectoryExtension("");
		assertEquals("", supplier.getDirectoryExtension());
	}

	@Test
	public void testIsImportable_1() {

		assertFalse(supplier.isImportable());
		supplier.setImportable(false);
		assertFalse(supplier.isImportable());
		supplier.setImportable(true);
		assertTrue(supplier.isImportable());
	}

	@Test
	public void testIsExportable_1() {

		assertFalse(supplier.isExportable());
		supplier.setExportable(false);
		assertFalse(supplier.isExportable());
		supplier.setExportable(true);
		assertTrue(supplier.isExportable());
	}
}
