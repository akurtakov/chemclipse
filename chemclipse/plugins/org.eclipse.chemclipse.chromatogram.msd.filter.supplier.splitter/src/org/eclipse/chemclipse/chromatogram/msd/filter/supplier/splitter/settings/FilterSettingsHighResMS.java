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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.model.core.support.HeaderField;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsHighResMS extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Header Field", defaultValue = "DATA_NAME")
	@JsonPropertyDescription(value = "Store the extracted transition in the selected header field.")
	private HeaderField headerField = HeaderField.DATA_NAME;
	@JsonProperty(value = "Binning (ppm)", defaultValue = "10")
	@JsonPropertyDescription(value = "Use the given ppm value to bin extract traces.")
	@IntSettingsProperty(minValue = 0, maxValue = Integer.MAX_VALUE)
	private int binning = 10;
	@JsonProperty(value = "Specific Traces", defaultValue = "")
	@JsonPropertyDescription(value = "Extract specific traces, e.g.: '400.01627' or '400.01627±5ppm'")
	@StringSettingsProperty(allowEmpty = false, isMultiLine = true)
	private String specificTraces = "";

	public HeaderField getHeaderField() {

		return headerField;
	}

	public void setHeaderField(HeaderField headerField) {

		this.headerField = headerField;
	}

	public int getBinning() {

		return binning;
	}

	public void setBinning(int binning) {

		this.binning = binning;
	}

	public String getSpecificTraces() {

		return specificTraces;
	}

	public void setSpecificTraces(String specificTraces) {

		this.specificTraces = specificTraces;
	}
}