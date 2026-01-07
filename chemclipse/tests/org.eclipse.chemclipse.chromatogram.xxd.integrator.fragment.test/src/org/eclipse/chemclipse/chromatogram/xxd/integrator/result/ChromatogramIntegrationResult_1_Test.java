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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.msd.model.core.AbstractIon;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramIntegrationResult_1_Test {

	private IChromatogramIntegrationResult result;
	private double backgroundArea;
	private double chromatogramArea;

	@BeforeAll
	public void setUp() {

		double ion = IIon.TIC_ION;
		backgroundArea = 10020993.34d;
		chromatogramArea = 289839830.483d;
		result = new ChromatogramIntegrationResult(ion, chromatogramArea, backgroundArea);
	}

	@Test
	public void testGetBackgroundArea_1() {

		assertEquals(backgroundArea, result.getBackgroundArea(), 0);
	}

	@Test
	public void testGetChromatogramArea_1() {

		assertEquals(chromatogramArea, result.getChromatogramArea(), 0);
	}

	@Test
	public void testGetIon_1() {

		assertEquals(AbstractIon.TIC_ION, result.getIon(), 0);
	}
}
