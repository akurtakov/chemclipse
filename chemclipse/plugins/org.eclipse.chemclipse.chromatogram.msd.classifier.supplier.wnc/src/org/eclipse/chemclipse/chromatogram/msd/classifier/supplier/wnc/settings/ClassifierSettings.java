/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
import org.eclipse.chemclipse.chromatogram.xxd.classifier.settings.AbstractChromatogramClassifierSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ClassifierSettings extends AbstractChromatogramClassifierSettings {

	@JsonProperty(value = "Traces", defaultValue = "Water:18;Nitrogen:28;Oxygen:32;Carbon Dioxide:44;Solvent Tailing:84;Column Bleed:207")
	@JsonPropertyDescription(value = "List the m/z traces to inspect.")
	private TargetTraces traces = TargetTraces.getDefault();

	public TargetTraces getTraces() {

		return traces;
	}

	public void setTraces(TargetTraces traces) {

		this.traces = traces;
	}
}