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
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.runnable;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.CrossValidatorOPLS;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.ProcessorPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Algorithm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class CalculationExecutor implements IRunnableWithProgress {

	private static final Logger logger = Logger.getLogger(CalculationExecutor.class);
	//
	private ISamplesPCA<? extends IVariable, ? extends ISample> samples = null;
	private EvaluationPCA masterEvaluationPCA = null;
	//
	private EvaluationPCA evaluationPCA = null;

	public CalculationExecutor(ISamplesPCA<? extends IVariable, ? extends ISample> samples, EvaluationPCA masterEvaluationPCA) {

		this.samples = samples;
		this.masterEvaluationPCA = masterEvaluationPCA;
	}

	public EvaluationPCA getEvaluationPCA() {

		return evaluationPCA;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		if(samples != null) {
			try {
				ProcessorPCA processorPCA = new ProcessorPCA();
				evaluationPCA = processorPCA.process(samples, masterEvaluationPCA, monitor);
				IAnalysisSettings settings = samples.getAnalysisSettings();
				if(settings.getCrossValidation()) {
					if(settings.getAlgorithm() == Algorithm.OPLS) {
						CrossValidatorOPLS crossValidator = new CrossValidatorOPLS();
						double[] q2 = crossValidator.crossValidate(samples, masterEvaluationPCA, monitor);
						evaluationPCA.addCrossValidation(q2);
						double[] q2Cum = new double[q2.length];
						q2Cum[0] = q2[0];
						for(int i = 1; i < q2.length; i++) {
							q2Cum[i] = q2Cum[i - 1] + q2[i];
						}
						evaluationPCA.addCumulativeCrossValidation(q2Cum);
					}
				}
			} catch(Exception e) {
				logger.error(e);
			}
		}
	}
}
