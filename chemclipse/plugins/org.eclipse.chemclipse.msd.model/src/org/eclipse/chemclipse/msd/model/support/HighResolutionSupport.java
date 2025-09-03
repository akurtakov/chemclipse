/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.core.support.HeaderField;
import org.eclipse.chemclipse.model.support.ChromatogramSupport;
import org.eclipse.chemclipse.model.support.HeaderUtil;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.implementation.RegularMassSpectrum;
import org.eclipse.chemclipse.support.traces.TraceHighResMSD;

public class HighResolutionSupport {

	public static List<IChromatogramMSD> extractHighResolutionData(IChromatogramMSD chromatogramMSD, HeaderField headerField, boolean enforceFullTimeRange, Set<TraceHighResMSD> traces, boolean separateTraces) {

		List<IChromatogramMSD> chromatograms = new ArrayList<>();
		List<Integer> retentionTimes = new ArrayList<>();
		/*
		 * Collect
		 */
		Map<TraceHighResMSD, Map<Integer, Float>> scanRangesMap = new HashMap<>();
		for(IScan scan : chromatogramMSD.getScans()) {
			if(scan instanceof IScanMSD scanMSD) {
				/*
				 * Traces
				 */
				int retentionTime = scan.getRetentionTime();
				retentionTimes.add(retentionTime);
				for(TraceHighResMSD trace : traces) {
					for(IIon ion : scanMSD.getIons()) {
						if(trace.matches(ion.getIon())) {
							Map<Integer, Float> scans = scanRangesMap.get(trace);
							if(scans == null) {
								scans = new HashMap<>();
								scans.put(scan.getRetentionTime(), ion.getAbundance());
								scanRangesMap.put(trace, scans);
							} else {
								Float intensity = scans.get(retentionTime);
								if(intensity == null) {
									scans.put(retentionTime, ion.getAbundance());
								} else {
									scans.put(retentionTime, intensity + ion.getAbundance());
								}
							}
						}
					}
				}

			}
		}
		/*
		 * Compile
		 */
		if(separateTraces) {
			/*
			 * One Trace per Reference Chromatogram
			 */
			for(TraceHighResMSD trace : traces) {
				Map<Integer, List<IIon>> scanIonsMap = new HashMap<>();
				collectTraces(trace, scanRangesMap, retentionTimes, scanIonsMap);
				createReferenceChromatogram(chromatograms, chromatogramMSD, retentionTimes, scanIonsMap, headerField, trace.toString(), enforceFullTimeRange);
			}
		} else {
			/*
			 * All Traces in one Reference Chromatogram
			 */
			enforceFullTimeRange = true; // needed to map all traces
			Map<Integer, List<IIon>> scanIonsMap = new HashMap<>();
			for(TraceHighResMSD trace : traces) {
				collectTraces(trace, scanRangesMap, retentionTimes, scanIonsMap);
			}
			createReferenceChromatogram(chromatograms, chromatogramMSD, retentionTimes, scanIonsMap, headerField, "Multiple Traces", enforceFullTimeRange);

		}

		return chromatograms;
	}

	private static void collectTraces(TraceHighResMSD trace, Map<TraceHighResMSD, Map<Integer, Float>> scanRangesMap, List<Integer> retentionTimes, Map<Integer, List<IIon>> scanIonsMap) {

		Map<Integer, Float> scans = scanRangesMap.get(trace);
		if(scans != null) {
			/*
			 * Traces
			 */
			for(int retentionTime : retentionTimes) {
				float intensity = scans.getOrDefault(retentionTime, 0.0f);
				if(intensity > 0.0f) {
					List<IIon> ions = scanIonsMap.get(retentionTime);
					if(ions == null) {
						ions = new ArrayList<>();
						scanIonsMap.put(retentionTime, ions);
					}
					ions.add(new Ion(trace.getMZ(), scans.get(retentionTime)));
				}
			}
		}
	}

	private static void createReferenceChromatogram(List<IChromatogramMSD> chromatograms, IChromatogramMSD chromatogramMSD, List<Integer> retentionTimes, Map<Integer, List<IIon>> scanIonsMap, HeaderField headerField, String headerData, boolean enforceFullTimeRange) {

		IChromatogramMSD chromatogramReferenceMSD = new ChromatogramMSD();
		chromatogramReferenceMSD.setConverterId(chromatogramMSD.getConverterId());
		HeaderUtil.setHeaderData(chromatogramReferenceMSD, headerField, headerData);
		for(int retentionTime : retentionTimes) {
			RegularMassSpectrum scanMSD = new RegularMassSpectrum();
			scanMSD.setRetentionTime(retentionTime);
			List<IIon> ions = scanIonsMap.get(retentionTime);
			if(ions != null) {
				for(IIon ion : ions) {
					scanMSD.addIon(ion);
				}
			}
			/*
			 * Scan
			 */
			if(enforceFullTimeRange) {
				chromatogramReferenceMSD.addScan(scanMSD);
			} else {
				if(ions != null && !ions.isEmpty()) {
					chromatogramReferenceMSD.addScan(scanMSD);
				}
			}
		}
		ChromatogramSupport.calculateScanIntervalAndDelay(chromatogramReferenceMSD);
		chromatograms.add(chromatogramReferenceMSD);
	}
}