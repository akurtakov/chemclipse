/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.chemclipse.csd.model.core.IScanCSD;
import org.eclipse.chemclipse.csd.model.implementation.ScanCSD;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.VendorMassSpectrum;
import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.core.Point;
import org.eclipse.chemclipse.numeric.equations.Equations;
import org.eclipse.chemclipse.numeric.equations.LinearEquation;
import org.eclipse.chemclipse.wsd.model.core.IScanSignalWSD;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.chemclipse.wsd.model.core.implementation.ScanSignalWSD;
import org.eclipse.chemclipse.wsd.model.core.implementation.ScanWSD;

public class ScanProcessor {

	public List<IScan> recalculateScans(IChromatogram chromatogram, int scanIntervalTarget, boolean mergeScans) {

		List<IScan> scans = new ArrayList<>();
		/*
		 * Map the existing scans.
		 */
		TreeMap<Integer, IScan> scanMap = new TreeMap<>();
		for(IScan scan : chromatogram.getScans()) {
			scanMap.put(scan.getRetentionTime(), scan);
		}
		/*
		 * Recalculate scan pattern.
		 */
		int retentionTime = (chromatogram.getStartRetentionTime() / scanIntervalTarget) * scanIntervalTarget;
		int retentionTimeStop = (chromatogram.getStopRetentionTime() / scanIntervalTarget) * scanIntervalTarget + scanIntervalTarget;
		while(retentionTime <= retentionTimeStop) {
			IScan scan = scanMap.get(retentionTime);
			if(scan != null) {
				/*
				 * Add existing scan
				 */
				scans.add(scan);
			} else {
				/*
				 * Calculate a new interpolated scan
				 */
				Map.Entry<Integer, IScan> scanEntryPrevious = scanMap.lowerEntry(retentionTime);
				Map.Entry<Integer, IScan> scanEntryNext = scanMap.higherEntry(retentionTime);
				if(scanEntryPrevious != null && scanEntryNext != null) {
					IScan scanPrevious = scanEntryPrevious.getValue();
					IScan scanNext = scanEntryNext.getValue();
					IPoint p1 = new Point(scanPrevious.getRetentionTime(), scanPrevious.getTotalSignal());
					IPoint p2 = new Point(scanNext.getRetentionTime(), scanNext.getTotalSignal());
					LinearEquation linearEquation = Equations.createLinearEquation(p1, p2);
					if(linearEquation != null) {
						float intensityNew = (float)linearEquation.calculateY(retentionTime);
						IScan scanCalculated = calculateScan(scanPrevious, scanNext, retentionTime, intensityNew, mergeScans);
						if(scanCalculated != null) {
							scans.add(scanCalculated);
						}
					}
				}
			}
			retentionTime += scanIntervalTarget;
		}

		return scans;
	}

	public List<IScan> increaseScansDensity(IChromatogram chromatogram, int modifications, boolean mergeScans) {

		List<IScan> scans = new ArrayList<>();

		/*
		 * Map the existing scans.
		 */
		TreeMap<Integer, IScan> scanMap = new TreeMap<>();
		for(IScan scan : chromatogram.getScans()) {
			scanMap.put(scan.getRetentionTime(), scan);
		}

		for(IScan scan : chromatogram.getScans()) {
			/*
			 * Base Scans (Original)
			 */
			scans.add(scan);
			Map.Entry<Integer, IScan> scanEntryNext = scanMap.higherEntry(scan.getRetentionTime());
			if(scanEntryNext != null) {
				/*
				 * Next Scan (Original)
				 */
				double parts = modifications + 1;
				IScan scanNext = scanEntryNext.getValue();
				int retentionTime = scan.getRetentionTime();
				int retentionTimePart = (int)((scanNext.getRetentionTime() - retentionTime) / parts);
				float intensity = scan.getTotalSignal();
				float intensityPart = (float)((scanNext.getTotalSignal() - intensity) / parts);
				for(int i = 1; i <= modifications; i++) {
					int retentionTimeNew = retentionTime + i * retentionTimePart;
					float intensityNew = intensity + i * intensityPart;
					IScan scanCalculated = calculateScan(scan, scanNext, retentionTimeNew, intensityNew, mergeScans);
					if(scanCalculated != null) {
						scans.add(scanCalculated);
					}
				}
			}
		}

		return scans;
	}

	private IScan calculateScan(IScan scanCurrent, IScan scanNext, int retentionTimeNew, float intensityNew, boolean mergeScans) {

		if(scanCurrent instanceof IScanCSD) {
			/*
			 * CSD
			 */
			IScanCSD scanNew = new ScanCSD(intensityNew);
			scanNew.setRetentionTime(retentionTimeNew);
			return scanNew;
		} else if(scanCurrent instanceof IScanMSD currentScan) {
			if(scanNext instanceof IScanMSD nextScan) {
				/*
				 * MSD
				 */
				IScanMSD scanNew = new VendorMassSpectrum();
				scanNew.setRetentionTime(retentionTimeNew);
				List<IIon> traces = new ArrayList<>();
				if(mergeScans) {
					traces.addAll(createTraces(currentScan));
				}
				traces.addAll(createTraces(nextScan));
				scanNew.addIons(traces, true);
				scanNew.adjustTotalSignal(intensityNew);
				return scanNew;
			}
		} else if(scanCurrent instanceof IScanWSD currentScan) {
			if(scanNext instanceof IScanWSD nextScan) {
				/*
				 * WSD
				 */
				IScanWSD scanNew = new ScanWSD();
				scanNew.setRetentionTime(retentionTimeNew);
				Map<Float, Float> traceMap = new HashMap<>();
				traceMap.putAll(getTraces(nextScan));
				if(mergeScans) {
					for(Map.Entry<Float, Float> entry : getTraces(currentScan).entrySet()) {
						Float abundance = traceMap.get(entry.getKey());
						if(abundance == null) {
							traceMap.put(entry.getKey(), entry.getValue());
						} else {
							traceMap.put(entry.getKey(), abundance + entry.getValue());
						}
					}
				}
				for(Map.Entry<Float, Float> entry : traceMap.entrySet()) {
					scanNew.addScanSignal(new ScanSignalWSD(entry.getKey(), entry.getValue()));
				}
				scanNew.adjustTotalSignal(intensityNew);
				return scanNew;
			}
		}

		return null;
	}

	private List<IIon> createTraces(IScanMSD scanMSD) {

		List<IIon> traces = new ArrayList<>();
		for(IIon trace : scanMSD.getIons()) {
			traces.add(new Ion(trace.getIon(), trace.getAbundance()));
		}

		return traces;
	}

	private Map<Float, Float> getTraces(IScanWSD scanWSD) {

		Map<Float, Float> traceMap = new HashMap<>();
		for(IScanSignalWSD trace : scanWSD.getScanSignals()) {
			traceMap.put(trace.getWavelength(), trace.getAbsorbance());
		}

		return traceMap;
	}
}