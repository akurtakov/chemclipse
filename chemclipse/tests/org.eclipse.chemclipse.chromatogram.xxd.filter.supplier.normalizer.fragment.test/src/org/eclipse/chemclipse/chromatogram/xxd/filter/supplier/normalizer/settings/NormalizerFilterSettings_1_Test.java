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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.normalizer.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NormalizerFilterSettings_1_Test {

	private FilterSettings normalizerFilterSettings = new FilterSettings();

	@Test
	public void testGetNormalizationBase_1() {

		assertEquals(1000.0f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_2() {

		normalizerFilterSettings.setNormalizationBase(5.7f);
		assertEquals(5.7f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_3() {

		normalizerFilterSettings.setNormalizationBase(129234.2f);
		assertEquals(129234.2f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_4() {

		normalizerFilterSettings.setNormalizationBase(0.0f);
		assertEquals(1000.0f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_5() {

		normalizerFilterSettings.setNormalizationBase(-1.0f);
		assertEquals(1000.0f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_6() {

		normalizerFilterSettings.setNormalizationBase(Float.NaN);
		assertEquals(1000.0f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_7() {

		normalizerFilterSettings.setNormalizationBase(Float.POSITIVE_INFINITY);
		assertEquals(1000.0f, normalizerFilterSettings.getNormalizationBase(), 0);
	}

	@Test
	public void testGetNormalizationBase_8() {

		normalizerFilterSettings.setNormalizationBase(Float.NEGATIVE_INFINITY);
		assertEquals(1000.0f, normalizerFilterSettings.getNormalizationBase(), 0);
	}
}
