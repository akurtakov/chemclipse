/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.converter;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.nmr.converter.core.AbstractScanImportConverter;
import org.eclipse.chemclipse.nmr.converter.core.IScanImportConverter;
import org.eclipse.chemclipse.nmr.converter.supplier.jcampdx.io.ScanReaderNMR;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ScanImportConverterNMR extends AbstractScanImportConverter<IComplexSignalMeasurement<?>> implements IScanImportConverter<IComplexSignalMeasurement<?>> {

	private static final Logger logger = Logger.getLogger(ScanImportConverterNMR.class);

	public ScanImportConverterNMR() {

		super();
	}

	@Override
	public IProcessingInfo<IComplexSignalMeasurement<?>> convert(File file, IProgressMonitor monitor) {

		IProcessingInfo<IComplexSignalMeasurement<?>> processingInfo = super.validate(file);
		if(!processingInfo.hasErrorMessages()) {
			ScanReaderNMR scanReader = new ScanReaderNMR();
			try {
				IComplexSignalMeasurement<?> result = scanReader.read(file, monitor);
				processingInfo.setProcessingResult(result);
			} catch(IOException e) {
				logger.warn(e);
			}
		}
		return processingInfo;
	}
}