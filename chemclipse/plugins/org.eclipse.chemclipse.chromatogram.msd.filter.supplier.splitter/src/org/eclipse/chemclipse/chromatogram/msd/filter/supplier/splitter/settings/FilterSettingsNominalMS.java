/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsNominalMS extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Enforce Full Time Range", defaultValue = "false")
	@JsonPropertyDescription(value = "Create a reference chromatogram that could contain empty scans.")
	boolean enforceFullTimeRange = false;

	public boolean isEnforceFullTimeRange() {

		return enforceFullTimeRange;
	}

	public void setEnforceFullTimeRange(boolean enforceFullTimeRange) {

		this.enforceFullTimeRange = enforceFullTimeRange;
	}
}