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
package org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BaselineDetectorSupplier_2_Test {

	private BaselineDetectorSupplier supplier;
	private String id = "id";
	private String description = "description";
	private String detectorName = "detectorName";

	@BeforeAll
	public void setUp() {

		supplier = new BaselineDetectorSupplier();
		supplier.setId(id);
		supplier.setDescription(description);
		supplier.setDetectorName(detectorName);
	}

	@Test
	public void testGetId_1() {

		assertEquals(id, supplier.getId());
		id = "newId";
		supplier.setId(id);
		assertEquals(id, supplier.getId());
	}

	@Test
	public void testGetDescription_1() {

		assertEquals(description, supplier.getDescription());
		description = "newDescription";
		supplier.setDescription(description);
		assertEquals(description, supplier.getDescription());
	}

	@Test
	public void testGetDetectorName_1() {

		assertEquals(detectorName, supplier.getDetectorName());
		detectorName = "newDetectorName";
		supplier.setDetectorName(detectorName);
		assertEquals(detectorName, supplier.getDetectorName());
	}
}
