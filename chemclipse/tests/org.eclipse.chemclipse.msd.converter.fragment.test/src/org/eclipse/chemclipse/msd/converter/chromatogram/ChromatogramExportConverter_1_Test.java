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

import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;

/**
 * This class validates the exceptions thrown by
 * AbstractChromatogramExportConverter.<br/>
 * Because AbstractChromatogramExportConverter is an abstract class,
 * TestChromatogramExportConverter is instantiated which extends
 * AbstractChromatogramExportConverter.
 */
public class ChromatogramExportConverter_1_Test {

	private TestChromatogramExportConverter ec = new TestChromatogramExportConverter();

	@Test
	public void testFileNotFoundException_1() {

		File file = null;
		IProcessingInfo<File> processingInfo = ec.convert(file, null, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testFileNotWritableException_1() {

		File file = null;
		file = new File("testData/files/export/NOT_WRITEABLE.D/DATA.MS");
		file.setWritable(false);
		IProcessingInfo<File> processingInfo = ec.convert(file, null, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
		if(file != null) {
			file.setWritable(true);
		}
	}
}
