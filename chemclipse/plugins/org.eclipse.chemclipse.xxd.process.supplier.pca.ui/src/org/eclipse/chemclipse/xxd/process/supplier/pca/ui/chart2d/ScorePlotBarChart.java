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
 * Lorenz Gerber- initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.IAxis;
import org.eclipse.swtchart.Range;
import org.eclipse.swtchart.extensions.barcharts.BarChart;
import org.eclipse.swtchart.extensions.barcharts.BarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesData;
import org.eclipse.swtchart.extensions.barcharts.IBarSeriesSettings;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.RangeRestriction;
import org.eclipse.swtchart.extensions.core.SeriesData;

public class ScorePlotBarChart extends BarChart {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00E0", new DecimalFormatSymbols(Locale.ENGLISH));
	private String title = "Score Plot - Bar Chart";
	private int currentPC = 0;
	private double explainedVariance = 0.0;

	public ScorePlotBarChart(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	private void initialize() {

		IChartSettings chartSettings = getChartSettings();
		chartSettings.setTitle(title);
		chartSettings.setTitleVisible(true);
		chartSettings.setBackground(null);
		chartSettings.setBackgroundChart(null);
		chartSettings.setBackgroundPlotArea(null);
		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setHorizontalSliderVisible(true);
		chartSettings.setVerticalSliderVisible(false);

		RangeRestriction rangeRestriction = chartSettings.getRangeRestriction();
		rangeRestriction.setZeroX(false);
		rangeRestriction.setZeroY(false);
		rangeRestriction.setRestrictFrame(false);
		rangeRestriction.setExtendTypeX(RangeRestriction.ExtendType.RELATIVE);
		rangeRestriction.setExtendTypeY(RangeRestriction.ExtendType.RELATIVE);
		rangeRestriction.setExtend(0.1d);

		chartSettings.setShowAxisZeroMarker(true);
		chartSettings.setCreateMenu(true);
		chartSettings.setEnableCompress(false);

		// X-axis settings (sample names)
		IPrimaryAxisSettings xAxisSettings = chartSettings.getPrimaryAxisSettingsX();
		xAxisSettings.setTitle("Samples (sorted by score)");
		xAxisSettings.setVisible(true);
		xAxisSettings.setDecimalFormat(DECIMAL_FORMAT);

		// Y-axis settings (scores)
		IPrimaryAxisSettings yAxisSettings = chartSettings.getPrimaryAxisSettingsY();
		yAxisSettings.setTitle("Score");
		yAxisSettings.setVisible(true);
		yAxisSettings.setDecimalFormat(DECIMAL_FORMAT);

		applySettings(chartSettings);
	}

	public void setInput(EvaluationPCA evaluationPCA, int principalComponent) {

		deleteSeries();
		currentPC = principalComponent;

		if(evaluationPCA == null) {
			getBaseChart().redraw();
			return;
		}

		IResultsMVA results = evaluationPCA.getResults();
		List<IResultMVA> resultList = results.getPcaResultList();
		double[] explainedVariances = results.getExplainedVariances();

		if(this.currentPC >= 0 && this.currentPC < explainedVariances.length) {
			this.explainedVariance = explainedVariances[this.currentPC];
		}

		// Update title with PC info
		String chartTitle = String.format("Score Plot - PC%d (%.1f%%)", this.currentPC + 1, explainedVariance * 100);
		getChartSettings().setTitle(chartTitle);

		// Create list of sample-score pairs
		List<SampleScore> sampleScores = new ArrayList<>();
		for(IResultMVA result : resultList) {
			ISample sample = result.getSample();
			double[] scoreMatrix = result.getScoreVector();

			if(this.currentPC < scoreMatrix.length) {
				double score = scoreMatrix[this.currentPC];
				String sampleName = sample.getSampleName();
				sampleScores.add(new SampleScore(sampleName, score));
			}
		}

		// Sort by score value (descending: positive to negative)
		sampleScores.sort(Comparator.comparingDouble(SampleScore::getScore).reversed());

		// Prepare data arrays
		int n = sampleScores.size();
		double[] xValues = new double[n];
		double[] yValues = new double[n];
		String[] labels = new String[n];

		for(int i = 0; i < n; i++) {
			xValues[i] = i;
			yValues[i] = sampleScores.get(i).getScore();
			labels[i] = sampleScores.get(i).getSampleName();
		}

		// Create series data
		SeriesData seriesData = new SeriesData(xValues, yValues, "PC" + (this.currentPC + 1));

		// Create bar series data
		IBarSeriesData barSeriesData = new BarSeriesData(seriesData);

		// Get and configure the settings
		IBarSeriesSettings barSeriesSettings = barSeriesData.getSettings();
		Color barColor = getDisplay().getSystemColor(SWT.COLOR_BLUE);
		barSeriesSettings.setBarColor(barColor);
		barSeriesSettings.setBarPadding(5);
		barSeriesSettings.setBarWidth(3);

		// Add series
		List<IBarSeriesData> barSeriesDataList = new ArrayList<>();
		barSeriesDataList.add(barSeriesData);

		addSeriesData(barSeriesDataList);

		// Set custom category labels for X-axis
		IAxis xAxis = getBaseChart().getAxisSet().getXAxis(0);
		xAxis.setCategorySeries(labels);
		xAxis.enableCategory(true);

		// Adjust Y-axis to center zero
		IAxis yAxis = getBaseChart().getAxisSet().getYAxis(0);
		double maxAbs = Math.max(Math.abs(getMaxValue(yValues)), Math.abs(getMinValue(yValues)));
		if(maxAbs > 0) {
			yAxis.setRange(new Range(-maxAbs * 1.1, maxAbs * 1.1));
		}

		getBaseChart().redraw();
	}

	private double getMaxValue(double[] values) {

		double max = Double.NEGATIVE_INFINITY;
		for(double v : values) {
			if(v > max) {
				max = v;
			}
		}
		return max;
	}

	private double getMinValue(double[] values) {

		double min = Double.POSITIVE_INFINITY;
		for(double v : values) {
			if(v < min) {
				min = v;
			}
		}
		return min;
	}

	private static class SampleScore {

		private final String sampleName;
		private final double score;

		public SampleScore(String sampleName, double score) {

			this.sampleName = sampleName;
			this.score = score;
		}

		public String getSampleName() {

			return sampleName;
		}

		public double getScore() {

			return score;
		}
	}
}
