/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - add generics, remove obsolete methods
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.massspectrum.AbstractMassSpectrumFilter;
import org.eclipse.chemclipse.chromatogram.msd.filter.result.IMassSpectrumFilterResult;
import org.eclipse.chemclipse.chromatogram.msd.filter.result.MassSpectrumFilterResult;
import org.eclipse.chemclipse.chromatogram.msd.filter.settings.IMassSpectrumFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.calculator.FilterSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.settings.MassSpectrumFilterSettings;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class MassSpectrumFilter extends AbstractMassSpectrumFilter {

	private static final String DESCRIPTION = "SNIP Filter Mass Spectra";

	@Override
	public IProcessingInfo<IMassSpectrumFilterResult> applyFilter(List<IScanMSD> massSpectra, IMassSpectrumFilterSettings filterSettings, IProgressMonitor monitor) {

		/*
		 * Settings
		 */
		MassSpectrumFilterSettings massSpectrumFilterSettings;
		if(filterSettings instanceof MassSpectrumFilterSettings settings) {
			massSpectrumFilterSettings = settings;
		} else {
			massSpectrumFilterSettings = new MassSpectrumFilterSettings();
		}
		/*
		 * Filter
		 */
		IProcessingInfo<IMassSpectrumFilterResult> processingInfo = validate(massSpectra, filterSettings);
		if(!processingInfo.hasErrorMessages()) {
			FilterSupplier filterSupplier = new FilterSupplier();
			int iterations = massSpectrumFilterSettings.getIterations();
			int transitions = massSpectrumFilterSettings.getTransitions();
			double magnificationFactor = massSpectrumFilterSettings.getMagnificationFactor();
			filterSupplier.applySnipFilter(massSpectra, iterations, transitions, magnificationFactor, monitor);

			processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, DESCRIPTION, "The mass spectrum has been optimized successfully."));
			IMassSpectrumFilterResult massSpectrumFilterResult = new MassSpectrumFilterResult(ResultStatus.OK, "The SNIP filter has been applied successfully.");
			processingInfo.setProcessingResult(massSpectrumFilterResult);
		}

		return processingInfo;
	}
}