/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;

public abstract class AbstractEvaluation<V extends IVariable, S extends ISample, R extends IResult> implements IEvaluation<IVariable, ISample, IResult> {

	protected ISamplesPCA<IVariable, ISample> samples = null;
	protected ISamplesPCA<V, S> predict = null;
	/*
	 * The feature data matrix can be calculated after samples and results are set.
	 */
	protected FeatureDataMatrix featureDataMatrix = null;
	protected List<ISample> highlightedSamples = new ArrayList<ISample>();
	protected List<IVariable> highlightedVariables = new ArrayList<IVariable>();

	public ISamplesPCA<IVariable, ISample> getSamples() {

		return samples;
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
				samples.getVariables().get(index).setVisualSelected(true);
			}
		}
		this.highlightedVariables = variables;
	}

	public List<IVariable> getHighlightedVariables() {

		return this.highlightedVariables;
	}
}
