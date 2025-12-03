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

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.PeakIonType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakIon_3_Test {

	private IIon ion;
	private PeakIon peakIon;

	@BeforeAll
	public void setUp() {

		ion = new Ion(45.5f, 2500.4f);
		peakIon = new PeakIon(ion);
	}

	@Test
	public void testGetUncertaintyFactor_1() {

		assertEquals(1.0f, peakIon.getUncertaintyFactor(), 0);
	}

	@Test
	public void testGetPeakIonType_1() {

		assertEquals(PeakIonType.NO_TYPE, peakIon.getPeakIonType());
	}
}
