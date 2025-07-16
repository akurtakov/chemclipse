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

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;

public class EvaluationPCA extends AbstractEvaluation<IVariable, ISample, IResult> {

	private IResultsMVA results = null;

	public EvaluationPCA(ISamplesPCA<IVariable, ISample> samples, IResultsMVA results) {

		this.samples = samples;
		this.results = results;
	}

	public IResultsMVA getResults() {

		return results;
	}

	@Override
	public void addCrossValidation(double[] q2) {

		results.setCrossValidations(q2);
	}

	@Override
	public void addCumulativeCrossValidation(double[] q2Cum) {

		results.setCumulativeCrossValidations(q2Cum);
	}
}