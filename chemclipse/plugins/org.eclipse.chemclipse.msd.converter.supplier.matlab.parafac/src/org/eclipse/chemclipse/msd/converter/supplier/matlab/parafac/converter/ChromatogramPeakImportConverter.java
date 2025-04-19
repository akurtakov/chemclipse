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
package org.eclipse.chemclipse.msd.converter.supplier.matlab.parafac.converter;

import java.io.File;

import org.eclipse.chemclipse.converter.chromatogram.AbstractChromatogramImportConverter;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramPeakImportConverter extends AbstractChromatogramImportConverter<IChromatogramMSD> {

	private static final String DESCRIPTION = "Matlab Parafac Chromatogram Import Converter";
	private static final String MESSAGE = "It's only possible to import peaks using the chromatogram peak import converter.";

	@Override
	public IProcessingInfo<IChromatogramMSD> convert(File file, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramMSD> processingInfo = new ProcessingInfo<>();
		processingInfo.addErrorMessage(DESCRIPTION, MESSAGE);
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramOverview> convertOverview(File file, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramOverview> processingInfo = new ProcessingInfo<>();
		processingInfo.addErrorMessage(DESCRIPTION, MESSAGE);
		return processingInfo;
	}
}
