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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.settings;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.core.PeakResolutionFormula;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.settings.AbstractChromatogramCalculatorSettings;
import org.eclipse.chemclipse.support.settings.LabelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class CalculatorSettings extends AbstractChromatogramCalculatorSettings {

	@JsonProperty(value = "Formula", defaultValue = "IUPAC")
	@JsonPropertyDescription(value = "Which formula shall be used for peak resolution calculation.")
	@LabelProperty(value = "%Formula", tooltip = "%FormulaDescription")
	private PeakResolutionFormula formula = PeakResolutionFormula.IUPAC;
}