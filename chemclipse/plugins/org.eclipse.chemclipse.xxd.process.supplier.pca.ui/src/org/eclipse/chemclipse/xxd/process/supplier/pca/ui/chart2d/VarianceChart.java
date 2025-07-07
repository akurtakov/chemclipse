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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.chemclipse.support.ui.workbench.DisplayUtils;
import org.eclipse.chemclipse.support.ui.workbench.PreferencesSupport;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Variance;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.IAxis;
import org.eclipse.swtchart.IBarSeries.BarWidthStyle;
import org.eclipse.swtchart.Range;
import org.eclipse.swtchart.extensions.barcharts.BarChart;
import org.eclipse.swtchart.extensions.barcharts.BarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesSettings;
import org.eclipse.swtchart.extensions.core.BaseChart;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISeriesData;
import org.eclipse.swtchart.extensions.core.RangeRestriction;
import org.eclipse.swtchart.extensions.core.SeriesData;

public class VarianceChart extends BarChart {

	private Variance variance = Variance.EXPLAINED;
	private EvaluationPCA evaluationPCA;

	public VarianceChart() {

		super();
		createControl();
	}

	public VarianceChart(Composite parent, int style) {

		super(parent, style);
		createControl();
	}

	public void setVariance(Variance variance) {

		this.variance = variance;
		updateChart();
	}

	public void setInput(EvaluationPCA evaluationPCA) {

		this.evaluationPCA = evaluationPCA;
		updateChart();
	}

	private void createControl() {

		IChartSettings chartSettings = getChartSettings();
		//
		chartSettings.setTitleVisible(false);
		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setHorizontalSliderVisible(false);
		chartSettings.setVerticalSliderVisible(false);
		//
		RangeRestriction rangeRestriction = chartSettings.getRangeRestriction();
		rangeRestriction.setZeroX(false);
		rangeRestriction.setZeroY(false);
		rangeRestriction.setForceZeroMinY(true);
		rangeRestriction.setRestrictFrame(true);
		//
		chartSettings.setShowAxisZeroMarker(true);
		if(PreferencesSupport.isDarkTheme()) {
			chartSettings.setColorAxisZeroMarker(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		} else {
			chartSettings.setColorAxisZeroMarker(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		chartSettings.setShowSeriesLabelMarker(false);
		chartSettings.setCreateMenu(true);
		chartSettings.setEnableCompress(false);
		//
		setPrimaryAxisSet(chartSettings);
		//
		applySettings(chartSettings);
	}

	private void setPrimaryAxisSet(IChartSettings chartSettings) {

		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		primaryAxisSettingsX.setTitle("Principal Component");
		primaryAxisSettingsX.setDecimalFormat(ValueFormat.getDecimalFormatEnglish());
		if(PreferencesSupport.isDarkTheme()) {
			primaryAxisSettingsX.setColor(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		} else {
			primaryAxisSettingsX.setColor(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		//
		IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
		primaryAxisSettingsY.setTitle("Variance");
		primaryAxisSettingsY.setDecimalFormat(ValueFormat.getDecimalFormatEnglish());
		if(PreferencesSupport.isDarkTheme()) {
			primaryAxisSettingsY.setColor(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		} else {
			primaryAxisSettingsY.setColor(DisplayUtils.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
	}

	private void updateChart() {

		deleteSeries();
		if(evaluationPCA != null) {
			//
			IResultsPCA<?, ?> resultsPCA = evaluationPCA.getResults();
			//
			IChartSettings chartSettings = getChartSettings();
			IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
			primaryAxisSettingsX.setEnableCategory(true);
			primaryAxisSettingsX.setCategorySeries(getCategories(resultsPCA));
			IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
			if(resultsPCA.getCrossValidations() != null) {
				primaryAxisSettingsY.setEnableCategory(true);
				primaryAxisSettingsY.setCategorySeries(new String[]{"Variance", "Q2"});
				chartSettings.setTitle("Explained Variance + CrossValidation Q2");
				chartSettings.setTitleVisible(true);
			} else {
				chartSettings.setTitle("Explained Variance");
				chartSettings.setTitleVisible(true);
			}
			primaryAxisSettingsY.setTitleVisible(false);
			applySettings(chartSettings);
			//
			List<IBarSeriesData> barSeriesDataList = new ArrayList<>();
			ISeriesData seriesData = getSeriesVariance(resultsPCA);
			IBarSeriesData barSeriesData = new BarSeriesData(seriesData);
			IBarSeriesSettings settings = barSeriesData.getSettings();
			settings.setBarColor(Colors.RED);
			settings.setBarWidthStyle(BarWidthStyle.STRETCHED);
			barSeriesDataList.add(barSeriesData);
			if(resultsPCA.getCrossValidations() != null) {
				ISeriesData seriesData2 = getSeriesQ2(resultsPCA);
				IBarSeriesData barSeriesData2 = new BarSeriesData(seriesData2);
				IBarSeriesSettings settings2 = barSeriesData2.getSettings();
				settings2.setBarColor(Colors.BLUE);
				settings2.setBarWidthStyle(BarWidthStyle.STRETCHED);
				barSeriesDataList.add(barSeriesData2);
			}
			addSeriesData(barSeriesDataList);
			IAxis axisY = getBaseChart().getAxisSet().getYAxis(BaseChart.ID_PRIMARY_Y_AXIS);
			axisY.setRange(new Range(0, 1));
		} else {
			getBaseChart().redraw();
		}
	}

	private String[] getCategories(IResultsPCA<?, ?> pcaResults) {

		int size = pcaResults.getCumulativeExplainedVariances().length;
		String[] categories = new String[size];
		//
		for(int i = 0; i < size; i++) {
			categories[i] = "PC" + (i + 1);
		}
		//
		return categories;
	}

	private ISeriesData getSeriesVariance(IResultsPCA<?, ?> pcaResults) {

		double[] ySeries;
		String label;
		//
		switch(variance) {
			case CUMULATIVE:
				ySeries = pcaResults.getCumulativeExplainedVariances();
				label = "Cumulative Variances";
				break;
			default:
				ySeries = pcaResults.getExplainedVariances();
				label = "Explained Variances";
				break;
		}
		//
		getChartSettings().getPrimaryAxisSettingsY().setTitle(label);
		applySettings(getChartSettings());
		double[] xSeries = new double[ySeries.length];
		return new SeriesData(xSeries, ySeries, label);
	}

	private ISeriesData getSeriesQ2(IResultsPCA<?, ?> pcaResults) {

		double[] ySeries;
		String label;
		//
		switch(variance) {
			case CUMULATIVE:
				ySeries = pcaResults.getCumulativeCrossValidations();
				label = "Cumulative Cross Validation Q2";
				break;
			default:
				ySeries = pcaResults.getCrossValidations();
				label = "CrossValidation Q2";
				break;
		}
		//
		getChartSettings().getPrimaryAxisSettingsY().setTitle(label);
		applySettings(getChartSettings());
		double[] xSeries = new double[ySeries.length];
		return new SeriesData(xSeries, ySeries, label);
	}
}
