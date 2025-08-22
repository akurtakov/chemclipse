/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.impl;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.impl.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.filter.impl.settings.ScanTargetsToReferencesSettings;
import org.eclipse.chemclipse.chromatogram.filter.l10n.Messages;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.support.TargetTransferSupport;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ScanTargetsToReferencesFilter extends AbstractTransferFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof ScanTargetsToReferencesSettings settings) {
				transferTargets(chromatogramSelection, settings);
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, Messages.targetsTransferredSuccessfully));
			}
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		ScanTargetsToReferencesSettings settings = PreferenceSupplier.getScansToReferencesTransferSettings();
		return applyFilter(chromatogramSelection, settings, monitor);
	}

	private void transferTargets(IChromatogramSelection chromatogramSelection, ScanTargetsToReferencesSettings settings) {

		TargetTransferSupport targetTransferSupport = new TargetTransferSupport();
		List<IChromatogram> referencedChromatograms = chromatogramSelection.getChromatogram().getReferencedChromatograms();
		if(!referencedChromatograms.isEmpty()) {
			boolean useBestTargetOnly = settings.isUseBestTargetOnly();
			List<IScan> scansSource = extractIdentifiedScans(chromatogramSelection);
			for(IChromatogram referencedChromatogram : referencedChromatograms) {
				targetTransferSupport.transferScanTargets(scansSource, referencedChromatogram, useBestTargetOnly);
			}
		}
	}
}
