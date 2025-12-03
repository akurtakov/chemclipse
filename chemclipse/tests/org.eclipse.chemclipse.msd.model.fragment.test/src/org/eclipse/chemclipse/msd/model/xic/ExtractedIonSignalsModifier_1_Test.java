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

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.chemclipse.model.exceptions.AnalysisSupportException;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ExtractedIonSignalsModifier_1_Test {

	private IChromatogramMSD chromatogram;
	private IScanMSD supplierMassSpectrum;
	private IIon supplierIon;

	@BeforeAll
	public void setUp() {

		/*
		 * Build a chromatogram and add scans with ions and no
		 * abundance.
		 */
		chromatogram = new ChromatogramMSD();
		for(int scan = 1; scan <= 100; scan++) {
			supplierMassSpectrum = new ScanMSD();
			for(int ion = 32; ion <= 104; ion++) {
				supplierIon = new Ion(ion, ion * 2);
				supplierMassSpectrum.addIon(supplierIon);
			}
			chromatogram.addScan(supplierMassSpectrum);
		}
	}

	@Test
	public void testAdjustThresholdTransitions_1() {

		assertThrows(AnalysisSupportException.class, () -> {
			ExtractedIonSignalsModifier.adjustThresholdTransitions(null);
		});
	}
}
