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
package org.eclipse.chemclipse.xxd.filter.chromatogram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.supplier.IChromatogramSelectionProcessSupplier;
import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.supplier.AbstractProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.chromatogram.settings.DeleteScansByRangeFilterSettings;
import org.eclipse.chemclipse.xxd.filter.core.CoordinateEvaluator;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.eclipse.chemclipse.xxd.filter.model.RangeOption;
import org.eclipse.chemclipse.xxd.filter.peaks.DeletePeaksByRangeFilter;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.DeletePeaksByRangeFilterSettings;
import org.osgi.service.component.annotations.Component;

@Component(service = {IProcessTypeSupplier.class})
public class DeleteScansByRangeFilter implements IProcessTypeSupplier {

	private static final String ID = "org.eclipse.chemclipse.xxd.filter.chromatogram.deleteScansByRange";
	private static final String NAME = "Delete Scans By Range";
	private static final String DESCRIPTION = "Delete scans by the given range options.";

	@Override
	public String getCategory() {

		return ICategories.CHROMATOGRAM_FILTER;
	}

	@Override
	public Collection<IProcessSupplier<?>> getProcessorSuppliers() {

		return Collections.singleton(new ProcessSupplier(this));
	}

	private static final class ProcessSupplier extends AbstractProcessSupplier<DeleteScansByRangeFilterSettings> implements IChromatogramSelectionProcessSupplier<DeleteScansByRangeFilterSettings> {

		public ProcessSupplier(IProcessTypeSupplier parent) {

			super(ID, NAME, DESCRIPTION, DeleteScansByRangeFilterSettings.class, parent, DataCategory.CSD, DataCategory.MSD, DataCategory.VSD, DataCategory.WSD);
		}

		@Override
		public IChromatogramSelection apply(IChromatogramSelection chromatogramSelection, DeleteScansByRangeFilterSettings processSettings, ProcessExecutionContext context) throws InterruptedException {

			RangeOption rangeOption = processSettings.getRangeOption();
			CoordinateOption coordinateOption = processSettings.getCoordinateOption();
			double coordinateValue = processSettings.getCoordinateValue();
			/*
			 * Delete the peaks in that range
			 */
			DeletePeaksByRangeFilter deletePeaksByRangeFilter = new DeletePeaksByRangeFilter();
			DeletePeaksByRangeFilterSettings deletePeaksByRangeFilterSettings = new DeletePeaksByRangeFilterSettings();
			deletePeaksByRangeFilterSettings.setRangeOption(rangeOption);
			deletePeaksByRangeFilterSettings.setCoordinateOption(coordinateOption);
			deletePeaksByRangeFilterSettings.setCoordinateValue(coordinateValue);
			deletePeaksByRangeFilter.filterPeaks(chromatogramSelection, deletePeaksByRangeFilterSettings, context);
			/*
			 * Collect the scans
			 */
			List<IScan> scansToKeep = new ArrayList<>();
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			for(IScan scan : chromatogram.getScans()) {
				if(!CoordinateEvaluator.isMatchScan(scan, coordinateOption, rangeOption, coordinateValue)) {
					scansToKeep.add(scan);
				}
			}
			/*
			 * Modify
			 */
			chromatogram.replaceAllScans(scansToKeep);
			chromatogram.setDirty(true);
			chromatogramSelection.reset(false);

			return chromatogramSelection;
		}
	}
}