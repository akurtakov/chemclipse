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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.system;

import org.eclipse.chemclipse.processing.system.ISystemProcessSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ConverterProcessSettings implements ISystemProcessSettings {

	@JsonProperty(value = "Calibration Export (Use Curated Names)", defaultValue = "true")
	@JsonPropertyDescription(value = "On export of the *.cal file, the names are matched e.g. to C6 (Hexane).")
	private boolean calibrationExportUseCuratedNames = true;
	@JsonProperty(value = "Calibration Export (Derive Missing Indices)", defaultValue = "true")
	@JsonPropertyDescription(value = "If alkane indices are missing, try to calculate them existing peak retention indices.")
	private boolean calibrationExportDeriveMissingIndices = true;

	public boolean isCalibrationExportUseCuratedNames() {

		return calibrationExportUseCuratedNames;
	}

	public void setCalibrationExportUseCuratedNames(boolean calibrationExportUseCuratedNames) {

		this.calibrationExportUseCuratedNames = calibrationExportUseCuratedNames;
	}

	public boolean isCalibrationExportDeriveMissingIndices() {

		return calibrationExportDeriveMissingIndices;
	}

	public void setCalibrationExportDeriveMissingIndices(boolean calibrationExportDeriveMissingIndices) {

		this.calibrationExportDeriveMissingIndices = calibrationExportDeriveMissingIndices;
	}
}