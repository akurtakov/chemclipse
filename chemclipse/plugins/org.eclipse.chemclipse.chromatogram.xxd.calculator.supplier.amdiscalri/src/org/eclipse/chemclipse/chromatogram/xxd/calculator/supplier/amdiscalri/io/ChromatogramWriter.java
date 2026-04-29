/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl.RetentionIndexExtractor;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings.IndexExportSettings;
import org.eclipse.chemclipse.model.columns.ISeparationColumnIndices;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.notifier.UpdateNotifier;

public class ChromatogramWriter {

	public void writeChromatogram(File file, IChromatogram chromatogram, IndexExportSettings indexExportSettings) throws IOException {

		if(chromatogram == null || file == null) {
			throw new IOException("The chromatogram and the file must be not null.");
		}
		/*
		 * Write the cal specifiation.
		 */
		RetentionIndexExtractor retentionIndexExtractor = new RetentionIndexExtractor();
		boolean useCuratedNames = indexExportSettings.isUseCuratedNames();
		boolean deriveMissingIndices = indexExportSettings.isDeriveMissingIndices();
		ISeparationColumnIndices separationColumnIndices = retentionIndexExtractor.extract(chromatogram, deriveMissingIndices, useCuratedNames);
		CalibrationFileWriter calibrationFileWriter = new CalibrationFileWriter();
		calibrationFileWriter.write(file, separationColumnIndices);
		if(indexExportSettings.isOpenCalibrationFileAfterProcessing()) {
			UpdateNotifier.update(CalibrationFileWriter.TOPIC_PROCESSING_FILE_CREATED, file);
		}
	}
}
