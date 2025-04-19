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

public class LowPassPeaksFilterSettings {

	@JsonProperty(value = "Number Lowest", defaultValue = "5")
	@JsonPropertyDescription(value = "This value defines the number of n lowest peaks to be preserved.")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_NUMBER_LOWEST, maxValue = PreferenceSupplier.MAX_NUMBER_LOWEST)
	private int numberLowest = PreferenceSupplier.DEF_NUMBER_LOWEST;
	@JsonProperty(value = "Filter Option", defaultValue = "AREA")
	@JsonPropertyDescription(value = "Select the option to filter the peaks.")
	private PeakFilterOption peakFilterOption = PeakFilterOption.AREA;

	public int getNumberLowest() {

		return numberLowest;
	}

	public void setNumberLowest(int numberLowest) {

		this.numberLowest = numberLowest;
	}

	public PeakFilterOption getPeakFilterOption() {

		return peakFilterOption;
	}

	public void setPeakFilterOption(PeakFilterOption peakFilterOption) {

		this.peakFilterOption = peakFilterOption;
	}
}