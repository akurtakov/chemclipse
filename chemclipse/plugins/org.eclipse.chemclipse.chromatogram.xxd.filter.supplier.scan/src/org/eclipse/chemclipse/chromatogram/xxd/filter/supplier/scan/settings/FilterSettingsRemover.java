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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsRemover extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Scan Remover Pattern", defaultValue = PreferenceSupplier.DEF_REMOVER_PATTERN)
	@JsonPropertyDescription(value = "The pattern, which is used to remove scans.")
	@StringSettingsProperty(regExp = PreferenceSupplier.CHECK_REMOVER_PATTERN, allowEmpty = false)
	private String scanRemoverPattern = PreferenceSupplier.DEF_REMOVER_PATTERN;

	@Override
	public void setSystemSettings() {

		scanRemoverPattern = PreferenceSupplier.getScanRemoverPattern();
	}

	public String getScanRemoverPattern() {

		return scanRemoverPattern;
	}

	public void setScanRemoverPattern(String scanRemoverPattern) {

		if(scanRemoverPattern != null) {
			this.scanRemoverPattern = scanRemoverPattern;
		}
	}
}