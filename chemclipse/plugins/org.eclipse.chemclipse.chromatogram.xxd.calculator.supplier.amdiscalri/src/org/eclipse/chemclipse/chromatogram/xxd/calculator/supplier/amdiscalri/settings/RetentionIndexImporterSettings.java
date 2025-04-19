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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl.RetentionIndexImporter;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexFileOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class RetentionIndexImporterSettings {

	@JsonProperty(value = "Retention Index File", defaultValue = "CAL")
	@JsonPropertyDescription("The retention index file to be used.")
	private RetentionIndexFileOption retentionIndexFileOption = RetentionIndexFileOption.CAL;
	@JsonProperty(value = "File Name Pattern", defaultValue = "")
	@JsonPropertyDescription("The name pattern for the calibration file can be set here, e.g. '" + RetentionIndexImporter.PLACEHOLDER_CHROMATOGRAM_NAME + "' to match the chromatogram name.")
	private String fileNamePattern = "";
	@JsonProperty(value = "Case Sensitive", defaultValue = "true")
	@JsonPropertyDescription("Case sensitivity to match the calibration file.")
	private boolean caseSensitive = true;
	@JsonProperty(value = "Reference Chromatograms", defaultValue = "true")
	@JsonPropertyDescription("Process all referenced chromatograms.")
	private boolean processReferenceChromatograms = true;

	public RetentionIndexFileOption getRetentionIndexFileOption() {

		return retentionIndexFileOption;
	}

	public void setRetentionIndexFileOption(RetentionIndexFileOption retentionIndexFileOption) {

		this.retentionIndexFileOption = retentionIndexFileOption;
	}

	public String getFileNamePattern() {

		return fileNamePattern;
	}

	public void setFileNamePattern(String fileNamePattern) {

		this.fileNamePattern = fileNamePattern;
	}

	public boolean isCaseSensitive() {

		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {

		this.caseSensitive = caseSensitive;
	}

	public boolean isProcessReferenceChromatograms() {

		return processReferenceChromatograms;
	}

	public void setProcessReferenceChromatograms(boolean processReferenceChromatograms) {

		this.processReferenceChromatograms = processReferenceChromatograms;
	}
}