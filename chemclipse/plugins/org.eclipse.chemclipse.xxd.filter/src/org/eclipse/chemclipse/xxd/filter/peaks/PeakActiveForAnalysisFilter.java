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
package org.eclipse.chemclipse.xxd.filter.peaks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.filter.IPeakFilter;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.PeakActiveForAnalysisSettings;
import org.eclipse.core.runtime.SubMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {IPeakFilter.class, Filter.class, Processor.class})
public class PeakActiveForAnalysisFilter extends AbstractPeakFilter<PeakActiveForAnalysisSettings> {

	@Override
	public String getName() {

		return "Activate/Deactivate for Analysis";
	}

	@Override
	public String getDescription() {

		return "Sets the active for analysis status for all peaks.";
	}

	@Override
	public Class<PeakActiveForAnalysisSettings> getConfigClass() {

		return PeakActiveForAnalysisSettings.class;
	}

	@Override
	public void filterPeaks(IChromatogramSelection chromatogramSelection, PeakActiveForAnalysisSettings configuration, ProcessExecutionContext context) throws IllegalArgumentException {

		Collection<IPeak> peaks = getReadOnlyPeaks(chromatogramSelection);
		if(configuration == null) {
			configuration = createConfiguration(peaks);
		}
		SubMonitor subMonitor = SubMonitor.convert(context.getProgressMonitor(), peaks.size());
		boolean activeForAnalysis = configuration.isActiveForAnalysis();
		for(IPeak peak : peaks) {
			peak.setActiveForAnalysis(activeForAnalysis);
			subMonitor.worked(1);
		}
		subMonitor.done();
	}

	@Override
	public List<String> getLegacyIDs() {

		List<String> legacyIDs = new ArrayList<>();
		legacyIDs.add("PeakFilter:filter:processor:class:org.eclipse.chemclipse.xxd.model.filter.peaks.PeakActiveForAnalysisFilter");
		return legacyIDs;
	}
}
