/*******************************************************************************
 * Copyright (c) 2010, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - simplify API ba removing delegate methods
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.wsd.identifier.wavespectrum;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.wsd.identifier.settings.IWaveSpectrumIdentifierSettings;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.chemclipse.wsd.model.core.WaveSpectra;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IWaveSpectrumIdentifier {

	/**
	 * Identifies a list of wave spectra.
	 *
	 * @param waveSpectra
	 *            the wave spectra to be identified
	 * @param monitor
	 *            a {@link IProgressMonitor monitor} to monitor progress and
	 *            provide cancellation functionality
	 */
	IProcessingInfo<WaveSpectra> identify(List<IScanWSD> waveSpectra, IWaveSpectrumIdentifierSettings waveSpectrumIdentifierSettings, IProgressMonitor monitor);
}
