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
package org.eclipse.chemclipse.msd.model.support;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CombinedNominalMassSpectrumCalculator_1_Test {

	private CombinedNominalMassSpectrumCalculator combinedNominalMassSpectrumCalculator = new CombinedNominalMassSpectrumCalculator();

	@Test
	public void testSize_1() {

		assertEquals("Size", 0, combinedNominalMassSpectrumCalculator.size());
	}

	@Test
	public void testSize_2() {

		combinedNominalMassSpectrumCalculator.addIon(56.5f, 500.0f);
		assertEquals("Size", 1, combinedNominalMassSpectrumCalculator.size());
	}

	@Test
	public void testSize_3() {

		combinedNominalMassSpectrumCalculator.addIon(56.5f, 500.0f);
		combinedNominalMassSpectrumCalculator.addIon(80.2f, 700.0f);
		assertEquals("Size", 2, combinedNominalMassSpectrumCalculator.size());
	}

	@Test
	public void testSize_4() {

		combinedNominalMassSpectrumCalculator.addIon(56.5f, 500.0f);
		combinedNominalMassSpectrumCalculator.addIon(80.2f, 700.0f);
		combinedNominalMassSpectrumCalculator.addIon(90.3f, 800.0f);
		assertEquals("Size", 3, combinedNominalMassSpectrumCalculator.size());
	}

	@Test
	public void testSize_5() {

		/*
		 * Math round is used to determine the integer value of the mass
		 * fragment.
		 */
		combinedNominalMassSpectrumCalculator.addIon(56.4f, 500.0f);
		combinedNominalMassSpectrumCalculator.addIon(56.2f, 700.0f);
		combinedNominalMassSpectrumCalculator.addIon(55.9f, 800.0f);
		assertEquals("Size", 1, combinedNominalMassSpectrumCalculator.size());
	}
}
