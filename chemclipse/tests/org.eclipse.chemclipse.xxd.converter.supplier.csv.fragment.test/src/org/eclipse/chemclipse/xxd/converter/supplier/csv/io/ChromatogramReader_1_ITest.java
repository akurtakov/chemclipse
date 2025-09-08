/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.csv.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.model.settings.Delimiter;
import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.xxd.converter.supplier.csv.TestPathHelper;
import org.eclipse.chemclipse.xxd.converter.supplier.csv.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.versions.VersionConstants;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChromatogramReader_1_ITest {

	private static File fileExport;
	private static IChromatogramMSD chromatogram;

	@BeforeClass
	public static void setUp() {

		PreferenceSupplier.setImportDelimiter(Delimiter.COMMA);
		PreferenceSupplier.setImportZeroMarker("0.0");
		/*
		 * Import
		 */
		String pathImport = TestPathHelper.getAbsolutePath(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1);
		String extensionPointImport = VersionConstants.CONVERTER_ID_CHROMATOGRAM;
		/*
		 * Export/Reimport
		 */
		String pathExport = TestPathHelper.getAbsolutePath(TestPathHelper.DIRECTORY_EXPORT_TEST) + File.separator + "Test.csv";
		String extensionPointExportReimport = "org.eclipse.chemclipse.msd.converter.supplier.csv";
		/*
		 * Import the chromatogram.
		 */
		File fileImport = new File(pathImport);
		IProcessingInfo<IChromatogramMSD> processingInfoImport = ChromatogramConverterMSD.getInstance().convert(fileImport, extensionPointImport, new NullProgressMonitor());
		IChromatogramMSD chromatogramImport = processingInfoImport.getProcessingResult();
		/*
		 * Export the chromatogram.
		 */
		fileExport = new File(pathExport);
		IProcessingInfo<File> processingInfoExport = ChromatogramConverterMSD.getInstance().convert(fileExport, chromatogramImport, extensionPointExportReimport, new NullProgressMonitor());
		fileExport = processingInfoExport.getProcessingResult();
		/*
		 * Reimport the exported chromatogram.
		 */
		IProcessingInfo<IChromatogramMSD> processingInfo = ChromatogramConverterMSD.getInstance().convert(fileExport, extensionPointExportReimport, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
	}

	@After
	public void tearDown() {

		fileExport.delete();
	}

	@Test
	public void testReimport1() {

		assertNotNull(chromatogram);
	}

	@Test
	public void testReimport2() {

		assertEquals(5726, chromatogram.getNumberOfScans());
	}
}