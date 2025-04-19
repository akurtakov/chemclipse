/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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

public class FilterSettingsDeleteIdentifier extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Delete Scan Targets", defaultValue = "false")
	@JsonPropertyDescription(value = "Confirm to delete the scan targets.")
	private boolean deleteScanIdentifications;

	public boolean isDeleteScanIdentifications() {

		return deleteScanIdentifications;
	}

	public void setDeleteScanIdentifications(boolean deleteScanIdentifications) {

		this.deleteScanIdentifications = deleteScanIdentifications;
	}
}