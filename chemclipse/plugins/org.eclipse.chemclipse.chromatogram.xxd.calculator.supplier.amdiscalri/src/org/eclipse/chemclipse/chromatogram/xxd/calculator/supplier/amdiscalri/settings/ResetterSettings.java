/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.settings.AbstractChromatogramCalculatorSettings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ResetterSettings extends AbstractChromatogramCalculatorSettings implements IRetentionIndexFilterSettings {

	@JsonProperty(value = "Clear Retention Indices (Stored)", defaultValue = "true")
	@JsonPropertyDescription("The retention indices, that are stored in the chromatogram, will be cleared.")
	private boolean clearStoredRetentionIndices = true;

	@JsonProperty(value = "Process Referenced Chromatograms", defaultValue = "true")
	@JsonPropertyDescription("Referenced chromatgrams will be also processed.")
	private boolean processReferencedChromatograms = true;

	@JsonIgnore
	private List<String> retentionIndexFiles = new ArrayList<>();

	@Override
	public List<String> getRetentionIndexFiles() {

		return retentionIndexFiles;
	}

	@Override
	public void setRetentionIndexFiles(List<String> retentionIndexFiles) {

		this.retentionIndexFiles = retentionIndexFiles;
	}

	public boolean isClearStoredRetentionIndices() {

		return clearStoredRetentionIndices;
	}

	public void setClearStoredRetentionIndices(boolean clearStoredRetentionIndices) {

		this.clearStoredRetentionIndices = clearStoredRetentionIndices;
	}

	public boolean isProcessReferencedChromatograms() {

		return processReferencedChromatograms;
	}

	public void setProcessReferencedChromatograms(boolean processReferencedChromatograms) {

		this.processReferencedChromatograms = processReferencedChromatograms;
	}
}
