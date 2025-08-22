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
 * Lorenz Gerber - Use IEvaluation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.runnable;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.CrossValidatorOPLS;
import org.eclipse.chemclipse.xxd.process.supplier.pca.core.ProcessorPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Algorithm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ICrossValidationProcessor;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IEvaluation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IProcessor;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResult;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class CalculationExecutor implements IRunnableWithProgress {

	private static final Logger logger = Logger.getLogger(CalculationExecutor.class);

	private ISamplesPCA<IVariable, ISample> samples = null;
	private IEvaluation<IVariable, ISample, IResult> masterEvaluation = null;

	private IEvaluation<IVariable, ISample, IResult> evaluation = null;

	public CalculationExecutor(ISamplesPCA<IVariable, ISample> samples, IEvaluation<IVariable, ISample, IResult> masterEvaluation) {

		this.samples = samples;
		this.masterEvaluation = masterEvaluation;
	}

	public IEvaluation<IVariable, ISample, IResult> getEvaluation() {

		return evaluation;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		if(samples != null) {
			try {
				IAnalysisSettings settings = samples.getAnalysisSettings();
				IProcessor processor = getProcessor(settings.getAlgorithm());
				evaluation = processor.process(samples, masterEvaluation, monitor);
				if(settings.getCrossValidation()) {
					ICrossValidationProcessor crossValidator = getCrossValidationProcessor(settings.getAlgorithm());
					if(crossValidator != null) {
						double[] q2 = crossValidator.crossValidate(samples, masterEvaluation, monitor);
						evaluation.addCrossValidation(q2);
						double[] q2Cum = new double[q2.length];
						q2Cum[0] = q2[0];
						for(int i = 1; i < q2.length; i++) {
							q2Cum[i] = q2Cum[i - 1] + q2[i];
						}
						evaluation.addCumulativeCrossValidation(q2Cum);
					}
				}
			} catch(Exception e) {
				logger.error(e);
			}
		}
	}

	private IProcessor getProcessor(Algorithm algorithm) {

		if(Algorithm.NIPALS == algorithm) {
			return new ProcessorPCA();
		} else if(Algorithm.SVD == algorithm) {
			return new ProcessorPCA();
		} else if(Algorithm.OPLS == algorithm) {
			return new ProcessorPCA();
		}
		return null;
	}

	private ICrossValidationProcessor getCrossValidationProcessor(Algorithm algorithm) {

		if(Algorithm.OPLS == algorithm) {
			return new CrossValidatorOPLS();
		}
		return null;
	}
}
