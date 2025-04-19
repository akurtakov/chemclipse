/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.chromatogram.settings;

import org.eclipse.chemclipse.support.settings.FloatSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class IntensityCutOffFilterSettings {

	@JsonProperty(value = "Intensity Option", defaultValue = "RELATIVE")
	@JsonPropertyDescription(value = "Define whether to use absolute or relative intensities.")
	private IntensityOption intensityOption = IntensityOption.RELATIVE;
	@JsonProperty(value = "Max Intensity", defaultValue = "75.0")
	@JsonPropertyDescription(value = "Cut off intensities higher than the given value.")
	@FloatSettingsProperty(minValue = 0)
	private float maxIntensity = 75.0f;

	public IntensityOption getIntensityOption() {

		return intensityOption;
	}

	public void setIntensityOption(IntensityOption intensityOption) {

		this.intensityOption = intensityOption;
	}

	public float getMaxIntensity() {

		return maxIntensity;
	}

	public void setMaxIntensity(float maxIntensity) {

		this.maxIntensity = maxIntensity;
	}
}