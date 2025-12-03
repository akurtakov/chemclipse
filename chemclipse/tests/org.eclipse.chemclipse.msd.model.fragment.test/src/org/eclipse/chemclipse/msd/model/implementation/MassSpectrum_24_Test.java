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
 * Tests adjustTotalSignal(float totalSignal).
 */
@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrum_24_Test {

	private ScanMSD massSpectrum1;
	private ScanMSD massSpectrum2;
	private IScanMSD mergedMassSpectrum;
	private IIon ion;

	@BeforeAll
	public void setUp() throws CloneNotSupportedException {

		massSpectrum1 = new ScanMSD();
		ion = new Ion(45.5f, 78500.2f);
		massSpectrum1.addIon(ion);
		ion = new Ion(104.1f, 120000.4f);
		massSpectrum1.addIon(ion);
		ion = new Ion(32.6f, 890520.4f);
		massSpectrum1.addIon(ion);
		ion = new Ion(105.7f, 120000.4f);
		massSpectrum1.addIon(ion);
		ion = new Ion(28.2f, 33000.5f);
		massSpectrum1.addIon(ion);
		massSpectrum2 = new ScanMSD();
		ion = new Ion(45.5f, 78500.2f);
		massSpectrum2.addIon(ion);
		ion = new Ion(110.1f, 120000.4f);
		massSpectrum2.addIon(ion);
		ion = new Ion(24.0f, 890520.4f);
		massSpectrum2.addIon(ion);
		ion = new Ion(105.7f, 120000.4f);
		massSpectrum2.addIon(ion);
		ion = new Ion(190.0f, 33000.5f);
		massSpectrum2.addIon(ion);
		mergedMassSpectrum = massSpectrum1.makeDeepCopy();
		mergedMassSpectrum.addIons(massSpectrum2.getIons(), true);
	}

	@Test
	public void testGetTotalSignal_1() {

		assertEquals(1242021.9f, massSpectrum1.getTotalSignal(), 0);
		assertEquals(1242021.9f, massSpectrum2.getTotalSignal(), 0);
	}

	@Test
	public void testGetTotalSignal_2() {

		assertEquals(2484043.8f, mergedMassSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void testGetTotalSignal_3() {

		ion = mergedMassSpectrum.getIon(46);
		assertEquals(157000.4f, ion.getAbundance(), 0);
	}

	@Test
	public void testGetTotalSignal_4() {

		ion = mergedMassSpectrum.getIon(110);
		assertEquals(120000.4f, ion.getAbundance(), 0);
	}

	@Test
	public void testGetTotalSignal_5() {

		ion = mergedMassSpectrum.getIon(33);
		assertEquals(890520.4f, ion.getAbundance(), 0);
	}
}
