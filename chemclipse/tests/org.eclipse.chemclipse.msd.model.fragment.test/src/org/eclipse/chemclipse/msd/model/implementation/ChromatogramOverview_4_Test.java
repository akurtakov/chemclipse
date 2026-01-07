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

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the interface IChromatogramOverview with 1 scan.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramOverview_4_Test {

	private IChromatogramOverview chromatogramOverview;

	@BeforeAll
	public void setUp() {

		IChromatogramMSD chromatogram = new ChromatogramMSD();
		chromatogramOverview = chromatogram;
		// There is no mass spectrum added to the chromatogram.
		chromatogramOverview.setScanDelay(5500);
		chromatogramOverview.setScanInterval(1500);
		chromatogramOverview.recalculateRetentionTimes();
	}

	@Test
	public void testGetScanNumber_1() {

		assertEquals(0, chromatogramOverview.getScanNumber(12736));
	}

	@Test
	public void testGetScanNumber_2() {

		assertEquals(0, chromatogramOverview.getScanNumber(5501));
	}

	@Test
	public void testGetScanNumber_3() {

		assertEquals(0, chromatogramOverview.getScanNumber(5500));
	}

	@Test
	public void testGetScanNumber_4() {

		assertEquals(0, chromatogramOverview.getScanNumber(5499));
	}

	@Test
	public void testGetScanNumber_5() {

		assertEquals(0, chromatogramOverview.getScanNumber(0));
	}

	@Test
	public void testGetScanNumber_6() {

		assertEquals(0, chromatogramOverview.getScanNumber(-1));
	}
}
