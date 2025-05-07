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
import org.eclipse.chemclipse.wsd.model.core.IScanSignalWSD;
import org.eclipse.chemclipse.wsd.model.core.IScanWSD;
import org.eclipse.chemclipse.wsd.model.core.implementation.ScanSignalWSD;
import org.eclipse.chemclipse.wsd.model.core.implementation.ScanWSD;

public class ScanProcessor {

	public List<IScan> increaseScansDensity(IChromatogram chromatogram, int modifications, boolean mergeScans) {

		List<IScan> scansToReplace = new ArrayList<>();

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
			scansToReplace.add(scan);
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
					addScanNew(scan, scanNext, scansToReplace, retentionTimeNew, intensityNew, mergeScans);
				}

			}
		}

		return scansToReplace;
	}

	private void addScanNew(IScan scan, IScan scanNext, List<IScan> scansToReplace, int retentionTimeNew, float intensityNew, boolean mergeScans) {

		if(scan instanceof IScanCSD) {
			/*
			 * CSD
			 */
			IScanCSD scanNew = new ScanCSD(intensityNew);
			scanNew.setRetentionTime(retentionTimeNew);
			scansToReplace.add(scanNew);
		} else if(scan instanceof IScanMSD currentScan) {
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
				scansToReplace.add(scanNew);
			}
		} else if(scan instanceof IScanWSD currentScan) {
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
				scansToReplace.add(scanNew);
			}
		}
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