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

import org.eclipse.chemclipse.msd.model.core.IPeakMassSpectrum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakMassSpectrum_4_Test {

	private IPeakMassSpectrum peakMassSpectrum;

	@BeforeAll
	public void setUp() {

		peakMassSpectrum = new PeakMassSpectrum();
		for(int i = 0; i < 5; i++) {
			peakMassSpectrum.addIon(new Ion(i, 100));
		}
	}

	@Test
	public void testGetNumberOfIons_1() {

		assertEquals(5, peakMassSpectrum.getNumberOfIons());
	}
}
