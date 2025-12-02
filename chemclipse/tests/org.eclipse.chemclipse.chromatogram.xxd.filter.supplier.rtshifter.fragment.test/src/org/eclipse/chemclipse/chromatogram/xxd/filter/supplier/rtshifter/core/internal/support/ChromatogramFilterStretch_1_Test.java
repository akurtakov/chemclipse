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

import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.exceptions.FilterException;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.settings.FilterSettingsStretch;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramFilterStretch_1_Test extends ChromatogramTestCase {

	private IChromatogramMSD chromatogram;
	private IChromatogramSelectionMSD chromatogramSelection;

	@Override
	@BeforeAll
	public void setUp() {

		super.setUp();
		chromatogram = getChromatogram();
		chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
	}

	@Test
	public void test_1() {

		/*
		 * PRE TESTS
		 */
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(1500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1500, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(10500, scan.getRetentionTime());
	}

	@Test
	public void test_2() throws FilterException {

		FilterSettingsStretch settings = new FilterSettingsStretch();
		settings.setScanDelay(3200);
		settings.setChromatogramLength(60000);

		RetentionTimeStretcher.stretchChromatogram(chromatogramSelection, settings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(3200, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(3200, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(59999, scan.getRetentionTime());
	}
}
