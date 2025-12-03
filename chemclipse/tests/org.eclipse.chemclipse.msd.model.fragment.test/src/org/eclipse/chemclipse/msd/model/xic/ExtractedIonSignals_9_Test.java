/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.exceptions.NoExtractedIonSignalStoredException;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.RegularMassSpectrum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtractedIonSignals_9_Test {

	private IExtractedIonSignals extractedIonSignals;
	private IExtractedIonSignal extractedIonSignal;

	@BeforeEach
	public void setUp() {

		int scans = 1;
		int ionStart = 25;
		int ionStop = 50;
		IChromatogramMSD chromatogram = new ChromatogramMSD();
		/*
		 * Add 100 scans with scans of 6 ions.
		 */
		for(int scan = 1; scan <= scans; scan++) {
			IRegularMassSpectrum supplierMassSpectrum = new RegularMassSpectrum();
			supplierMassSpectrum.setRetentionTime(scan);
			supplierMassSpectrum.setRetentionIndex(scan / 60.0f);
			for(int ion = ionStart; ion <= ionStop; ion++) {
				IIon defaultIon = new Ion(ion, ion * scan);
				supplierMassSpectrum.addIon(defaultIon);
			}
			chromatogram.addScan(supplierMassSpectrum);
		}
		IExtractedIonSignalExtractor extractedIonSignalExtractor = new ExtractedIonSignalExtractor(chromatogram);
		extractedIonSignals = extractedIonSignalExtractor.getExtractedIonSignals();
	}

	@Test
	public void test_1() {

		assertEquals(1, extractedIonSignals.size());
	}

	@Test
	public void test_2() throws NoExtractedIonSignalStoredException {

		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(50.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(975.0f, extractedIonSignal.getTotalSignal(), 0);
		extractedIonSignal.normalizeIntensity(100.0f);
		assertEquals(100.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(1950.0f, extractedIonSignal.getTotalSignal(), 0);
	}

	@Test
	public void test_3() throws NoExtractedIonSignalStoredException {

		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(50.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(975.0f, extractedIonSignal.getTotalSignal(), 0);
		extractedIonSignal.normalizeIntensity(0.0f);
		assertEquals(50.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(975.0f, extractedIonSignal.getTotalSignal(), 0);
	}

	@Test
	public void test_4() throws NoExtractedIonSignalStoredException {

		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(50.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(975.0f, extractedIonSignal.getTotalSignal(), 0);
		extractedIonSignal.normalizeIntensity(1.0f);
		assertEquals(1.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(19.5f, extractedIonSignal.getTotalSignal(), 0.1f);
	}

	@Test
	public void test_5() throws NoExtractedIonSignalStoredException {

		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(50.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(975.0f, extractedIonSignal.getTotalSignal(), 0);
		extractedIonSignal.normalizeIntensity();
		assertEquals(1000.0f, extractedIonSignal.getMaxIntensity(), 0);
		assertEquals(19500.0f, extractedIonSignal.getTotalSignal(), 0);
	}
}
