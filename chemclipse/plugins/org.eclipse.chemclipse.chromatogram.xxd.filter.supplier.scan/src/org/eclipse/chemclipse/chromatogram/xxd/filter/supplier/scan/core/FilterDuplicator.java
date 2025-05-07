/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.core;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.AbstractChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.calculator.ScanProcessor;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsDelayInterval;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsDuplicator;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class FilterDuplicator extends AbstractChromatogramFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsDuplicator settings) {
				applyScanDuplicatorFilter(chromatogramSelection, settings, monitor);
				processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, "Scan Duplicator", "Scans have been duplicated successfully."));
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Scans have been duplicated successfully."));
				chromatogramSelection.getChromatogram().setDirty(true);
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		FilterSettingsDuplicator filterSettings = PreferenceSupplier.getDuplicatorFilterSettings();
		return applyFilter(chromatogramSelection, filterSettings, monitor);
	}

	private void applyScanDuplicatorFilter(IChromatogramSelection chromatogramSelection, FilterSettingsDuplicator settings, IProgressMonitor monitor) {

		if(chromatogramSelection != null) {
			/*
			 * The complete range of the chromatogram must be processed.
			 */
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			ScanProcessor scanProcessor = new ScanProcessor();
			List<IScan> scansToReplace = scanProcessor.increaseScansDensity(chromatogram, 1, settings.isMergeScans());
			chromatogram.replaceAllScans(scansToReplace);
			/*
			 * Don't recalculate the retention times
			 */
			chromatogram.recalculateScanNumbers();
			FilterDelayInterval filterDelayInterval = new FilterDelayInterval();
			FilterSettingsDelayInterval filterSettingsDelayInterval = new FilterSettingsDelayInterval();
			filterSettingsDelayInterval.setResetRetentionTimes(false);
			filterDelayInterval.applyFilter(chromatogramSelection, filterSettingsDelayInterval, monitor);
			chromatogramSelection.reset();
		}
	}
}