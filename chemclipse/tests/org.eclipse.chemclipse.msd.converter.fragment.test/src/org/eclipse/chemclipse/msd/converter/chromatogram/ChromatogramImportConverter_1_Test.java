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
package org.eclipse.chemclipse.msd.converter.chromatogram;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.msd.converter.TestPathHelper;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;

/**
 * This class validates the exceptions thrown by
 * AbstractChromatogramImportConverter. Because
 * AbstractChromatogramImportConverter is an abstract class,
 * TestChromatogramImportConverter is instantiated which extends
 * AbstractChromatogramImportConverter.
 */
public class ChromatogramImportConverter_1_Test {

	TestChromatogramImportConverter ic = new TestChromatogramImportConverter();

	@Test
	public void testFileNotFoundException_1() {

		File file = new File("");
		IProcessingInfo<IChromatogram> processingInfo = ic.convert(file, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testFileIsNotReadableException_1() throws IOException {

		File file = null;
		file = new File(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_NOT_READABLE);
		file.setReadable(false);
		IProcessingInfo<IChromatogram> processingInfo = ic.convert(file, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
		if(file != null) {
			file.setReadable(true);
		}
	}

	@Test
	public void testFileIsEmptyException_1() throws IOException {

		File file = null;
		file = new File(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_EMPTY);
		IProcessingInfo<IChromatogram> processingInfo = ic.convert(file, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}
}
