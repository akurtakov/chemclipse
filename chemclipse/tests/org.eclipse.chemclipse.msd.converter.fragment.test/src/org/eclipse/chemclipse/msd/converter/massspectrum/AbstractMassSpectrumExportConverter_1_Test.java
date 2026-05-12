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
package org.eclipse.chemclipse.msd.converter.massspectrum;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.ScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;

/**
 * This class validates the exceptions thrown by
 * AbstractMassSpectrumExportConverter.<br/>
 * Because AbstractMassSpectrumExportConverter is an abstract class,
 * TestMassSpectrumExportConverter is instantiated which extends
 * AbstractMassSpectrumExportConverter.
 */
public class AbstractMassSpectrumExportConverter_1_Test {

	private TestMassSpectrumExportConverter ec = new TestMassSpectrumExportConverter();
	private IScanMSD massSpectrum = new ScanMSD();

	@Test
	public void testFileNotFoundException_1() {

		File file = null;
		massSpectrum = null;
		IProcessingInfo<?> processingInfo = ec.convert(file, massSpectrum, false, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testFileNotWritableException_1() {

		File file = null;
		file = new File("testData/files/export/NOT_WRITEABLE.msl");
		file.setWritable(false);
		IProcessingInfo<?> processingInfo = ec.convert(file, massSpectrum, false, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
		if(file != null) {
			file.setWritable(true);
		}
	}
}
