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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.noise.stein.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.noise.stein.TestPathHelper;
import org.eclipse.chemclipse.converter.PathResolver;
import org.eclipse.chemclipse.model.results.ChromatogramSegmentation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.osgi.framework.FrameworkUtil;

@TestInstance(Lifecycle.PER_CLASS)
public class NoiseCalculator_2_ITest extends ChromatogramReaderTestCase {

	private NoiseCalculator noiseCalculator = new NoiseCalculator();

	@Override
	@BeforeAll
	public void setUp() throws IOException {

		fileImport = PathResolver.getFile(FrameworkUtil.getBundle(getClass()), TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_2);
		super.setUp();
	}

	@Test
	public void testReader_1() {

		chromatogram.addMeasurementResult(new ChromatogramSegmentation(chromatogram, 9));
		assertEquals(9.437958f, noiseCalculator.getSignalToNoiseRatio(chromatogram, 500), 0);
	}
}
