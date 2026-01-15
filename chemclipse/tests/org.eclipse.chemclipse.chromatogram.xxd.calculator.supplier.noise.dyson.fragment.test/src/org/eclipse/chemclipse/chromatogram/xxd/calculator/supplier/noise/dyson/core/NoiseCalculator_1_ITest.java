/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.noise.dyson.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.noise.dyson.TestPathHelper;
import org.eclipse.chemclipse.model.results.ChromatogramSegmentation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class NoiseCalculator_1_ITest extends ChromatogramReaderTestCase {

	private NoiseCalculator noiseCalculator;

	@Override
	@BeforeAll
	public void setUp() throws IOException {

		fileImport = new File(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1);
		super.setUp();
		noiseCalculator = new NoiseCalculator();
	}

	@Test
	public void testReader_1() {

		/*
		 * The loading time of the chromatogram takes a while.
		 * That's why several tests are made here.
		 */
		chromatogram.addMeasurementResult(new ChromatogramSegmentation(chromatogram, 13));
		assertEquals(0.0f, noiseCalculator.getSignalToNoiseRatio(chromatogram, 0), 0);
		assertEquals(0.4935501963f, noiseCalculator.getSignalToNoiseRatio(chromatogram, 2200), 0);
		assertEquals(1.0f, noiseCalculator.getSignalToNoiseRatio(chromatogram, 4457.5f), 0);
		assertEquals(17.9472798654f, noiseCalculator.getSignalToNoiseRatio(chromatogram, 80000), 0);
	}
}
