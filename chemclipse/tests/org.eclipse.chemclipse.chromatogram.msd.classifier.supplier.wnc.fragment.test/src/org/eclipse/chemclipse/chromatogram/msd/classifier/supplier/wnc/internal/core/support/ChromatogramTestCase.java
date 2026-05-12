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
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.internal.core.support;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.exceptions.ClassifierException;
import org.eclipse.chemclipse.model.settings.Delimiter;
import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.ChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.xxd.converter.supplier.csv.preferences.PreferenceSupplier;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@Disabled
@TestInstance(Lifecycle.PER_CLASS)
public class ChromatogramTestCase {

	protected IChromatogramMSD chromatogram;
	protected IChromatogramSelectionMSD chromatogramSelection;
	protected File chromatogramFile;

	@BeforeEach
	public void setUp() throws IOException, ClassifierException {

		PreferenceSupplier.setImportDelimiter(Delimiter.SEMICOLON);
		File file = new File("testData/files/import/Chromatogram1.csv.zip");
		try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))) {
			zipInputStream.getNextEntry();
			File folder = new File("testData/files/unzipped-files");
			chromatogramFile = new File(folder, File.separator + "Chromatogram1.csv");
			if(chromatogramFile.exists()) {
				chromatogramFile.delete();
			}
			try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(chromatogramFile), 2048)) {
				int count;
				int buffer = 2048;
				byte[] data = new byte[buffer];
				while((count = zipInputStream.read(data, 0, buffer)) != -1) {
					bufferedOutputStream.write(data, 0, count);
				}
				bufferedOutputStream.flush();
			}
		}
		/*
		 * Read the chromatogram
		 */
		IProcessingInfo<IChromatogramMSD> processingInfo = ChromatogramConverterMSD.getInstance().convert(chromatogramFile, new NullProgressMonitor());
		chromatogram = processingInfo.getProcessingResult();
		chromatogramSelection = new ChromatogramSelectionMSD(chromatogram);
	}

	@AfterAll
	public void tearDown() {

		PreferenceSupplier.setImportDelimiter(Delimiter.COMMA);

		chromatogramFile.delete();
	}

	public IChromatogramSelectionMSD getChromatogramSelection() {

		return chromatogramSelection;
	}
}
