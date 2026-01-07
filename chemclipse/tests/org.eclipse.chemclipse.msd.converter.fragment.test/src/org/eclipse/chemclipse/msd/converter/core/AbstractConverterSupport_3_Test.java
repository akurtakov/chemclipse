/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.converter.core.IConverterSupport;
import org.eclipse.chemclipse.converter.core.IConverterSupportSetter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AbstractConverterSupport_3_Test extends AbstractConverterTestCase {

	private String[] filterExtensions;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		IConverterSupportSetter converterSupport = getConverterSupport();
		filterExtensions = converterSupport.getFilterExtensions(IConverterSupport.EXPORT_SUPPLIER);
	}

	@Test
	public void testGetExportableFilterExtensions_1() {

		int size = filterExtensions.length;
		assertEquals(3, size); // Important ... otherwise 'Save As...' fails
	}

	@Test
	public void testGetExportableFilterExtensions_2() {

		String extension = filterExtensions[0];
		assertEquals("*.CDF;*.cdf", extension);
	}

	@Test
	public void testGetExportableFilterExtensions_3() {

		String extension = filterExtensions[1];
		assertEquals("*.xlsx;*.XLSX", extension);
	}

	@Test
	public void testGetExportableFilterExtensions_4() {

		String extension = filterExtensions[2];
		assertEquals("*.", extension);
	}
}
