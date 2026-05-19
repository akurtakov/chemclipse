/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.io;

import java.util.ArrayList;
import java.util.List;

public class SamplesDTO {

	private List<SampleDTO> samples = new ArrayList<>();
	private List<VariableDTO> variables = new ArrayList<>();
	private AnalysisSettingsDTO analysisSettings;

	public List<SampleDTO> getSamples() {

		return samples;
	}

	public void setSamples(List<SampleDTO> samples) {

		this.samples = samples;
	}

	public List<VariableDTO> getVariables() {

		return variables;
	}

	public void setVariables(List<VariableDTO> variables) {

		this.variables = variables;
	}

	public AnalysisSettingsDTO getAnalysisSettings() {

		return analysisSettings;
	}

	public void setAnalysisSettings(AnalysisSettingsDTO analysisSettings) {

		this.analysisSettings = analysisSettings;
	}
}
