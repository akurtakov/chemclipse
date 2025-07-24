/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.peaks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.filter.IPeakFilter;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.core.CoordinateEvaluator;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.eclipse.chemclipse.xxd.filter.model.RangeOption;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.DeletePeaksByRangeFilterSettings;
import org.osgi.service.component.annotations.Component;

@Component(service = {IPeakFilter.class, Filter.class, Processor.class})
public class DeletePeaksByRangeFilter extends AbstractPeakFilter<DeletePeaksByRangeFilterSettings> {

	@Override
	public String getName() {

		return "Delete Peaks by Range";
	}

	@Override
	public String getDescription() {

		return "Delete peaks by the given coordinates.";
	}

	@Override
	public Class<DeletePeaksByRangeFilterSettings> getConfigClass() {

		return DeletePeaksByRangeFilterSettings.class;
	}

	@Override
	public void filterPeaks(IChromatogramSelection chromatogramSelection, DeletePeaksByRangeFilterSettings processSettings, ProcessExecutionContext context) throws IllegalArgumentException {

		RangeOption rangeOption = processSettings.getRangeOption();
		CoordinateOption coordinateOption = processSettings.getCoordinateOption();
		double coordinateValue = processSettings.getCoordinateValue();
		/*
		 * Collect the peaks
		 */
		List<IPeak> peaksToDelete = new ArrayList<>();
		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		for(IPeak peak : chromatogram.getPeaks()) {
			if(CoordinateEvaluator.isMatchPeak(peak, coordinateOption, rangeOption, coordinateValue)) {
				peaksToDelete.add(peak);
			}
		}
		/*
		 * Delete the peaks
		 */
		if(!peaksToDelete.isEmpty()) {
			deletePeaks(peaksToDelete, chromatogramSelection);
			resetPeakSelection(chromatogramSelection);
		}
	}
}