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
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import org.eclipse.chemclipse.xxd.filter.peaks.PeakModelOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class DeletePeaksByModelFilterSettings {

	@JsonProperty(value = "Peak Model Option", defaultValue = "NON_STRICT")
	@JsonPropertyDescription(value = "Peaks with the given peak model will be deleted.")
	private PeakModelOption peakModelOption = PeakModelOption.NON_STRICT;

	public PeakModelOption getPeakModelOption() {

		return peakModelOption;
	}

	public void setPeakModelOption(PeakModelOption peakModelOption) {

		this.peakModelOption = peakModelOption;
	}
}