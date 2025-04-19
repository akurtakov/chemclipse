/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class IndexExportSettings {

	@JsonProperty(value = "Curate Names", defaultValue = "true")
	@JsonPropertyDescription(value = "Names are matched e.g. to C6 (Hexane).")
	private boolean useCuratedNames = true;
	@JsonProperty(value = "Derive Missing Indices", defaultValue = "true")
	@JsonPropertyDescription(value = "If alkane indices are missing, try to calculate them existing peak retention indices.")
	private boolean deriveMissingIndices = true;
	@JsonProperty(value = "Open Calibration File", defaultValue = "false")
	@JsonPropertyDescription(value = "Opens the calibration file with the system application if available after processing.")
	private boolean openCalibrationFileAfterProcessing = false;

	public boolean isUseCuratedNames() {

		return useCuratedNames;
	}

	public void setUseCuratedNames(boolean useCuratedNames) {

		this.useCuratedNames = useCuratedNames;
	}

	public boolean isDeriveMissingIndices() {

		return deriveMissingIndices;
	}

	public void setDeriveMissingIndices(boolean deriveMissingIndices) {

		this.deriveMissingIndices = deriveMissingIndices;
	}

	public boolean isOpenCalibrationFileAfterProcessing() {

		return openCalibrationFileAfterProcessing;
	}

	public void setOpenCalibrationFileAfterProcessing(boolean openCalibrationFileAfterProcessing) {

		this.openCalibrationFileAfterProcessing = openCalibrationFileAfterProcessing;
	}
}