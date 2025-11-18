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

	@JsonProperty(value = "Transfer Closest Scan", defaultValue = "true")
	@JsonPropertyDescription(value = "Transfer the targets of the closest scan relative to the peak.")
	private boolean transferClosestScan = true;
	@JsonProperty(value = "Transfer Best Target Only", defaultValue = "true")
	@JsonPropertyDescription(value = "Transfer only the best target.")
	private boolean useBestTargetOnly = true;
	@JsonProperty(value = "Delete Assigned Scan Identifications", defaultValue = "true")
	@JsonPropertyDescription(value = "If scan targets were assigned to a peak, delete the scan identification.")
	private boolean deleteAssignedScanIdentifications = true;

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

	public boolean isDeleteAssignedScanIdentifications() {

		return deleteAssignedScanIdentifications;
	}

	public void setDeleteAssignedScanIdentifications(boolean deleteAssignedScanIdentifications) {

		this.deleteAssignedScanIdentifications = deleteAssignedScanIdentifications;
	}
}