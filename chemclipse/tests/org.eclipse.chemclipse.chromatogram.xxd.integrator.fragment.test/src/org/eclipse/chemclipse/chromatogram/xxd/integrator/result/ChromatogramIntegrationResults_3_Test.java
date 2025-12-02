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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramIntegrationResults_3_Test {

	private IChromatogramIntegrationResults results = new ChromatogramIntegrationResults();

	@Test
	public void testGetBackgroundArea_1() {

		assertEquals(0.0d, results.getTotalBackgroundArea(), 0);
	}

	@Test
	public void testGetChromatogramArea_1() {

		assertEquals(0.0d, results.getTotalChromatogramArea(), 0);
	}
}
