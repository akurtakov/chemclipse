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
package org.eclipse.chemclipse.xxd.model.quantitation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.eclipse.chemclipse.model.quantitation.CalibrationMethod;
import org.eclipse.chemclipse.model.quantitation.IQuantitationCompound;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class QuantitationCompound_2_Test {

	private IQuantitationCompound quantitationCompound;

	@BeforeAll
	public void setUp() {

		quantitationCompound = new QuantitationCompound("Styrene", "mg/ml", 5500);
	}

	@Test
	public void testGetCalibrationMethod_1() {

		assertEquals(CalibrationMethod.LINEAR, quantitationCompound.getCalibrationMethod());
	}

	@Test
	public void testGetChemicalClass_1() {

		assertEquals("", quantitationCompound.getChemicalClass());
	}

	@Test
	public void testGetConcentrationResponseEntries_1() {

		assertNotNull(quantitationCompound.getResponseSignals());
	}

	@Test
	public void testGetConcentrationUnit_1() {

		assertEquals("mg/ml", quantitationCompound.getConcentrationUnit());
	}

	@Test
	public void testGetName_1() {

		assertEquals("Styrene", quantitationCompound.getName());
	}

	@Test
	public void testGetQuantitationSignals_1() {

		assertNotNull(quantitationCompound.getQuantitationSignals());
	}

	@Test
	public void testGetRetentionIndexWindow_1() {

		assertNotNull(quantitationCompound.getRetentionIndexWindow());
	}

	@Test
	public void testGetRetentionTimeWindow_1() {

		assertNotNull(quantitationCompound.getRetentionTimeWindow());
	}
}
