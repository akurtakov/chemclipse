/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.multiplier.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.support.settings.FloatSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class DivisorSettings extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Divisor", defaultValue = "1")
	@JsonPropertyDescription(value = "The factor to divide the signals.")
	@FloatSettingsProperty(minValue = 1.0E-12f, maxValue = Float.MAX_VALUE)
	private float divisor = 1.0f;

	public float getDivisor() {

		return divisor;
	}

	public void setDivisor(float divisor) {

		this.divisor = divisor;
	}
}
