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
package org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.IPeakFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.PeakFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IPeakFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.peak.AbstractPeakFilter;
import org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.calculator.FilterSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.settings.PeakFilterSettings;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakFilter extends AbstractPeakFilter {

	private static final String DESCRIPTION = "SNIP Filter Peaks Mass Spectra";

	@Override
	public IProcessingInfo<IPeakFilterResult> applyFilter(List<IPeakMSD> peaks, IPeakFilterSettings filterSettings, IProgressMonitor monitor) {

		/*
		 * Settings
		 */
		PeakFilterSettings peakFilterSettings;
		if(filterSettings instanceof PeakFilterSettings settings) {
			peakFilterSettings = settings;
		} else {
			peakFilterSettings = new PeakFilterSettings();
		}
		/*
		 * Filter
		 */
		FilterSupplier filterSupplier = new FilterSupplier();
		int iterations = peakFilterSettings.getIterations();
		int transitions = peakFilterSettings.getTransitions();
		double magnificationFactor = peakFilterSettings.getMagnificationFactor();
		filterSupplier.applySnipFilter(getMassSpectra(peaks), iterations, transitions, magnificationFactor);
		IProcessingInfo<IPeakFilterResult> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, DESCRIPTION, "The mass spectrum has been optimized successfully."));
		IPeakFilterResult peakFilterResult = new PeakFilterResult(ResultStatus.OK, "The SNIP filter has been applied successfully.");
		processingInfo.setProcessingResult(peakFilterResult);

		return processingInfo;
	}

	private List<IScanMSD> getMassSpectra(List<IPeakMSD> peaks) {

		List<IScanMSD> massSpectra = new ArrayList<>();
		for(IPeakMSD peakMSD : peaks) {
			massSpectra.add(peakMSD.getPeakModel().getPeakMassSpectrum());
		}

		return massSpectra;
	}
}