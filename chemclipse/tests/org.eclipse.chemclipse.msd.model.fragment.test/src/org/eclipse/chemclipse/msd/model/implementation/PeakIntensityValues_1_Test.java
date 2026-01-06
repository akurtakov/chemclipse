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
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.chemclipse.model.implementation.PeakIntensityValues;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the peak intensity values.<br/>
 * Make sure that the limit IPeakIntensityValues.MAX_INTENSITY is implemented
 * correctly.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class PeakIntensityValues_1_Test {

	private PeakIntensityValues intensityValues;
	private TreeMap<Integer, Float> scanValues;

	@BeforeAll
	public void setUp() {

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
	}

	@Test
	public void testGetHighestIntensityValue_1() {

		Entry<Integer, Float> entry = intensityValues.getHighestIntensityValue();
		assertNotNull(entry);
		int retentionTime = entry.getKey();
		float intensity = entry.getValue();
		assertEquals(9500, retentionTime);
		assertEquals(100.0f, intensity, 0);
	}

	@Test
	public void testGetIntensityValue_1() {

		Entry<Integer, Float> entry = intensityValues.getIntensityValue(9500);
		assertNotNull(entry);
		int retentionTime = entry.getKey();
		float intensity = entry.getValue();
		assertEquals(9500, retentionTime);
		assertEquals(100.0f, intensity, 0);
	}

	@Test
	public void testGetIntensityValue_2() {

		Entry<Integer, Float> entry = intensityValues.getIntensityValue(2200);
		assertNotNull(entry);
		int retentionTime = entry.getKey();
		float intensity = entry.getValue();
		assertEquals(1500, retentionTime);
		assertEquals(0.0f, intensity, 0);
	}

	@Test
	public void testGetIntensityValue_3() {

		Entry<Integer, Float> entry = intensityValues.getIntensityValue(1200);
		assertNull(entry);
	}

	@Test
	public void testGetIntensityValue_4() {

		Entry<Integer, Float> entry = intensityValues.getIntensityValue(11700);
		assertNotNull(entry);
		int retentionTime = entry.getKey();
		float intensity = entry.getValue();
		assertEquals(11500, retentionTime);
		assertEquals(64.0f, intensity, 0);
	}

	@Test
	public void testGetIntensityValue_5() {

		Entry<Integer, Float> entry = intensityValues.getIntensityValue(15500);
		assertNotNull(entry);
		int retentionTime = entry.getKey();
		float intensity = entry.getValue();
		assertEquals(15500, retentionTime);
		assertEquals(4.0f, intensity, 0);
	}

	@Test
	public void testGetIntensityValue_6() {

		Entry<Integer, Float> entry = intensityValues.getIntensityValue(15600);
		assertNull(entry);
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(1500, intensityValues.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(15500, intensityValues.getStopRetentionTime());
	}
}
