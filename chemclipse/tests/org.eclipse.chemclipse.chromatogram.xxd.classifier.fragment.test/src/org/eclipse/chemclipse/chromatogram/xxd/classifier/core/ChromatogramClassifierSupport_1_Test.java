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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramClassifierSupport_1_Test {

	private ChromatogramClassifierSupport support;
	private ChromatogramClassifierSupplier supplier;

	@BeforeAll
	public void setUp() throws Exception {

		support = new ChromatogramClassifierSupport();
		supplier = new ChromatogramClassifierSupplier();
		supplier.setId("net.first.supplier");
		supplier.setDescription("Classifier Description");
		supplier.setClassifierName("Test Classifier Name");
		support.add(supplier);
	}

	@Test
	public void testGetAvailableClassifierIds_1() {

		assertDoesNotThrow(() -> {
			List<String> ids = support.getAvailableClassifierIds();
			assertEquals("net.first.supplier", ids.get(0));
		});
	}

	@Test
	public void testGetIntegratorId_1() {

		assertDoesNotThrow(() -> {
			String name = support.getClassifierId(0);
			assertEquals("net.first.supplier", name);
		});
	}

	@Test
	public void testGetIntegratorSupplier_1() {

		assertDoesNotThrow(() -> {
			IChromatogramClassifierSupplier supplier = support.getClassifierSupplier("net.first.supplier");
			assertNotNull(supplier);
			assertEquals("Test Classifier Name", supplier.getClassifierName());
		});
	}

	@Test
	public void testGetIntegratorNames_1() {

		assertDoesNotThrow(() -> {
			String[] names = support.getClassifierNames();
			assertEquals(1, names.length);
			assertEquals("Test Classifier Name", names[0]);
		});
	}
}
