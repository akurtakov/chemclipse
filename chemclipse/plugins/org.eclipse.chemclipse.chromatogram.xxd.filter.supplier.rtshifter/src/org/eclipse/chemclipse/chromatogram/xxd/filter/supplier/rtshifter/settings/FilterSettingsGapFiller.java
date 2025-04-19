/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsGapFiller extends AbstractChromatogramFilterSettings {

	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_LIMIT_FACTOR, maxValue = PreferenceSupplier.MAX_LIMIT_FACTOR)
	@JsonProperty(value = "Limit Factor", defaultValue = "4")
	@JsonPropertyDescription("The gap must be larger than the scan interval * limit factor to be filled.")
	private int limitFactor = PreferenceSupplier.DEF_LIMIT_FACTOR;

	public int getLimitFactor() {

		return limitFactor;
	}

	public void setLimitFactor(int limitFactor) {

		this.limitFactor = limitFactor;
	}
}
