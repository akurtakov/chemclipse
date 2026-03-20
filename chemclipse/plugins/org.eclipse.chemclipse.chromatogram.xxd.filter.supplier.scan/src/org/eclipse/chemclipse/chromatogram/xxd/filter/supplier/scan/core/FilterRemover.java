/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.exceptions.FilterException;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model.ScanRemoverPattern;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsRemover;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class FilterRemover extends AbstractChromatogramFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsRemover settings) {
				ScanRemoverPattern scanRemoverPattern = new ScanRemoverPattern(settings.getScanRemoverPattern());
				applyScanRemoverFilter(chromatogramSelection, scanRemoverPattern, monitor);
				processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, "Scan Remover", "Scans have been removed successfully."));
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Scans have been removed successfully."));
				chromatogramSelection.getChromatogram().setDirty(true);
			}
		}
		return processingInfo;
	}

	/**
	 * Removes the given ions stored in the excludedIons
	 * instance from the chromatogram selection.
	 * 
	 * @param chromatogramSelection
	 * @throws FilterException
	 */
	private void applyScanRemoverFilter(IChromatogramSelection chromatogramSelection, ScanRemoverPattern scanRemoverPattern, IProgressMonitor monitor) {

		if(chromatogramSelection != null && scanRemoverPattern != null) {
			/*
			 * Range of interest.
			 */
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			int startRetentionTime = chromatogramSelection.getStartRetentionTime();
			int stopRetentionTime = chromatogramSelection.getStopRetentionTime();
			/*
			 * Iterate through all scans and mark scans to be preserved.
			 */
			List<IScan> scansToKeep = new ArrayList<>();
			for(IScan scan : chromatogram.getScans()) {
				if(scan.getRetentionTime() < startRetentionTime || scan.getRetentionTime() > stopRetentionTime) {
					scansToKeep.add(scan);
				} else if(!scanRemoverPattern.remove()) {
					scansToKeep.add(scan);
				}
			}

			chromatogram.replaceAllScans(scansToKeep);
			chromatogram.recalculateScanNumbers();
			chromatogramSelection.reset();
		}
	}
}
