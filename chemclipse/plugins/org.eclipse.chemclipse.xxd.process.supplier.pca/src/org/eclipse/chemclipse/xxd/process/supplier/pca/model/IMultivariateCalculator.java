/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation, prediction
 * Philip Wenig - color refactorings
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import org.eclipse.chemclipse.model.statistics.ISample;

public interface IMultivariateCalculator {

	void addObservation(double[] obsData, ISample sampleKey, String groupName, String classificationName);

	void addPrediction(double[] obsData, ISample sampleKey, String groupName, String classificationName);

	void compute();

	void predict();

	boolean getComputeStatus();

	void setComputeSuccess();

	double getErrorMetric(double[] obs);

	double[] getLoadingVector(int var);

	double[] getScoreVector(ISample sampleId);

	double getSummedVariance();

	double getExplainedVariance(int var);
}