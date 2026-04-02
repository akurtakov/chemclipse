/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsScanClipper;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public class FilterScanClipper extends AbstractChromatogramFilter {

	private static final String DESCRIPTION = "Scan Clipper";

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsScanClipper settings) {
				/*
				 * Run
				 */
				applyScanClipperFilter(chromatogramSelection, settings.getScanNumberPattern());
				/*
				 * Result
				 */
				String message = "Scans have been clipped successfully.";
				processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, DESCRIPTION, message));
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, message));
				chromatogramSelection.getChromatogram().setDirty(true);
			}
		}

		return processingInfo;
	}

	private void applyScanClipperFilter(IChromatogramSelection chromatogramSelection, String scanNumberPattern) {

		if(chromatogramSelection != null && scanNumberPattern != null) {
			/*
			 * Scans to be removed
			 */
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			List<Integer> scanNumbers = extractScanNumbers(scanNumberPattern);
			int offset = 0;
			for(int scanNumber : scanNumbers) {
				int scanNumberEffective = scanNumber - offset;
				if(scanNumberEffective > 0 && scanNumberEffective <= chromatogram.getNumberOfScans()) {
					chromatogram.removeScan(scanNumberEffective);
					offset++;
				}
			}
			/*
			 * Reset numbers
			 */
			chromatogram.recalculateScanNumbers();
			chromatogramSelection.reset();
		}
	}

	private List<Integer> extractScanNumbers(String scanNumberPattern) {

		List<Integer> scanNumbers = new ArrayList<>();
		for(String value : scanNumberPattern.split(" ")) {
			try {
				scanNumbers.add(Integer.parseInt(value.trim()));
			} catch(NumberFormatException e) {
			}
		}

		return scanNumbers;
	}
}
