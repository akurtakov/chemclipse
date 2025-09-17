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
 * Lorenz Gerber - Specific result type for multivariate analysis (MVA)
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.chemclipse.support.ui.workbench.PreferencesSupport;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.IBarSeries.BarWidthStyle;
import org.eclipse.swtchart.extensions.barcharts.BarChart;
import org.eclipse.swtchart.extensions.barcharts.BarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesSettings;
import org.eclipse.swtchart.extensions.core.IAxisSettings;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISeriesData;
import org.eclipse.swtchart.extensions.core.RangeRestriction;
import org.eclipse.swtchart.extensions.core.SeriesData;

public class ErrorResidueChart extends BarChart {

	public ErrorResidueChart() {

		super();
		createControl();
	}

	public ErrorResidueChart(Composite parent, int style) {

		super(parent, style);
		createControl();
	}

	public void setInput(EvaluationPCA evaluationPCA) {

		if(evaluationPCA != null) {
			IResultsMVA resultsPCA = evaluationPCA.getResults();
			updateChart(resultsPCA);
		} else {
			updateChart(null);
		}
	}

	private void createControl() {

		IChartSettings chartSettings = getChartSettings();

		chartSettings.setTitle("Error Residues");
		chartSettings.setTitleVisible(true);
		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setHorizontalSliderVisible(false);
		chartSettings.setVerticalSliderVisible(false);

		RangeRestriction rangeRestriction = chartSettings.getRangeRestriction();
		rangeRestriction.setZeroX(false);
		rangeRestriction.setZeroY(false);
		rangeRestriction.setForceZeroMinY(true);
		rangeRestriction.setRestrictFrame(true);

		chartSettings.setShowAxisZeroMarker(true);
		chartSettings.setShowSeriesLabelMarker(false);
		chartSettings.setCreateMenu(true);
		chartSettings.setEnableCompress(false);

		setPrimaryAxisSet(chartSettings);

		applySettings(chartSettings);
	}

	private void setPrimaryAxisSet(IChartSettings chartSettings) {

		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		primaryAxisSettingsX.setTitle("Sample Name");
		primaryAxisSettingsX.setDecimalFormat(ValueFormat.getDecimalFormatEnglish());
		setGridColor(primaryAxisSettingsX);

		IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
		primaryAxisSettingsY.setTitle("Error Values");
		primaryAxisSettingsY.setDecimalFormat(ValueFormat.getDecimalFormatEnglish());
		setGridColor(primaryAxisSettingsY);
	}

	private void updateChart(IResultsMVA pcaResults) {

		deleteSeries();
		if(pcaResults != null) {

			IChartSettings chartSettings = getChartSettings();
			IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
			primaryAxisSettingsX.setEnableCategory(true);
			primaryAxisSettingsX.setCategorySeries(getCategories(pcaResults));
			applySettings(chartSettings);

			List<IBarSeriesData> barSeriesDataList = new ArrayList<>();
			ISeriesData seriesData = getSeries(pcaResults);
			IBarSeriesData barSeriesData = new BarSeriesData(seriesData);
			IBarSeriesSettings settings = barSeriesData.getSettings();
			settings.setBarColor(Colors.RED);
			settings.setBarWidthStyle(BarWidthStyle.STRETCHED);
			barSeriesDataList.add(barSeriesData);
			addSeriesData(barSeriesDataList);
		} else {
			getBaseChart().redraw();
		}
	}

	private String[] getCategories(IResultsMVA pcaResults) {

		List<IResultMVA> pcaResultList = pcaResults.getPcaResultList();
		int size = pcaResultList.size();
		String[] categories = new String[size];

		for(int i = 0; i < size; i++) {
			IResultMVA pcaResult = pcaResultList.get(i);
			categories[i] = pcaResult.getSample().getSampleName();
		}

		return categories;
	}

	private ISeriesData getSeries(IResultsMVA pcaResults) {

		List<IResultMVA> pcaResultList = pcaResults.getPcaResultList();
		int size = pcaResultList.size();
		double[] xSeries = new double[size];
		double[] ySeries = new double[size];

		for(int i = 0; i < size; i++) {
			IResultMVA pcaResult = pcaResultList.get(i);
			xSeries[i] = i;
			ySeries[i] = pcaResult.getErrorMetric();
		}

		return new SeriesData(xSeries, ySeries, "Error Residues");
	}

	private void setGridColor(IAxisSettings axisSettings) {

		if(PreferencesSupport.isDarkTheme()) {
			axisSettings.setGridColor(Colors.getColor(new RGB(64, 64, 64)));
		} else {
			axisSettings.setGridColor(Colors.GRAY);
		}
	}
}
