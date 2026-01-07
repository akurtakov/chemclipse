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
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class PeakModel_1_Test {

	private IPeakModelMSD peakModel;
	private IPeakMassSpectrum peakMaximum;
	private IPeakIon ion;
	private TreeMap<Float, Float> fragmentValues;
	private IPeakIntensityValues intensityValues;
	private TreeMap<Integer, Float> scanValues;
	private float startBackgroundAbundance = 0.0f;
	private float stopBackgroundAbundance = 0.0f;

	@BeforeAll
	public void setUp() {

		// ----------------------PeakMaximum
		peakMaximum = new PeakMassSpectrum();
		fragmentValues = new TreeMap<>();
		fragmentValues.put(104.0f, 2300.0f);
		fragmentValues.put(103.0f, 580.0f);
		fragmentValues.put(51.0f, 260.0f);
		fragmentValues.put(50.0f, 480.0f);
		fragmentValues.put(78.0f, 236.0f);
		fragmentValues.put(77.0f, 25.0f);
		fragmentValues.put(74.0f, 380.0f);
		fragmentValues.put(105.0f, 970.0f);
		for(Entry<Float, Float> entry : fragmentValues.entrySet()) {
			ion = new PeakIon(entry.getKey(), entry.getValue());
			peakMaximum.addIon(ion);
		}
		// ----------------------PeakMaximum
		// ----------------------IntensityValues
		intensityValues = new PeakIntensityValues();
		scanValues = new TreeMap<>();
		scanValues.put(1500, 0.0f);
		scanValues.put(2500, 5.0f);
		scanValues.put(3500, 10.0f);
		scanValues.put(4500, 15.0f);
		scanValues.put(5500, 20.0f);
		scanValues.put(6500, 30.0f);
		scanValues.put(7500, 46.0f);
		scanValues.put(8500, 82.0f);
		scanValues.put(9500, 100.0f);
		scanValues.put(10500, 86.0f);
		scanValues.put(11500, 64.0f);
		scanValues.put(12500, 43.0f);
		scanValues.put(13500, 30.0f);
		scanValues.put(14500, 15.0f);
		scanValues.put(15500, 4.0f);
		for(Entry<Integer, Float> entry : scanValues.entrySet()) {
			intensityValues.addIntensityValue(entry.getKey(), entry.getValue());
		}
		// ----------------------IntensityValues
		// ----------------------BackgroundValues
		startBackgroundAbundance = 360.0f;
		stopBackgroundAbundance = 420.5f;
		// ----------------------BackgroundValues
		peakModel = new PeakModelMSD(peakMaximum, intensityValues, startBackgroundAbundance, stopBackgroundAbundance);
	}

	@Test
	public void testGetBackgroundAbundance_1() {

		assertEquals(394.57144f, peakModel.getBackgroundAbundance(), 0);
	}

	@Test
	public void testGetBackgroundAbundance_2() {

		assertEquals(374.05762f, peakModel.getBackgroundAbundance(4753), 0);
	}

	@Test
	public void testGetBackgroundAbundance_3() {

		assertEquals(407.89438f, peakModel.getBackgroundAbundance(12583), 0);
	}

	@Test
	public void testGetBackgroundAbundance_4() {

		assertEquals(420.28394f, peakModel.getBackgroundAbundance(15450), 0);
	}

	@Test
	public void testGetBackgroundAbundance_5() {

		assertEquals(360.0f, peakModel.getBackgroundAbundance(1500), 0);
	}

	@Test
	public void testGetBackgroundAbundance_6() {

		assertEquals(420.5f, peakModel.getBackgroundAbundance(15500), 0);
	}

	@Test
	public void testGetBackgroundAbundance_7() {

		assertEquals(365.61786f, peakModel.getBackgroundAbundance(2800), 0);
	}

	@Test
	public void testGetPeakAbundance_1() {

		assertEquals(5231.0f, peakModel.getPeakAbundance(), 0);
	}

	@Test
	public void testGetPeakAbundance_2() {

		assertEquals(5231.0f, peakModel.getPeakAbundance(9500), 0);
	}

	@Test
	public void testGetPeakAbundance_3() {

		assertEquals(3347.84f, peakModel.getPeakAbundance(11500), 0);
	}

	@Test
	public void testGetPeakAbundance_4() {

		assertEquals(209.24f, peakModel.getPeakAbundance(15500), 0);
	}

	@Test
	public void testGetPeakAbundance_5() {

		assertEquals(0.0f, peakModel.getPeakAbundance(1500), 0);
	}

	@Test
	public void testGetPeakAbundance_6() {

		assertEquals(2249.33f, peakModel.getPeakAbundance(12500), 0);
	}

	@Test
	public void testGetPeakAbundance_7() {

		assertEquals(5231.0f, peakModel.getPeakAbundance(10000), 0);
	}

	@Test
	public void testGetPeakAbundance_8() {

		assertEquals(261.55f, peakModel.getPeakAbundance(3000), 0);
	}

	@Test
	public void testGetPeakAbundance_9() {

		assertEquals(1569.3f, peakModel.getPeakAbundance(14000), 0);
	}

	@Test
	public void testGetPeakAbundance_10() {

		assertEquals(0.0f, peakModel.getPeakAbundance(15501), 0);
	}

	@Test
	public void testGetPeakAbundance_11() {

		assertEquals(0.0f, peakModel.getPeakAbundance(1499), 0);
	}

	@Test
	public void testGetPeakMassSpectrum_1() {

		assertNotNull(peakModel.getPeakMassSpectrum());
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(1500, peakModel.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(15500, peakModel.getStopRetentionTime());
	}

	@Test
	public void testGetWidthBaselineTotal_1() {

		assertEquals(14001, peakModel.getWidthBaselineTotal());
	}

	@Test
	public void testGetRetentionTimeAtPeakMaximum_1() {

		assertEquals(9500, peakModel.getRetentionTimeAtPeakMaximum());
	}

	@Test
	public void testGetPeakMassSpectrum_2() {

		IPeakMassSpectrum massSpectrum = peakModel.getPeakMassSpectrum();
		assertEquals(9500, massSpectrum.getRetentionTime());
	}
}
