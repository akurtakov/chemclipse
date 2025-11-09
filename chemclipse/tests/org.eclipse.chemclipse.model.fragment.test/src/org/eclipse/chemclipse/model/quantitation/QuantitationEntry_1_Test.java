/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.model.implementation.QuantitationEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class QuantitationEntry_1_Test {

	private IQuantitationEntry quantitationEntry1;
	private IQuantitationEntry quantitationEntry2;
	private IQuantitationEntry quantitationEntry3;

	@BeforeAll
	public void setUp() {

		quantitationEntry1 = new QuantitationEntry("Toluene", "PAK", 0.25d, "mg/g", 2000.0d);
		quantitationEntry2 = new QuantitationEntry("Toluene", "", 0.25d, "mg/g", 2000.0d);
		quantitationEntry3 = new QuantitationEntry("Toluene", "PAK", 0.25d, "mg/g", 2000.0d);
	}

	@Test
	public void test1() {

		assertFalse(quantitationEntry1.equals(quantitationEntry2));
	}

	@Test
	public void test2() {

		assertTrue(quantitationEntry1.equals(quantitationEntry3));
	}

	@Test
	public void test3() {

		assertFalse(quantitationEntry2.equals(quantitationEntry3));
	}
}