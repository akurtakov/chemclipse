/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.ocx.converter;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.peak.AbstractPeakExportConverter;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakExportConverter extends AbstractPeakExportConverter {

	@Override
	public IProcessingInfo<File> convert(File file, IPeaksMSD peaks, boolean append, IProgressMonitor monitor) {

		return getErrorMessage();
	}

	private IProcessingInfo<File> getErrorMessage() {

		IProcessingInfo<File> processingInfo = new ProcessingInfo<>();
		processingInfo.addErrorMessage("OCB Peak Writer", "There is no capability to write peaks in *.ocb format.");
		return processingInfo;
	}
}
