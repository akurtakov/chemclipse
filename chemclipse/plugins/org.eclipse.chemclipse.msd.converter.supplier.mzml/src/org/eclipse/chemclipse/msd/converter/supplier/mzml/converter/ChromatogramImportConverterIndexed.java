/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mzml.converter;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.converter.chromatogram.AbstractChromatogramImportConverter;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.msd.converter.io.IChromatogramMSDReader;
import org.eclipse.chemclipse.msd.converter.supplier.mzml.converter.io.ChromatogramReaderIndexed;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramImportConverterIndexed extends AbstractChromatogramImportConverter<IChromatogramMSD> {

	private static final Logger logger = Logger.getLogger(ChromatogramImportConverterIndexed.class);
	private static final String DESCRIPTION = "indexed mzML Import Converter";
	private static final String IMPORT_CHROMATOGRAM = "Import indexed mzML Chromatogram";
	private static final String IMPORT_CHROMATOGRAM_OVERVIEW = "Import indexed mzML Chromatogram Overview";
	private static final String ERROR = "Error reading file: ";

	@Override
	public IProcessingInfo<IChromatogramMSD> convert(File file, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramMSD> processingInfo = super.validate(file);
		if(!processingInfo.hasErrorMessages()) {
			/*
			 * Read the chromatogram.
			 */
			IChromatogramMSDReader reader = new ChromatogramReaderIndexed();
			monitor.subTask(IMPORT_CHROMATOGRAM);
			try {
				IChromatogramMSD chromatogram = reader.read(file, monitor);
				processingInfo.setProcessingResult(chromatogram);
			} catch(IOException e) {
				logger.warn(e);
				processingInfo.addErrorMessage(DESCRIPTION, ERROR + file.getAbsolutePath());
			} catch(InterruptedException e) {
				logger.warn(e);
				processingInfo.addErrorMessage(DESCRIPTION, ERROR + file.getAbsolutePath());
				Thread.currentThread().interrupt();
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramOverview> convertOverview(File file, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramOverview> processingInfo = super.validate(file);
		if(!processingInfo.hasErrorMessages()) {
			IChromatogramMSDReader reader = new ChromatogramReaderIndexed();
			monitor.subTask(IMPORT_CHROMATOGRAM_OVERVIEW);
			try {
				IChromatogramOverview chromatogramOverview = reader.readOverview(file, monitor);
				processingInfo.setProcessingResult(chromatogramOverview);
			} catch(IOException e) {
				logger.warn(e);
				processingInfo.addErrorMessage(DESCRIPTION, ERROR + file.getAbsolutePath());
			}
		}
		return processingInfo;
	}
}
