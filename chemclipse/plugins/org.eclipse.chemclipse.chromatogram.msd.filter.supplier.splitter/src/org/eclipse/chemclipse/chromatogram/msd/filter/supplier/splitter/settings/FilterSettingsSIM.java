/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsSIM extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Limit Ions", defaultValue = "5")
	@JsonPropertyDescription(value = "If the scan contains m/z values <= limit, then assume that it is a SIM.")
	@IntSettingsProperty(minValue = 1, maxValue = Integer.MAX_VALUE)
	private int limitIons = 5;

	public int getLimitIons() {

		return limitIons;
	}

	public void setLimitIons(int limitIons) {

		this.limitIons = limitIons;
	}
}