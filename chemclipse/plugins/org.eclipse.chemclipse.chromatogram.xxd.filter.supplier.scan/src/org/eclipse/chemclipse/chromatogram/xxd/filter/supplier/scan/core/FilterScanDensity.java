/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.AbstractChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.calculator.ScanProcessor;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsScanDensity;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.ChromatogramSelection;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.support.ChromatogramSupport;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class FilterScanDensity extends AbstractChromatogramFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsScanDensity settings) {
				if(chromatogramSelection != null) {
					applyScanDensityFilter(chromatogramSelection, settings);
					if(settings.isProcessReferencedChromatograms()) {
						IChromatogram chromatogram = chromatogramSelection.getChromatogram();
						for(IChromatogram chromatogramReference : chromatogram.getReferencedChromatograms()) {
							ChromatogramSelection chromatogramSelectionReference = new ChromatogramSelection(chromatogramReference);
							applyScanDensityFilter(chromatogramSelectionReference, settings);
						}
					}
					processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, "Scan Density", "The chromatogram has been modified to reach the target scan density."));
					processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Scan density calculated successfully."));
					chromatogramSelection.getChromatogram().setDirty(true);
				}
			}
		}
		return processingInfo;
	}

	private void applyScanDensityFilter(IChromatogramSelection chromatogramSelection, FilterSettingsScanDensity settings) {

		int scanIntervalTarget = Math.round(1000.0f / settings.getScansPerSecond());
		if(scanIntervalTarget > 0) {
			/*
			 * Factor = 1 - no change
			 */
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			ChromatogramSupport.calculateScanIntervalAndDelay(chromatogram);
			int scanIntervalCurrent = chromatogram.getScanInterval();
			if(scanIntervalCurrent != scanIntervalTarget) {
				ScanProcessor scanProcessor = new ScanProcessor();
				List<IScan> scans = scanProcessor.recalculateScans(chromatogram, scanIntervalTarget, settings.isMergeScans());
				for(IScan scan : scans) {
					if(scan instanceof IScanMSD scanMSD) {
						/*
						 * Remove traces with 0 intensity.
						 */
						List<IIon> ions = new ArrayList<>(scanMSD.getIons());
						for(IIon ion : ions) {
							float abundance = ion.getAbundance();
							if(abundance == 0) {
								scanMSD.removeIon(ion);
							}
						}
					}
				}
				chromatogram.replaceAllScans(scans);
				ChromatogramSupport.calculateScanIntervalAndDelay(chromatogram);
				ChromatogramSupport.resetCycleNumber(chromatogram);
				chromatogramSelection.reset();
			}
		}
	}
}