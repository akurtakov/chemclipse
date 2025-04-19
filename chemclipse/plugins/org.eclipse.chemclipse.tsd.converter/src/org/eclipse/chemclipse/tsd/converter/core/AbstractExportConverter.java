/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.tsd.converter.core;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.chemclipse.converter.chromatogram.AbstractChromatogramExportConverter;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class AbstractExportConverter extends AbstractChromatogramExportConverter implements IExportConverterTSD {

	private static final String DESCRIPTION = "Export Converter (TSD)";

	@Override
	public IProcessingInfo<File> convert(File file, IChromatogram chromatogram, IProgressMonitor monitor) {

		IProcessingInfo<File> processingInfo = new ProcessingInfo<>();
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			processingInfo.addMessages(convert(outputStream, chromatogram, monitor));
		} catch(Exception e) {
			processingInfo.addErrorMessage(DESCRIPTION, "Failed to export the chromatogram to file: " + file);
		}
		//
		return processingInfo;
	}
}
