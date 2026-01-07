/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
 * Christoph Läubrich - remove default methods, fix generics
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.identifier.peak.AbstractPeakIdentifierMSD;
import org.eclipse.chemclipse.chromatogram.msd.identifier.settings.IPeakIdentifierSettingsMSD;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl.AlkaneIdentifier;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings.PeakIdentifierAlkaneSettings;
import org.eclipse.chemclipse.model.identifier.IPeakIdentificationResults;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakIdentifier extends AbstractPeakIdentifierMSD {

	@Override
	public IProcessingInfo<IPeakIdentificationResults> identify(List<? extends IPeakMSD> peaks, IPeakIdentifierSettingsMSD peakIdentifierSettings, IProgressMonitor monitor) {

		ProcessingInfo<IPeakIdentificationResults> processingInfo = new ProcessingInfo<>();
		AlkaneIdentifier alkaneIdentifier = new AlkaneIdentifier();
		PeakIdentifierAlkaneSettings alkaneSettings;
		if(peakIdentifierSettings instanceof PeakIdentifierAlkaneSettings settings) {
			alkaneSettings = settings;
		} else {
			alkaneSettings = PreferenceSupplier.getPeakIdentifierAlkaneSettings();
		}
		/*
		 * Run the identifier.
		 */
		processingInfo.addMessages(alkaneIdentifier.runPeakIdentification(peaks, alkaneSettings, monitor));

		return processingInfo;
	}
}
