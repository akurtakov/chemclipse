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

import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;

import junit.framework.TestCase;

public class ExtractedIonSignals_3_Test extends TestCase {

	private IExtractedIonSignals extractedIonSignals;
	private IChromatogramMSD chromatogram;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = new ChromatogramMSD();
	}

	@Override
	protected void tearDown() throws Exception {

		extractedIonSignals = null;
		chromatogram = null;
		super.tearDown();
	}

	public void testConstructor_1() {

		extractedIonSignals = new ExtractedIonSignals(10, chromatogram);
		assertNotNull("getChromatogram", extractedIonSignals.getChromatogram());
	}

	public void testConstructor_2() {

		extractedIonSignals = new ExtractedIonSignals(10, null);
		assertNull("getChromatogram", extractedIonSignals.getChromatogram());
	}

	public void testConstructor_3() {

		extractedIonSignals = new ExtractedIonSignals(20, 40, chromatogram);
		assertNotNull("getChromatogram", extractedIonSignals.getChromatogram());
	}

	public void testConstructor_4() {

		extractedIonSignals = new ExtractedIonSignals(20, 40, null);
		assertNull("getChromatogram", extractedIonSignals.getChromatogram());
	}
}
