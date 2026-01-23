/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzml.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.converter.supplier.mzml.TestPathHelper;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.xxd.converter.supplier.ocx.versions.VersionConstants;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramImportExport110_ITest {

	private IChromatogramMSD chromatogram;
	private File fileExport;

	@BeforeAll
	public void setUp() {

		/*
		 * Import
		 */
		String extensionPointImport = VersionConstants.CONVERTER_ID_CHROMATOGRAM;
		/*
		 * Export/Reimport
		 */
		File directory = new File(TestPathHelper.DIRECTORY_EXPORT_TEST);
		directory.mkdir();
		String extensionPointExportReimport = "org.eclipse.chemclipse.msd.converter.supplier.mzml";
		/*
		 * Import the chromatogram.
		 */
		File fileImport = new File(TestPathHelper.TESTFILE_IMPORT_CHROMATOGRAM_1);
		IProcessingInfo<IChromatogramMSD> processingInfoImport = ChromatogramConverterMSD.getInstance().convert(fileImport, extensionPointImport, new NullProgressMonitor());
		IChromatogramMSD chromatogramImport = processingInfoImport.getProcessingResult();
		/*
		 * Export the chromatogram.
		 */
		fileExport = new File(TestPathHelper.DIRECTORY_EXPORT_TEST + File.separator + "Test.mzML");
		IProcessingInfo<File> processingInfoExport = ChromatogramConverterMSD.getInstance().convert(fileExport, chromatogramImport, extensionPointExportReimport, new NullProgressMonitor());
		fileExport = processingInfoExport.getProcessingResult();
		/*
		 * Reimport the exported chromatogram.
		 */
		IProcessingInfo<IChromatogramMSD> processingInfo = ChromatogramConverterMSD.getInstance().convert(fileExport, extensionPointExportReimport, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
	}

	@AfterAll
	public void tearDown() {

		fileExport.delete();
	}

	@Test
	public void testReimport_1() {

		assertNotNull(chromatogram);
	}

	@Test
	public void testReimport_2() {

		assertEquals(5726, chromatogram.getNumberOfScans());
	}
}
