/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.comparator.IonAbundanceComparator;
import org.eclipse.chemclipse.msd.model.implementation.Ion;
import org.eclipse.chemclipse.msd.model.support.CondenseMassSpectrumCalculator;
import org.eclipse.chemclipse.support.comparator.SortOrder;

public abstract class XPassFilter {

	public static void nominalize(IScanMSD massSpectrum) {

		CondenseMassSpectrumCalculator calculator = new CondenseMassSpectrumCalculator(true);
		for(IIon ion : massSpectrum.getIons()) {
			calculator.add(ion.getIon(), ion.getAbundance());
		}
		//
		massSpectrum.removeAllIons();
		/*
		 * Create a new spectrum.
		 */
		for(Map.Entry<Double, Double> entry : calculator.getMappedTraces().entrySet()) {
			float intensity = entry.getValue().floatValue();
			IIon vendorIon = new Ion(entry.getKey(), intensity);
			massSpectrum.addIon(vendorIon);
		}
	}

	public static void applyHighPass(IScanMSD massSpectrum, int number) {

		filter(massSpectrum, SortOrder.DESC, number);
	}

	public static void applyLowPass(IScanMSD massSpectrum, int number) {

		filter(massSpectrum, SortOrder.ASC, number);
	}

	private static void filter(IScanMSD massSpectrum, SortOrder sortOrder, int number) {

		List<IIon> ions = new ArrayList<>(massSpectrum.getIons());
		Collections.sort(ions, new IonAbundanceComparator(sortOrder));
		List<IIon> ionsToRemove = new ArrayList<>();
		int counter = 0;
		for(IIon ion : ions) {
			if(counter >= number) {
				ionsToRemove.add(ion);
			}
			counter++;
		}
		/*
		 * Remove the ions.
		 */
		for(IIon ion : ionsToRemove) {
			massSpectrum.removeIon(ion);
		}
	}
}
