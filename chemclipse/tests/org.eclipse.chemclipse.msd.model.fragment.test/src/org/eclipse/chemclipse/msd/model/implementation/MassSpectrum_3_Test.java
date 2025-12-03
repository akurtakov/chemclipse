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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.Test;

public class MassSpectrum_3_Test {

	private IScanMSD massSpectrum = new ScanMSD();

	@Test
	public void testGetIons_1() {

		assertEquals(0, massSpectrum.getIons().size());
	}

	@Test
	public void testGetParentChromatogram_1() {

		assertNull(massSpectrum.getParentChromatogram());
	}

	@Test
	public void getTotalSignal_1() {

		assertEquals(0, massSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void getExtractedIonSignal_1() {

		assertEquals(0, massSpectrum.getExtractedIonSignal().getAbundance(0), 0);
	}

	@Test
	public void getExtractedIonSignal_2() {

		assertEquals(0, massSpectrum.getExtractedIonSignal(1, 50).getAbundance(1), 0);
	}

	@Test
	public void testGetBasePeak_1() {

		assertEquals(0.0d, massSpectrum.getBasePeak(), 0);
	}

	@Test
	public void testGetBasePeakAbundance_1() {

		assertEquals(0.0f, massSpectrum.getBasePeakAbundance(), 0);
	}

	@Test
	public void testGetHighestAbundance_1a() {

		assertEquals(0.0d, massSpectrum.getHighestAbundance().getIon(), 0);
	}

	@Test
	public void testGetHighestAbundance_1b() {

		assertEquals(0.0f, massSpectrum.getHighestAbundance().getAbundance(), 0);
	}

	@Test
	public void testGetHighestIon_1a() {

		assertEquals(0.0d, massSpectrum.getHighestIon().getIon(), 0);
	}

	@Test
	public void testGetHighestIon_1b() {

		assertEquals(0.0f, massSpectrum.getHighestIon().getAbundance(), 0);
	}

	@Test
	public void testGetLowestAbundance_1a() {

		assertEquals(0.0d, massSpectrum.getLowestAbundance().getIon(), 0);
	}

	@Test
	public void testGetLowestAbundance_1b() {

		assertEquals(0.0f, massSpectrum.getLowestAbundance().getAbundance(), 0);
	}

	@Test
	public void testGetLowestIon_1a() {

		assertEquals(0.0d, massSpectrum.getLowestIon().getIon(), 0);
	}

	@Test
	public void testGetLowestIon_1b() {

		assertEquals(0.0f, massSpectrum.getLowestIon().getAbundance(), 0);
	}

	@Test
	public void testGetIonBounds_1() {

		assertNull(massSpectrum.getIonBounds());
	}

	@Test
	public void testGetNumberOfIons_1() {

		assertEquals(0, massSpectrum.getNumberOfIons());
	}

	@Test
	public void testGetIon_1() {

		IIon ion;
		ion = massSpectrum.getIon(5);
		assertNull(ion);
	}

	@Test
	public void testIsDirty_1() {

		assertFalse(massSpectrum.isDirty());
	}
}
