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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexMarker;
import org.eclipse.chemclipse.model.columns.IRetentionIndexEntry;
import org.eclipse.chemclipse.model.columns.ISeparationColumnIndices;
import org.eclipse.chemclipse.model.columns.RetentionIndexEntry;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.support.RetentionIndexMath;

public class RetentionIndexSupport {

	public static TreeMap<Integer, Integer> getRetentionIndexMap(RetentionIndexMarker retentionIndexMarker) {

		TreeMap<Integer, Integer> retentionIndexMap = new TreeMap<>();
		for(IRetentionIndexEntry retentionIndexEntry : retentionIndexMarker) {
			retentionIndexMap.put(Math.round(retentionIndexEntry.getRetentionIndex()), retentionIndexEntry.getRetentionTime());
		}

		return retentionIndexMap;
	}

	public static void transferRetentionIndexMarker(RetentionIndexMarker retentionIndexMarkerSource, RetentionIndexMarker retentionIndexMarkerSink) {

		retentionIndexMarkerSink.clear();
		retentionIndexMarkerSink.addAll(retentionIndexMarkerSource);
	}

	public static void transferRetentionIndexMarker(ISeparationColumnIndices separationColumnIndicesSource, RetentionIndexMarker retentionIndexMarkerSink) {

		retentionIndexMarkerSink.clear();
		for(IRetentionIndexEntry retentionIndexEntry : separationColumnIndicesSource.values()) {
			int retentionTime = retentionIndexEntry.getRetentionTime();
			float retentionIndex = retentionIndexEntry.getRetentionIndex();
			String name = retentionIndexEntry.getName();
			retentionIndexMarkerSink.add(new RetentionIndexEntry(retentionTime, retentionIndex, name));
		}
	}

	public static void transferRetentionIndexMarker(RetentionIndexMarker retentionIndexMarkerSource, ISeparationColumnIndices separationColumnIndicesSink) {

		separationColumnIndicesSink.clear();
		for(IRetentionIndexEntry retentionIndexEntry : retentionIndexMarkerSource) {
			int retentionTime = retentionIndexEntry.getRetentionTime();
			float retentionIndex = retentionIndexEntry.getRetentionIndex();
			String name = retentionIndexEntry.getName();
			separationColumnIndicesSink.put(new RetentionIndexEntry(retentionTime, retentionIndex, name));
		}
	}

	public static RetentionIndexMarker getRetentionIndexMarker(ISeparationColumnIndices separationColumnIndices, IChromatogram chromatogram, boolean extrapolateLeft, boolean extrapolateRight) {

		RetentionIndexMarker retentionIndexMarker = new RetentionIndexMarker();
		transferRetentionIndexMarker(separationColumnIndices, retentionIndexMarker);

		return getRetentionIndexMarker(retentionIndexMarker, extrapolateLeft, extrapolateRight);
	}

	public static RetentionIndexMarker getRetentionIndexMarker(RetentionIndexMarker retentionIndexMarker, boolean extrapolateLeft, boolean extrapolateRight) {

		if(retentionIndexMarker != null && retentionIndexMarker.size() >= 2) {
			if(RetentionIndexSupport.extrapolateData(extrapolateLeft, extrapolateRight)) {
				/*
				 * Get the start/stop marker
				 */
				Optional<IRetentionIndexEntry> markerStart = retentionIndexMarker.stream().min((m1, m2) -> Integer.compare(m1.getRetentionTime(), m2.getRetentionTime()));
				Optional<IRetentionIndexEntry> markerStop = retentionIndexMarker.stream().max((m1, m2) -> Integer.compare(m1.getRetentionTime(), m2.getRetentionTime()));
				/*
				 * Calculate the missing ranges.
				 */
				RetentionIndexExtrapolator retentionIndexExtrapolator = new RetentionIndexExtrapolator();
				retentionIndexExtrapolator.extrapolateMissingAlkaneRanges(retentionIndexMarker);
				/*
				 * Constraint Remove (Left)
				 */
				if(!extrapolateLeft && markerStart.isPresent()) {
					List<IRetentionIndexEntry> removeEntries = new ArrayList<>();
					int retentionTimeStart = markerStart.get().getRetentionTime();
					for(IRetentionIndexEntry retentionIndexEntry : retentionIndexMarker) {
						if(retentionIndexEntry.getRetentionTime() < retentionTimeStart) {
							removeEntries.add(retentionIndexEntry);
						}
					}
					retentionIndexMarker.removeAll(removeEntries);
				}
				/*
				 * Constraint Remove (Right)
				 */
				if(!extrapolateRight && markerStop.isPresent()) {
					List<IRetentionIndexEntry> removeEntries = new ArrayList<>();
					int retentionTimeStop = markerStop.get().getRetentionTime();
					for(IRetentionIndexEntry retentionIndexEntry : retentionIndexMarker) {
						if(retentionIndexEntry.getRetentionTime() > retentionTimeStop) {
							removeEntries.add(retentionIndexEntry);
						}
					}
					retentionIndexMarker.removeAll(removeEntries);
				}
			}
		}
		/*
		 * Return the initial marker.
		 */
		return retentionIndexMarker;
	}

	public static boolean extrapolateData(boolean extrapolateLeft, boolean extrapolateRight) {

		return extrapolateLeft == true || extrapolateRight == true;
	}

	public static void deriveMissingIndices(TreeMap<Integer, Integer> retentionIndexPeakMap, Set<Integer> availableIndices, String[] standards, ISeparationColumnIndices separationColumnIndices) {

		if(retentionIndexPeakMap.size() >= 2) {
			/*
			 * Calculate the alkanes in between.
			 */
			List<IRetentionIndexEntry> derivedRetentionIndexEntries = new ArrayList<>();
			int minAlkane = (int)Math.round(retentionIndexPeakMap.firstKey() / 100.0d);
			int maxAlkane = (int)Math.round(retentionIndexPeakMap.lastKey() / 100.0d);

			for(int alkane = minAlkane; alkane <= maxAlkane; alkane++) {
				int retentionIndex = alkane * 100;
				if(!availableIndices.contains(retentionIndex)) {
					Map.Entry<Integer, Integer> floorEntry = retentionIndexPeakMap.floorEntry(retentionIndex);
					if(floorEntry != null) {
						Map.Entry<Integer, Integer> ceilingEntry = retentionIndexPeakMap.ceilingEntry(retentionIndex);
						if(ceilingEntry != null) {
							/*
							 * Derived Entry
							 */
							int retentionTime = 0;
							if(floorEntry.getKey() == retentionIndex) {
								retentionTime = floorEntry.getValue();
							} else if(ceilingEntry.getKey() == retentionIndex) {
								retentionTime = ceilingEntry.getValue();
							} else {
								int retentionIndexLow = floorEntry.getKey();
								int retentionTimeLow = floorEntry.getValue();
								int retentionIndexHigh = ceilingEntry.getKey();
								int retentionTimeHigh = ceilingEntry.getValue();
								retentionTime = RetentionIndexMath.calculateRetentionTime(retentionIndex, retentionIndexLow, retentionIndexHigh, retentionTimeLow, retentionTimeHigh);
							}
							/*
							 * Add
							 */
							if(retentionTime > 0) {
								String name = getRetentionIndexName(standards, alkane);
								derivedRetentionIndexEntries.add(new RetentionIndexEntry(retentionTime, retentionIndex, name));
							}
						}
					}
				}
			}
			/*
			 * Transfer
			 */
			for(IRetentionIndexEntry derivedRetentionIndexEntry : derivedRetentionIndexEntries) {
				separationColumnIndices.put(derivedRetentionIndexEntry);
			}
		}

	}

	public static String getRetentionIndexName(String[] standards, int index) {

		return RetentionIndexCalculator.getAlkaneLabel(standards, index) + " -> Derived";
	}
}