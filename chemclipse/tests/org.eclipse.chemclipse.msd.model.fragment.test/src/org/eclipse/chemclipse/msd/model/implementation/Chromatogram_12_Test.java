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

import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.xic.ITotalIonSignalExtractor;
import org.eclipse.chemclipse.msd.model.xic.TotalIonSignalExtractor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Add 100 scans and get an {@link ITotalScanSignals} object.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_12_Test {

	private ChromatogramMSD chromatogram;
	private ITotalIonSignalExtractor totalIonSignalExtractor;

	@BeforeAll
	public void setUp() {

		chromatogram = new ChromatogramMSD();
		// ------------------------------Scan 1
		for(int i = 1; i <= 1; i++) {
			IScanMSD supplierMassSpectrum = new ScanMSD();
			supplierMassSpectrum.setRetentionTime(i);
			IIon ion = new Ion(IIon.TIC_ION, i);
			supplierMassSpectrum.addIon(ion);
			chromatogram.addScan(supplierMassSpectrum);
		}
		// ------------------------------Scan 1

		totalIonSignalExtractor = new TotalIonSignalExtractor(chromatogram);
	}

	@Test
	public void testGetNumberOfScans_1() {

		assertEquals(1, chromatogram.getNumberOfScans());
	}

	@Test
	public void testGetStartRetentionTime_1() {

		assertEquals(1, chromatogram.getStartRetentionTime());
	}

	@Test
	public void testGetStopRetentionTime_1() {

		assertEquals(1, chromatogram.getStopRetentionTime());
	}

	@Test
	public void testGetTotalIonSignals_1() {

		ChromatogramSelectionMSD chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
		chromatogramSelection.setStartRetentionTime(1);
		chromatogramSelection.setStopRetentionTime(1);
		ITotalScanSignal signal;
		ITotalScanSignals signals = totalIonSignalExtractor.getTotalIonSignals(chromatogramSelection);
		assertEquals(1, signals.size());
		assertEquals(1, signals.getStartScan());
		assertEquals(1, signals.getStopScan());
		signal = signals.getTotalScanSignal(1);
		assertEquals(1, signal.getRetentionTime());
	}
}
