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

public class CombinedNominalMassSpectrumCalculator_5_Test {

	private CombinedNominalMassSpectrumCalculator combinedNominalMassSpectrumCalculator = new CombinedNominalMassSpectrumCalculator();

	@Test
	public void testValues_1() {

		combinedNominalMassSpectrumCalculator.addIon(56.0f, 5200.0f);
		combinedNominalMassSpectrumCalculator.addIon(56.0f, 6800.0f);
		assertEquals(5200.0, combinedNominalMassSpectrumCalculator.getValues().get(56).get(0), 0);
		assertEquals(6800.0, combinedNominalMassSpectrumCalculator.getValues().get(56).get(1), 0);
	}
}
