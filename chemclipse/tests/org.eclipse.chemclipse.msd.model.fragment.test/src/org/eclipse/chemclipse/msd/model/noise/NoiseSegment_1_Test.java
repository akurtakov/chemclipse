/*******************************************************************************
 * Copyright (c) 2010, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.noise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.eclipse.chemclipse.model.support.AnalysisSegment;
import org.eclipse.chemclipse.model.support.IAnalysisSegment;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.CombinedMassSpectrum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class NoiseSegment_1_Test {

	private INoiseSegmentMSD noiseSegment;

	@BeforeAll
	public void setUp() {

		IAnalysisSegment analysisSegment = new AnalysisSegment(20, 200) {

			@Override
			public int getStartRetentionTime() {

				return 0;
			}

			@Override
			public int getStopRetentionTime() {

				return 0;
			}
		};
		ICombinedMassSpectrum noiseMassSpectrum = new CombinedMassSpectrum();
		noiseSegment = new NoiseSegmentMSD(analysisSegment, noiseMassSpectrum);
	}

	@Test
	public void testGetAnalysisSegment_1() {

		assertNotNull(noiseSegment.getAnalysisSegment());
	}

	@Test
	public void testGetAnalysisSegment_2() {

		assertEquals(200, noiseSegment.getAnalysisSegment().getWidth());
	}

	@Test
	public void testGetNoiseMassSpectrum_1() {

		assertNotNull(noiseSegment.getNoiseMassSpectrum());
	}
}
