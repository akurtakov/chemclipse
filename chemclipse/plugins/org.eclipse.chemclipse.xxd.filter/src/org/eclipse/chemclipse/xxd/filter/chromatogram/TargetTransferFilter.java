/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IScan;
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

			CoordinateOption coordinateOption = processSettings.getCoordinateOption();
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			boolean useRetentionIndex = CoordinateOption.RETENTION_INDEX.equals(coordinateOption);
			RetentionIndexMap retentionIndexMap = useRetentionIndex ? new RetentionIndexMap(chromatogram) : null;
			int coordinateOffset = CoordinateOption.RETENTION_TIME_MIN.equals(coordinateOption) ? (int)Math.round(processSettings.getCoordinateOffset() * IChromatogramOverview.MINUTE_CORRELATION_FACTOR) : (int)Math.round(processSettings.getCoordinateOffset());
			int startRetentionTime = chromatogramSelection.getStartRetentionTime();
			int stopRetentionTime = chromatogramSelection.getStopRetentionTime();
			List<? extends IPeak> peaks = chromatogram.getPeaks(startRetentionTime, stopRetentionTime);

			List<IChromatogram> referenceChromatograms = chromatogram.getReferencedChromatograms();
			for(IChromatogram referenceChromatogram : referenceChromatograms) {
				for(IPeak peak : peaks) {
					if(!peak.getTargets().isEmpty()) {
						List<IPeak> overlappingsPeaks = getOverlappingPeaks(peak, coordinateOffset, retentionIndexMap, referenceChromatogram);
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

		private List<IPeak> getOverlappingPeaks(IPeak peak, int coordinateOffset, RetentionIndexMap retentionIndexMap, IChromatogram referenceChromatogram) {

			List<IPeak> peaks = new ArrayList<>();

			boolean useRetentionIndex = retentionIndexMap != null;
			IPeakModel peakModel = peak.getPeakModel();
			int coordinateStart = peakModel.getStartRetentionTime();
			int coordinateStop = peakModel.getStopRetentionTime();
			if(useRetentionIndex) {
				coordinateStart = Math.round(retentionIndexMap.getRetentionIndex(coordinateStart));
				coordinateStop = Math.round(retentionIndexMap.getRetentionIndex(coordinateStop));
			}
			/*
			 * Offset
			 */
			coordinateStart += coordinateOffset;
			coordinateStop += coordinateOffset;
			/*
			 * Select Peaks
			 */
			for(IPeak referencePeak : referenceChromatogram.getPeaks()) {
				IPeakModel referencePeakModel = referencePeak.getPeakModel();
				IScan referencePeakMaximum = referencePeakModel.getPeakMaximum();
				int peakValue = useRetentionIndex ? Math.round(referencePeakMaximum.getRetentionIndex()) : referencePeakMaximum.getRetentionTime();
				if(peakValue >= coordinateStart && peakValue <= coordinateStop) {
					peaks.add(referencePeak);
				}
			}

			return peaks;
		}
	}
}