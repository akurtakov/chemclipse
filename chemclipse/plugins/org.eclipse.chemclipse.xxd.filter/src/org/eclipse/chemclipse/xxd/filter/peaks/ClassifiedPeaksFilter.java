/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - refactorings
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.filter.peaks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.filter.IPeakFilter;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.ClassifiedPeaksFilterSettings;
import org.eclipse.core.runtime.SubMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {IPeakFilter.class, Filter.class, Processor.class})
public class ClassifiedPeaksFilter extends AbstractPeakFilter<ClassifiedPeaksFilterSettings> {

	@Override
	public String getName() {

		return "Activate/Deactivate by Classification";
	}

	@Override
	public String getDescription() {

		return "Sets the active for analysis status for peaks with a given classification";
	}

	@Override
	public Class<ClassifiedPeaksFilterSettings> getConfigClass() {

		return ClassifiedPeaksFilterSettings.class;
	}

	@Override
	public void filterPeaks(IChromatogramSelection chromatogramSelection, ClassifiedPeaksFilterSettings configuration, ProcessExecutionContext context) throws IllegalArgumentException {

		Collection<IPeak> peaks = getReadOnlyPeaks(chromatogramSelection);
		if(configuration == null) {
			configuration = createConfiguration(peaks);
		}

		Set<String> classifications = configuration.getClassificationSet();
		boolean activeForAnalysis = configuration.isActiveForAnalysis();

		SubMonitor subMonitor = SubMonitor.convert(context.getProgressMonitor(), peaks.size());
		for(IPeak peak : peaks) {
			Collection<String> classifier = peak.getClassifiers();
			for(String classification : classifications) {
				if(classifier.contains(classification)) {
					peak.setActiveForAnalysis(activeForAnalysis);
					break;
				}
			}
			subMonitor.worked(1);
		}
		subMonitor.done();
	}

	@Override
	public List<String> getLegacyIDs() {

		List<String> legacyIDs = new ArrayList<>();
		legacyIDs.add("PeakFilter:filter:processor:class:org.eclipse.chemclipse.xxd.model.filter.peaks.ClassifiedPeaksFilter");
		return legacyIDs;
	}
}
