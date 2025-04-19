/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - update to reflect changes in INoiseCalculator API
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.noise.stein.core;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.noise.stein.TestPathHelper;
import org.eclipse.chemclipse.model.results.ChromatogramSegmentation;

public class NoiseCalculator_2_ITest extends ChromatogramReaderTestCase {

	private NoiseCalculator noiseCalculator;

	@Override
	protected void setUp() throws Exception {

		pathImport = TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_2);
		super.setUp();
		noiseCalculator = new NoiseCalculator();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}

	public void testReader_1() {

		chromatogram.addMeasurementResult(new ChromatogramSegmentation(chromatogram, 9));
		assertEquals(9.437958f, noiseCalculator.getSignalToNoiseRatio(chromatogram, 500));
	}
}
