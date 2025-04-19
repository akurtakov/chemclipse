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

public class FilterSettingsDelayInterval extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Reset Retention Times", defaultValue = "false")
	@JsonPropertyDescription(value = "Reset the retention times after calculation of scan delay/interval.")
	private boolean resetRetentionTimes = false;

	public boolean isResetRetentionTimes() {

		return resetRetentionTimes;
	}

	public void setResetRetentionTimes(boolean resetRetentionTimes) {

		this.resetRetentionTimes = resetRetentionTimes;
	}
}