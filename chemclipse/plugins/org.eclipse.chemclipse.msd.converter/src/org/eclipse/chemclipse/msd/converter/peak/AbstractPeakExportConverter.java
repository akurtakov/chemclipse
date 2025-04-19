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
 * Christoph Läubrich - adjust to new API
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.peak;

import java.io.File;

import org.eclipse.chemclipse.converter.core.AbstractExportConverter;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.IProcessingMessage;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;

public abstract class AbstractPeakExportConverter extends AbstractExportConverter implements IPeakExportConverter {

	public IProcessingInfo<File> validate(IPeakMSD peak) {

		if(peak == null) {
			return getProcessingInfo("The peak couldn't be found.");
		} else {
			return new ProcessingInfo<>();
		}
	}

	public IProcessingInfo<File> validate(IPeaksMSD peaks) {

		if(peaks == null) {
			return getProcessingInfo("The peak list couldn't be found.");
		} else {
			return new ProcessingInfo<>();
		}
	}

	private IProcessingInfo<File> getProcessingInfo(String message) {

		IProcessingInfo<File> processingInfo = new ProcessingInfo<>();
		IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, "Export Converter", message);
		processingInfo.addMessage(processingMessage);
		return processingInfo;
	}
}
