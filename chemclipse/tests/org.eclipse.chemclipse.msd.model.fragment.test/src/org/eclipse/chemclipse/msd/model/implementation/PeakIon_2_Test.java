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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.msd.model.core.PeakIonType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PeakIon_2_Test {

	private PeakIon peakIon;

	@BeforeEach
	public void setUp() {

		peakIon = new PeakIon(45.5f, 2500.4f);
	}

	@Test
	public void testGetUncertaintyFactor_1() {

		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
		peakIon.setUncertaintyFactor(0.3f);
		assertEquals(0.3f, peakIon.getUncertaintyFactor(), 0);
	}

	@Test
	public void testGetUncertaintyFactor_2() {

		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
		peakIon.setUncertaintyFactor(0.0f);
		assertEquals(0.0f, peakIon.getUncertaintyFactor(), 0);
	}

	@Test
	public void testGetUncertaintyFactor_3() {

		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
		peakIon.setUncertaintyFactor(1.0f);
		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
	}

	@Test
	public void testGetUncertaintyFactor_4() {

		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
		peakIon.setUncertaintyFactor(-0.1f);
		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
	}

	@Test
	public void testGetUncertaintyFactor_5() {

		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
		peakIon.setUncertaintyFactor(1.1f);
		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
	}

	@Test
	public void testGetPeakIonType_1() {

		assertEquals(PeakIonType.NO_TYPE, peakIon.getPeakIonType());
		peakIon.setPeakIonType(PeakIonType.B);
		assertEquals(PeakIonType.B, peakIon.getPeakIonType());
	}

	@Test
	public void testGetPeakIonType_2() {

		assertEquals(PeakIonType.NO_TYPE, peakIon.getPeakIonType());
		peakIon.setPeakIonType(null);
		assertEquals(PeakIonType.NO_TYPE, peakIon.getPeakIonType());
	}
}
