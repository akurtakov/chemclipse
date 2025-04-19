/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsObfuscator extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Scans", defaultValue = "true")
	@JsonPropertyDescription(value = "Obfuscate the selected scans.")
	private boolean scans = true;
	@JsonProperty(value = "Peaks", defaultValue = "false")
	@JsonPropertyDescription(value = "Obfuscate the selected peaks.")
	private boolean peaks = false;

	public boolean isScans() {

		return scans;
	}

	public void setScans(boolean scans) {

		this.scans = scans;
	}

	public boolean isPeaks() {

		return peaks;
	}

	public void setPeaks(boolean peaks) {

		this.peaks = peaks;
	}
}