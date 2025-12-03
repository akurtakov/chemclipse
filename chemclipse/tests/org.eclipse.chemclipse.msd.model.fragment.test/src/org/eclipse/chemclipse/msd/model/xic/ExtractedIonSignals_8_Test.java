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
package org.eclipse.chemclipse.msd.model.xic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.exceptions.NoExtractedIonSignalStoredException;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.RegularMassSpectrum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtractedIonSignals_8_Test {

	private IExtractedIonSignals extractedIonSignals;
	private IExtractedIonSignal extractedIonSignal;

	@BeforeEach
	public void setUp() {

		int scans = 100;
		int ionStart = 25;
		int ionStop = 30;
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
	public void testSize_1() {

		assertEquals(100, extractedIonSignals.size());
	}

	@Test
	public void testSize_2() throws NoExtractedIonSignalStoredException {

		assertEquals(100, extractedIonSignals.size());
		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(25.0f, extractedIonSignal.getAbundance(25), 0);
		extractedIonSignals.add(25, 250.0f, 1, true);
		assertEquals(100, extractedIonSignals.size());
		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(250.0f, extractedIonSignal.getAbundance(25), 0);
	}

	@Test
	public void testSize_3() throws NoExtractedIonSignalStoredException {

		assertEquals(100, extractedIonSignals.size());
		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(25.0f, extractedIonSignal.getAbundance(25), 0);
		extractedIonSignals.add(25, 250, 1, false);
		assertEquals(100, extractedIonSignals.size());
		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(275.0f, extractedIonSignal.getAbundance(25), 0);
	}

	@Test
	public void testSize_4() throws NoExtractedIonSignalStoredException {

		assertEquals(100, extractedIonSignals.size());
		extractedIonSignal = extractedIonSignals.getExtractedIonSignal(1);
		assertEquals(25.0f, extractedIonSignal.getAbundance(25), 0);
		extractedIonSignals.add(31, 600.0f, 101, false);
		assertEquals(100, extractedIonSignals.size());
		assertThrows(NoExtractedIonSignalStoredException.class, () -> {
			extractedIonSignal = extractedIonSignals.getExtractedIonSignal(101);
		});
	}
}
