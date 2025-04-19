/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.amdis.converter.msp;

import java.io.File;

import org.eclipse.chemclipse.msd.converter.peak.AbstractPeakImportConverter;
import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class MSPPeakImportConverter extends AbstractPeakImportConverter {

	@Override
	public IProcessingInfo<IPeaksMSD> convert(File file, IProgressMonitor monitor) {

		IProcessingInfo<IPeaksMSD> processingInfo = new ProcessingInfo<>();
		processingInfo.addErrorMessage("AMDIS MSP Peak Import", "The converter supports no *.msp file import.");
		return processingInfo;
	}
}
