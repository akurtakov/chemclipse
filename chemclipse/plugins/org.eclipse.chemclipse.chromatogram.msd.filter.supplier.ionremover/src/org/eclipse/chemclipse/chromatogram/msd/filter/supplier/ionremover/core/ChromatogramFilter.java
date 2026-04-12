/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.ionremover.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram.AbstractChromatogramFilterMSD;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.ionremover.settings.ITraceRemoverFilterSettings;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramFilter extends AbstractChromatogramFilterMSD {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessages(validate(chromatogramSelection, chromatogramFilterSettings));
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof ITraceRemoverFilterSettings traceRemoverFilterSettings) {
				List<IScanMSD> massSpectra = getMassSpectra(chromatogramSelection);
				ScanProcessor scanProcessor = new ScanProcessor();
				scanProcessor.apply(massSpectra, traceRemoverFilterSettings);
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Mass fragments have been removed successfully."));
				chromatogramSelection.getChromatogram().setDirty(true);
			} else {
				processingInfo.addErrorMessage(ITraceRemoverFilterSettings.DESCRIPTION, "The filter settings instance is not a type of: " + ITraceRemoverFilterSettings.class);
			}
		}
		return processingInfo;
	}

	private List<IScanMSD> getMassSpectra(IChromatogramSelectionMSD chromatogramSelection) {

		List<IScanMSD> massSpectra = new ArrayList<>();

		IChromatogramMSD chromatogram = chromatogramSelection.getChromatogram();
		int startScan = chromatogram.getScanNumber(chromatogramSelection.getStartRetentionTime());
		int stopScan = chromatogram.getScanNumber(chromatogramSelection.getStopRetentionTime());
		for(int scan = startScan; scan <= stopScan; scan++) {
			massSpectra.add(chromatogram.getScan(scan));
		}

		return massSpectra;
	}
}