/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.vsd.filter.settings;

import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class WavenumberCalibratorSettings {

	/*
	 * regExp = "((-?\\d+\\.?\\d?)[\\s]?)+",
	 */
	@JsonProperty(value = "Wavenumbers", defaultValue = "")
	@JsonPropertyDescription(value = "List of the wavenumbers.")
	@StringSettingsProperty(isMultiLine = true, allowEmpty = false)
	private String wavenumbers = "";

	public String getWavenumbers() {

		return wavenumbers;
	}

	public void setWavenumbers(String wavenumbers) {

		this.wavenumbers = wavenumbers;
	}
}