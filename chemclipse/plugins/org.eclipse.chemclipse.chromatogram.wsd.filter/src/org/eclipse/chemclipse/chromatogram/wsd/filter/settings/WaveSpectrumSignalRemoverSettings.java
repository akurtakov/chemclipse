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
package org.eclipse.chemclipse.chromatogram.wsd.filter.settings;

import org.eclipse.chemclipse.model.core.MarkedTraceModus;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class WaveSpectrumSignalRemoverSettings {

	@JsonProperty(value = "Wavelengths", defaultValue = "200 202")
	@JsonPropertyDescription(value = "List the wavelengths, separated by a white space.")
	@StringSettingsProperty(regExp = "(\\d+[;|\\s]?)+", description = "must be space separated digits.", isMultiLine = false, allowEmpty = false)
	private String wavelengthsToRemove = "200 202";
	@JsonProperty(value = "Mode", defaultValue = "INCLUDE")
	@JsonPropertyDescription(value = "Gives the mode to use (include = remove all wavelengths given in the list, exclude = remove all wavelengths not in the list)")
	private MarkedTraceModus markMode = MarkedTraceModus.INCLUDE;

	public String getWavelengthsToRemove() {

		return wavelengthsToRemove;
	}

	public void setWavelengthsToRemove(String wavelengthsToRemove) {

		this.wavelengthsToRemove = wavelengthsToRemove;
	}

	public MarkedTraceModus getMarkMode() {

		return markMode;
	}

	public void setMarkMode(MarkedTraceModus markMode) {

		this.markMode = markMode;
	}
}