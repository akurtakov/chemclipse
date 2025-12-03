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
package org.eclipse.chemclipse.msd.model.core.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IonPercentages_1_Test {

	private IScanMSD massSpectrum;
	private IIon defaultIon;
	private IIonPercentages ionPercentages;
	private Map<Integer, Float> ions;

	@BeforeAll
	public void setUp() {

		ions = new HashMap<Integer, Float>();
		ions.put(45, 5000.0f);
		ions.put(55, 500.0f);
		ions.put(65, 250.0f);
		ions.put(75, 760.0f);
		ions.put(85, 8800.0f);
		massSpectrum = new ScanMSD();
		for(Integer ion : ions.keySet()) {
			defaultIon = new Ion(ion, ions.get(ion));
			massSpectrum.addIon(defaultIon);
		}
		ionPercentages = new IonPercentages(massSpectrum);
	}

	@Test
	public void testMassSpectrum_1() {

		assertEquals(15310.0f, massSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void testIonPercentages_1() {

		assertEquals(32.658394f, ionPercentages.getPercentage(45), 0);
	}

	@Test
	public void testIonPercentages_2() {

		assertEquals(3.2658393f, ionPercentages.getPercentage(55), 0);
	}

	@Test
	public void testIonPercentages_3() {

		assertEquals(1.6329197f, ionPercentages.getPercentage(65), 0);
	}

	@Test
	public void testIonPercentages_4() {

		assertEquals(4.9640756f, ionPercentages.getPercentage(75), 0);
	}

	@Test
	public void testIonPercentages_5() {

		assertEquals(57.47877f, ionPercentages.getPercentage(85), 0);
	}

	@Test
	public void testIonPercentages_6() {

		List<Integer> ionList = new ArrayList<Integer>(ions.keySet());
		assertEquals(100.0f, ionPercentages.getPercentage(ionList), 0);
	}

	@Test
	public void testIonPercentages_7() {

		assertEquals(0.0f, ionPercentages.getPercentage(95), 0);
	}
}
