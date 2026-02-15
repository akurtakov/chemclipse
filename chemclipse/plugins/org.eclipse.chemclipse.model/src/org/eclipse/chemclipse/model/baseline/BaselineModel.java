/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.baseline;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.exceptions.BaselineIsNotDefinedException;
import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.numeric.core.Point;
import org.eclipse.chemclipse.numeric.equations.Equations;
import org.eclipse.chemclipse.support.traces.ITrace;
import org.eclipse.chemclipse.support.traces.TraceEmpty;

/**
 * This class represents the baseline model of the current chromatogram.
 */
public class BaselineModel implements IBaselineModel {

	private IChromatogram chromatogram;
	private ITrace traceTIC = new TraceEmpty();
	/*
	 * The start retention time is the key.
	 */
	private NavigableMap<Integer, Map<ITrace, IBaselineSegment>> baselineSegments = new TreeMap<>();
	private float defaultBackgroundAbundance;
	private boolean interpolate;

	public BaselineModel(IChromatogram chromatogram) {

		this.chromatogram = chromatogram;
		this.defaultBackgroundAbundance = 0f;
		this.interpolate = false;
	}

	public BaselineModel(IChromatogram chromatogram, float defaultBackgroundAbundance) {

		this.chromatogram = chromatogram;
		this.defaultBackgroundAbundance = defaultBackgroundAbundance;
		if(Double.isNaN(defaultBackgroundAbundance)) {
			this.interpolate = true;
		} else {
			this.interpolate = false;
		}
	}

	/**
	 * Copies the content from the given baseline.
	 * Use this method with care, as no deep copy is created.
	 * 
	 * @param baselineModel
	 */
	public void copyFrom(BaselineModel baselineModel) {

		this.baselineSegments = baselineModel.baselineSegments;
		this.defaultBackgroundAbundance = baselineModel.defaultBackgroundAbundance;
		this.interpolate = baselineModel.interpolate;
	}

	@Override
	public boolean isBaselineSet() {

		if(baselineSegments != null) {
			return baselineSegments.size() > 0;
		}
		return false;
	}

	@Override
	public void addBaseline(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, boolean validate) {

		addBaseline(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, traceTIC, validate);
	}

	@Override
	public void addBaseline(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, ITrace trace, boolean validate) {

		if(startRetentionTime < stopRetentionTime) {
			if(validate) {
				addBaselineChecked(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, trace);
			} else {
				addBaselineUnchecked(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, trace);
			}
		}
	}

	@Override
	public void addBaseline(ITotalScanSignals totalIonSignals) {

		addBaseline(totalIonSignals, traceTIC);
	}

	public void addBaseline(ITotalScanSignals totalIonSignals, ITrace trace) {

		if(totalIonSignals.size() == 0) {
			return;
		}
		/*
		 * remove old baseline
		 */
		ITotalScanSignal firstTotalSignal = totalIonSignals.getFirstTotalScanSignal();
		ITotalScanSignal lastTotalSignal = totalIonSignals.getLastTotalScanSignal();
		removeBaselineSegments(firstTotalSignal.getRetentionTime(), lastTotalSignal.getRetentionTime(), firstTotalSignal.getTotalSignal(), lastTotalSignal.getTotalSignal(), trace);
		/*
		 * Why scan < numberOfScans instead of scan <= numberOfScans? Because of
		 * .getNextTotalIonSignal();
		 */
		for(int scan = totalIonSignals.getStartScan(); scan < totalIonSignals.getStopScan(); scan++) {
			ITotalScanSignal actualTotalIonSignal = totalIonSignals.getTotalScanSignal(scan);
			ITotalScanSignal nextTotalIonSignal = totalIonSignals.getNextTotalScanSignal(scan);
			/*
			 * Retention times and background abundances.
			 */
			int startRetentionTime = actualTotalIonSignal.getRetentionTime();
			float startBackgroundAbundance = actualTotalIonSignal.getTotalSignal();
			int stopRetentionTime = nextTotalIonSignal.getRetentionTime();
			float stopBackgroundAbundance = nextTotalIonSignal.getTotalSignal();
			/*
			 * Set the baseline.
			 * It is validate == false, cause we know that the segments are calculated without overlap.
			 */
			addBaseline(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, false);
		}
	}

	@Override
	public void removeBaseline() {

		clearBaseline();
	}

	@Override
	@Deprecated
	public float getBackgroundAbundance(int retentionTime) {

		float defaultBackgroundAbundance = 0f;
		if(retentionTime < chromatogram.getStartRetentionTime() || retentionTime > chromatogram.getStopRetentionTime()) {
			return defaultBackgroundAbundance;
		}
		return getBackground(retentionTime);
	}

	@Override
	public float getBackground(int retentionTime) {

		return getBackground(retentionTime, Collections.emptySet());
	}

	@Override
	public float getBackground(int retentionTime, Set<ITrace> traces) {

		return getBackground(retentionTime, defaultBackgroundAbundance, traces);
	}

	@Override
	public float getBackgroundNotNaN(int retentionTime) throws BaselineIsNotDefinedException {

		return getBackgroundNotNaN(retentionTime, Collections.emptySet());
	}

	@Override
	public float getBackgroundNotNaN(int retentionTime, Set<ITrace> traces) throws BaselineIsNotDefinedException {

		float background = getBackground(retentionTime, traces);
		if(background != Float.NaN) {
			return background;
		} else {
			throw new BaselineIsNotDefinedException();
		}
	}

	@Override
	public IBaselineModel makeDeepCopy() {

		IBaselineModel baselineModelCopy = new BaselineModel(chromatogram, defaultBackgroundAbundance);
		int startRT;
		int stopRT;
		float startAB;
		float stopAB;
		for(Map<ITrace, IBaselineSegment> baselineSegmentMap : baselineSegments.values()) {
			for(Map.Entry<ITrace, IBaselineSegment> entry : baselineSegmentMap.entrySet()) {
				ITrace trace = entry.getKey();
				IBaselineSegment baselineSegment = entry.getValue();
				startRT = baselineSegment.getStartRetentionTime();
				stopRT = baselineSegment.getStopRetentionTime();
				startAB = baselineSegment.getStartBackgroundAbundance();
				stopAB = baselineSegment.getStopBackgroundAbundance();
				baselineModelCopy.addBaseline(startRT, stopRT, startAB, stopAB, trace, false);
			}
		}
		return baselineModelCopy;
	}

	@Override
	public void removeBaseline(int startRetentionTime, int stopRetentionTime) {

		removeBaseline(startRetentionTime, stopRetentionTime, traceTIC);
	}

	public void removeBaseline(int startRetentionTime, int stopRetentionTime, ITrace trace) {

		if(startRetentionTime >= stopRetentionTime) {
			return;
		}
		removeBaselineSegments(startRetentionTime, stopRetentionTime, Float.NaN, Float.NaN, trace);
	}

	private void removeBaselineSegments(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, ITrace trace) {

		/*
		 * The part that should be removed lies in interval one segment
		 */
		removeMiddleSegments(startRetentionTime, stopRetentionTime, trace);
		cutSegmentInTwoParts(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, trace);
		cutSegmentBeginningPart(startRetentionTime, stopRetentionTime, stopBackgroundAbundance, trace);
		cutSegmentEndingPart(startRetentionTime, stopRetentionTime, startBackgroundAbundance, trace);
	}

	/**
	 * remove middle segments
	 * 
	 */
	private void removeMiddleSegments(int startRetentionTime, int stopRetentionTime, ITrace trace) {

		SortedMap<Integer, Map<ITrace, IBaselineSegment>> sortedMap = baselineSegments.subMap(startRetentionTime, stopRetentionTime);
		Set<Integer> checkKeys = new HashSet<>();

		for(Entry<Integer, Map<ITrace, IBaselineSegment>> entry : sortedMap.entrySet()) {
			IBaselineSegment baselineSegment = entry.getValue().get(trace);
			if(baselineSegment != null) {
				int stopRetentionTimeRemoveSegment = baselineSegment.getStopRetentionTime();
				if(stopRetentionTimeRemoveSegment <= stopRetentionTime) {
					checkKeys.add(entry.getKey());
				}
			}
		}
		/**
		 * Remove keys.
		 */
		Set<Integer> keysToRemove = new HashSet<>();
		for(int key : checkKeys) {
			Map<ITrace, IBaselineSegment> baselineSegmentMap = baselineSegments.get(key);
			if(baselineSegmentMap != null) {
				baselineSegmentMap.remove(trace);
				/*
				 * Check if empty
				 */
				if(baselineSegmentMap.isEmpty()) {
					keysToRemove.add(key);
				}
			}
		}
		keysToRemove.forEach(k -> baselineSegments.remove(k));
	}

	/**
	 * Cut the beginning part of an existing segment.
	 * 
	 */
	private void cutSegmentBeginningPart(int startRetentionTime, int stopRetentionTime, float stopBackgroundAbundance, ITrace trace) {

		Entry<Integer, Map<ITrace, IBaselineSegment>> cuttingSegmentEntry = baselineSegments.floorEntry(stopRetentionTime);
		if(cuttingSegmentEntry != null) {
			Map<ITrace, IBaselineSegment> cuttingSegmentMap = cuttingSegmentEntry.getValue();
			IBaselineSegment cuttingSegment = cuttingSegmentMap.get(trace);
			if(cuttingSegment != null) {
				int x0 = cuttingSegment.getStartRetentionTime();
				int x1 = cuttingSegment.getStopRetentionTime();
				if(startRetentionTime <= x0 && x0 <= stopRetentionTime && stopRetentionTime < x1) {
					baselineSegments.remove(cuttingSegmentEntry.getKey());
					int partSegmentStartRetentionTime = stopRetentionTime + 1;
					int partSegmentStopRetentionTime = x1;
					float partSegmentStartAbundance = cuttingSegment.getBackgroundAbundance(partSegmentStartRetentionTime);
					float partSegmentStopAbundance = cuttingSegment.getStopBackgroundAbundance();
					/*
					 * 
					 */
					if(partSegmentStartRetentionTime != partSegmentStopRetentionTime) {
						addBaselineUnchecked(partSegmentStartRetentionTime, partSegmentStopRetentionTime, partSegmentStartAbundance, partSegmentStopAbundance, trace);
					} else if(!Float.isNaN(stopBackgroundAbundance)) {
						partSegmentStartRetentionTime -= 1;
						addBaselineUnchecked(partSegmentStartRetentionTime, partSegmentStopRetentionTime, stopBackgroundAbundance, partSegmentStopAbundance, trace);
					}
				}
			}
		}
	}

	/**
	 * Cut the ending part of an existing segment.
	 * 
	 */
	private void cutSegmentEndingPart(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, ITrace trace) {

		Entry<Integer, Map<ITrace, IBaselineSegment>> cuttingSegmentEntry = baselineSegments.floorEntry(startRetentionTime);
		if(cuttingSegmentEntry != null) {
			Map<ITrace, IBaselineSegment> cuttingSegmentMap = cuttingSegmentEntry.getValue();
			IBaselineSegment cuttingSegment = cuttingSegmentMap.get(trace);
			if(cuttingSegment != null) {
				int x0 = cuttingSegment.getStartRetentionTime();
				int x1 = cuttingSegment.getStopRetentionTime();
				if(x0 < startRetentionTime && startRetentionTime <= x1 && x1 <= stopRetentionTime) {
					baselineSegments.remove(cuttingSegmentEntry.getKey());
					int partSegmentStartRetentionTime = x0;
					int partSegmentStopRetentionTime = startRetentionTime - 1;
					float partSegmentStartAbundance = cuttingSegment.getStartBackgroundAbundance();
					float partSegmentStopAbundance = cuttingSegment.getBackgroundAbundance(partSegmentStopRetentionTime);
					/*
					 * 
					 */
					if(partSegmentStartRetentionTime != partSegmentStopRetentionTime) {
						addBaselineUnchecked(partSegmentStartRetentionTime, partSegmentStopRetentionTime, partSegmentStartAbundance, partSegmentStopAbundance, trace);
					} else if(!Float.isNaN(startBackgroundAbundance)) {
						partSegmentStopRetentionTime += 1;
						addBaselineUnchecked(partSegmentStartRetentionTime, partSegmentStopRetentionTime, partSegmentStartAbundance, startBackgroundAbundance, trace);
					}
				}
			}
		}
	}

	/**
	 * Cut an existing segment into two peaces.
	 */
	private void cutSegmentInTwoParts(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, ITrace trace) {

		Map.Entry<Integer, Map<ITrace, IBaselineSegment>> cuttingSegmentEntry = baselineSegments.floorEntry(startRetentionTime);
		if(cuttingSegmentEntry != null) {
			Map<ITrace, IBaselineSegment> cuttingSegmentMap = cuttingSegmentEntry.getValue();
			IBaselineSegment cuttingSegment = cuttingSegmentMap.get(trace);
			if(cuttingSegment != null) {
				int x0 = cuttingSegment.getStartRetentionTime();
				int x1 = cuttingSegment.getStopRetentionTime();
				if(x0 < startRetentionTime && stopRetentionTime < x1) {
					baselineSegments.remove(cuttingSegmentEntry.getKey());
					/*
					 * add first segment
					 */
					int firstPartSegmentStartRetentionTime = x0;
					int firstPartSegmentStopRetentionTime = startRetentionTime - 1;
					float firstPartSegmentStartAbundance = cuttingSegment.getStartBackgroundAbundance();
					float firstPartSegmentStopAbundance = cuttingSegment.getBackgroundAbundance(firstPartSegmentStopRetentionTime);
					/*
					 * 
					 */
					if(firstPartSegmentStartRetentionTime != firstPartSegmentStopRetentionTime) {
						addBaselineUnchecked(firstPartSegmentStartRetentionTime, firstPartSegmentStopRetentionTime, firstPartSegmentStartAbundance, firstPartSegmentStopAbundance, trace);
					} else if(!Float.isNaN(startBackgroundAbundance)) {
						firstPartSegmentStopRetentionTime += 1;
						addBaselineUnchecked(firstPartSegmentStartRetentionTime, firstPartSegmentStopRetentionTime, firstPartSegmentStartAbundance, startBackgroundAbundance, trace);
					}
					/*
					 * add second segment
					 */
					int secondPartSegmentStartRetentionTime = stopRetentionTime + 1;
					int secondPartSegmentStopRetentionTime = x1;
					float secondPartSegmentStartAbundance = cuttingSegment.getBackgroundAbundance(secondPartSegmentStartRetentionTime);
					float secondPartSegmentStopAbundance = cuttingSegment.getStopBackgroundAbundance();
					/*
					 * 
					 */
					if(firstPartSegmentStartRetentionTime != firstPartSegmentStopRetentionTime) {
						addBaselineUnchecked(secondPartSegmentStartRetentionTime, secondPartSegmentStopRetentionTime, secondPartSegmentStartAbundance, secondPartSegmentStopAbundance, trace);
					} else if(!Float.isNaN(stopBackgroundAbundance)) {
						secondPartSegmentStartRetentionTime = stopRetentionTime - 1;
						addBaselineUnchecked(secondPartSegmentStartRetentionTime, secondPartSegmentStopRetentionTime, stopBackgroundAbundance, secondPartSegmentStopAbundance, trace);
					}
				}
			}
		}
	}

	private float getBackground(int retentionTime, float defaultAbundance, Set<ITrace> traces) {

		/*
		 * Get the correct baseline segment and calculate the abundance.
		 */
		if(isPositionValid(retentionTime)) {
			Map<ITrace, IBaselineSegment> floorSegmentMap = baselineSegments.floorEntry(retentionTime).getValue();
			if(traces.isEmpty()) {
				Set<ITrace> tracesAvailable = new HashSet<>(floorSegmentMap.keySet());
				tracesAvailable.remove(traceTIC);
				if(tracesAvailable.isEmpty()) {
					/*
					 * TIC
					 */
					return getAbundance(floorSegmentMap, retentionTime, floorSegmentMap.keySet());
				} else {
					/*
					 * Sum of all available traces.
					 */
					return getAbundance(floorSegmentMap, retentionTime, tracesAvailable);
				}
			} else {
				/*
				 * Request the sum baseline for specific traces.
				 */
				return getAbundance(floorSegmentMap, retentionTime, traces);
			}
		}

		return defaultAbundance;
	}

	private float getAbundance(Map<ITrace, IBaselineSegment> floorSegmentMap, int retentionTime, Set<ITrace> traces) {

		float abundance = 0;
		for(ITrace trace : traces) {
			abundance += getAbundance(floorSegmentMap.get(trace), retentionTime, trace, 0);
		}
		return abundance;
	}

	private float getAbundance(IBaselineSegment floorSegment, int retentionTime, ITrace trace, float defaultAbundance) {

		if(floorSegment != null) {
			int stopRetentionTime = floorSegment.getStopRetentionTime();
			if(retentionTime <= stopRetentionTime) {
				return floorSegment.getBackgroundAbundance(retentionTime);
			} else {
				if(interpolate) {
					Map<ITrace, IBaselineSegment> ceilSegmentMap = baselineSegments.ceilingEntry(retentionTime).getValue();
					IBaselineSegment ceilSegment = ceilSegmentMap.get(trace);
					if(ceilSegment != null) {
						Point p1 = new Point(floorSegment.getStopRetentionTime(), floorSegment.getStopBackgroundAbundance());
						Point p2 = new Point(ceilSegment.getStartRetentionTime(), ceilSegment.getStartBackgroundAbundance());
						return (float)Equations.createLinearEquation(p1, p2).calculateY(retentionTime);
					}
				}
			}
		}

		return defaultAbundance;
	}

	private boolean isPositionValid(int retentionTime) {

		if(baselineSegments.isEmpty() || retentionTime < baselineSegments.firstKey()) {
			return false;
		}

		return true;
	}

	private void addBaselineUnchecked(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, ITrace trace) {

		IBaselineSegment baselineSegment = new BaselineSegment(startRetentionTime, stopRetentionTime, trace);
		baselineSegment.setStartBackgroundAbundance(startBackgroundAbundance);
		baselineSegment.setStopBackgroundAbundance(stopBackgroundAbundance);
		/*
		 * Map
		 */
		int retentionTime = baselineSegment.getStartRetentionTime();
		Map<ITrace, IBaselineSegment> baselineSegmentMap = baselineSegments.get(retentionTime);
		if(baselineSegmentMap == null) {
			baselineSegmentMap = new HashMap<>();
		}
		baselineSegmentMap.put(trace, baselineSegment);
		baselineSegments.put(retentionTime, baselineSegmentMap);
	}

	private void addBaselineChecked(int startRetentionTime, int stopRetentionTime, float startBackgroundAbundance, float stopBackgroundAbundance, ITrace trace) {

		removeBaselineSegments(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, trace);
		addBaselineUnchecked(startRetentionTime, stopRetentionTime, startBackgroundAbundance, stopBackgroundAbundance, trace);
	}

	/**
	 * Clear the baseline segments and create a new tree map to store them.
	 */
	private void clearBaseline() {

		if(baselineSegments != null) {
			baselineSegments.clear();
		}
	}
}