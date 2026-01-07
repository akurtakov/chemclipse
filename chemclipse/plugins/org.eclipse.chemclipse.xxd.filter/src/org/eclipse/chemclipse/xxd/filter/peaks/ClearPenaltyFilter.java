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
package org.eclipse.chemclipse.xxd.filter.peaks;

import java.util.Collection;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.filter.IPeakFilter;
import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.PenaltyClearFilterSettings;
import org.eclipse.core.runtime.SubMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {IPeakFilter.class, Filter.class, Processor.class})
public class ClearPenaltyFilter extends AbstractPeakFilter<PenaltyClearFilterSettings> {

	@Override
	public String getName() {

		return "Penalties (Clear)";
	}

	@Override
	public String getDescription() {

		return "Clears all calculated penalties from the target comparison results.";
	}

	@Override
	public Class<PenaltyClearFilterSettings> getConfigClass() {

		return PenaltyClearFilterSettings.class;
	}

	@Override
	public void filterPeaks(IChromatogramSelection chromatogramSelection, PenaltyClearFilterSettings configuration, ProcessExecutionContext context) throws IllegalArgumentException {

		Collection<IPeak> peaks = getReadOnlyPeaks(chromatogramSelection);

		SubMonitor subMonitor = SubMonitor.convert(context.getProgressMonitor(), peaks.size());
		for(IPeak peak : peaks) {
			Set<IIdentificationTarget> identificationTargets = peak.getTargets();
			for(IIdentificationTarget identificationTarget : identificationTargets) {
				IComparisonResult comparisonResult = identificationTarget.getComparisonResult();
				comparisonResult.clearPenalty();
			}
			subMonitor.worked(1);
		}
	}
}
