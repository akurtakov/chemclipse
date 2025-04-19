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
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - initial API and implementation
 * Dr. Alexander Kerner - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class SignalToNoisePeakFilterSettings {

	@JsonProperty(value = "Min Signal-To-Noise", defaultValue = "10")
	@JsonPropertyDescription(value = "The min S/N value to filter peaks.")
	private float minSignalToNoise = 10;
	@JsonProperty(value = "Max Signal-To-Noise", defaultValue = "10000")
	@JsonPropertyDescription(value = "The max S/N value to filter peaks.")
	private float maxSignalToNoise = 10000;

	public float getMinSignalToNoise() {

		return minSignalToNoise;
	}

	public void setMinSignalToNoise(float minSignalToNoise) {

		this.minSignalToNoise = minSignalToNoise;
	}

	public float getMaxSignalToNoise() {

		return maxSignalToNoise;
	}

	public void setMaxSignalToNoise(float maxSignalToNoise) {

		this.maxSignalToNoise = maxSignalToNoise;
	}
}
