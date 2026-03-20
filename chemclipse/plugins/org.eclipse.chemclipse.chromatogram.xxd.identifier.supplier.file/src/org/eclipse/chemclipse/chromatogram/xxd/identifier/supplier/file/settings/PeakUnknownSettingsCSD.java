/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.identifier.supplier.file.settings;

import org.eclipse.chemclipse.chromatogram.csd.identifier.settings.IPeakIdentifierSettingsCSD;
import org.eclipse.chemclipse.model.identifier.AbstractIdentifierSettings;
import org.eclipse.chemclipse.model.identifier.GeneratedIdentifierSettings;
import org.eclipse.chemclipse.support.settings.FloatSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@GeneratedIdentifierSettings
public class PeakUnknownSettingsCSD extends AbstractIdentifierSettings implements IPeakIdentifierSettingsCSD, IUnknownSettings {

	@JsonProperty(value = "Target Name", defaultValue = "Unknown")
	private String targetName = "Unknown";

	@JsonProperty(value = "Match Quality", defaultValue = "80.0")
	@JsonPropertyDescription(value = "The match quality is set as the Match Factor.")
	@FloatSettingsProperty(minValue = 0.0f, maxValue = 100.0f)
	private float matchQuality = 80.0f;

	@JsonProperty(value = "Marker Start", defaultValue = "[")
	private String markerStart = "[";

	@JsonProperty(value = "Marker Stop", defaultValue = "]")
	private String markerStop = "]";

	@JsonProperty(value = "Include Retention Time", defaultValue = "true")
	private boolean includeRetentionTime = true;

	@JsonProperty(value = "Include Retention Index", defaultValue = "false")
	private boolean includeRetentionIndex = false;

	@Override
	public String getTargetName() {

		return targetName;
	}

	@Override
	public void setTargetName(String targetName) {

		this.targetName = targetName;
	}

	@Override
	public float getMatchQuality() {

		return matchQuality;
	}

	@Override
	public void setMatchQuality(float matchQuality) {

		this.matchQuality = matchQuality;
	}

	@Override
	public String getMarkerStart() {

		return markerStart;
	}

	@Override
	public void setMarkerStart(String markerStart) {

		this.markerStart = markerStart;
	}

	@Override
	public String getMarkerStop() {

		return markerStop;
	}

	@Override
	public void setMarkerStop(String markerStop) {

		this.markerStop = markerStop;
	}

	@Override
	public boolean isIncludeRetentionTime() {

		return includeRetentionTime;
	}

	@Override
	public void setIncludeRetentionTime(boolean includeRetentionTime) {

		this.includeRetentionTime = includeRetentionTime;
	}

	@Override
	public boolean isIncludeRetentionIndex() {

		return includeRetentionIndex;
	}

	@Override
	public void setIncludeRetentionIndex(boolean includeRetentionIndex) {

		this.includeRetentionIndex = includeRetentionIndex;
	}
}
