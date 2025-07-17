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

import java.util.List;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;

public interface IEvaluation<V extends IVariable, S extends ISample, R extends IResult> {

	public ISamplesPCA<IVariable, ISample> getSamples();

	public void addCrossValidation(double[] q2);

	public void addCumulativeCrossValidation(double[] q2Cum);

	public FeatureDataMatrix getFeatureDataMatrix();

	public void setFeatureDataMatrix(FeatureDataMatrix featureDataMatrix);

	public List<ISample> getHighlightedSamples();

	public void setHighlightedSamples(List<ISample> samples);

	public List<IVariable> getHighlightedVariables();

	public void setHighlightedVariables(List<IVariable> variables);
}
