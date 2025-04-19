/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core.interpolation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.chemclipse.fsd.model.core.IChromatogramFSD;
import org.eclipse.chemclipse.fsd.model.core.IScanFSD;
import org.eclipse.chemclipse.fsd.model.core.IScanSignalFSD;
import org.eclipse.chemclipse.fsd.model.core.implementation.ScanSignalFSD;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.interpolation.RasterizeCalculator;

public class ScanRasterizer {

	public static void normalize(IChromatogramFSD chromatogramFSD, int steps) {

		if(chromatogramFSD != null) {
			for(IScan scan : chromatogramFSD.getScans()) {
				if(scan instanceof IScanFSD scanFSD) {
					normalize(scanFSD, steps);
				}
			}
		}
	}

	public static void normalize(IScanFSD scanFSD, int steps) {

		if(scanFSD != null) {
			if(steps >= RasterizeCalculator.MIN_STEPS && steps <= RasterizeCalculator.MAX_STEPS) {
				/*
				 * Collect the data
				 */
				TreeMap<Float, Float> wavelengthOriginal = new TreeMap<>();
				for(IScanSignalFSD scanSignalFSD : scanFSD.getScanSignals()) {
					wavelengthOriginal.put(scanSignalFSD.getWavelength(), scanSignalFSD.getFluorescence());
				}

				Map<Integer, Float> wavelengthsAdjusted = RasterizeCalculator.apply(wavelengthOriginal, steps);
				if(wavelengthsAdjusted != null) {
					/*
					 * Rasterized Data
					 */
					List<Integer> wavelengths = new ArrayList<>(wavelengthsAdjusted.keySet());
					Collections.sort(wavelengths);

					scanFSD.deleteScanSignals();
					for(int wavelength : wavelengths) {
						scanFSD.addScanSignal(new ScanSignalFSD(wavelength, wavelengthsAdjusted.get(wavelength)));
					}
				}
			}
		}
	}
}
