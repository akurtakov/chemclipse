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

public class EvaluationPCADTO {

	private int version = 1;
	private SamplesDTO samples;
	private ResultsPCADTO results;
	private FeatureDataMatrixDTO featureDataMatrix;
	private List<Integer> highlightedSampleIndices = new ArrayList<>();
	private List<Integer> highlightedVariableIndices = new ArrayList<>();

	public int getVersion() {

		return version;
	}

	public void setVersion(int version) {

		this.version = version;
	}

	public SamplesDTO getSamples() {

		return samples;
	}

	public void setSamples(SamplesDTO samples) {

		this.samples = samples;
	}

	public ResultsPCADTO getResults() {

		return results;
	}

	public void setResults(ResultsPCADTO results) {

		this.results = results;
	}

	public FeatureDataMatrixDTO getFeatureDataMatrix() {

		return featureDataMatrix;
	}

	public void setFeatureDataMatrix(FeatureDataMatrixDTO featureDataMatrix) {

		this.featureDataMatrix = featureDataMatrix;
	}

	public List<Integer> getHighlightedSampleIndices() {

		return highlightedSampleIndices;
	}

	public void setHighlightedSampleIndices(List<Integer> highlightedSampleIndices) {

		this.highlightedSampleIndices = highlightedSampleIndices;
	}

	public List<Integer> getHighlightedVariableIndices() {

		return highlightedVariableIndices;
	}

	public void setHighlightedVariableIndices(List<Integer> highlightedVariableIndices) {

		this.highlightedVariableIndices = highlightedVariableIndices;
	}
}
