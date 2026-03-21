/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - adjust to simplified API, add generics
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.wsd.identifier.settings.IWaveSpectrumIdentifierSettings;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.wavespectrum.AbstractWaveSpectrumIdentifier;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.identifier.FileIdentifier;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.identifier.UnknownIdentifier;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.model.UnknownSettingsSupport;
import org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.settings.WaveSpectrumUnknownSettings;
import org.eclipse.chemclipse.model.targets.TargetUnknownSettings;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.chemclipse.wsd.model.core.WaveSpectra;
import org.eclipse.core.runtime.IProgressMonitor;

public class WaveSpectrumIdentifierUnknown extends AbstractWaveSpectrumIdentifier {

	@Override
	public IProcessingInfo<WaveSpectra> identify(List<IScanWSD> waveSpectraList, IWaveSpectrumIdentifierSettings identifierSettings, IProgressMonitor monitor) {

		WaveSpectrumUnknownSettings unknownSettings = (WaveSpectrumUnknownSettings)identifierSettings;
		IProcessingInfo<WaveSpectra> processingInfo = new ProcessingInfo<>();
		TargetUnknownSettings targetUnknownSettings = UnknownSettingsSupport.getTargetUnknownSettings(unknownSettings);
		float limitMatchFactor = unknownSettings.getLimitMatchFactor();
		UnknownIdentifier unknownIdentifier = new UnknownIdentifier();
		unknownIdentifier.runIdentificationScan(waveSpectraList, limitMatchFactor, targetUnknownSettings);
		processingInfo.addInfoMessage(FileIdentifier.IDENTIFIER, "Wave spectra have been identified.");

		return processingInfo;
	}
}
