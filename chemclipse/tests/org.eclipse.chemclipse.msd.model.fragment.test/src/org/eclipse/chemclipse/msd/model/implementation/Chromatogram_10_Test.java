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

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Tests the methods getMinIonAbundance() and
 * getMaxIonAbundance().
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_10_Test {

	private ChromatogramMSD chromatogram;
	private IScanMSD supplierMassSpectrum;
	private IIon ion;

	@BeforeAll
	public void setUp() {

		chromatogram = new ChromatogramMSD();
		// Scan 1
		supplierMassSpectrum = new ScanMSD();
		ion = new Ion(45.3f, 45827.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(55.8f, 457.1f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(75.2f, 827.8f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
		// Scan 2
		supplierMassSpectrum = new ScanMSD();
		ion = new Ion(45.3f, 827.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(55.8f, 45827.4f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(75.2f, 427.4f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
		// Scan 3
		supplierMassSpectrum = new ScanMSD();
		ion = new Ion(45.3f, 927.3f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(55.8f, 74627.2f);
		supplierMassSpectrum.addIon(ion);
		ion = new Ion(75.2f, 12477.3f);
		supplierMassSpectrum.addIon(ion);
		chromatogram.addScan(supplierMassSpectrum);
	}

	@Test
	public void testMinIonAbundance_1() {

		assertEquals(427.4f, chromatogram.getMinIonAbundance(), 0);
	}

	@Test
	public void testMaxIonAbundance_1() {

		assertEquals(74627.2f, chromatogram.getMaxIonAbundance(), 0);
	}
}
