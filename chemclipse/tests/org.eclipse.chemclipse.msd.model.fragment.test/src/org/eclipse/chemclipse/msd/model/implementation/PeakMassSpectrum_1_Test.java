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

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IPeakMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PeakMassSpectrum_1_Test {

	private IScanMSD massSpectrum;
	private IPeakMassSpectrum peakMassSpectrum;

	@BeforeAll
	public void setUp() {

		massSpectrum = new ScanMSD();
		IIon ion = new Ion(45.5f, 64830.4f);
		massSpectrum.addIon(ion);
		ion = new Ion(78.5f, 4440.4f);
		massSpectrum.addIon(ion);
		ion = new Ion(104.5f, 6444830.4f);
		massSpectrum.addIon(ion);
		ion = new Ion(14.5f, 40.4f);
		massSpectrum.addIon(ion);
		peakMassSpectrum = new PeakMassSpectrum(massSpectrum);
	}

	@Test
	public void testGetNumberOfIons_1() {

		assertEquals(massSpectrum.getNumberOfIons(), peakMassSpectrum.getNumberOfIons());
	}

	@Test
	public void testGetTotalSignal_1() {

		assertEquals(massSpectrum.getTotalSignal(), peakMassSpectrum.getTotalSignal(), 0);
	}

	@Test
	public void testGetBasePeak_1() {

		assertEquals(massSpectrum.getBasePeak(), peakMassSpectrum.getBasePeak(), 0);
	}
}
