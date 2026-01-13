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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.impl;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.massspectrum.AbstractMassSpectrumFilter;
import org.eclipse.chemclipse.chromatogram.msd.filter.impl.settings.PrecursorAssignerFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.impl.settings.ScanTypeAssignerFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.result.IMassSpectrumFilterResult;
import org.eclipse.chemclipse.chromatogram.msd.filter.result.MassSpectrumFilterResult;
import org.eclipse.chemclipse.chromatogram.msd.filter.settings.IMassSpectrumFilterSettings;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class ScanTypeAssignerFilter extends AbstractMassSpectrumFilter {

	private static final String DESCRIPTION = "Precursor Assigner";

	@Override
	public IProcessingInfo<IMassSpectrumFilterResult> applyFilter(List<IScanMSD> massSpectra, IMassSpectrumFilterSettings filterSettings, IProgressMonitor monitor) {

		if(filterSettings == null) {
			filterSettings = new PrecursorAssignerFilterSettings();
		}

		IProcessingInfo<IMassSpectrumFilterResult> processingInfo = validate(massSpectra, filterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(filterSettings instanceof ScanTypeAssignerFilterSettings settings) {
				for(IScanMSD massSpectrum : massSpectra) {
					if(massSpectrum instanceof IRegularMassSpectrum regularMassSpectrum) {
						regularMassSpectrum.setMassSpectrometer(settings.getMassSpectrometer());
						regularMassSpectrum.setMassSpectrumType(settings.getMassSpectrumType());
					}
				}
				processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, DESCRIPTION, "The scan type has been set successfully."));
				IMassSpectrumFilterResult massSpectrumFilterResult = new MassSpectrumFilterResult(ResultStatus.OK, "The scan type has been applied successfully.");
				processingInfo.setProcessingResult(massSpectrumFilterResult);
			} else {
				processingInfo.addErrorMessage(DESCRIPTION, "The filter settings instance is not a type of: " + ScanTypeAssignerFilterSettings.class);
			}
		}

		return processingInfo;
	}
}