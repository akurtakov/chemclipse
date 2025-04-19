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
package org.eclipse.chemclipse.msd.model.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.chemclipse.msd.model.core.AbstractIon;

public class CondenseMassSpectrumCalculator {

	private boolean condenseNominal = false;
	private Map<Double, Double> mappedTraces = new HashMap<>();

	public CondenseMassSpectrumCalculator(boolean condenseNominal) {

		this.condenseNominal = condenseNominal;
	}

	public void add(double mz, double intensity) {

		double mzMapped = condenseNominal ? AbstractIon.getIon(mz) : mz;
		Double intensityMapped = mappedTraces.get(mzMapped);
		//
		if(intensityMapped == null) {
			mappedTraces.put(mzMapped, intensity);
		} else {
			intensityMapped += intensity;
			mappedTraces.put(mzMapped, intensityMapped);
		}
	}

	public Map<Double, Double> getMappedTraces() {

		return Collections.unmodifiableMap(mappedTraces);
	}
}
