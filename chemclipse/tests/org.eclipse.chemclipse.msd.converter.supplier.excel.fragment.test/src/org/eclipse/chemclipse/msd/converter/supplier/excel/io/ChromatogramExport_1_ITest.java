/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.excel.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.converter.supplier.excel.PathResolver;
import org.eclipse.chemclipse.msd.converter.supplier.excel.TestPathHelper;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.versions.VersionConstants;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChromatogramExport_1_ITest {

	private ChromatogramWriter chromatogramWriter = new ChromatogramWriter();

	private static IChromatogramMSD chromatogram;
	private static File file;

	@BeforeClass
	public static void setUp() {

		File fileImport = new File(PathResolver.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1));
		IProcessingInfo<IChromatogramMSD> processingInfo = ChromatogramConverterMSD.getInstance().convert(fileImport, VersionConstants.CONVERTER_ID_CHROMATOGRAM, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
		new File(TestPathHelper.DIRECTORY_EXPORT_TEST).mkdirs();
		file = new File(PathResolver.getAbsolutePath(TestPathHelper.DIRECTORY_EXPORT_TEST) + File.separator + "Test.xlsx");
	}

	@AfterClass
	public static void tearDown() {

		file.delete();
	}

	@Test
	public void testExport() throws FileIsNotWriteableException, IOException {

		chromatogramWriter.writeChromatogram(file, chromatogram, new NullProgressMonitor());
		assertTrue(file.length() > 0);
	}
}
