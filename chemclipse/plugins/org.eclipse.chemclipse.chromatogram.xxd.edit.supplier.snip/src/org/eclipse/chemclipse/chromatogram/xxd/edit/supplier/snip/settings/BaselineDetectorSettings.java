/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - remove the window size enum
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.settings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.settings.AbstractBaselineDetectorSettings;
import org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty.Validation;
import org.eclipse.chemclipse.support.settings.serialization.WindowSizeDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class BaselineDetectorSettings extends AbstractBaselineDetectorSettings {

	private static final Logger logger = Logger.getLogger(BaselineDetectorSettings.class);

	@JsonProperty(value = "Number of Iterations", defaultValue = "100")
	@JsonPropertyDescription(value = "The number of iterations to apply the SNIP filter.")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_ITERATIONS, maxValue = PreferenceSupplier.MAX_ITERATIONS)
	private int iterations = 100;

	@JsonProperty(value = "Window Size", defaultValue = "5")
	@JsonPropertyDescription(value = "Window Size: 3, 5, 7, ..., 45")
	@JsonDeserialize(using = WindowSizeDeserializer.class)
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_WINDOW_SIZE, maxValue = PreferenceSupplier.MAX_WINDOW_SIZE, validation = Validation.ODD_NUMBER_INCLUDING_ZERO)
	private int windowSize = 5;

	public int getWindowSize() {

		return windowSize;
	}

	public void setWindowSize(int windowSize) {

		this.windowSize = windowSize;
	}

	public int getIterations() {

		return iterations;
	}

	public void setIterations(int iterations) {

		this.iterations = iterations;
	}

	@Override
	public List<LiteratureReference> getLiteratureReferences() {

		List<LiteratureReference> literatureReferences = new ArrayList<>();
		literatureReferences.add(createLiteratureReference("0168583X88900638.ris", "10.1016/0168-583X(88)90063-8"));
		return literatureReferences;
	}

	private static LiteratureReference createLiteratureReference(String file, String doi) {

		String content;
		try {
			content = new String(BaselineDetectorSettings.class.getResourceAsStream(file).readAllBytes());
		} catch(Exception e) {
			content = doi;
			logger.warn(e);
		}
		return new LiteratureReference(content);
	}
}