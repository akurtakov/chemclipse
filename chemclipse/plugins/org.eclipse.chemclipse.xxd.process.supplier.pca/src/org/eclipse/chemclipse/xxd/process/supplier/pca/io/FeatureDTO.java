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

public class FeatureDTO {

	private VariableDTO variable;
	private List<FeatureSampleDataDTO> sampleData = new ArrayList<>();

	public VariableDTO getVariable() {

		return variable;
	}

	public void setVariable(VariableDTO variable) {

		this.variable = variable;
	}

	public List<FeatureSampleDataDTO> getSampleData() {

		return sampleData;
	}

	public void setSampleData(List<FeatureSampleDataDTO> sampleData) {

		this.sampleData = sampleData;
	}
}
