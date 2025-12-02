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
package org.eclipse.chemclipse.msd.converter.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.converter.core.IConverterSupport;
import org.eclipse.chemclipse.converter.core.IConverterSupportSetter;
import org.eclipse.chemclipse.converter.exceptions.NoConverterAvailableException;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AbstractConverterSupport_7_Test extends AbstractConverterTestCase {

	private IConverterSupportSetter converterSupport;
	private List<ISupplier> supplier;
	private ISupplier actSupplier;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		converterSupport = getConverterSupport();
		supplier = new ArrayList<>(converterSupport.getSupplier(IConverterSupport.EXPORT_SUPPLIER));
	}

	@Test
	public void testGetSupplier_1() {

		assertEquals(3, supplier.size());
	}

	@Test
	public void testGetSupplier_2() throws NoConverterAvailableException {

		String id = "org.eclipse.chemclipse.msd.converter.supplier.agilent";
		actSupplier = converterSupport.getSupplier(id);
	}

	@Test
	public void testGetSupplier_3() throws NoConverterAvailableException {

		String id = "org.eclipse.chemclipse.msd.converter.supplier.agilent.msd1";
		actSupplier = converterSupport.getSupplier(id);
	}

	@Test
	public void testGetSupplier_4() throws NoConverterAvailableException {

		String id = "net.openchrom.msd.converter.supplier.cdf";
		String filterName = "ANDI/AIA CDF Chromatogram (*.CDF)";
		actSupplier = converterSupport.getSupplier(id);
		assertEquals(filterName, actSupplier.getFilterName());
	}

	@Test
	public void testGetSupplier_5() throws NoConverterAvailableException {

		String id = "org.eclipse.chemclipse.msd.converter.supplier.excel";
		String filterName = "Excel Chromatogram (*.xlsx)";
		actSupplier = converterSupport.getSupplier(id);
		assertEquals(filterName, actSupplier.getFilterName());
	}

	@Test
	public void testGetSupplier_6() throws NoConverterAvailableException {

		String id = "org.eclipse.chemclipse.msd.converter.supplier.test";
		String filterName = "Test Chromatogram (*.C/CHROM.MS)";
		actSupplier = converterSupport.getSupplier(id);
		assertEquals(filterName, actSupplier.getFilterName());
	}
}
