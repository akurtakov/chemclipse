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
package org.eclipse.chemclipse.msd.converter.massspectrum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.converter.chromatogram.ChromatogramSupplier;
import org.junit.jupiter.api.Test;

/**
 * Testing toString(), hashCode() and equals() of ChromatogramSupplier.
 */
public class MassSpectrumSupplier_2_Test {

	private MassSpectrumSupplier supplier = new MassSpectrumSupplier();

	@Test
	public void testToString_1() {

		String test = "org.eclipse.chemclipse.msd.converter.massspectrum.MassSpectrumSupplier[id=,description=,filterName=,fileExtension=,fileName=,directoryExtension=,isExportable=false,isImportable=false]";
		assertEquals(test, supplier.toString());
	}

	@Test
	public void testEquals_1() {

		MassSpectrumSupplier anotherSupplier = new MassSpectrumSupplier();
		assertEquals(supplier, anotherSupplier);
	}

	@Test
	public void testEquals_2() {

		MassSpectrumSupplier anotherSupplier = new MassSpectrumSupplier();
		anotherSupplier.setId("chemclipse");
		assertNotEquals(supplier, anotherSupplier);
		anotherSupplier.setId("");
		assertEquals(supplier, anotherSupplier);
		anotherSupplier.setDescription("chemclipse");
		assertNotEquals(supplier, anotherSupplier);
		anotherSupplier.setDescription("");
		assertEquals(supplier, anotherSupplier);
		anotherSupplier.setFilterName("chemclipse");
		assertNotEquals(supplier, anotherSupplier);
		anotherSupplier.setFilterName("");
		assertEquals(supplier, anotherSupplier);
		anotherSupplier.setFileExtension("chemclipse");
		assertNotEquals(supplier, anotherSupplier);
		anotherSupplier.setFileExtension("");
		assertEquals(supplier, anotherSupplier);
		anotherSupplier.setFileName("chemclipse");
		assertNotEquals(supplier, anotherSupplier);
		anotherSupplier.setFileName("");
		assertEquals(supplier, anotherSupplier);
		anotherSupplier.setDirectoryExtension("chemclipse");
		assertNotEquals(supplier, anotherSupplier);
		anotherSupplier.setDirectoryExtension("");
		assertEquals(supplier, anotherSupplier);
	}

	@Test
	public void testEquals_3() {

		MassSpectrumSupplier anotherSupplier = new MassSpectrumSupplier();
		anotherSupplier.setId("chemclipse");
		assertNotEquals(anotherSupplier, supplier);
		anotherSupplier.setId("");
		assertEquals(anotherSupplier, supplier);
		anotherSupplier.setDescription("chemclipse");
		assertNotEquals(anotherSupplier, supplier);
		anotherSupplier.setDescription("");
		assertEquals(anotherSupplier, supplier);
		anotherSupplier.setFilterName("chemclipse");
		assertNotEquals(anotherSupplier, supplier);
		anotherSupplier.setFilterName("");
		assertEquals(anotherSupplier, supplier);
		anotherSupplier.setFileExtension("chemclipse");
		assertNotEquals(anotherSupplier, supplier);
		anotherSupplier.setFileExtension("");
		assertEquals(anotherSupplier, supplier);
		anotherSupplier.setFileName("chemclipse");
		assertNotEquals(anotherSupplier, supplier);
		anotherSupplier.setFileName("");
		assertEquals(anotherSupplier, supplier);
		anotherSupplier.setDirectoryExtension("chemclipse");
		assertNotEquals(anotherSupplier, supplier);
		anotherSupplier.setDirectoryExtension("");
		assertEquals(anotherSupplier, supplier);
	}

	@Test
	public void testEquals_4() {

		MassSpectrumSupplier anotherSupplier = supplier;
		assertEquals(anotherSupplier, supplier);
	}

	@Test
	public void testEquals_5() {

		assertEquals(supplier, supplier);
	}

	@Test
	public void testEquals_6() {

		ChromatogramSupplier anotherSupplier = null;
		assertNotEquals(supplier, anotherSupplier);
	}

	@Test
	public void testEquals_7() {

		Object anotherSupplier = new Object();
		assertNotEquals(supplier, anotherSupplier);
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
