/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.peaks.AbstractPeakIntegrator;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.peaks.IPeakIntegrationSettings;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.result.IPeakIntegrationResult;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.result.IPeakIntegrationResults;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.result.PeakIntegrationResults;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.internal.support.PeakIntegratorSupport;
import org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.settings.PeakIntegrationSettings;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakIntegrator extends AbstractPeakIntegrator {

	@Override
	public IProcessingInfo<IPeakIntegrationResults> integrate(IPeak peak, IPeakIntegrationSettings peakIntegrationSettings, IProgressMonitor monitor) {

		IProcessingInfo<IPeakIntegrationResults> processingInfo = super.validate(peak, peakIntegrationSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(peakIntegrationSettings instanceof PeakIntegrationSettings settings) {
				PeakIntegratorSupport firstDerivativePeakIntegratorSupport = new PeakIntegratorSupport();
				IPeakIntegrationResult peakIntegrationResult = firstDerivativePeakIntegratorSupport.calculatePeakIntegrationResult(peak, settings, monitor);
				IPeakIntegrationResults peakIntegrationResults = new PeakIntegrationResults();
				peakIntegrationResults.add(peakIntegrationResult);
				processingInfo.setProcessingResult(peakIntegrationResults);
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IPeakIntegrationResults> integrate(List<? extends IPeak> peaks, IPeakIntegrationSettings peakIntegrationSettings, IProgressMonitor monitor) {

		IProcessingInfo<IPeakIntegrationResults> processingInfo = super.validate(peaks, peakIntegrationSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(peakIntegrationSettings instanceof PeakIntegrationSettings settings) {
				PeakIntegratorSupport firstDerivativePeakIntegratorSupport = new PeakIntegratorSupport();
				IPeakIntegrationResults peakIntegrationResults = firstDerivativePeakIntegratorSupport.calculatePeakIntegrationResults(peaks, settings, monitor);
				processingInfo.setProcessingResult(peakIntegrationResults);
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IPeakIntegrationResults> integrate(IChromatogramSelection chromatogramSelection, IPeakIntegrationSettings peakIntegrationSettings, IProgressMonitor monitor) {

		IProcessingInfo<IPeakIntegrationResults> processingInfo = super.validate(chromatogramSelection, peakIntegrationSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(peakIntegrationSettings instanceof PeakIntegrationSettings settings) {
				PeakIntegratorSupport firstDerivativePeakIntegratorSupport = new PeakIntegratorSupport();
				IPeakIntegrationResults peakIntegrationResults = firstDerivativePeakIntegratorSupport.calculatePeakIntegrationResults(chromatogramSelection, settings, monitor);
				processingInfo.setProcessingResult(peakIntegrationResults);
			}
		}
		return processingInfo;
	}
}
