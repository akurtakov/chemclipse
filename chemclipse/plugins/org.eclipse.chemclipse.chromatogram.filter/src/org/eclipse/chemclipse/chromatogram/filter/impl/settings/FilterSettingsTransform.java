/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.impl.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsTransform extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "m/z", defaultValue = "28")
	@JsonPropertyDescription(value = "Use the following m/z when transforming the chromatogram to MSD.")
	@IntSettingsProperty(minValue = 18, maxValue = 1000)
	private int mz;

	public int getMz() {

		return mz;
	}

	public void setMz(int mz) {

		this.mz = mz;
	}
}