/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.quantitation.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PeakQuantifierSupplier_2_Test {

	private PeakQuantifierSupplier supplier;
	private String id = "id";
	private String description = "description";
	private String detectorName = "detectorName";

	@BeforeEach
	public void setUp() {

		supplier = new PeakQuantifierSupplier();
		supplier.setId(id);
		supplier.setDescription(description);
		supplier.setPeakQuantifierName(detectorName);
	}

	@Test
	public void testGetId_1() {

		assertEquals("id", id, supplier.getId());
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

		assertEquals(detectorName, supplier.getPeakQuantifierName());
		detectorName = "newDetectorName";
		supplier.setPeakQuantifierName(detectorName);
		assertEquals(detectorName, supplier.getPeakQuantifierName());
	}
}
