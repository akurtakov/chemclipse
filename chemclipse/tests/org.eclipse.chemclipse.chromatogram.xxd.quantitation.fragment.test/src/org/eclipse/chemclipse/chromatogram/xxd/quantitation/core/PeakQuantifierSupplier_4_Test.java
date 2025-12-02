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

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakQuantifierSupplier_4_Test {

	private PeakQuantifierSupplier supplier1;
	private PeakQuantifierSupplier supplier2;

	@BeforeAll
	public void setUp() {

		supplier1 = new PeakQuantifierSupplier();
		supplier1.setId("id1");
		supplier1.setDescription("description1");
		supplier1.setPeakQuantifierName("detectorName1");

		supplier2 = new PeakQuantifierSupplier();
		supplier2.setId("id2");
		supplier2.setDescription("description2");
		supplier2.setPeakQuantifierName("detectorName2");
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

		assertNotEquals(supplier1.hashCode(), supplier2.hashCode());
	}
}
