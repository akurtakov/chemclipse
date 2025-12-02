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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.core.internal.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.settings.FilterSettingsGapFiller;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramFilterGapFilller_1_Test extends ChromatogramTestCase {

	private IChromatogramMSD chromatogram;
	private IChromatogramSelectionMSD chromatogramSelection;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		chromatogram = getChromatogram();
		chromatogram.removeScans(2, 9);
		chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
	}

	@Test
	public void test_1() {

		/*
		 * PRE TESTS
		 */
		assertEquals(2, chromatogram.getNumberOfScans());
		assertEquals(1500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1500, scan.getRetentionTime());
		scan = chromatogram.getScan(2);
		assertEquals(10500, scan.getRetentionTime());
	}

	@Test
	public void test_2() {

		FilterSettingsGapFiller settings = new FilterSettingsGapFiller();
		settings.setLimitFactor(4);

		GapFiller.autofillScans(chromatogramSelection, settings);
		assertEquals(1003, chromatogram.getNumberOfScans());
		assertEquals(1500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1500, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(2556, scan.getRetentionTime());
		scan = chromatogram.getScan(1003);
		assertEquals(10500, scan.getRetentionTime());
	}
}
