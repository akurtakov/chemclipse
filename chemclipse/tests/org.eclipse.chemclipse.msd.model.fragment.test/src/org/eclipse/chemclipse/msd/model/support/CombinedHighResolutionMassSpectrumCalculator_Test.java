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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.chemclipse.model.support.CalculationType;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;
import org.junit.Before;
import org.junit.Test;

public class CombinedHighResolutionMassSpectrumCalculator_Test {

	private CombinedHighResolutionMassSpectrumCalculator combinedHighResMassSpectrumCalculator;

	@Before
	public void setUp() {

		combinedHighResMassSpectrumCalculator = new CombinedHighResolutionMassSpectrumCalculator();
		combinedHighResMassSpectrumCalculator.addIon(56.023595f, 2323.0f);
		combinedHighResMassSpectrumCalculator.addIon(56.435424f, 7834.f);
		combinedHighResMassSpectrumCalculator.addIon(57.013455f, 7423.0f);
		combinedHighResMassSpectrumCalculator.addIon(57.256245f, 5434.0f);
		combinedHighResMassSpectrumCalculator.addIon(57.545454f, 0.0f);
	}

	@Test
	public void testValues_1() {

		assertEquals(4, combinedHighResMassSpectrumCalculator.size());
	}

	@Test
	public void testValues_2() {

		double ion = 57.013455d;
		ICombinedMassSpectrum massSpectrum = combinedHighResMassSpectrumCalculator.createMassSpectrum(CalculationType.SUM);
		assertNotNull(massSpectrum.getIon(ion));
	}

	@Test
	public void testValues_3() {

		float ion = 23.545454f;
		ICombinedMassSpectrum massSpectrum = combinedHighResMassSpectrumCalculator.createMassSpectrum(CalculationType.SUM);
		assertEquals(0d, massSpectrum.getIon(ion).getAbundance(), 0);
	}

	@Test
	public void testValues_4() {

		float ion = 57.256245f;
		ICombinedMassSpectrum massSpectrum = combinedHighResMassSpectrumCalculator.createMassSpectrum(CalculationType.MEAN);
		assertEquals(5434.0f, massSpectrum.getIon(ion).getAbundance(), 0);
	}

	@Test
	public void testValues_5() {

		int ion = 23;
		ICombinedMassSpectrum massSpectrum = combinedHighResMassSpectrumCalculator.createMassSpectrum(CalculationType.SUM);
		assertNull(massSpectrum.getIon(ion));
	}

	@Test
	public void testValues_6() {

		double ion = 56.023595f;
		ICombinedMassSpectrum massSpectrum = combinedHighResMassSpectrumCalculator.createMassSpectrum(CalculationType.SUM);
		assertEquals(2323.0f, massSpectrum.getIon(ion).getAbundance(), 0);
	}
}
