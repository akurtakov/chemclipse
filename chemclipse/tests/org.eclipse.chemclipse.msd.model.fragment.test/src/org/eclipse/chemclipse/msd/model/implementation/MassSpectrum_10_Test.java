/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IIonBounds;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MassSpectrum_10_Test {

	private IScanMSD massSpectrum;

	@BeforeAll
	public void setUp() {

		massSpectrum = new ScanMSD();
		IIon ion = new Ion(45.5f, 78500.2f);
		massSpectrum.addIon(ion);
		ion = new Ion(85.4f, 3000.5f);
		massSpectrum.addIon(ion);
		ion = new Ion(104.1f, 120000.4f);
		massSpectrum.addIon(ion);
		ion = new Ion(32.6f, 890520.4f);
		massSpectrum.addIon(ion);
		ion = new Ion(105.7f, 120000.4f);
		massSpectrum.addIon(ion);
		ion = new Ion(28.2f, 33000.5f);
		massSpectrum.addIon(ion);
		ion = new Ion(85.4f, 3000.5f);
		massSpectrum.removeIon(ion);
	}

	@Test
	public void testGetIons_1() {

		assertEquals(5, massSpectrum.getIons().size());
	}

	@Test
	public void testGetTotalSignal_1() {

		assertEquals(1242021.9f, massSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void testGetExtractedIonSignal_1() {

		assertEquals(0.0f, massSpectrum.getExtractedIonSignal().getAbundance(0), 0);
	}

	@Test
	public void testGetExtractedIonSignal_2() {

		assertEquals(120000.4f, massSpectrum.getExtractedIonSignal(25, 120).getAbundance(104), 0);
	}

	@Test
	public void testGetExtractedIonSignal_3() {

		assertEquals(890520.4f, massSpectrum.getExtractedIonSignal(25, 120).getAbundance(33), 0);
	}

	@Test
	public void testGetExtractedIonSignal_4() {

		assertEquals(120000.4f, massSpectrum.getExtractedIonSignal(25, 120).getAbundance(106), 0);
	}

	@Test
	public void testGetBasePeak_1() {

		assertEquals(32.599998474121094d, massSpectrum.getBasePeak(), 0);
	}

	@Test
	public void testGetBasePeakAbundance_1() {

		assertEquals(890520.4f, massSpectrum.getBasePeakAbundance(), 0);
	}

	@Test
	public void testGetHighestAbundance_1() {

		assertEquals(890520.4f, massSpectrum.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testGetHighestAbundance_2() {

		assertEquals(32.599998474121094d, massSpectrum.getHighestAbundance().getIon(), 0);
	}

	@Test
	public void testGetHighestIon_1() {

		assertEquals(120000.4f, massSpectrum.getHighestIon().getAbundance(), 0);
	}

	@Test
	public void testGetHighestIon_2() {

		assertEquals(105.69999694824219d, massSpectrum.getHighestIon().getIon(), 0);
	}

	@Test
	public void testGetLowestAbundance_1() {

		assertEquals(33000.5f, massSpectrum.getLowestAbundance().getAbundance(), 0);
	}

	@Test
	public void testGetLowestAbundance_2() {

		assertEquals(28.200000762939453d, massSpectrum.getLowestAbundance().getIon(), 0);
	}

	@Test
	public void testGetLowestIon_1() {

		assertEquals(33000.5f, massSpectrum.getLowestIon().getAbundance(), 0);
	}

	@Test
	public void testGetLowestIon_2() {

		assertEquals(28.200000762939453d, massSpectrum.getLowestIon().getIon(), 0);
	}

	@Test
	public void testGetIonBounds_1() {

		IIonBounds bounds = massSpectrum.getIonBounds();
		assertEquals(33000.5f, bounds.getLowestIon().getAbundance(), 0);
		assertEquals(28.200000762939453d, bounds.getLowestIon().getIon(), 0);
		assertEquals(120000.4f, bounds.getHighestIon().getAbundance(), 0);
		assertEquals(105.69999694824219d, bounds.getHighestIon().getIon(), 0);
	}

	@Test
	public void testGetNumberOfIons_1() {

		assertEquals(5, massSpectrum.getNumberOfIons());
	}

	@Test
	public void testGetIon_1() {

		IIon ion;
		ion = massSpectrum.getIon(5);
		assertNull(ion);
		ion = massSpectrum.getIon(46);
		assertNotNull(ion);
		assertEquals(78500.2f, ion.getAbundance(), 0);
		assertEquals(46.0d, ion.getIon(), 0);
	}

	@Test
	public void testIsDirty_1() {

		assertTrue(massSpectrum.isDirty());
	}
}
