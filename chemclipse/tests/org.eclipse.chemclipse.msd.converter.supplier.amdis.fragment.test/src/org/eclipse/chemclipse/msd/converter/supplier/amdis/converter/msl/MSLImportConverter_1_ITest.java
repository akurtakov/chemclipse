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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.msd.converter.database.IDatabaseImportConverter;
import org.eclipse.chemclipse.msd.converter.supplier.amdis.TestPathHelper;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MSLImportConverter_1_ITest {

	private IDatabaseImportConverter importConverter = new MSLDatabaseImportConverter();
	private File importFile;

	@Test
	public void testExceptions_1() {

		importFile = null;
		IProcessingInfo<?> processingInfo = importConverter.convert(null, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testExceptions_2() throws IOException {

		importFile = new File(TestPathHelper.TESTFILE_IMPORT_EMPTY);
		IProcessingInfo<?> processingInfo = importConverter.convert(importFile, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testExceptions_3() {

		importFile = new File("nirvana");
		IProcessingInfo<?> processingInfo = importConverter.convert(importFile, new NullProgressMonitor());
		assertTrue(processingInfo.hasErrorMessages());
	}

	@Test
	public void testExceptions_4() throws IOException {

		importFile = new File(TestPathHelper.TESTFILE_IMPORT_NOT_READABLE);
		importFile.setReadable(false);
		try {
			IProcessingInfo<?> processingInfo = importConverter.convert(importFile, new NullProgressMonitor());
			assertTrue(processingInfo.hasErrorMessages());
		} finally {
			importFile.setReadable(true);
		}
	}
}
