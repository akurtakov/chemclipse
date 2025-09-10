/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.internal.core.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.support.comparator.SortOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IonNoise_2_Test {

	private IonNoise ionNoise1;
	private IonNoise ionNoise2;
	private IonNoise ionNoise3;

	private IonNoiseAbundanceComparator ionNoiseAbundanceComparator = new IonNoiseAbundanceComparator(SortOrder.DESC);

	@BeforeAll
	public void setUp() {

		ionNoise1 = new IonNoise(120, 3889.56f);
		ionNoise2 = new IonNoise(167, 5893.56f);
		ionNoise3 = new IonNoise(140, 28793809.56f);
	}

	@Test
	public void testCompareTo_1() {

		assertEquals(0, ionNoiseAbundanceComparator.compare(ionNoise1, ionNoise1));
	}

	@Test
	public void testCompareTo_2() {

		assertTrue(1 <= ionNoiseAbundanceComparator.compare(ionNoise1, ionNoise2));
	}

	@Test
	public void testCompareTo_3() {

		assertTrue(-1 >= ionNoiseAbundanceComparator.compare(ionNoise2, ionNoise1));
	}

	@Test
	public void testCompareTo_4() {

		assertTrue(-1 >= ionNoiseAbundanceComparator.compare(ionNoise3, ionNoise2));
	}

	@Test
	public void testCompareTo_5() {

		assertTrue(-1 >= ionNoiseAbundanceComparator.compare(ionNoise3, ionNoise1));
	}
}
