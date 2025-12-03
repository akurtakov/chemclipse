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
package org.eclipse.chemclipse.msd.model.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.signals.ITotalScanSignalExtractor;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the interface IChromatogramOverview.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramOverview_1_Test {

	private ChromatogramMSD chrom;
	private IChromatogramOverview chromatogram;
	private Date date;
	private ITotalScanSignalExtractor totalIonSignalExtractor;

	@BeforeAll
	public void setUp() {

		chrom = new ChromatogramMSD();
		date = new Date();
		chromatogram = chrom;

		totalIonSignalExtractor = new TotalScanSignalExtractor(chrom);
	}

	@Test
	public void testGetMinSignal_1() {

		assertEquals(0, chromatogram.getMinSignal(), 0);
	}

	@Test
	public void testGetMaxSignal_1() {

		assertEquals(0, chromatogram.getMaxSignal(), 0);
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(0, chromatogram.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(0, chromatogram.getStopRetentionTime());
	}

	@Test
	public void testGetScanDelay_1() {

		assertEquals(4500, chromatogram.getScanDelay());
	}

	@Test
	public void testGetScanInterval_1() {

		assertEquals(1000, chromatogram.getScanInterval());
	}

	@Test
	public void testGetNumberOfScans_1() {

		assertEquals(0, chromatogram.getNumberOfScans());
	}

	@Test
	public void testGetName_1() {

		assertEquals("Chromatogram", chromatogram.getName());
	}

	@Test
	public void testGetFile_1() {

		assertEquals(null, chromatogram.getFile());
	}

	@Test
	public void testGetOperator_1() {

		assertEquals("", chromatogram.getOperator());
	}

	@Test
	public void testGetDate_1() {

		assertTrue(chromatogram.getDate() != null);
	}

	@Test
	public void testGetDate_2() {

		chromatogram.setDate(date);
		assertEquals(date.toString(), chromatogram.getDate().toString());
	}

	@Test
	public void testGetMiscInfo_1() {

		assertEquals("", chromatogram.getMiscInfo());
	}

	@Test
	public void testGetTotalIonSignals_1() {

		ITotalScanSignals signals = totalIonSignalExtractor.getTotalScanSignals();
		assertEquals(0, signals.size());
	}

	@Test
	public void testGetTotalIonSignal_1() {

		assertEquals(0, chromatogram.getTotalSignal(), 0);
	}
}
