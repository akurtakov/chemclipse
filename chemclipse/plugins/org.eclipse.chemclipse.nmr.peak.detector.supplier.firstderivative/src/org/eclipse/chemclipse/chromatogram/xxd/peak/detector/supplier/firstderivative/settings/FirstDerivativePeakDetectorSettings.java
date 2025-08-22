/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.firstderivative.settings;

import org.eclipse.chemclipse.chromatogram.peak.detector.model.Threshold;
import org.eclipse.chemclipse.chromatogram.peak.detector.settings.AbstractPeakDetectorSettings;
import org.eclipse.chemclipse.chromatogram.peak.detector.settings.IPeakDetectorSettings;
import org.eclipse.chemclipse.chromatogram.xxd.peak.detector.supplier.firstderivative.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty.Validation;
import org.eclipse.chemclipse.support.settings.LabelProperty;
import org.eclipse.chemclipse.support.settings.serialization.WindowSizeDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class FirstDerivativePeakDetectorSettings extends AbstractPeakDetectorSettings implements IPeakDetectorSettings {

	@JsonProperty(value = "Window Size", defaultValue = "5")
	@LabelProperty(value = "%WindowSize", tooltip = "%WindowSizeDescription")
	@JsonDeserialize(using = WindowSizeDeserializer.class)
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_WINDOW_SIZE, maxValue = PreferenceSupplier.MAX_WINDOW_SIZE, validation = Validation.ODD_NUMBER_INCLUDING_ZERO)
	private int windowSize = 5;

	@JsonProperty(value = "Threshold", defaultValue = "MEDIUM")
	@LabelProperty(value = "%Threshold")
	private Threshold threshold = Threshold.MEDIUM;

	public int getMovingAverageWindowSize() {

		return windowSize;
	}

	public void setMovingAverageWindowSize(int windowSize) {

		this.windowSize = windowSize;
	}

	public Threshold getThreshold() {

		return threshold;
	}

	public void setThreshold(Threshold threshold) {

		if(threshold != null) {
			this.threshold = threshold;
		}
	}
}
