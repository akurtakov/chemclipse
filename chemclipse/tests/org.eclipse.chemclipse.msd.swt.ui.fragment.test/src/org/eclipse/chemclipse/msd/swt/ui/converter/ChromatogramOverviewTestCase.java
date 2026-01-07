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
package org.eclipse.chemclipse.msd.swt.ui.converter;

import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

@Disabled
public class ChromatogramOverviewTestCase {

	private IChromatogramMSD chromatogram;

	@BeforeAll
	public void setUp() {

		chromatogram = new ChromatogramMSD();
		chromatogram.setScanDelay(5000);
		chromatogram.setScanInterval(1000);
		// Scan RT - Abundance
		// 5000 - 22000
		IScanMSD massSpectrum = new ScanMSD();
		massSpectrum.addIon(new Ion(IIon.TIC_ION, 22000));
		chromatogram.addScan(massSpectrum);
		// 6000 - 66200
		massSpectrum = new ScanMSD();
		massSpectrum.addIon(new Ion(IIon.TIC_ION, 66200));
		chromatogram.addScan(massSpectrum);
		// 7000 - 1712850
		massSpectrum = new ScanMSD();
		massSpectrum.addIon(new Ion(IIon.TIC_ION, 1712850));
		chromatogram.addScan(massSpectrum);
		// 8000 - 812450
		massSpectrum = new ScanMSD();
		massSpectrum.addIon(new Ion(IIon.TIC_ION, 812450));
		chromatogram.addScan(massSpectrum);
		chromatogram.recalculateRetentionTimes();
	}

	public IChromatogramOverview getChromatogramOverview() {

		return chromatogram;
	}
}
