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
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.settings;

import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.model.TargetTraces;
import org.eclipse.chemclipse.chromatogram.msd.classifier.supplier.wnc.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.settings.AbstractChromatogramClassifierSettings;
import org.eclipse.chemclipse.support.settings.StringSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ClassifierSettings extends AbstractChromatogramClassifierSettings {

	@JsonProperty(value = "Traces", defaultValue = PreferenceSupplier.DEFAULT_TRACES)
	@JsonPropertyDescription(value = "List the m/z traces to inspect.")
	@StringSettingsProperty(allowEmpty = true, isMultiLine = true)
	private String traces = PreferenceSupplier.DEFAULT_TRACES;

	public String getTraces() {

		return traces;
	}

	public void setTraces(String traces) {

		this.traces = traces;
	}

	public TargetTraces getTargetTraces() {

		return PreferenceSupplier.getTargetTraces(traces);
	}
}