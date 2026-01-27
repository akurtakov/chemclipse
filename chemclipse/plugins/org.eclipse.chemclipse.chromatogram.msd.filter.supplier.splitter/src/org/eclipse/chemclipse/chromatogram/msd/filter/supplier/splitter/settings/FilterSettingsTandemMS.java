/*******************************************************************************
 * Copyright (c) 2024, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.msd.model.support.CondenseOption;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsTandemMS extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Header Field", defaultValue = "DATA_NAME")
	@JsonPropertyDescription(value = "Store the extracted transition in the selected header field.")
	private HeaderField headerField = HeaderField.DATA_NAME;
	@JsonProperty(value = "Specific Traces", defaultValue = "")
	@JsonPropertyDescription(value = "Extract specific transitions, e.g.: '267 > 159.0 @15'")
	@StringSettingsProperty(allowEmpty = true, isMultiLine = true)
	private String specificTraces = "";
	@JsonProperty(value = "Condense Option", defaultValue = "STANDARD")
	@JsonPropertyDescription(value = "Some instruments store each transition in a separate scan, which leads to slightly deviating retention times.")
	private CondenseOption condenseOption = CondenseOption.STANDARD;
	@JsonProperty(value = "Enforce Full Time Range", defaultValue = "false")
	@JsonPropertyDescription(value = "Create a reference chromatogram that could contain empty scans.")
	boolean enforceFullTimeRange = false;
	@JsonProperty(value = "Separate Traces", defaultValue = "true")
	@JsonPropertyDescription(value = "Each trace is saved in a separate reference chromatogram.")
	boolean separateTraces = true;

	public HeaderField getHeaderField() {

		return headerField;
	}

	public void setHeaderField(HeaderField headerField) {

		this.headerField = headerField;
	}

	public String getSpecificTraces() {

		return specificTraces;
	}

	public void setSpecificTraces(String specificTraces) {

		this.specificTraces = specificTraces;
	}

	public CondenseOption getCondenseOption() {

		return condenseOption;
	}

	public void setCondenseOption(CondenseOption condenseOption) {

		this.condenseOption = condenseOption;
	}

	public boolean isEnforceFullTimeRange() {

		return enforceFullTimeRange;
	}

	public void setEnforceFullTimeRange(boolean enforceFullTimeRange) {

		this.enforceFullTimeRange = enforceFullTimeRange;
	}

	public boolean isSeparateTraces() {

		return separateTraces;
	}

	public void setSeparateTraces(boolean separateTraces) {

		this.separateTraces = separateTraces;
	}
}