/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.filter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.chemclipse.chromatogram.filter.impl.settings.ScanTargetsToPeakSettings;
import org.eclipse.chemclipse.chromatogram.filter.internal.model.IdentifiedScan;
import org.eclipse.chemclipse.chromatogram.filter.internal.model.ScanPeakPair;
import org.eclipse.chemclipse.chromatogram.filter.l10n.Messages;
import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.model.comparator.IdentificationTargetComparator;
import org.eclipse.chemclipse.model.core.IPeak;
import org.eclipse.chemclipse.model.core.IPeakModel;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.identifier.ComparisonResult;
import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.identifier.LibraryInformation;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ScanTargetsToPeakFilter extends AbstractTransferFilter {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelection chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = validate(chromatogramSelection, chromatogramFilterSettings);
		if(!processingInfo.hasErrorMessages()) {
			if(chromatogramFilterSettings instanceof ScanTargetsToPeakSettings settings) {
				transferScanTargets(chromatogramSelection, settings);
				processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, Messages.targetsTransferredSuccessfully));
			}
		}

		return processingInfo;
	}

	private void transferScanTargets(IChromatogramSelection chromatogramSelection, ScanTargetsToPeakSettings settings) {

		boolean transferClosestScan = settings.isTransferClosestScan();
		Map<IdentifiedScan, List<ScanPeakPair>> scanPeakPairMap = createScanPeakPairMap(chromatogramSelection, transferClosestScan);
		assignScanTargets(scanPeakPairMap, transferClosestScan, settings.isUseBestTargetOnly());
		if(settings.isDeleteAssignedScanIdentifications()) {
			deleteAssignedScanIdentifications(scanPeakPairMap.keySet());
		}
	}

	private Map<IdentifiedScan, List<ScanPeakPair>> createScanPeakPairMap(IChromatogramSelection chromatogramSelection, boolean transferClosestScan) {

		Map<IdentifiedScan, List<ScanPeakPair>> scanPeakPairMap = new HashMap<>();

		List<IdentifiedScan> identifiedScans = getIdentifiedScans(chromatogramSelection);
		for(IPeak peak : extractPeaks(chromatogramSelection)) {
			List<IdentifiedScan> scans = getScansInPeakRange(peak, identifiedScans, transferClosestScan);
			for(IdentifiedScan scan : scans) {
				List<ScanPeakPair> scanPeakPairs = scanPeakPairMap.get(scan);
				if(scanPeakPairs == null) {
					scanPeakPairs = new ArrayList<>();
					scanPeakPairMap.put(scan, scanPeakPairs);
				}
				scanPeakPairs.add(new ScanPeakPair(scan, peak));
			}
		}

		return scanPeakPairMap;
	}

	private void assignScanTargets(Map<IdentifiedScan, List<ScanPeakPair>> peakPairMap, boolean transferClosestScan, boolean useBestTargetOnly) {

		for(IdentifiedScan identifiedScan : peakPairMap.keySet()) {
			/*
			 * Get the closest peak and assign the targets.
			 */
			List<ScanPeakPair> scanPeakPairs = getScanPeakPairs(peakPairMap.get(identifiedScan), transferClosestScan);
			for(ScanPeakPair scanPeakPair : scanPeakPairs) {
				IPeak peak = scanPeakPair.getPeak();
				IScan scan = identifiedScan.getScan();
				for(IIdentificationTarget sourceTarget : getIdentificationTargets(scan, useBestTargetOnly)) {
					ILibraryInformation libraryInformation = new LibraryInformation(sourceTarget.getLibraryInformation());
					IComparisonResult comparisonResult = new ComparisonResult(sourceTarget.getComparisonResult());
					IdentificationTarget sinkTarget = new IdentificationTarget(libraryInformation, comparisonResult);
					peak.getTargets().add(sinkTarget);
				}
				identifiedScan.setAssigned(true);
			}
		}
	}

	private List<ScanPeakPair> getScanPeakPairs(List<ScanPeakPair> scanPeakPairs, boolean transferClosestScan) {

		if(transferClosestScan) {
			/*
			 * Drill down to the closest peak.
			 */
			ScanPeakPair scanPeakPairClosest = null;
			for(ScanPeakPair scanPeakPair : scanPeakPairs) {
				if(isUse(scanPeakPair)) {
					if(scanPeakPairClosest == null) {
						scanPeakPairClosest = scanPeakPair;
					} else {
						if(scanPeakPair.getRetentionTimeDelta() < scanPeakPairClosest.getRetentionTimeDelta()) {
							scanPeakPairClosest = scanPeakPair;
						}
					}
				}
			}
			/*
			 * Return the closest pair if available.
			 */
			if(scanPeakPairClosest != null) {
				return Arrays.asList(scanPeakPairClosest);
			} else {
				return Collections.emptyList();
			}
		} else {
			return scanPeakPairs;
		}
	}

	private boolean isUse(ScanPeakPair scanPeakPair) {

		return !scanPeakPair.getIdentifiedScan().isAssigned();
	}

	private Set<IIdentificationTarget> getIdentificationTargets(IScan scan, boolean useBestTargetOnly) {

		if(useBestTargetOnly) {
			List<IIdentificationTarget> targets = new ArrayList<>(scan.getTargets());
			if(targets.isEmpty()) {
				return Collections.emptySet();
			} else {
				Collections.sort(targets, new IdentificationTargetComparator());
				Set<IIdentificationTarget> bestTargets = new HashSet<>();
				bestTargets.add(targets.get(0));
				return bestTargets;
			}
		} else {
			return scan.getTargets();
		}
	}

	private void deleteAssignedScanIdentifications(Set<IdentifiedScan> identifiedScans) {

		for(IdentifiedScan identifiedScan : identifiedScans) {
			if(identifiedScan.isAssigned()) {
				IScan scan = identifiedScan.getScan();
				scan.getTargets().clear();
			}
		}
	}

	private List<IdentifiedScan> getIdentifiedScans(IChromatogramSelection chromatogramSelection) {

		List<IdentifiedScan> identifiedScans = new ArrayList<>();
		for(IScan scan : extractIdentifiedScans(chromatogramSelection)) {
			identifiedScans.add(new IdentifiedScan(scan));
		}

		return identifiedScans;
	}

	private List<IdentifiedScan> getScansInPeakRange(IPeak peak, List<IdentifiedScan> identifiedScans, boolean transferClosestScan) {

		List<IdentifiedScan> targetScans = new ArrayList<>();

		IPeakModel peakModel = peak.getPeakModel();
		int startRetentionTime = peakModel.getStartRetentionTime();
		int stopRetentionTime = peakModel.getStopRetentionTime();
		int peakMaxRetentionTime = peakModel.getRetentionTimeAtPeakMaximum();
		/*
		 * Transfer all or only the closest.
		 */
		for(IdentifiedScan identifiedScan : identifiedScans) {
			IScan scan = identifiedScan.getScan();
			int retentionTime = scan.getRetentionTime();
			if(retentionTime >= startRetentionTime && retentionTime <= stopRetentionTime) {
				if(!transferClosestScan) {
					targetScans.add(identifiedScan);
				} else {
					if(targetScans.isEmpty()) {
						targetScans.add(identifiedScan);
					} else {
						int delta = Math.abs(peakMaxRetentionTime - scan.getRetentionTime());
						IScan scanClosest = targetScans.get(0).getScan();
						int deltaClosest = Math.abs(peakMaxRetentionTime - scanClosest.getRetentionTime());
						if(delta < deltaClosest) {
							targetScans.clear();
							targetScans.add(identifiedScan);
						}
					}
				}
			}
		}

		return targetScans;
	}
}