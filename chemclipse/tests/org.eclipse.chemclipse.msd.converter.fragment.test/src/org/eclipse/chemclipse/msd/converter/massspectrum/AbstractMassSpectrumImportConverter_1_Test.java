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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;

/**
 * This class validates the exceptions thrown by
 * AbstractMassSpectrumImportConverter. Because
 * AbstractMassSpectrumImportConverter is an abstract class,
 * TestMassSpectrumImportConverter is instantiated which extends
 * AbstractMassSpectrumImportConverter.
 */
public class AbstractMassSpectrumImportConverter_1_Test {

	TestMassSpectrumImportConverter importConverter = new TestMassSpectrumImportConverter();

	@Test
	public void testFileNotFoundException_1() {

		File file = new File("notexisting.weird.filename");
		assertFalse(file.exists());
		IProcessingInfo<IMassSpectra> processingInfo = importConverter.convert(file, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testFileIsNotReadableException_1() {

		File file = null;
		file = new File("testData/files/import/NOT_READABLE.msl");
		file.setReadable(false);
		IProcessingInfo<IMassSpectra> prcoessingInfo = importConverter.convert(file, new NullProgressMonitor());
		assertTrue(prcoessingInfo.hasErrorMessages());
		if(file != null) {
			file.setReadable(true);
		}
	}

	@Test
	public void testFileIsEmptyException_1() {

		File file = null;
		file = new File("testData/files/import/EMPTY.msl");
		IProcessingInfo<IMassSpectra> prcoessingInfo = importConverter.convert(file, new NullProgressMonitor());
		assertTrue(prcoessingInfo.hasErrorMessages());
	}
}
