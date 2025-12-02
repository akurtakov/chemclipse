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
 * Testing toString(), hashCode() and equals() of ChromatogramSupplier.
 */
public class ChromatogramSupplier_2_Test {

	private ChromatogramSupplier supplier = new ChromatogramSupplier();

	@Test
	public void testToString_1() {

		String test = "org.eclipse.chemclipse.converter.chromatogram.ChromatogramSupplier[id=,description=,filterName=,fileExtension=,fileName=,directoryExtension=,isExportable=false,isImportable=false]";
		assertEquals(test, supplier.toString());
	}

	@Test
	public void testEquals_1() {

		ChromatogramSupplier anotherSupplier = new ChromatogramSupplier();
		assertEquals(true, supplier.equals(anotherSupplier));
	}

	@Test
	public void testEquals_2() {

		ChromatogramSupplier anotherSupplier = new ChromatogramSupplier();
		anotherSupplier.setId("chemclipse");
		assertFalse(supplier.equals(anotherSupplier));
		anotherSupplier.setId("");
		assertTrue(supplier.equals(anotherSupplier));
		anotherSupplier.setDescription("chemclipse");
		assertFalse(supplier.equals(anotherSupplier));
		anotherSupplier.setDescription("");
		assertTrue(supplier.equals(anotherSupplier));
		anotherSupplier.setFilterName("chemclipse");
		assertFalse(supplier.equals(anotherSupplier));
		anotherSupplier.setFilterName("");
		assertTrue(supplier.equals(anotherSupplier));
		anotherSupplier.setFileExtension("chemclipse");
		assertFalse(supplier.equals(anotherSupplier));
		anotherSupplier.setFileExtension("");
		assertTrue(supplier.equals(anotherSupplier));
		anotherSupplier.setFileName("chemclipse");
		assertFalse(supplier.equals(anotherSupplier));
		anotherSupplier.setFileName("");
		assertTrue(supplier.equals(anotherSupplier));
		anotherSupplier.setDirectoryExtension("chemclipse");
		assertFalse(supplier.equals(anotherSupplier));
		anotherSupplier.setDirectoryExtension("");
		assertTrue(supplier.equals(anotherSupplier));
	}

	@Test
	public void testEquals_3() {

		ChromatogramSupplier anotherSupplier = new ChromatogramSupplier();
		anotherSupplier.setId("chemclipse");
		assertFalse(anotherSupplier.equals(supplier));
		anotherSupplier.setId("");
		assertTrue(anotherSupplier.equals(supplier));
		anotherSupplier.setDescription("chemclipse");
		assertFalse(anotherSupplier.equals(supplier));
		anotherSupplier.setDescription("");
		assertTrue(anotherSupplier.equals(supplier));
		anotherSupplier.setFilterName("chemclipse");
		assertFalse(anotherSupplier.equals(supplier));
		anotherSupplier.setFilterName("");
		assertTrue(anotherSupplier.equals(supplier));
		anotherSupplier.setFileExtension("chemclipse");
		assertFalse(anotherSupplier.equals(supplier));
		anotherSupplier.setFileExtension("");
		assertTrue(anotherSupplier.equals(supplier));
		anotherSupplier.setFileName("chemclipse");
		assertFalse(anotherSupplier.equals(supplier));
		anotherSupplier.setFileName("");
		assertTrue(anotherSupplier.equals(supplier));
		anotherSupplier.setDirectoryExtension("chemclipse");
		assertFalse(anotherSupplier.equals(supplier));
		anotherSupplier.setDirectoryExtension("");
		assertTrue(anotherSupplier.equals(supplier));
	}

	@Test
	public void testEquals_4() {

		ChromatogramSupplier anotherSupplier = supplier;
		assertTrue(anotherSupplier.equals(supplier));
	}

	@Test
	public void testEquals_5() {

		assertTrue(supplier.equals(supplier));
	}

	@Test
	public void testEquals_6() {

		ChromatogramSupplier anotherSupplier = null;
		assertFalse(supplier.equals(anotherSupplier));
	}

	@Test
	public void testEquals_7() {

		Object anotherSupplier = new Object();
		assertFalse(supplier.equals(anotherSupplier));
	}

	@Test
	public void testHashCode_1() {

		ChromatogramSupplier anotherSupplier = new ChromatogramSupplier();
		assertEquals(anotherSupplier.hashCode(), supplier.hashCode());
	}

	@Test
	public void testHashCode_2() {

		ChromatogramSupplier anotherSupplier = new ChromatogramSupplier();
		anotherSupplier.setId("chemclipse");
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setId("");
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setDescription("chemclipse");
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setDescription("");
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setFilterName("chemclipse");
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setFilterName("");
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setFileExtension("chemclipse");
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setFileExtension("");
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setFileName("chemclipse");
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setFileName("");
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setDirectoryExtension("chemclipse");
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setDirectoryExtension("");
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setImportable(true);
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setImportable(false);
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setExportable(true);
		assertFalse(anotherSupplier.hashCode() == supplier.hashCode());
		anotherSupplier.setExportable(false);
		assertTrue(anotherSupplier.hashCode() == supplier.hashCode());
	}
}
