/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.statistics.IVariable;

public class ResultsPCA implements IResultsPCA<IResultPCA, IVariable> {

	private List<double[]> loadingVectors;
	private double[] explainedVariances;
	private double[] cumulativeExplainedVariances;
	private List<IVariable> extractedVariables;
	private List<IResultPCA> pcaResultList;
	//
	private IAnalysisSettings analysisSettings;

	public ResultsPCA(IAnalysisSettings analysisSettings) {

		this.analysisSettings = analysisSettings;
		extractedVariables = new ArrayList<>();
		pcaResultList = new ArrayList<>();
	}

	@Override
	public List<double[]> getLoadingVectors() {

		return loadingVectors;
	}

	@Override
	public List<IVariable> getExtractedVariables() {

		return extractedVariables;
	}

	@Override
	public List<IResultPCA> getPcaResultList() {

		return pcaResultList;
	}

	@Override
	public IAnalysisSettings getPcaSettings() {

		return analysisSettings;
	}

	@Override
	public void setLoadingVectors(List<double[]> loadingVectors) {

		this.loadingVectors = loadingVectors;
	}

	@Override
	public double[] getExplainedVariances() {

		return this.explainedVariances;
	}

	@Override
	public void setExplainedVariances(double[] explainedVariances) {

		this.explainedVariances = explainedVariances;
	}

	@Override
	public double[] getCumulativeExplainedVariances() {

		return this.cumulativeExplainedVariances;
	}

	@Override
	public void setCumulativeExplainedVariances(double[] cumulativeExplainedVariances) {

		this.cumulativeExplainedVariances = cumulativeExplainedVariances;
	}
}
