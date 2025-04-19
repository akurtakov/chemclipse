/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class PeakActiveForAnalysisSettings {

	@JsonProperty(value = "Active for Analysis", defaultValue = "true")
	@JsonPropertyDescription("Set the active for analysis status of the peaks.")
	private boolean activeForAnalysis = true;

	public boolean isActiveForAnalysis() {

		return activeForAnalysis;
	}

	public void setActiveForAnalysis(boolean activeForAnalysis) {

		this.activeForAnalysis = activeForAnalysis;
	}
}