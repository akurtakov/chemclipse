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
 * Dr. Alexander Kerner - implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.backfolding.settings;

import org.eclipse.chemclipse.chromatogram.msd.peak.detector.settings.AbstractPeakDetectorSettingsMSD;
import org.eclipse.chemclipse.chromatogram.peak.detector.model.Threshold;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PeakDetectorSettings extends AbstractPeakDetectorSettingsMSD {

	@JsonProperty(value = "Threshold", defaultValue = "MEDIUM")
	private Threshold threshold = Threshold.MEDIUM;
	@JsonIgnore
	private IBackfoldingSettings backfoldingSettings;

	public PeakDetectorSettings() {

		backfoldingSettings = new BackfoldingSettings();
	}

	public IBackfoldingSettings getBackfoldingSettings() {

		return backfoldingSettings;
	}

	public Threshold getThreshold() {

		return threshold;
	}

	public void setThreshold(Threshold threshold) {

		this.threshold = threshold;
	}
}
