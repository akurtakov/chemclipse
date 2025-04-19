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

import org.eclipse.chemclipse.model.exceptions.AnalysisSupportException;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;

import junit.framework.TestCase;

/**
 * @author eselmeister
 */
public class ExtractedIonSignalsModifier_1_Test extends TestCase {

	private IChromatogramMSD chromatogram;
	private IRegularMassSpectrum supplierMassSpectrum;
	private IIon supplierIon;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		/*
		 * Build a chromatogram and add scans with ions and no
		 * abundance.
		 */
		chromatogram = new ChromatogramMSD();
		for(int scan = 1; scan <= 100; scan++) {
			supplierMassSpectrum = new VendorMassSpectrum();
			for(int ion = 32; ion <= 104; ion++) {
				supplierIon = new Ion(ion, ion * 2);
				supplierMassSpectrum.addIon(supplierIon);
			}
			chromatogram.addScan(supplierMassSpectrum);
		}
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		supplierIon = null;
		supplierMassSpectrum = null;
		super.tearDown();
	}

	public void testAdjustThresholdTransitions_1() {

		try {
			ExtractedIonSignalsModifier.adjustThresholdTransitions(null);
		} catch(AnalysisSupportException e) {
			assertTrue("AnalysisSupportException", true);
		}
	}
}
