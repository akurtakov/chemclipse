/*******************************************************************************
 * Copyright (c) 2022, 2026 Lablicate GmbH.
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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.chemclipse.chromatogram.filter.core.chromatogram.AbstractChromatogramFilter;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model.RetentionIndexOption;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings.FilterSettingsRetentionIndexSelector;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.identifier.IColumnIndexMarker;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.support.ColumnIndexSupport;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.chemclipse.support.model.SeparationColumnType;
import org.eclipse.core.runtime.IProgressMonitor;

public class FilterRetentionIndexSelector extends AbstractChromatogramFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsRetentionIndexSelector settings) {
				selectRetentionIndices(chromatogramSelection, settings);
				processingInfo.addMessage(new ProcessingMessage(MessageType.INFO, "Select Retention Index", "The retention indices have been selected successfully."));
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "Retention Index selection was successful."));
				chromatogramSelection.getChromatogram().setDirty(true);
			}
		}
		return processingInfo;
	}

	private void selectRetentionIndices(IChromatogramSelection chromatogramSelection, FilterSettingsRetentionIndexSelector settings) {

		String searchColumn = settings.getSearchColumn();
		if(!searchColumn.isEmpty()) {
			adjustSearchColumn(chromatogramSelection, settings);
			assignRetentionIndexScans(chromatogramSelection, settings);
			assignRetentionIndexPeaks(chromatogramSelection, settings);
		}
	}

	private void adjustSearchColumn(IChromatogramSelection chromatogramSelection, FilterSettingsRetentionIndexSelector settings) {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		if(ColumnIndexSupport.COLUMN_TYPE_CHROMATOGRAM.equals(settings.getSearchColumn())) {
			settings.setSearchColumn(chromatogram.getSeparationColumnIndices().getSeparationColumn().getSeparationColumnType().label());
		}
	}

	private void assignRetentionIndexScans(IChromatogramSelection chromatogramSelection, FilterSettingsRetentionIndexSelector settings) {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		int startScan = chromatogram.getScanNumber(chromatogramSelection.getStartRetentionTime());
		int stopScan = chromatogram.getScanNumber(chromatogramSelection.getStopRetentionTime());
		for(int i = startScan; i <= stopScan; i++) {
			IScan scan = chromatogram.getScan(i);
			if(!scan.getTargets().isEmpty()) {
				selectColumnRetentionIndex(scan, settings);
			}
		}
	}

	private void assignRetentionIndexPeaks(IChromatogramSelection chromatogramSelection, FilterSettingsRetentionIndexSelector settings) {

		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		List<? extends IPeak> peaks = chromatogram.getPeaks(chromatogramSelection.getStartRetentionTime(), chromatogramSelection.getStopRetentionTime());
		for(IPeak peak : peaks) {
			selectColumnRetentionIndex(peak.getPeakModel().getPeakMaximum(), settings);
		}
	}

	private void selectColumnRetentionIndex(IScan scan, FilterSettingsRetentionIndexSelector settings) {

		float retentionIndexTarget = scan.getRetentionIndex();
		String searchColumn = settings.getSearchColumn();
		boolean caseSensitive = settings.isCaseSensitive();
		boolean removeWhiteSpace = settings.isRemoveWhiteSpace();
		boolean matchPartly = settings.isMatchPartly();
		SeparationColumnType separationColumnTypeFallback = settings.getSeparationColumnTypeFallback();
		RetentionIndexOption retentionIndexOption = settings.getRetentionIndexOption();
		boolean deleteUnrelatedIndices = settings.isDeleteUnrelatedIndices();

		Set<IIdentificationTarget> identificationTargets = scan.getTargets();
		for(IIdentificationTarget identificationTarget : identificationTargets) {
			ILibraryInformation libraryInformation = identificationTarget.getLibraryInformation();
			List<IColumnIndexMarker> columnIndexMarkers = ColumnIndexSupport.getColumnIndexMarker(libraryInformation.getColumnIndexMarkers(), searchColumn, caseSensitive, removeWhiteSpace, matchPartly, separationColumnTypeFallback);
			float retentionIndex = 0.0f;
			if(!columnIndexMarkers.isEmpty()) {
				Collections.sort(columnIndexMarkers, (c1, c2) -> Float.compare(c1.getRetentionIndex(), c2.getRetentionIndex()));
				switch(retentionIndexOption) {
					case MIN:
						retentionIndex = columnIndexMarkers.get(0).getRetentionIndex();
						break;
					case MAX:
						retentionIndex = columnIndexMarkers.get(columnIndexMarkers.size() - 1).getRetentionIndex();
						break;
					case MEAN:
					case MEDIAN:
						DescriptiveStatistics descriptiveStatistics = createDescriptiveStatistics(columnIndexMarkers);
						double retentionIndexCalculated = RetentionIndexOption.MEAN.equals(retentionIndexOption) ? descriptiveStatistics.getMean() : descriptiveStatistics.getPercentile(50);
						retentionIndex = Math.round(retentionIndexCalculated);
						break;
					default:
						/*
						 * BEST
						 */
						float deltaReference = Float.MAX_VALUE;
						for(IColumnIndexMarker columnIndexMarker : columnIndexMarkers) {
							float delta = Math.abs(retentionIndexTarget - columnIndexMarker.getRetentionIndex());
							if(delta < deltaReference) {
								retentionIndex = columnIndexMarker.getRetentionIndex();
								deltaReference = delta;
							}
						}
						break;
				}
				/*
				 * Remove Entries
				 */
				if(deleteUnrelatedIndices) {
					Set<IColumnIndexMarker> columnIndexMarkerSet = new HashSet<>(libraryInformation.getColumnIndexMarkers());
					columnIndexMarkerSet.removeAll(columnIndexMarkers);
					for(IColumnIndexMarker columnIndexMarker : columnIndexMarkerSet) {
						libraryInformation.delete(columnIndexMarker);
					}
				}
			}
			/*
			 * Assign the retention index.
			 */
			libraryInformation.setRetentionIndex(retentionIndex);
		}
	}

	private DescriptiveStatistics createDescriptiveStatistics(List<IColumnIndexMarker> columnIndexMarkers) {

		DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
		for(IColumnIndexMarker columnIndexMarker : columnIndexMarkers) {
			descriptiveStatistics.addValue(columnIndexMarker.getRetentionIndex());
		}

		return descriptiveStatistics;
	}
}