/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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

import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.chemclipse.model.core.IPeakIntensityValues;
import org.eclipse.chemclipse.model.implementation.PeakIntensityValues;
import org.eclipse.chemclipse.msd.model.core.IPeakIon;
import org.eclipse.chemclipse.msd.model.core.IPeakMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IPeakModelMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakModel_10_Test {

	private IPeakModelMSD peakModel;
	private float startBackgroundAbundance = 100.0f;
	private float stopBackgroundAbundance = 100.0f;

	@BeforeAll
	public void setUp() {

		// ----------------------PeakMaximum
		IPeakMassSpectrum peakMaximum = new PeakMassSpectrum();
		TreeMap<Float, Float> fragmentValues = new TreeMap<>();
		fragmentValues.put(104.0f, 230000.0f);
		fragmentValues.put(103.0f, 58000.0f);
		fragmentValues.put(51.0f, 26000.0f);
		fragmentValues.put(50.0f, 48000.0f);
		fragmentValues.put(78.0f, 23600.0f);
		fragmentValues.put(77.0f, 2500.0f);
		fragmentValues.put(74.0f, 38000.0f);
		fragmentValues.put(105.0f, 97000.0f);
		for(Entry<Float, Float> entry : fragmentValues.entrySet()) {
			IPeakIon ion = new PeakIon(entry.getKey(), entry.getValue());
			peakMaximum.addIon(ion);
		}
		// ----------------------PeakMaximum
		// ----------------------IntensityValues
		IPeakIntensityValues intensityValues = new PeakIntensityValues();
		TreeMap<Integer, Float> scanValues = new TreeMap<>();
		scanValues.put(4500, 0.0f);
		scanValues.put(5500, 20.0f);
		scanValues.put(6500, 40.0f);
		scanValues.put(7500, 60.0f);
		scanValues.put(8500, 80.0f);
		scanValues.put(9500, 100.0f);
		scanValues.put(10500, 20.0f);
		scanValues.put(11500, 0.0f);
		for(Entry<Integer, Float> entry : scanValues.entrySet()) {
			intensityValues.addIntensityValue(entry.getKey(), entry.getValue());
		}
		// ----------------------IntensityValues
		peakModel = new PeakModelMSD(peakMaximum, intensityValues, startBackgroundAbundance, stopBackgroundAbundance);
		peakModel.setStrictModel(true);
	}

	@Test
	public void testTailing_1() {

		assertEquals(0.25f, peakModel.getTailing(), 0);
	}
}
