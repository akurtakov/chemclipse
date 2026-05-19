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

public class ResultsPCADTO {

	private List<double[]> loadingVectors;
	private double[] explainedVariances;
	private double[] cumulativeExplainedVariances;
	private double[] crossValidations;
	private double[] cumulativeCrossValidations;
	private List<VariableDTO> extractedVariables = new ArrayList<>();
	private List<ResultMVADTO> pcaResultList = new ArrayList<>();
	private double[] pCovarianceValues;
	private double[] pCorrValues;

	public List<double[]> getLoadingVectors() {

		return loadingVectors;
	}

	public void setLoadingVectors(List<double[]> loadingVectors) {

		this.loadingVectors = loadingVectors;
	}

	public double[] getExplainedVariances() {

		return explainedVariances;
	}

	public void setExplainedVariances(double[] explainedVariances) {

		this.explainedVariances = explainedVariances;
	}

	public double[] getCumulativeExplainedVariances() {

		return cumulativeExplainedVariances;
	}

	public void setCumulativeExplainedVariances(double[] cumulativeExplainedVariances) {

		this.cumulativeExplainedVariances = cumulativeExplainedVariances;
	}

	public double[] getCrossValidations() {

		return crossValidations;
	}

	public void setCrossValidations(double[] crossValidations) {

		this.crossValidations = crossValidations;
	}

	public double[] getCumulativeCrossValidations() {

		return cumulativeCrossValidations;
	}

	public void setCumulativeCrossValidations(double[] cumulativeCrossValidations) {

		this.cumulativeCrossValidations = cumulativeCrossValidations;
	}

	public List<VariableDTO> getExtractedVariables() {

		return extractedVariables;
	}

	public void setExtractedVariables(List<VariableDTO> extractedVariables) {

		this.extractedVariables = extractedVariables;
	}

	public List<ResultMVADTO> getPcaResultList() {

		return pcaResultList;
	}

	public void setPcaResultList(List<ResultMVADTO> pcaResultList) {

		this.pcaResultList = pcaResultList;
	}

	public double[] getPCovarianceValues() {

		return pCovarianceValues;
	}

	public void setPCovarianceValues(double[] pCovarianceValues) {

		this.pCovarianceValues = pCovarianceValues;
	}

	public double[] getPCorrValues() {

		return pCorrValues;
	}

	public void setPCorrValues(double[] pCorrValues) {

		this.pCorrValues = pCorrValues;
	}
}
