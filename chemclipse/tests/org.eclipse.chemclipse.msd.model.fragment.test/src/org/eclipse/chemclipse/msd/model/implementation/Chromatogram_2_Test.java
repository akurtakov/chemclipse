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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Tests the methods equals and hashCode.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class Chromatogram_2_Test {

	private ChromatogramMSD chromatogram1;
	private ChromatogramMSD chromatogram2;
	private IScanMSD supplierMassSpectrum;
	private IIon ion;

	@BeforeAll
	public void setUp() {

		chromatogram1 = new ChromatogramMSD();
		chromatogram2 = new ChromatogramMSD();
		supplierMassSpectrum = new ScanMSD();
		ion = new Ion(25.5f, 45862.3f);
		supplierMassSpectrum.addIon(ion);
		chromatogram2.addScan(supplierMassSpectrum);
	}

	@Test
	public void testEquals_1() {

		assertFalse(chromatogram1.equals(chromatogram2));
	}

	@Test
	public void testEquals_2() {

		assertFalse(chromatogram2.equals(chromatogram1));
	}

	@Test
	public void testHashCode_1() {

		assertTrue(chromatogram1.hashCode() != chromatogram2.hashCode());
	}

	@Test
	public void testHashCode_2() {

		assertTrue(chromatogram2.hashCode() != chromatogram1.hashCode());
	}
}
