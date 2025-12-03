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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.eclipse.chemclipse.model.signals.ITotalScanSignalExtractor;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.ExtractedIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.IExtractedIonSignals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Test the interface IChromatogram.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_3_Test {

	private ChromatogramMSD chromatogram;
	private Date date;
	private ITotalScanSignalExtractor totalIonSignalExtractor;
	private IExtractedIonSignalExtractor extractedIonSignalExtractor;

	@BeforeAll
	public void setUp() throws Exception {

		chromatogram = new ChromatogramMSD();
		date = new Date();

		totalIonSignalExtractor = new TotalScanSignalExtractor(chromatogram);
		extractedIonSignalExtractor = new ExtractedIonSignalExtractor(chromatogram);
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
	public void testGetOperator_1() {

		assertEquals("", chromatogram.getOperator());
	}

	@Test
	public void testGetFile_1() {

		assertNull(chromatogram.getFile());
	}

	@Test
	public void testGetName_1() {

		assertEquals("Chromatogram", chromatogram.getName());
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
	public void testGetNumberOfScans_1() {

		assertEquals(0, chromatogram.getNumberOfScans());
	}

	@Test
	public void testGetNumberOfScanIons_1() {

		assertEquals(0, chromatogram.getNumberOfScanIons());
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
	public void testGetMinSignal_1() {

		assertEquals(0.0f, chromatogram.getMinSignal(), 0);
	}

	@Test
	public void testGetMaxSignal_1() {

		assertEquals(0.0f, chromatogram.getMaxSignal(), 0);
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

		// Cast to int because float is not as precise as for example
		// java.lang.Math.
		assertEquals(0, (int)chromatogram.getTotalSignal());
	}

	@Test
	public void testGetExtractedIonSignals_1() {

		IExtractedIonSignals signals = extractedIonSignalExtractor.getExtractedIonSignals();
		assertEquals(0, signals.size());
	}

	@Test
	public void testGetExtractedIonSignals_2() {

		IExtractedIonSignals signals = extractedIonSignalExtractor.getExtractedIonSignals(14.2f, 105.6f);
		assertEquals(0, signals.size());
	}
}
