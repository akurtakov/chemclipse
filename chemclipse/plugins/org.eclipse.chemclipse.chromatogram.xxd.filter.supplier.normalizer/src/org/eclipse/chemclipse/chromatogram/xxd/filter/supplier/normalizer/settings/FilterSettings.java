/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.normalizer.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.support.settings.FloatSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettings extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Normalization Base", defaultValue = "1000")
	@JsonPropertyDescription(value = "Use this value to normalize the chromatogram.")
	@FloatSettingsProperty(minValue = 1.0f, maxValue = Float.MAX_VALUE)
	private float normalizationBase = 1000.0f;

	public float getNormalizationBase() {

		return normalizationBase;
	}

	public void setNormalizationBase(float normalizationBase) {

		if(normalizationBase >= 1.0f && !Float.isNaN(normalizationBase) && !Float.isInfinite(normalizationBase)) {
			this.normalizationBase = normalizationBase;
		}
	}
}
