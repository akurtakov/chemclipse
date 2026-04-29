/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson.processor;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson.result.IDurbinWatsonClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.supplier.durbinwatson.result.SavitzkyGolayFilterRating;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.processor.SavitzkyGolayProcessor;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings.ChromatogramFilterSettings;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.exceptions.ChromatogramIsNullException;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.model.signals.ITotalScanSignal;
import org.eclipse.chemclipse.model.signals.ITotalScanSignals;
import org.eclipse.chemclipse.model.signals.TotalScanSignalExtractor;
import org.eclipse.core.runtime.IProgressMonitor;

public class DurbinWatsonProcessor {

	private static final Logger logger = Logger.getLogger(DurbinWatsonProcessor.class);

	public void run(IChromatogramSelection chromatogramSelection, IDurbinWatsonClassifierResult durbinWatsonClassifierResult, IProgressMonitor monitor) {

		try {
			/*
			 * Extract the TIC signals.
			 */
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			TotalScanSignalExtractor signalExtractor = new TotalScanSignalExtractor(chromatogram);
			ITotalScanSignals totalScanSignals = signalExtractor.getTotalScanSignals(chromatogramSelection, false);
			double[] valuesOriginal = getScanSignalsAsArray(totalScanSignals);
			durbinWatsonMain(valuesOriginal, durbinWatsonClassifierResult, monitor);
		} catch(ChromatogramIsNullException e) {
			logger.warn(e);
		}
	}

	public void durbinWatsonMain(double[] valuesOriginal, IDurbinWatsonClassifierResult durbinWatsonClassifierResult, IProgressMonitor monitor) {

		/*
		 * Iterate through the width
		 */
		int minDerivative = 0;
		int maxDerivative = 5;
		int minOrder = 2;
		int maxOrder = 5;
		int minWidth = 5;
		int maxWidth = 51;
		if(valuesOriginal.length < maxWidth) {
			maxWidth = valuesOriginal.length;
		}

		for(int derivative = minDerivative; derivative <= maxDerivative; derivative++) {
			for(int order = minOrder; order <= maxOrder; order++) {
				for(int width = minWidth; width <= maxWidth; width++) {
					/*
					 * Create the settings and test.
					 * Width must be odd.
					 */
					if(width % 2 == 1) {
						ChromatogramFilterSettings filterSettings = new ChromatogramFilterSettings();
						filterSettings.setDerivative(derivative);
						filterSettings.setOrder(order);
						filterSettings.setWidth(width);
						double[] valuesSmoothed = SavitzkyGolayProcessor.smooth(valuesOriginal, filterSettings);
						double rating = calculateDurbinWatsonRating(valuesOriginal, valuesSmoothed);
						/*
						 * Store the result
						 */
						durbinWatsonClassifierResult.getSavitzkyGolayFilterRatings().add(new SavitzkyGolayFilterRating(rating, filterSettings));
					}
				}
			}
		}
	}

	private double calculateDurbinWatsonRating(double[] valuesOriginal, double[] valuesSmoothed) {

		double rating = 0;
		if(valuesOriginal.length == valuesSmoothed.length) {
			/*
			 * Calculate the denominator
			 */
			double denominator = 0;
			for(int i = 0; i < valuesOriginal.length; i++) {
				denominator += Math.pow(valuesOriginal[i] - valuesSmoothed[i], 2);
			}
			/*
			 * Calculate the nominator
			 */
			if(denominator != 0) {
				double nominator = 0;
				for(int i = 1; i < valuesOriginal.length; i++) {
					nominator += Math.pow((valuesOriginal[i] - valuesSmoothed[i]) - (valuesOriginal[i - 1] - valuesSmoothed[i - 1]), 2);
				}
				/*
				 * A correction could be applied too.
				 */
				rating = nominator / denominator;
			}
		}
		return rating;
	}

	private double[] getScanSignalsAsArray(ITotalScanSignals totalScanSignals) {

		int size = totalScanSignals.size();
		double[] ticValues = new double[size];
		int column = 0;
		for(ITotalScanSignal signal : totalScanSignals.getTotalScanSignals()) {
			ticValues[column++] = signal.getTotalSignal();
		}

		return ticValues;
	}
}
