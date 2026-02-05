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
package org.eclipse.chemclipse.chromatogram.csd.identifier.impl;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.csd.identifier.l10n.Messages;
import org.eclipse.chemclipse.chromatogram.csd.identifier.peak.AbstractPeakIdentifierCSD;
import org.eclipse.chemclipse.chromatogram.csd.identifier.settings.IPeakIdentifierSettingsCSD;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.csd.model.core.IChromatogramPeakCSD;
import org.eclipse.chemclipse.csd.model.core.IPeakCSD;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.identifier.IPeakIdentificationResults;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakIdentifierRemoveUnidentified extends AbstractPeakIdentifierCSD {

	private static final Logger logger = Logger.getLogger(PeakIdentifierRemoveUnidentified.class);

	@Override
	public IProcessingInfo<IPeakIdentificationResults> identify(List<? extends IPeakCSD> peaks, IPeakIdentifierSettingsCSD peakIdentifierSettings, IProgressMonitor monitor) {

		IProcessingInfo<IPeakIdentificationResults> processingInfo = new ProcessingInfo<>();
		/*
		 * Remove all unidentified peaks.
		 */
		try {
			for(IPeakCSD peak : peaks) {
				if(peak instanceof IChromatogramPeakCSD chromatogramPeakCSD) {
					IChromatogramCSD chromatogramCSD = chromatogramPeakCSD.getChromatogram();
					if(chromatogramCSD != null) {
						if(chromatogramPeakCSD.getTargets().isEmpty()) {
							chromatogramCSD.getPeaks().remove(chromatogramPeakCSD);
						}
					}
				}
			}
			processingInfo.addInfoMessage(Messages.identifier, Messages.removedUnidentifiedPeaks);
		} catch(Exception e) {
			processingInfo.addErrorMessage(Messages.identifier, Messages.identifierError);
			logger.error(e);
		}
		return processingInfo;
	}
}
