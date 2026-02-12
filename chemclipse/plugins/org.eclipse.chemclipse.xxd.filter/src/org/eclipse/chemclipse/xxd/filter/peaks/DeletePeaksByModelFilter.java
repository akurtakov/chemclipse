/*******************************************************************************
 * Copyright (c) 2024, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.filter.IPeakFilter;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.DeletePeaksByModelFilterSettings;
import org.osgi.service.component.annotations.Component;

@Component(service = {IPeakFilter.class, Filter.class, Processor.class})
public class DeletePeaksByModelFilter extends AbstractPeakFilter<DeletePeaksByModelFilterSettings> {

	@Override
	public String getName() {

		return "Delete Peaks by Model";
	}

	@Override
	public String getDescription() {

		return "Filter by internal peak model.";
	}

	@Override
	public Class<DeletePeaksByModelFilterSettings> getConfigClass() {

		return DeletePeaksByModelFilterSettings.class;
	}

	@Override
	public void filterPeaks(IChromatogramSelection chromatogramSelection, DeletePeaksByModelFilterSettings configuration, ProcessExecutionContext context) throws IllegalArgumentException {

		PeakModelOption peakModelOption = configuration.getPeakModelOption();
		List<IPeak> peaksToDelete = new ArrayList<>();
		/*
		 * Collect the peaks
		 */
		IChromatogram chromatogram = chromatogramSelection.getChromatogram();
		for(IPeak peak : chromatogram.getPeaks(chromatogramSelection)) {
			IPeakModel peakModel = peak.getPeakModel();
			switch(peakModelOption) {
				case STRICT:
					if(peakModel.isStrictModel()) {
						peaksToDelete.add(peak);
					}
					break;
				default:
					/*
					 * NON-STRICT
					 */
					if(!peakModel.isStrictModel()) {
						peaksToDelete.add(peak);
					}
					break;
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

	@Override
	public List<String> getLegacyIDs() {

		List<String> legacyIDs = new ArrayList<>();
		legacyIDs.add("PeakFilter:filter:processor:class:org.eclipse.chemclipse.xxd.model.filter.peaks.DeletePeaksByModelFilter");
		return legacyIDs;
	}
}
