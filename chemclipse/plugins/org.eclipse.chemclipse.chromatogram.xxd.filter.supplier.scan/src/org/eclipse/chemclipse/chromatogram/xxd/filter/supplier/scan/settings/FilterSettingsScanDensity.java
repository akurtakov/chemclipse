/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsScanDensity extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Scans per Second", defaultValue = "2")
	@JsonPropertyDescription(value = "Define the target scan density of the chromatogram.")
	@IntSettingsProperty(minValue = 1, maxValue = 1000)
	private int scansPerSecond = 2;
	@JsonProperty(value = "Duplicated Scan (Merge Traces)", defaultValue = "true")
	@JsonPropertyDescription(value = "The traces of both start and stop scan shall be merged.")
	private boolean mergeScans = true;
	@JsonProperty(value = "Process Referenced Chromatograms", defaultValue = "true")
	@JsonPropertyDescription("Referenced chromatgrams will be also processed.")
	private boolean processReferencedChromatograms = true;

	public int getScansPerSecond() {

		return scansPerSecond;
	}

	public void setScansPerSecond(int scansPerSecond) {

		this.scansPerSecond = scansPerSecond;
	}

	public boolean isMergeScans() {

		return mergeScans;
	}

	public void setMergeScans(boolean mergeScans) {

		this.mergeScans = mergeScans;
	}

	public boolean isProcessReferencedChromatograms() {

		return processReferencedChromatograms;
	}

	public void setProcessReferencedChromatograms(boolean processReferencedChromatograms) {

		this.processReferencedChromatograms = processReferencedChromatograms;
	}
}