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
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.zeroset.core;

import org.eclipse.chemclipse.chromatogram.csd.filter.core.chromatogram.AbstractChromatogramFilterCSD;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.csd.model.core.selection.IChromatogramSelectionCSD;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramFilterCSD extends AbstractChromatogramFilterCSD {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionCSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			applyFilter(chromatogramSelection);
			chromatogramSelection.getChromatogram().setDirty(true);
			processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "The chromatogram selection was successfully set to zero"));
		}
		return processingInfo;
	}

	private void applyFilter(IChromatogramSelectionCSD chromatogramSelection) {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		float minSignal = chromatogram.getMinSignal();
		if(minSignal < 0) {
			float delta = minSignal * -1;
			for(IScan scan : chromatogram.getScans()) {
				float adjustedIntensity = scan.getTotalSignal() + delta;
				scan.adjustTotalSignal(adjustedIntensity);
			}
			chromatogram.setDirty(true);
		}
	}
}
