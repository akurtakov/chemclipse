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
 * Philip Wenig - improvement update process
 * Matthias Mailänder - undoable
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.filter.peaks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.filter.IPeakFilter;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.Processor;
import org.eclipse.chemclipse.processing.filter.Filter;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.peaks.settings.DeletePeaksFilterSettings;
import org.eclipse.chemclipse.xxd.filter.support.DeletePeakOption;
import org.eclipse.core.runtime.SubMonitor;
import org.osgi.service.component.annotations.Component;

@Component(service = {IPeakFilter.class, Filter.class, Processor.class})
public class DeletePeaksFilter extends AbstractPeakFilter<DeletePeaksFilterSettings> {

	@Override
	public String getName() {

		return "Delete Peaks";
	}

	@Override
	public Class<DeletePeaksFilterSettings> getConfigClass() {

		return DeletePeaksFilterSettings.class;
	}

	@Override
	public void filterPeaks(IChromatogramSelection chromatogramSelection, DeletePeaksFilterSettings configuration, ProcessExecutionContext context) throws IllegalArgumentException {

		/*
		 * Settings
		 */
		Collection<IPeak> peaks = getReadOnlyPeaks(chromatogramSelection);
		if(configuration == null) {
			configuration = createConfiguration(peaks);
		}

		DeletePeakOption deletePeakOption = configuration.getDeletePeakOption();
		if(!DeletePeakOption.NONE.equals(deletePeakOption)) {
			/*
			 * Delete the peaks.
			 */
			SubMonitor subMonitor = SubMonitor.convert(context.getProgressMonitor(), peaks.size());
			List<IPeak> peaksToDelete = new ArrayList<>();
			if(DeletePeakOption.ALL.equals(deletePeakOption)) {
				peaksToDelete.addAll(peaks);
				subMonitor.worked(peaks.size());
			} else {
				/*
				 * Specific cases.
				 */
				switch(deletePeakOption) {
					case UNIDENTIFIED:
						for(IPeak peak : peaks) {
							Set<IIdentificationTarget> targets = peak.getTargets();
							if(targets.isEmpty()) {
								peaksToDelete.add(peak);
							} else {
								/*
								 * It needs at least one target with name to
								 * assume that the peak is identified.
								 */
								boolean isBlank = true;
								exitloop:
								for(IIdentificationTarget target : targets) {
									if(!target.getLibraryInformation().getName().isBlank()) {
										isBlank = false;
										break exitloop;
									}
								}
								/*
								 * White space is used as a placeholder to
								 * edit dynamically sometimes.
								 */
								if(isBlank) {
									peaksToDelete.add(peak);
								}
							}
							subMonitor.worked(1);
						}
						break;
					case ACTIVE:
						for(IPeak peak : peaks) {
							if(peak.isActiveForAnalysis()) {
								peaksToDelete.add(peak);
							}
							subMonitor.worked(1);
						}
						break;
					case INACTIVE:
						for(IPeak peak : peaks) {
							if(!peak.isActiveForAnalysis()) {
								peaksToDelete.add(peak);
							}
							subMonitor.worked(1);
						}
						break;
					default:
						/*
						 * Cases handled already before.
						 */
						break;
				}
			}

			deletePeaks(peaksToDelete, chromatogramSelection);
			resetPeakSelection(chromatogramSelection);
		}
	}

	@Override
	public List<String> getLegacyIDs() {

		List<String> legacyIDs = new ArrayList<>();
		legacyIDs.add("PeakFilter:filter:processor:class:org.eclipse.chemclipse.xxd.model.filter.peaks.DeletePeaksFilter");
		return legacyIDs;
	}
}