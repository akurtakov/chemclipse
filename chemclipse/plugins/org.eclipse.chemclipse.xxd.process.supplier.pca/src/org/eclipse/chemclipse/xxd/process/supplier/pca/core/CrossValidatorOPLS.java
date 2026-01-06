/*******************************************************************************
 * Copyright (c) 2017, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.exception.MathIllegalArgumentException;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Algorithm;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ICrossValidationProcessor;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IEvaluation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IMultivariateCalculator;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResult;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ResultsPCA;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

public class CrossValidatorOPLS extends AbstractProcessorMultivariateAanalysis implements ICrossValidationProcessor {

	@Override
	public double[] crossValidate(ISamplesPCA<IVariable, ISample> samples, IEvaluation<IVariable, ISample, IResult> masterEvaluation, IProgressMonitor monitor) throws MathIllegalArgumentException {

		/*
		 * Settings
		 */
		IAnalysisSettings analysisSettings = samples.getAnalysisSettings();
		ResultsPCA results = new ResultsPCA(analysisSettings);
		DMatrixRMaj q2 = new DMatrixRMaj(1, analysisSettings.getNumberOfPrincipalComponents());
		if(samples != null) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, "Crossvalidate OPLS", samples.getSamples().size() * 20 + 5);
			try {
				/*
				 * Template Map
				 */
				Map<String, Boolean> variablesSelectionMap = getVariablesSelectionMap(masterEvaluation != null ? masterEvaluation.getSamples().getVariables() : Collections.emptyList());
				subMonitor.worked(5);
				/*
				 * Looping over Samples
				 */
				List<Integer> useSample = new ArrayList<>();
				for(int i = 0; i < samples.getSamples().size(); i++) {
					if(samples.getSamples().get(i).isSelected() && !samples.getSamples().get(i).isPredicted()) {
						useSample.add(i);
					}
				}
				DMatrixRMaj cvScoresPredicted = new DMatrixRMaj(useSample.size(), analysisSettings.getNumberOfPrincipalComponents());
				DMatrixRMaj cvScoresModel = new DMatrixRMaj(useSample.size(), analysisSettings.getNumberOfPrincipalComponents());
				for(int i = 0; i <= useSample.size(); i++) {
					/*
					 * Run first all leave-out predictions, as the last run,
					 * build the full model.
					 */
					ISample currentSample = null;
					if(i != useSample.size()) {
						samples.getSamples().get(useSample.get(i)).setPredicted(true);
						currentSample = samples.getSamples().get(useSample.get(i));
					}
					/*
					 * Preprocess
					 */
					IPreprocessingSettings preprocessingSettings = analysisSettings.getPreprocessingSettings();
					preprocessingSettings.process(samples, monitor);
					subMonitor.worked(5);
					/*
					 * Variable Extraction
					 */
					int numberOfPrincipalComponents = analysisSettings.getNumberOfPrincipalComponents();
					Algorithm algorithm = analysisSettings.getAlgorithm();
					boolean[] selectedVariables = getSelectedVariables(samples, analysisSettings, variablesSelectionMap);
					Map<ISample, double[]> extractData = extractData(samples, algorithm, analysisSettings, selectedVariables);
					int numberPredictionSamples = numberPredictionSamples(extractData);
					assignVariables(results, samples, selectedVariables, variablesSelectionMap);
					int numberVariables = getNumSampleVars(extractData);
					/*
					 * Prepare PCA Calculation
					 */
					IMultivariateCalculator principalComponentAnalysis = setupPCA(extractData, numberPredictionSamples, numberVariables, numberOfPrincipalComponents, algorithm, analysisSettings.getOplsTargetGroupName());
					subMonitor.worked(5);
					/*
					 * Compute PCA
					 */
					principalComponentAnalysis.compute();
					subMonitor.worked(5);
					/*
					 * Predict samples
					 */
					principalComponentAnalysis.predict();
					subMonitor.worked(5);
					if(i != useSample.size()) {
						double[] scores = principalComponentAnalysis.getScoreVector(currentSample);
						DMatrixRMaj row = new DMatrixRMaj(1, scores.length, true, scores);
						CommonOps_DDRM.insert(row, cvScoresPredicted, i, 0);
						samples.getSamples().get(useSample.get(i)).setPredicted(false);
					} else {
						/*
						 * Calculate Q2
						 */
						for(int j = 0; j < useSample.size(); j++) {
							DMatrixRMaj source = new DMatrixRMaj(1, analysisSettings.getNumberOfPrincipalComponents(), true, principalComponentAnalysis.getScoreVector(samples.getSamples().get(useSample.get(j))));
							CommonOps_DDRM.insert(source, cvScoresModel, j, 0);
						}
						CommonOps_DDRM.subtractEquals(cvScoresPredicted, cvScoresModel);
						DMatrixRMaj diffSquared = new DMatrixRMaj(cvScoresPredicted.getNumRows(), cvScoresPredicted.getNumCols());
						CommonOps_DDRM.elementPower(cvScoresPredicted, 2.0, diffSquared);
						DMatrixRMaj modelSquared = new DMatrixRMaj(cvScoresModel.getNumRows(), cvScoresModel.getNumCols());
						CommonOps_DDRM.elementPower(cvScoresModel, 2.0, modelSquared);
						DMatrixRMaj press = CommonOps_DDRM.sumCols(diffSquared, null);
						DMatrixRMaj ss = CommonOps_DDRM.sumCols(modelSquared, null);
						DMatrixRMaj divided = new DMatrixRMaj(1, cvScoresModel.getNumCols());
						CommonOps_DDRM.elementDiv(press, ss, divided);
						CommonOps_DDRM.subtract(1, divided, q2);
						double[] result = q2.data;
						for(int k = 0; k < result.length; k++) {
							if(result[k] < 0) {
								result[k] = 0;
							}
						}
					}
				}
			} finally {
				SubMonitor.done(subMonitor);
			}
		}
		return q2.data;
	}
}
