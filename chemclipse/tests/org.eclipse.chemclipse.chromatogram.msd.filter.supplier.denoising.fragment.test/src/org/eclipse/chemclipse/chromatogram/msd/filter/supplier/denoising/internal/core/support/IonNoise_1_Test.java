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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IonNoise_1_Test {

	private IonNoise ionNoise;

	@BeforeAll
	public void setUp() throws Exception {

		ionNoise = new IonNoise(167, 5893.56f);
	}

	@Test
	public void testGetIon_1() {

		assertEquals(167, ionNoise.getIon(), "Ion");
	}

	@Test
	public void testGetAbundance_1() {

		assertEquals(5893.56f, ionNoise.getAbundance(), 0, "Abundance");
	}
}
