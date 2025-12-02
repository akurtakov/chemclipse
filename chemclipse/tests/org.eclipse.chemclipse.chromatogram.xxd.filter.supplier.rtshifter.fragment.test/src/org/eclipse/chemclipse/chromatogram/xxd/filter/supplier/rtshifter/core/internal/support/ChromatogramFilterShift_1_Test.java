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
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.settings.FilterSettingsShift;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChromatogramFilterShift_1_Test extends ChromatogramTestCase {

	private IChromatogramMSD chromatogram;
	private IChromatogramSelectionMSD chromatogramSelection;

	@Override
	@BeforeEach
	public void setUp() {

		super.setUp();
		chromatogram = getChromatogram();
		chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
	}

	@Test
	public void testShiftBackward_1() {

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
	public void testShiftBackward_2() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(-0, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(1500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1500, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(10500, scan.getRetentionTime());
	}

	@Test
	public void testShiftBackward_3() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(-1000, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(500, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(9500, scan.getRetentionTime());
	}

	@Test
	public void testShiftBackward_4() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(-1499, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(1, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(9001, scan.getRetentionTime());
	}

	@Test
	public void testShiftBackward_5() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(-1500, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(9, chromatogram.getNumberOfScans());
		assertEquals(1000, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1000, scan.getRetentionTime());
		scan = chromatogram.getScan(9);
		assertEquals(9000, scan.getRetentionTime());
	}

	@Test
	public void testShiftBackward_6() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(-2000, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(9, chromatogram.getNumberOfScans());
		assertEquals(500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(500, scan.getRetentionTime());
		scan = chromatogram.getScan(9);
		assertEquals(8500, scan.getRetentionTime());
	}
}
