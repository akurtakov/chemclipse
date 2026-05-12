/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.junit.jupiter.api.Test;

public class AbstractChromatogram_2_Test {

	private ChromatogramMSD chromatogram = new ChromatogramMSD();

	@Test
	public void testExtractNameFromFile_1() {

		chromatogram.setFile(new File("testData/files/import/10.102040.cdf"));
		assertEquals("10.102040", chromatogram.getName());
	}

	@Test
	public void testExtractNameFromFile_2() {

		chromatogram.setFile(new File("testData/files/import/102040.mzXML"));
		assertEquals("102040", chromatogram.getName());
	}

	@Test
	public void testExtractNameFromFile_3() {

		chromatogram.setFile(new File("testData/files/import/2012.102040.SMS"));
		assertEquals("2012.102040", chromatogram.getName());
	}

	@Test
	public void testExtractNameFromFile_4() {

		chromatogram.setFile(new File("testData/files/import/2012.20.102078.SMS"));
		assertEquals("2012.20.102078", chromatogram.getName());
	}

	@Test
	public void testExtractNameFromFile_5() {

		chromatogram.setFile(new File("testData/files/import/polyethylene.cdf"));
		assertEquals("polyethylene", chromatogram.getName());
	}

	@Test
	public void testExtractNameFromFile_6() {

		chromatogram.setFile(new File("testData/files/import/polyethylene-test"));
		assertEquals("polyethylene-test", chromatogram.getName());
	}
}
