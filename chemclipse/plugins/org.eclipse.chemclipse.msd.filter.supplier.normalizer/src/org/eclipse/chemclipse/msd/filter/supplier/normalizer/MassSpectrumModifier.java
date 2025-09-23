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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.filter.supplier.normalizer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.chemclipse.model.core.IMassSpectrumPeak;
import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.IStandaloneMassSpectrum;

public class MassSpectrumModifier {

	public static void medianNormalize(IScanMSD massSpectrum) throws IllegalStateException {

		float median = calculateMedian(massSpectrum.getIons());
		if(median == 0) {
			throw new IllegalStateException("The median abundance must not be 0.");
		}
		normalize(massSpectrum, median);
	}

	public static void meanNormalize(IScanMSD massSpectrum) throws IllegalStateException {

		float mean = calculateMean(massSpectrum.getIons());
		if(mean == 0) {
			throw new IllegalStateException("The mean abundance must not be 0.");
		}
		normalize(massSpectrum, mean);
	}

	/**
	 * Normalize signals and peaks.
	 * 
	 * @param massSpectrum
	 * @param average
	 */
	private static void normalize(IScanMSD massSpectrum, float average) {

		for(IIon ion : massSpectrum.getIons()) {
			ion.setAbundance(getNormalized(ion.getAbundance(), average));
		}
		if(massSpectrum instanceof IStandaloneMassSpectrum standaloneMassSpectrum) {
			for(IMassSpectrumPeak massSpectrumPeak : standaloneMassSpectrum.getPeaks()) {
				massSpectrumPeak.setAbundance(getNormalized((float)massSpectrumPeak.getAbundance(), average));
			}
		}
	}

	private static float calculateMedian(List<IIon> unmodifiableList) {

		List<IIon> ions = getSorted(unmodifiableList);
		int middle = ions.size() / 2;

		if(ions.size() % 2 == 1) {
			return ions.get(middle).getAbundance();
		} else {
			return (ions.get(middle - 1).getAbundance() + ions.get(middle).getAbundance()) / 2.0f;
		}
	}

	private static List<IIon> getSorted(List<IIon> unmodifiableList) {

		List<IIon> ions = new ArrayList<IIon>(unmodifiableList);
		ions.sort(Comparator.comparingDouble(IIon::getAbundance));
		return ions;
	}

	private static float calculateMean(List<IIon> ions) {

		int size = ions.size();
		if(size == 0) {
			return 0.0f;
		}

		float sum = 0.0f;
		for(IIon ion : ions) {
			sum += ion.getAbundance();
		}
		return sum / size;
	}

	private static float getNormalized(float abundance, float median) {

		float normalizedIntensity = abundance / median;
		if(normalizedIntensity < 0.0f) {
			normalizedIntensity = 0.0f;
		}
		return normalizedIntensity;
	}
}
