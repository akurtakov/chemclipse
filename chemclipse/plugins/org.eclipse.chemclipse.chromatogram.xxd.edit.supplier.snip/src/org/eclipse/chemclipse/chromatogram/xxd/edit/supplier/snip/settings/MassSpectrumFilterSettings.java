/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.settings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.filter.settings.AbstractMassSpectrumFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.edit.supplier.snip.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.support.literature.LiteratureReference;
import org.eclipse.chemclipse.support.settings.DoubleSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class MassSpectrumFilterSettings extends AbstractMassSpectrumFilterSettings {

	private static final Logger logger = Logger.getLogger(MassSpectrumFilterSettings.class);

	@JsonProperty(value = "Iterations", defaultValue = "100")
	@JsonPropertyDescription(value = "The number of iterations to run the filter.")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_ITERATIONS, maxValue = PreferenceSupplier.MAX_ITERATIONS)
	private int iterations = 100;

	@JsonProperty(value = "Magnification Factor", defaultValue = "1.0")
	@JsonPropertyDescription(value = "The magnification factor run the filter.")
	@DoubleSettingsProperty(minValue = PreferenceSupplier.MIN_MAGNIFICATION_FACTOR, maxValue = PreferenceSupplier.MAX_MAGNIFICATION_FACTOR)
	private double magnificationFactor = 1.0d;

	@JsonProperty(value = "Transitions", defaultValue = "1")
	@JsonPropertyDescription(value = "The number of transitions run the filter.")
	@IntSettingsProperty(minValue = PreferenceSupplier.MIN_TRANSITIONS, maxValue = PreferenceSupplier.MAX_TRANSITIONS)
	private int transitions = 1;

	public int getIterations() {

		return iterations;
	}

	public void setIterations(int iterations) {

		this.iterations = iterations;
	}

	public double getMagnificationFactor() {

		return magnificationFactor;
	}

	public void setMagnificationFactor(double magnificationFactor) {

		this.magnificationFactor = magnificationFactor;
	}

	public int getTransitions() {

		return transitions;
	}

	public void setTransitions(int transitions) {

		this.transitions = transitions;
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