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

import org.eclipse.chemclipse.model.quantitation.CalibrationMethod;
import org.eclipse.chemclipse.model.quantitation.IQuantitationCompound;

import junit.framework.TestCase;

public class QuantitationCompound_2_Test extends TestCase {

	private IQuantitationCompound quantitationCompound;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		quantitationCompound = new QuantitationCompound("Styrene", "mg/ml", 5500);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
		quantitationCompound = null;
	}

	public void testGetCalibrationMethod_1() {

		assertEquals(CalibrationMethod.LINEAR, quantitationCompound.getCalibrationMethod());
	}

	public void testGetChemicalClass_1() {

		assertEquals("", quantitationCompound.getChemicalClass());
	}

	public void testGetConcentrationResponseEntries_1() {

		assertNotNull(quantitationCompound.getResponseSignals());
	}

	public void testGetConcentrationUnit_1() {

		assertEquals("mg/ml", quantitationCompound.getConcentrationUnit());
	}

	public void testGetName_1() {

		assertEquals("Styrene", quantitationCompound.getName());
	}

	public void testGetQuantitationSignals_1() {

		assertNotNull(quantitationCompound.getQuantitationSignals());
	}

	public void testGetRetentionIndexWindow_1() {

		assertNotNull(quantitationCompound.getRetentionIndexWindow());
	}

	public void testGetRetentionTimeWindow_1() {

		assertNotNull(quantitationCompound.getRetentionTimeWindow());
	}
}
