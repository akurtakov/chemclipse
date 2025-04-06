/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.core;

import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.AbstractChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.exceptions.FilterException;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsDelayInterval;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsDuplicator;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsRemover;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsScanDensity;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.selection.ChromatogramSelection;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class FilterScanDensity extends AbstractChromatogramFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			try {
				if(chromatogramFilterSettings instanceof FilterSettingsScanDensity settings) {
					if(chromatogramSelection != null) {
						applyScanDensityFilter(chromatogramSelection, settings, monitor);
						if(settings.isProcessReferencedChromatograms()) {
							IChromatogram chromatogram = chromatogramSelection.getChromatogram();
							for(IChromatogram chromatogramReference : chromatogram.getReferencedChromatograms()) {
								ChromatogramSelection chromatogramSelectionReference = new ChromatogramSelection(chromatogramReference);
								applyScanDensityFilter(chromatogramSelectionReference, settings, monitor);
							}
						}
						processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, "Scan Density", "The chromatogram has been modified to reach the target scan density."));
						processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Scan density calculated successfully."));
						chromatogramSelection.getChromatogram().setDirty(true);
					}
				}
			} catch(FilterException e) {
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.EXCEPTION, e.getMessage()));
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		FilterSettingsScanDensity filterSettings = new FilterSettingsScanDensity();
		return applyFilter(chromatogramSelection, filterSettings, monitor);
	}

	private void applyScanDensityFilter(IChromatogramSelection chromatogramSelection, FilterSettingsScanDensity settings, IProgressMonitor monitor) throws FilterException {

		/*
		 * Complete chromatogram
		 */
		int scanIntervalTarget = Math.round(1000.0f / settings.getScansPerSecond());
		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		int scanIntervalCurrent = chromatogram.getScanInterval();
		float factor = scanIntervalCurrent / (scanIntervalTarget * 1.0f);
		boolean recalculate = true;
		/*
		 * Factor = 1 - no change
		 */
		if(factor == 1) {
			recalculate = false;
		} else if(factor > 1) {
			/*
			 * Duplicate Scans
			 */
			int duplication = 2;
			FilterDuplicator filterDuplicator = new FilterDuplicator();
			FilterSettingsDuplicator filterSettingsDuplicator = new FilterSettingsDuplicator();
			filterSettingsDuplicator.setMergeScans(true);
			while(duplication <= factor) {
				filterDuplicator.applyFilter(chromatogramSelection, filterSettingsDuplicator, monitor);
				duplication *= 2;
			}

		} else if(factor < 1) {
			/*
			 * Remove Scans
			 */
			factor = 1.0f / factor;
			int reduction = 2;
			FilterRemover filterRemover = new FilterRemover();
			FilterSettingsRemover filterSettingsRemover = new FilterSettingsRemover();
			filterSettingsRemover.setScanRemoverPattern("XO");
			while(reduction <= factor) {
				filterRemover.applyFilter(chromatogramSelection, filterSettingsRemover, monitor);
				reduction *= 2;
			}
		}

		if(recalculate) {
			chromatogram.recalculateScanNumbers();
			FilterDelayInterval filterDelayInterval = new FilterDelayInterval();
			FilterSettingsDelayInterval filterSettingsDelayInterval = new FilterSettingsDelayInterval();
			filterSettingsDelayInterval.setResetRetentionTimes(false);
			filterDelayInterval.applyFilter(chromatogramSelection, filterSettingsDelayInterval, monitor);
			chromatogramSelection.reset();
		}
	}
}
