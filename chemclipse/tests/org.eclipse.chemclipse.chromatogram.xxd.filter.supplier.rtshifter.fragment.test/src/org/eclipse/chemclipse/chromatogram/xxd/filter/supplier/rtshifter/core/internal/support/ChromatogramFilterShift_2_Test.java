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

import static org.junit.Assert.assertEquals;

import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.exceptions.FilterException;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.settings.FilterSettingsShift;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.junit.Before;
import org.junit.Test;

public class ChromatogramFilterShift_2_Test extends ChromatogramTestCase {

	private IChromatogramMSD chromatogram;
	private IChromatogramSelectionMSD chromatogramSelection;

	@Override
	@Before
	public void setUp() {

		super.setUp();
		chromatogram = getChromatogram();
		chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
	}

	@Test
	public void testShiftForward_1() {

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
	public void testShiftForward_2() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(0, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(1500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(1500, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(10500, scan.getRetentionTime());
	}

	@Test
	public void testShiftForward_3() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(1000, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(2500, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(2500, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(11500, scan.getRetentionTime());
	}

	@Test
	public void testShiftForward_4() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(1499, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(2999, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(2999, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(11999, scan.getRetentionTime());
	}

	@Test
	public void testShiftForward_5() throws FilterException {

		FilterSettingsShift supplierFilterSettings = new FilterSettingsShift(1500, true);
		RetentionTimeShifter.shiftRetentionTimes(chromatogramSelection, supplierFilterSettings);
		assertEquals(10, chromatogram.getNumberOfScans());
		assertEquals(3000, chromatogram.getScanDelay());
		IScan scan = chromatogram.getScan(1);
		assertEquals(3000, scan.getRetentionTime());
		scan = chromatogram.getScan(10);
		assertEquals(12000, scan.getRetentionTime());
	}
}
