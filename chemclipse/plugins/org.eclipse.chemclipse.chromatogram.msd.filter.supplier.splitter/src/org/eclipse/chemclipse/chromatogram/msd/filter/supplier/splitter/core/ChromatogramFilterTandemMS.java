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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram.AbstractChromatogramFilterMSD;
import org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.settings.FilterSettingsTandemMS;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.support.HeaderField;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.support.CondenseOption;
import org.eclipse.chemclipse.msd.model.support.TandemDataSupport;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.support.traces.TraceFactory;
import org.eclipse.chemclipse.support.traces.TraceTandemMSD;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramFilterTandemMS extends AbstractChromatogramFilterMSD {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> validation = validate(chromatogramSelection, chromatogramFilterSettings);
		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessages(validation);

		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof FilterSettingsTandemMS filterSettings) {
				IChromatogram chromatogram = chromatogramSelection.getChromatogram();
				if(chromatogram instanceof IChromatogramMSD chromatogramMSD) {
					/*
					 * Split selected traces.
					 */
					Set<TraceTandemMSD> specificTraces = getSpecificTraces(filterSettings);
					if(!specificTraces.isEmpty()) {
						HeaderField headerField = filterSettings.getHeaderField();
						CondenseOption condenseOption = filterSettings.getCondenseOption();
						boolean enforceFullTimeRange = filterSettings.isEnforceFullTimeRange();
						boolean separateTraces = filterSettings.isSeparateTraces();
						List<IChromatogramMSD> chromatograms = TandemDataSupport.extractTandemData(chromatogramMSD, headerField, condenseOption, enforceFullTimeRange, specificTraces, separateTraces);
						for(IChromatogramMSD chromatogramReferenceMSD : chromatograms) {
							chromatogramMSD.addReferencedChromatogram(chromatogramReferenceMSD);
						}
					}
					/*
					 * Result
					 */
					chromatogramSelection.getChromatogram().setDirty(true);
					processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "The chromatogram was splitted into MS/MS reference chromatograms."));
				}
			} else {
				processingInfo.addWarnMessage("Splitter (MS/MS)", "The filter settings are not of type: " + FilterSettingsTandemMS.class);
			}
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IProgressMonitor monitor) {

		FilterSettingsTandemMS splitterSettings = new FilterSettingsTandemMS();
		return applyFilter(chromatogramSelection, splitterSettings, monitor);
	}

	private Set<TraceTandemMSD> getSpecificTraces(FilterSettingsTandemMS filterSettingsTandemMS) {

		Set<TraceTandemMSD> specificTransitions = new HashSet<>();
		String content = filterSettingsTandemMS.getSpecificTraces();
		for(TraceTandemMSD traceTandemMSD : TraceFactory.parseTraces(content, TraceTandemMSD.class)) {
			specificTransitions.add(traceTandemMSD);
		}

		return specificTransitions;
	}
}