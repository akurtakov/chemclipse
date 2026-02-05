/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.wsd.identifier.impl;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.wsd.identifier.peak.AbstractPeakIdentifierWSD;
import org.eclipse.chemclipse.chromatogram.wsd.identifier.settings.IPeakIdentifierSettingsWSD;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.identifier.IPeakIdentificationResults;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramPeakWSD;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramWSD;
import org.eclipse.chemclipse.wsd.model.core.IPeakWSD;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakIdentifierRemoveUnidentified extends AbstractPeakIdentifierWSD {

	private static final Logger logger = Logger.getLogger(PeakIdentifierRemoveUnidentified.class);

	@Override
	public IProcessingInfo<IPeakIdentificationResults> identify(List<? extends IPeakWSD> peaks, IPeakIdentifierSettingsWSD peakIdentifierSettings, IProgressMonitor monitor) {

		IProcessingInfo<IPeakIdentificationResults> processingInfo = new ProcessingInfo<>();
		/*
		 * Remove all unidentified peaks.
		 */
		try {
			for(IPeakWSD peak : peaks) {
				if(peak instanceof IChromatogramPeakWSD chromatogramPeakWSD) {
					IChromatogramWSD chromatogramWSD = chromatogramPeakWSD.getChromatogram();
					if(chromatogramWSD != null) {
						if(chromatogramPeakWSD.getTargets().isEmpty()) {
							chromatogramWSD.getPeaks().remove(chromatogramPeakWSD);
						}
					}
				}
			}
			processingInfo.addInfoMessage("Identifier", "Unidentified peaks have been removed.");
		} catch(Exception e) {
			processingInfo.addErrorMessage("Identifier", "Failed to remove unidentified peaks.");
			logger.error(e);
		}
		return processingInfo;
	}
}
