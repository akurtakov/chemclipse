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
package org.eclipse.chemclipse.msd.model.core.selection;

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;

import junit.framework.TestCase;

public class ChromatogramSelection_9_Test extends TestCase {

	private IChromatogramMSD chromatogram;
	private IChromatogramSelectionMSD selection;
	private IRegularMassSpectrum massSpectrum;
	private IIon ion;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = new ChromatogramMSD();
		chromatogram.setScanDelay(500);
		chromatogram.setScanInterval(1000);
		for(int scan = 1; scan <= 10; scan++) {
			massSpectrum = new VendorMassSpectrum();
			ion = new Ion(IIon.TIC_ION, 45528.3f);
			massSpectrum.addIon(ion);
			chromatogram.addScan(massSpectrum);
		}
		chromatogram.recalculateRetentionTimes();
		/*
		 * Default values from IChromatogram will be chosen.
		 */
		selection = new ChromatogramSelectionMSD(chromatogram);
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		selection = null;
		massSpectrum = null;
		ion = null;
		super.tearDown();
	}

	public void testGetSelectedScan_1() {

		IRegularMassSpectrum selectedScan = selection.getSelectedScan();
		assertNotNull(selectedScan);
		assertEquals("RetentionTime", 500, selectedScan.getRetentionTime());
	}
}
