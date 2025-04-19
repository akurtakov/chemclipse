/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.filter.impl.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ScanTargetsToPeakSettings extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Transfer Closest Scan", defaultValue = "false")
	@JsonPropertyDescription(value = "If this value is true, only the closest scan to the peak maximum will be used to transfer targets.")
	private boolean transferClosestScan = false;
	@JsonProperty(value = "Transfer Best Target Only", defaultValue = "false")
	@JsonPropertyDescription(value = "If this value is true, only the best target will be transfered.")
	private boolean useBestTargetOnly = false;

	public boolean isTransferClosestScan() {

		return transferClosestScan;
	}

	public void setTransferClosestScan(boolean transferClosestScan) {

		this.transferClosestScan = transferClosestScan;
	}

	public boolean isUseBestTargetOnly() {

		return useBestTargetOnly;
	}

	public void setUseBestTargetOnly(boolean useBestTargetOnly) {

		this.useBestTargetOnly = useBestTargetOnly;
	}
}
