/*******************************************************************************
 * Copyright (c) 2016, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsStretch extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Scan Delay [ms]", defaultValue = "0")
	@JsonPropertyDescription(value = "Set the scan delay.")
	@IntSettingsProperty(minValue = 0, maxValue = Integer.MAX_VALUE)
	private int scanDelay = 0;

	@JsonProperty(value = "Chromatogram Runtime [ms]", defaultValue = "300000")
	@JsonPropertyDescription(value = "Set the length of the chromatogram.")
	@IntSettingsProperty(minValue = 0, maxValue = Integer.MAX_VALUE)
	private int chromatogramLength = 300000;

	public FilterSettingsStretch() {

		// Default constructor is needed, see filter extension point: filterSettings=
	}

	public FilterSettingsStretch(int chromatogramLength) {

		this.chromatogramLength = chromatogramLength;
	}

	public int getScanDelay() {

		return scanDelay;
	}

	public void setScanDelay(int scanDelay) {

		this.scanDelay = scanDelay;
	}

	public int getChromatogramLength() {

		return chromatogramLength;
	}

	public void setChromatogramLength(int chromatogramLength) {

		this.chromatogramLength = chromatogramLength;
	}
}
