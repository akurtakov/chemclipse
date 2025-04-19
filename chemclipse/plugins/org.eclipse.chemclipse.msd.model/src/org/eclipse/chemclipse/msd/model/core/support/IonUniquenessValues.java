/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.model.core.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eselmeister
 */
public class IonUniquenessValues implements IIonUniquenessValues {

	private static Map<Integer, Float> probabilityValues;

	public IonUniquenessValues() {
		probabilityValues = new HashMap<Integer, Float>();
	}

	@Override
	public void add(int ion, float probabilityValue) {

		if(probabilityValue >= MIN_PROBABILITY_VALUE && probabilityValue <= MAX_PROBABILITY_VALUE) {
			probabilityValues.put(ion, probabilityValue);
		}
	}

	@Override
	public void remove(int ion) {

		probabilityValues.remove(ion);
	}

	@Override
	public float getUniquenessValue(int ion) {

		float result = getPropabilityValue(ion);
		return 1.0f - result;
	}

	@Override
	public float getPropabilityValue(int ion) {

		Float result = probabilityValues.get(ion);
		if(result == null) {
			return 0.0f;
		} else {
			return result;
		}
	}
}
