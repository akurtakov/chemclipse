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
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.xxd.filter.preferences.PreferenceSupplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class HighPassPeaksFilterSettings {

	@JsonProperty(value = "Number Highest", defaultValue = "5")
	@JsonPropertyDescription(value = "This value defines the number of n highest peaks to be preserved.")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_NUMBER_HIGHEST, maxValue = PreferenceSupplier.MAX_NUMBER_HIGHEST)
	private int numberHighest = PreferenceSupplier.DEF_NUMBER_HIGHEST;
	@JsonProperty(value = "Filter Option", defaultValue = "AREA")
	@JsonPropertyDescription(value = "Select the option to filter the peaks.")
	private PeakFilterOption peakFilterOption = PeakFilterOption.AREA;

	public int getNumberHighest() {

		return numberHighest;
	}

	public void setNumberHighest(int numberHighest) {

		this.numberHighest = numberHighest;
	}

	public PeakFilterOption getPeakFilterOption() {

		return peakFilterOption;
	}

	public void setPeakFilterOption(PeakFilterOption peakFilterOption) {

		this.peakFilterOption = peakFilterOption;
	}
}