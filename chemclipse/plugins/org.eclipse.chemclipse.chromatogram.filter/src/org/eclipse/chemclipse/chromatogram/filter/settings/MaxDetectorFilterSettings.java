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
package org.eclipse.chemclipse.chromatogram.filter.settings;

import org.eclipse.chemclipse.chromatogram.filter.impl.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.settings.FloatSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.LabelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxDetectorFilterSettings extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Target Name", defaultValue = "M")
	@LabelProperty(value = "%TargetName", tooltip = "%TargetNameDescription")
	private String targetName = PreferenceSupplier.DEF_MAX_DETECTOR_TARGET_NAME;
	@JsonProperty(value = "Match Factor", defaultValue = "80.0")
	@LabelProperty(value = "%MatchFactor")
	@FloatSettingsProperty(minValue = PreferenceSupplier.MIN_FACTOR, maxValue = PreferenceSupplier.MAX_FACTOR)
	private float matchFactor = PreferenceSupplier.DEF_MAX_DETECTOR_MATCH_FACTOR;
	@JsonProperty(value = "Minima", defaultValue = "false")
	@LabelProperty(value = "%Minima", tooltip = "%MinimaDescription")
	private boolean detectMinima = PreferenceSupplier.DEF_MAX_DETECTOR_MINIMA;
	@JsonProperty(value = "Count", defaultValue = "0")
	@LabelProperty(value = "%Count", tooltip = "%CountDescription")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_COUNT_MARKER, maxValue = PreferenceSupplier.MAX_COUNT_MARKER)
	private int count = PreferenceSupplier.DEF_MAX_DETECTOR_COUNT;

	public String getTargetName() {

		return targetName;
	}

	public void setTargetName(String targetName) {

		this.targetName = targetName;
	}

	public float getMatchFactor() {

		return matchFactor;
	}

	public void setMatchFactor(float matchFactor) {

		this.matchFactor = matchFactor;
	}

	public boolean isDetectMinima() {

		return detectMinima;
	}

	public void setDetectMinima(boolean detectMinima) {

		this.detectMinima = detectMinima;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int count) {

		this.count = count;
	}
}