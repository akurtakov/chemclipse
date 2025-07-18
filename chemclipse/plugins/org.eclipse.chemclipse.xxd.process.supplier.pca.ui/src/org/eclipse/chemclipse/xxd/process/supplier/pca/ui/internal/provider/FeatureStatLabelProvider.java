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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.internal.provider;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.chemclipse.model.statistics.ISampleData;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.support.ui.provider.AbstractChemClipseLabelProvider;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Feature;
import org.eclipse.swt.graphics.Image;

public class FeatureStatLabelProvider extends AbstractChemClipseLabelProvider {

	public static final String VARIABLE = "Variable";
	public static final String NAME = "Name";
	public static final String MEAN = "Mean";
	public static final String MIN = "Min";
	public static final String MAX = "Max";
	public static final String RELATIVESTDDEV = "RSD";
	public static final String SKEWNESS = "Skewness";
	public static final String KURTOSIS = "Excess Kurtosis";
	//
	private DecimalFormat decimalFormat = getDecimalFormat();
	//
	public static String[] TITLES = {//
			VARIABLE, //
			NAME, //
			MEAN, //
			MIN, //
			MAX, //
			RELATIVESTDDEV, //
			SKEWNESS, //
			KURTOSIS, //
	};
	public static int[] BOUNDS = {//
			50, //
			280, //
			140, //
			140, //
			140, //
			140, //
			140, //
			140 //
	};

	public FeatureStatLabelProvider(String pattern) {

		super(pattern);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		String text = "";
		if(element instanceof Feature feature) {
			IVariable variable = feature.getVariable();
			List<ISampleData<?>> sampleData = feature.getSampleData();
			DescriptiveStatistics stats = new DescriptiveStatistics();
			for(int i = 0; i < sampleData.size(); i++) {
				stats.addValue(sampleData.get(i).getData());
			}
			double value = 0.0;
			//
			switch(columnIndex) {
				case 0:
					text = variable.getValue();
					break;
				case 1:
					text = variable.getDescription();
					break;
				case 2:
					value = 0.0;
					value = stats.getMean();
					text = Double.isNaN(value) ? "NaN" : decimalFormat.format(value);
					break;
				case 3:
					value = 0.0;
					value = stats.getMin();
					text = Double.isNaN(value) ? "NaN" : decimalFormat.format(value);
					break;
				case 4:
					value = 0.0;
					value = stats.getMax();
					text = Double.isNaN(value) ? "NaN" : decimalFormat.format(value);
					break;
				case 5:
					value = 0.0;
					value = 100.0 / stats.getSum() * stats.getStandardDeviation();
					text = Double.isNaN(value) ? "NaN" : decimalFormat.format(value);
					break;
				case 6:
					value = 0.0;
					value = stats.getSkewness();
					text = Double.isNaN(value) ? "NaN" : decimalFormat.format(value);
					break;
				case 7:
					value = 0.0;
					value = stats.getKurtosis() - 3.0;
					text = Double.isNaN(value) ? "NaN" : decimalFormat.format(value);
				default:
					break;
			}
		}
		return text;
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		return null;
	}
}
