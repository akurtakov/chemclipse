/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.support.settings.FloatSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.LabelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxDetectorFilterSettings extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Target Name", defaultValue = "M")
	@LabelProperty(value = "%TargetName", tooltip = "%TargetNameDescription")
	private String targetName = "M";

	@JsonProperty(value = "Match Factor", defaultValue = "80.0")
	@LabelProperty(value = "%MatchFactor")
	@FloatSettingsProperty(minValue = 0.0f, maxValue = 100.0f)
	private float matchFactor = 80.0f;

	@JsonProperty(value = "Minima", defaultValue = "false")
	@LabelProperty(value = "%Minima", tooltip = "%MinimaDescription")
	private boolean detectMinima = false;

	@JsonProperty(value = "Count", defaultValue = "0")
	@LabelProperty(value = "%Count", tooltip = "%CountDescription")
	@IntSettingsProperty(minValue = 0, maxValue = Integer.MAX_VALUE)
	private int count = 0;

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