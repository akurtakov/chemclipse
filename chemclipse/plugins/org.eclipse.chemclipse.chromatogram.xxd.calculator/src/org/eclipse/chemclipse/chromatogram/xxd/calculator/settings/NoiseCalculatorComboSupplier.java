/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.settings;

import java.util.Collection;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.core.noise.INoiseCalculatorSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.core.noise.NoiseCalculator;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.exceptions.NoNoiseCalculatorAvailableException;
import org.eclipse.chemclipse.support.settings.ComboSettingsProperty.ComboSupplier;

public class NoiseCalculatorComboSupplier implements ComboSupplier<INoiseCalculatorSupplier> {

	@Override
	public Collection<INoiseCalculatorSupplier> items() {

		return NoiseCalculator.getNoiseCalculatorSupport().getCalculatorSupplier();
	}

	@Override
	public INoiseCalculatorSupplier fromString(String detectorId) {

		if(detectorId != null) {
			try {
				return NoiseCalculator.getNoiseCalculatorSupport().getCalculatorSupplier(detectorId);
			} catch(NoNoiseCalculatorAvailableException e) {
			}
		}
		return null;
	}

	@Override
	public String asString(INoiseCalculatorSupplier item) {

		if(item == null) {
			return null;
		}
		return item.getId();
	}
}
