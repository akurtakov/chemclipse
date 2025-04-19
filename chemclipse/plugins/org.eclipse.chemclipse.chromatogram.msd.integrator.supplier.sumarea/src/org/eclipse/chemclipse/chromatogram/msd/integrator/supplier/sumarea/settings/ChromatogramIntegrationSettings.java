/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.integrator.supplier.sumarea.settings;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.chromatogram.AbstractChromatogramIntegrationSettings;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChromatogramIntegrationSettings extends AbstractChromatogramIntegrationSettings {

	@JsonProperty(value = "Ions To Integrate", defaultValue = "")
	@JsonPropertyDescription(value = "List the ions to integrate, separated by a semicolon. Empty means TIC.")
	@StringSettingsProperty(regExp = "(^$|((\\d+;?)+))", description = "must be semicolon separated digits.", isMultiLine = false, allowEmpty = true)
	private String selectedIons = "";

	public String getSelectedIons() {

		return selectedIons;
	}

	public void setSelectedIons(String selectedIons) {

		this.selectedIons = selectedIons;
	}
}
