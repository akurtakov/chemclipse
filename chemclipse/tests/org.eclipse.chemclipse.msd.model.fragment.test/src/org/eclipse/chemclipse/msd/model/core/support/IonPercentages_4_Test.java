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
package org.eclipse.chemclipse.msd.model.core.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IonPercentages_4_Test {

	private IScanMSD massSpectrum;
	private IIonPercentages ionPercentages;
	private Map<Integer, Float> ions;

	@BeforeAll
	public void setUp() {

		ions = new HashMap<>();
		massSpectrum = null;
		ionPercentages = new IonPercentages(massSpectrum);
	}

	@Test
	public void testMassSpectrum_1() {

		assertNull(massSpectrum);
	}

	@Test
	public void testIonPercentages_1() {

		assertEquals(0.0f, ionPercentages.getPercentage(45), 0);
	}

	@Test
	public void testIonPercentages_2() {

		List<Integer> ionList = new ArrayList<>(ions.keySet());
		assertEquals(0.0f, ionPercentages.getPercentage(ionList), 0);
	}
}
