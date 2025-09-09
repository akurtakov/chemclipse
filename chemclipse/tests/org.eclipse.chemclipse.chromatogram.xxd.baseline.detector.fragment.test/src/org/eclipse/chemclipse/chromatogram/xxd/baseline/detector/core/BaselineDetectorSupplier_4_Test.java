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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BaselineDetectorSupplier_4_Test {

	private BaselineDetectorSupplier supplier1;
	private BaselineDetectorSupplier supplier2;

	@BeforeAll
	public void setUp() {

		supplier1 = new BaselineDetectorSupplier();
		supplier1.setId("id1");
		supplier1.setDescription("description1");
		supplier1.setDetectorName("detectorName1");

		supplier2 = new BaselineDetectorSupplier();
		supplier2.setId("id2");
		supplier2.setDescription("description2");
		supplier2.setDetectorName("detectorName2");
	}

	@Test
	public void testEquals_1() {

		assertNotEquals(supplier1, supplier2);
	}

	@Test
	public void testEquals_2() {

		assertNotEquals(supplier2, supplier1);
	}

	@Test
	public void testEquals_3() {

		assertNotNull(supplier1);
	}

	@Test
	public void testEquals_4() {

		assertNotEquals(supplier1, new Object());
	}

	@Test
	public void testHashCode_1() {

		assertFalse(supplier1.hashCode() == supplier2.hashCode());
	}
}
