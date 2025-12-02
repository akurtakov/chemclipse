/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramIntegrationResults_2_Test {

	private IChromatogramIntegrationResults results;
	private IChromatogramIntegrationResult result;
	private float ion;
	private double backgroundArea;
	private double chromatogramArea;

	@BeforeAll
	public void setUp() {

		results = new ChromatogramIntegrationResults();
		ion = 18.1f;
		backgroundArea = 7823090.9d;
		chromatogramArea = 23938.54d;
		result = new ChromatogramIntegrationResult(ion, chromatogramArea, backgroundArea);
		results.add(result);
	}

	@Test
	public void testGetBackgroundArea_1() {

		assertEquals(7823090.9d, results.getTotalBackgroundArea(), 0);
	}

	@Test
	public void testGetChromatogramArea_1() {

		assertEquals(23938.54d, result.getChromatogramArea(), 0);
	}
}
