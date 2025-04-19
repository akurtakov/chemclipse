/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

import java.io.File;

import org.eclipse.chemclipse.msd.model.TestPathHelper;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;

import junit.framework.TestCase;

public class AbstractChromatogram_3_Test extends TestCase {

	private ChromatogramMSD chromatogram;
	private String nameDefault = "default";

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		chromatogram = new ChromatogramMSD();
	}

	@Override
	protected void tearDown() throws Exception {

		chromatogram = null;
		super.tearDown();
	}

	public void testExtractNameFromDirectory_1() {

		chromatogram.setFile(new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_DIR_20120319)));
		assertEquals("PW2012.03.19", chromatogram.extractNameFromFile(nameDefault));
	}

	public void testExtractNameFromDirectory_2() {

		chromatogram.setFile(new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_DIR_20120320)));
		assertEquals(nameDefault, chromatogram.extractNameFromFile(nameDefault));
	}

	public void testExtractNameFromDirectory_3() {

		chromatogram.setFile(new File(TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_DIR_20120321_1)));
		assertEquals("PW20120321-1", chromatogram.extractNameFromFile(nameDefault));
	}
}
