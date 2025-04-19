/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.model.matrix;

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;

import junit.framework.TestCase;

public class ExtractedMatrix_1_Test extends TestCase {

	private IRegularMassSpectrum supplierMassSpectrum;
	private IIon defaultIon;
	private IChromatogramMSD chromatogram;

	@Override
	protected void setUp() throws Exception {

		int scans = 120;
		int ionStart = 25;
		int ionStop = 30;
		/*
		 * No empty scans.
		 */
		chromatogram = new ChromatogramMSD();
		for(int scan = 1; scan <= scans; scan++) {
			supplierMassSpectrum = new VendorMassSpectrum();
			supplierMassSpectrum.setRetentionTime(scan);
			supplierMassSpectrum.setRetentionIndex(scan / 60.0f);
			for(int ion = ionStart; ion <= ionStop; ion++) {
				defaultIon = new Ion(ion, ion * scan);
				supplierMassSpectrum.addIon(defaultIon);
			}
			chromatogram.addScan(supplierMassSpectrum);
		}
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		super.tearDown();
	}

	public void testConstructor_1() {

		try {
			ChromatogramSelectionMSD selection = new ChromatogramSelectionMSD(chromatogram);
			ExtractedMatrix extracted = new ExtractedMatrix(selection);
			assertNotNull(extracted);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
