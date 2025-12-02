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
 * Christoph Läubrich - Adjust to new API
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.chromatogram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.chemclipse.converter.chromatogram.ChromatogramConverterSupport;
import org.eclipse.chemclipse.converter.chromatogram.ChromatogramSupplier;
import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * This TestCase analyses if the class ChromatogramConverterSupport methods work
 * in a correct way.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramConverterSupport_2_Test {

	private ChromatogramConverterSupport support = new ChromatogramConverterSupport(null);

	@BeforeAll
	public void setUp() {

		ChromatogramSupplier supplier = new ChromatogramSupplier();
		supplier.setId("org.eclipse.chemclipse.msd.converter.supplier.agilent");
		supplier.setFileExtension(".MS");
		supplier.setDirectoryExtension(".D");
		supplier.setFilterName("Agilent Chromatogram (.D)");
		support.add(supplier);

		supplier = new ChromatogramSupplier();
		supplier.setId("org.eclipse.chemclipse.msd.converter.supplier.netCDF");
		supplier.setFileExtension(".netCDF");
		supplier.setDirectoryExtension("");
		supplier.setFilterName("ANDI/AIA (.netCDF)");
		support.add(supplier);

		supplier = new ChromatogramSupplier();
		supplier.setId("org.eclipse.chemclipse.xxd.converter.supplier.chemclipse");
		supplier.setFileExtension(".chrom");
		supplier.setDirectoryExtension("");
		supplier.setFilterName("ChemClipse Chromatogram (.chrom)");
		support.add(supplier);
	}

	@Test
	public void testGetConverterId_1() {

		assertThrows(NoConverterAvailableException.class, () -> {
			support.getConverterId(-1);
		});
	}

	@Test
	public void testGetConverterId_2() {

		assertThrows(NoConverterAvailableException.class, () -> {
			support.getConverterId(3);
		});
	}

	@Test
	public void testGetConverterId_3() throws NoConverterAvailableException {

		String id = support.getConverterId(0);
		assertEquals("org.eclipse.chemclipse.msd.converter.supplier.agilent", id);
		id = support.getConverterId(1);
		assertEquals("org.eclipse.chemclipse.msd.converter.supplier.netCDF", id);
		id = support.getConverterId(2);
		assertEquals("org.eclipse.chemclipse.xxd.converter.supplier.chemclipse", id);
	}

	@Test
	public void testGetFilterExtensions_1() throws NoConverterAvailableException {

		String[] ids = support.getFilterExtensions();
		assertEquals("*.", ids[0]); // Important ... otherwise 'Save As...' fails
		assertEquals("*.netCDF;*.netcdf;*.NETCDF", ids[1]);
		assertEquals("*.chrom;*.CHROM", ids[2]);
	}

	@Test
	public void testGetFilterNames_1() throws NoConverterAvailableException {

		String[] names = support.getFilterNames();
		assertEquals("Agilent Chromatogram (.D)", names[0]);
		assertEquals("ANDI/AIA (.netCDF)", names[1]);
		assertEquals("ChemClipse Chromatogram (.chrom)", names[2]);
	}
}
