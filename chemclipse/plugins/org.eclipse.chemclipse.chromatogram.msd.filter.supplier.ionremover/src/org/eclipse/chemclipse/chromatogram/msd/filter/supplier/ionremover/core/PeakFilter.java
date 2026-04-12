/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.ionremover.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.IPeakFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.PeakFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IPeakFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.peak.AbstractPeakFilter;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.ionremover.settings.ITraceRemoverFilterSettings;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakFilter extends AbstractPeakFilter {

	@Override
	public IProcessingInfo<IPeakFilterResult> applyFilter(List<IPeakMSD> peaks, IPeakFilterSettings filterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IPeakFilterResult> processingInfo = new ProcessingInfo<>();
		if(filterSettings instanceof ITraceRemoverFilterSettings traceRemoverFilterSettings) {
			List<IScanMSD> massSpectra = getMassSpectra(peaks);
			ScanProcessor scanProcessor = new ScanProcessor();
			scanProcessor.apply(massSpectra, traceRemoverFilterSettings);
			processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, ITraceRemoverFilterSettings.DESCRIPTION, "Peaks have been optimized successfully."));
			IPeakFilterResult peakFilterResult = new PeakFilterResult(ResultStatus.OK, "The ion remover filter has been applied successfully.");
			processingInfo.setProcessingResult(peakFilterResult);
		} else {
			processingInfo.addErrorMessage(ITraceRemoverFilterSettings.DESCRIPTION, "The filter settings instance is not a type of: " + ITraceRemoverFilterSettings.class);
		}

		return processingInfo;
	}

	private List<IScanMSD> getMassSpectra(List<IPeakMSD> peaks) {

		List<IScanMSD> massSpectra = new ArrayList<>();
		for(IPeakMSD peak : peaks) {
			peak.getTargets().clear();
			massSpectra.add(peak.getPeakModel().getPeakMassSpectrum());
		}

		return massSpectra;
	}
}