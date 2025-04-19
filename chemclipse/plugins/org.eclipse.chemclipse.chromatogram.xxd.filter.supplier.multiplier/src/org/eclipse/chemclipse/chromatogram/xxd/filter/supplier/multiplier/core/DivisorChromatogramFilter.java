/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.core;

import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.exceptions.FilterException;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.settings.DivisorSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class DivisorChromatogramFilter extends ModifierChromatogramFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof DivisorSettings filterSettings) {
				try {
					float divisor = filterSettings.getDivisor();
					applyFilter(chromatogramSelection, divisor, false);
					chromatogramSelection.getChromatogram().setDirty(true);
					processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "The chromatogram selection was successfully normalized."));
				} catch(FilterException e) {
					processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.EXCEPTION, e.getMessage()));
				}
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		DivisorSettings filterSettings = PreferenceSupplier.getFilterSettingsDivisor();
		return applyFilter(chromatogramSelection, filterSettings, monitor);
	}
}
