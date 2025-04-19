/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.database;

import java.io.File;

import org.eclipse.chemclipse.converter.core.AbstractExportConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.IProcessingMessage;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;

public abstract class AbstractDatabaseExportConverter extends AbstractExportConverter implements IDatabaseExportConverter {

	@Override
	public IProcessingInfo<File> validate(IScanMSD massSpectrum) {

		IProcessingInfo<File> processingInfo = new ProcessingInfo<>();
		if(massSpectrum == null) {
			IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, "Database Export", "The is no mass spectrum to export.");
			processingInfo.addMessage(processingMessage);
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<File> validate(IMassSpectra massSpectra) {

		IProcessingInfo<File> processingInfo = new ProcessingInfo<>();
		if(massSpectra == null) {
			IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, "Database Export", "The are no mass spectra to export.");
			processingInfo.addMessage(processingMessage);
		}
		return processingInfo;
	}
}