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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.vsd.converter.chromatogram;

import java.io.File;
import java.io.FileInputStream;

import org.eclipse.chemclipse.converter.chromatogram.AbstractChromatogramImportConverter;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.vsd.model.core.IChromatogramVSD;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class AbstractImportConverter extends AbstractChromatogramImportConverter<IChromatogramVSD> implements IImportConverterVSD {

	private static final String DESCRIPTION = "Import Converter (VSD)";

	@Override
	public IProcessingInfo<IChromatogramVSD> convert(File file, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramVSD> processingInfo = new ProcessingInfo<>();
		try (FileInputStream inputStream = new FileInputStream(file)) {
			IChromatogramVSD chromatogramVSD = convert(inputStream, monitor);
			setFile(file, chromatogramVSD);
			processingInfo.setProcessingResult(chromatogramVSD);
		} catch(Exception e) {
			processingInfo.addErrorMessage(DESCRIPTION, "Failed to load the file: " + file);
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramOverview> convertOverview(File file, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramOverview> processingInfo = new ProcessingInfo<>();
		try (FileInputStream inputStream = new FileInputStream(file)) {
			IChromatogramOverview chromatogramOverview = convertOverview(inputStream, monitor);
			processingInfo.setProcessingResult(chromatogramOverview);
		} catch(Exception e) {
			processingInfo.addErrorMessage(DESCRIPTION, "Failed to load the overview of the file: " + file);
		}

		return processingInfo;
	}

	private void setFile(File file, IChromatogramVSD chromatogramVSD) {

		if(chromatogramVSD != null) {
			chromatogramVSD.setFile(file);
		}
	}
}