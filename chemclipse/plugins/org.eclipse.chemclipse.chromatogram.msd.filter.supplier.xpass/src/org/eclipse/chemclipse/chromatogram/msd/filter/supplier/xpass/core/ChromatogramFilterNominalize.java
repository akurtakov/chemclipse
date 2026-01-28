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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.core;

import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram.AbstractChromatogramFilterMSD;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.filter.XPassFilter;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.settings.ChromatogramFilterNominalizeSettings;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramFilterNominalize extends AbstractChromatogramFilterMSD {

	private static final Logger logger = Logger.getLogger(ChromatogramFilterNominalize.class);

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof ChromatogramFilterNominalizeSettings filterSettings) {
				IChromatogramMSD chromatogramMSD = chromatogramSelection.getChromatogram();
				nominalize(chromatogramMSD);
				if(filterSettings.isProcessReferencedChromatograms()) {
					for(IChromatogram chromatogramReference : chromatogramMSD.getReferencedChromatograms()) {
						nominalize(chromatogramReference);
					}
				}
				chromatogramSelection.getChromatogram().setDirty(true);
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Chromatogram Filter Nominalize applied successfully."));
			} else {
				logger.warn("The settings are not of type: " + ChromatogramFilterNominalizeSettings.class);
			}
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IProgressMonitor monitor) {

		ChromatogramFilterNominalizeSettings filterSettings = new ChromatogramFilterNominalizeSettings();
		return applyFilter(chromatogramSelection, filterSettings, monitor);
	}

	private void nominalize(IChromatogram chromatogram) {

		if(chromatogram instanceof IChromatogramMSD chromatogramMSD) {
			for(IScan scan : chromatogramMSD.getScans()) {
				if(scan instanceof IScanMSD scanMSD) {
					XPassFilter.nominalize(scanMSD);
				}
			}
		}
	}
}