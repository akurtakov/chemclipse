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
package org.eclipse.chemclipse.xxd.filter.chromatogram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IChromatogramOverview;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.support.PeakSupport;
import org.eclipse.chemclipse.model.identifier.ComparisonResult;
import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.supplier.IChromatogramSelectionProcessSupplier;
import org.eclipse.chemclipse.model.support.LimitSupport;
import org.eclipse.chemclipse.model.support.RetentionIndexMap;
import org.eclipse.chemclipse.model.targets.TargetSupport;
import org.eclipse.chemclipse.processing.DataCategory;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.supplier.AbstractProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessSupplier;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.eclipse.chemclipse.processing.supplier.ProcessExecutionContext;
import org.eclipse.chemclipse.xxd.filter.chromatogram.settings.TargetTransferFilterSettings;
import org.eclipse.chemclipse.xxd.filter.core.PeakTransferCalculator;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.osgi.service.component.annotations.Component;

@Component(service = {IProcessTypeSupplier.class})
public class TargetTransferFilter implements IProcessTypeSupplier {

	private static final String ID = "org.eclipse.chemclipse.xxd.filter.chromatogram.peakTargetTransfer";
	private static final String NAME = "Target Transfer";
	private static final String DESCRIPTION = "Transfers the peak targets from the master to its references.";

	@Override
	public String getCategory() {

		return ICategories.PEAK_IDENTIFIER;
	}

	@Override
	public Collection<IProcessSupplier<?>> getProcessorSuppliers() {

		return Collections.singleton(new ProcessSupplier(this));
	}

	private static final class ProcessSupplier extends AbstractProcessSupplier<TargetTransferFilterSettings> implements IChromatogramSelectionProcessSupplier<TargetTransferFilterSettings> {

		public ProcessSupplier(IProcessTypeSupplier parent) {

			super(ID, NAME, DESCRIPTION, TargetTransferFilterSettings.class, parent, DataCategory.CSD, DataCategory.MSD, DataCategory.VSD, DataCategory.WSD);
		}

		@Override
		public IChromatogramSelection apply(IChromatogramSelection chromatogramSelection, TargetTransferFilterSettings processSettings, ProcessExecutionContext context) throws InterruptedException {

			PeakTransferCalculator peakTransferCalculator = new PeakTransferCalculator();

			CoordinateOption coordinateOption = processSettings.getCoordinateOption();
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			boolean useRetentionIndex = CoordinateOption.RETENTION_INDEX.equals(coordinateOption);
			RetentionIndexMap retentionIndexMap = useRetentionIndex ? new RetentionIndexMap(chromatogram) : null;
			int coordinateOffset = CoordinateOption.RETENTION_TIME_MIN.equals(coordinateOption) ? (int)Math.round(processSettings.getCoordinateOffset() * IChromatogramOverview.MINUTE_CORRELATION_FACTOR) : (int)Math.round(processSettings.getCoordinateOffset());

			List<? extends IPeak> peaks = peakTransferCalculator.getSourcePeaks(chromatogramSelection);

			List<IChromatogram> referenceChromatograms = chromatogram.getReferencedChromatograms();
			for(IChromatogram referenceChromatogram : referenceChromatograms) {
				for(IPeak peak : peaks) {
					if(!peak.getTargets().isEmpty()) {
						List<IPeak> overlappingsPeaks = peakTransferCalculator.getSinkPeaks(peak, coordinateOffset, retentionIndexMap, referenceChromatogram);
						if(!overlappingsPeaks.isEmpty()) {
							IPeak nearestPeak = PeakSupport.selectNearestPeak(overlappingsPeaks, peak, useRetentionIndex);
							if(nearestPeak != null) {
								if(LimitSupport.doIdentify(nearestPeak.getTargets(), processSettings.getLimitMatchFactor())) {
									/*
									 * Collect targets
									 */
									List<IIdentificationTarget> identificationTargets = new ArrayList<>();
									if(processSettings.isUseBestTargetOnly()) {
										identificationTargets.add(TargetSupport.getBestIdentificationTarget(peak));
									} else {
										identificationTargets.addAll(peak.getTargets());
									}
									/*
									 * Transfer to reference peak
									 */
									for(IIdentificationTarget identificationTarget : identificationTargets) {
										addIdentificationTarget(nearestPeak, identificationTarget, processSettings);
									}
								}
							}
						}
					}
				}
			}

			return chromatogramSelection;
		}

		private void addIdentificationTarget(IPeak peak, IIdentificationTarget identificationTarget, TargetTransferFilterSettings processSettings) {

			float matchFactor = processSettings.getMatchQuality();
			IComparisonResult comparisonResult = matchFactor > 0 ? new ComparisonResult(matchFactor) : identificationTarget.getComparisonResult();
			IdentificationTarget newIdentificationTarget = new IdentificationTarget(identificationTarget.getLibraryInformation(), comparisonResult, NAME);
			newIdentificationTarget.setVerified(identificationTarget.isVerified());
			peak.getTargets().add(newIdentificationTarget);
		}
	}
}