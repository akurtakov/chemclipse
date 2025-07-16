/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Lorenz Gerber - add highlight data, prediction
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class EvaluationPCA<V extends IVariable, S extends ISample, R extends IResultPCA> {

	private ISamplesPCA<V, S> samples = null;
	private IResultsPCA<R, V> results = null;
	@SuppressWarnings("unused")
	private ISamplesPCA<V, S> predict = null;
	/*
	 * The feature data matrix can be calculated after samples and results are set.
	 */
	private FeatureDataMatrix featureDataMatrix = null;
	private List<ISample> highlightedSamples = new ArrayList<ISample>();
	private List<IVariable> highlightedVariables = new ArrayList<IVariable>();

	public EvaluationPCA(ISamplesPCA<V, S> samples, IResultsPCA<R, V> results) {

		this.samples = samples;
		this.results = results;
	}

	public ISamplesPCA<V, S> getSamples() {

		return samples;
	}

	public IResultsPCA<R, V> getResults() {

		return results;
	}

	public FeatureDataMatrix getFeatureDataMatrix() {

		return featureDataMatrix;
	}

	public void setFeatureDataMatrix(FeatureDataMatrix featureDataMatrix) {

		this.featureDataMatrix = featureDataMatrix;
	}

	public void setHighlightedSamples(List<ISample> samples) {

		this.highlightedSamples = samples;
	}

	public List<ISample> getHighlightedSamples() {

		return this.highlightedSamples;
	}

	public void setHighlightedVariables(List<IVariable> variables) {

		for(IVariable variable : variables) {
			int index = samples.getVariables().indexOf(variable);
			if(index > -1) {
				samples.getVariables().get(index).setSelected(true);
			}
		}
		this.highlightedVariables = variables;
	}

	public List<IVariable> getHighlightedVariables() {

		return this.highlightedVariables;
	}

	public void addCrossValidation(double[] crossValidation) {

		this.results.setCrossValidations(crossValidation);
	}

	public void addCumulativeCrossValidation(double[] cumulativeCrossValidation) {

		this.results.setCumulativeCrossValidations(cumulativeCrossValidation);
	}
}