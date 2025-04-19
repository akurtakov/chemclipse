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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.result;

import org.eclipse.chemclipse.msd.model.core.AbstractIon;

import junit.framework.TestCase;

public class ChromatogramIntegrationResult_1_Test extends TestCase {

	private IChromatogramIntegrationResult result;
	private double ion;
	private double backgroundArea;
	private double chromatogramArea;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		ion = AbstractIon.TIC_ION;
		backgroundArea = 10020993.34d;
		chromatogramArea = 289839830.483d;
		result = new ChromatogramIntegrationResult(ion, chromatogramArea, backgroundArea);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testGetBackgroundArea_1() {

		assertEquals("BackgroundArea", backgroundArea, result.getBackgroundArea());
	}

	public void testGetChromatogramArea_1() {

		assertEquals("ChromatogramArea", chromatogramArea, result.getChromatogramArea());
	}

	public void testGetIon_1() {

		assertEquals("Ion", AbstractIon.TIC_ION, result.getIon());
	}
}
