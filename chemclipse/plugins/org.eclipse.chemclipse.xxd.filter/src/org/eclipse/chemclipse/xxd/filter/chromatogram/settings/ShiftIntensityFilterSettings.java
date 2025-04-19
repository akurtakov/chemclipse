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
package org.eclipse.chemclipse.xxd.filter.chromatogram.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ShiftIntensityFilterSettings {

	@JsonProperty(value = "Intensity Option", defaultValue = "RELATIVE")
	@JsonPropertyDescription(value = "Define whether to use absolute or relative intensities.")
	private IntensityOption intensityOption = IntensityOption.RELATIVE;
	@JsonProperty(value = "Shift Intensity", defaultValue = "0.0")
	@JsonPropertyDescription(value = "Cut off intensities higher than the given value.")
	private float shiftIntensity = 0.0f;

	public IntensityOption getIntensityOption() {

		return intensityOption;
	}

	public void setIntensityOption(IntensityOption intensityOption) {

		this.intensityOption = intensityOption;
	}

	public float getShiftIntensity() {

		return shiftIntensity;
	}

	public void setShiftIntensity(float shiftIntensity) {

		this.shiftIntensity = shiftIntensity;
	}
}