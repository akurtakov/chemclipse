/*******************************************************************************
 * Copyright (c) 2014, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.msd.model.core.IIon;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.comparator.IonValueComparator;

public class FilterSupplier {

	public void applySnipFilter(List<IScanMSD> massSpectra, int iterations, int transitions, double magnificationFactor) {

		for(IScanMSD massSpectrum : massSpectra) {
			/*
			 * Apply the filter to all peaks.
			 */
			for(int i = 1; i <= transitions; i++) {
				/*
				 * Do the subtraction n times.
				 */
				applySnipTransition(massSpectrum, iterations, magnificationFactor);
			}
		}
	}

	private void applySnipTransition(IScanMSD massSpectrum, int iterations, double magnificationFactor) {

		int extraValues = 6; // Leading and tailing extra values.
		List<IIon> ions = new ArrayList<>(massSpectrum.getIons());
		Collections.sort(ions, new IonValueComparator());
		float[] intensityValues = getIntensityValues(ions, extraValues);
		/*
		 * Run the SNIP baseline calculation.
		 */
		SnipCalculator.calculateBaselineIntensityValues(intensityValues, iterations);
		/*
		 * Subtract the values.
		 */
		List<IIon> ionsToRemove = applySnipBaselineToSubtractIons(ions, intensityValues, extraValues, magnificationFactor);
		for(IIon ion : ionsToRemove) {
			massSpectrum.removeIon(ion);
		}
	}

	private float[] getIntensityValues(List<IIon> ions, int extraValues) {

		float[] intensityValues = new float[ions.size() + extraValues * 2];
		int counter = 0;
		/*
		 * Extra values before.
		 */
		for(int i = 0; i < extraValues; i++) {
			intensityValues[counter++] = 1;
		}
		/*
		 * Data
		 */
		for(IIon ion : ions) {
			intensityValues[counter++] = ion.getAbundance();
		}
		/*
		 * Extra values after.
		 */
		for(int i = 0; i < extraValues; i++) {
			intensityValues[counter++] = 1;
		}

		return intensityValues;
	}

	private List<IIon> applySnipBaselineToSubtractIons(List<IIon> ions, float[] intensityValues, int extraValues, double magnificationFactor) {

		List<IIon> ionsToRemove = new ArrayList<>();
		int counter = 0;
		/*
		 * Skip leading extra values.
		 */
		for(int i = 0; i < extraValues; i++) {
			counter++;
		}
		/*
		 * Subtract intensity values.
		 */
		for(IIon ion : ions) {
			/*
			 * Get the baseline intensity and magnify the signal.
			 * 1 = no changes
			 * 1.3 = 30% extra
			 */
			float baselineIntensity = intensityValues[counter++];
			baselineIntensity *= magnificationFactor;
			/*
			 * Remove the calculated intensity.
			 */
			float abundance = ion.getAbundance() - baselineIntensity;
			if(abundance <= 0) {
				ionsToRemove.add(ion);
			} else {
				ion.setAbundance(abundance);
			}
		}
		/*
		 * Delete the ions that have been marked to be removed.
		 */
		return ionsToRemove;
	}
}
