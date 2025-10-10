/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.charts;

import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.extensions.axisconverter.MillisecondsToMinuteConverter;
import org.eclipse.swtchart.extensions.axisconverter.PercentageConverter;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISecondaryAxisSettings;
import org.eclipse.swtchart.extensions.core.RangeRestriction;
import org.eclipse.swtchart.extensions.core.SecondaryAxisSettings;
import org.eclipse.swtchart.extensions.linecharts.LineChart;

public class PeaksChart extends LineChart {

	private final IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();

	private String titleMinutes = "";
	private String titleRelativeIntensity = "";

	public PeaksChart() {

		super();
		initialize();
	}

	public PeaksChart(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	private void initialize() {

		/*
		 * Initialize secondary axis titles.
		 */
		titleMinutes = preferenceStore.getString(PreferenceSupplier.P_TITLE_X_AXIS_MINUTES);
		titleRelativeIntensity = preferenceStore.getString(PreferenceSupplier.P_TITLE_Y_AXIS_RELATIVE_INTENSITY);

		IChartSettings chartSettings = getChartSettings();
		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setHorizontalSliderVisible(false);
		chartSettings.setVerticalSliderVisible(false);
		RangeRestriction rangeRestriction = chartSettings.getRangeRestriction();
		rangeRestriction.setZeroX(true);
		rangeRestriction.setZeroY(true);
		rangeRestriction.setReferenceZoomZeroX(false);
		rangeRestriction.setReferenceZoomZeroY(true);
		rangeRestriction.setRestrictZoomX(false);
		rangeRestriction.setRestrictZoomY(true);
		chartSettings.setCreateMenu(true);

		modifyAxes(true);
	}

	public void modifyAxes(boolean applySettings) {

		modifyXAxisMilliseconds();
		modifyXAxisMinutes();
		modifyYAxisResponse();
		modifyYAxisRelativeResponse();

		if(applySettings) {
			IChartSettings chartSettings = getChartSettings();
			applySettings(chartSettings);
		}
	}

	private void modifyXAxisMilliseconds() {

		IChartSettings chartSettings = getChartSettings();
		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		primaryAxisSettingsX.setTitle(preferenceStore.getString(PreferenceSupplier.P_TITLE_X_AXIS_MILLISECONDS));

		String positionNode = PreferenceSupplier.P_POSITION_X_AXIS_MILLISECONDS_PEAKS;
		String pattern = "0.0##";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_X_AXIS_MILLISECONDS_PEAKS;
		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_X_AXIS_MILLISECONDS_PEAKS);

		ChartSupport.setAxisSettings(primaryAxisSettingsX, positionNode, pattern, gridLineStyleNode);
		primaryAxisSettingsX.setVisible(isShowAxis);
		ChartSupport.themeAxis(primaryAxisSettingsX, PeaksChart.class.getName() + ".XAxisMilliseconds");
	}

	private void modifyYAxisResponse() {

		IChartSettings chartSettings = getChartSettings();
		IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
		primaryAxisSettingsY.setTitle(preferenceStore.getString(PreferenceSupplier.P_TITLE_Y_AXIS_INTENSITY));

		String positionNode = PreferenceSupplier.P_POSITION_Y_AXIS_INTENSITY_PEAKS;
		String pattern = "0.0#E0";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_Y_AXIS_INTENSITY_PEAKS;
		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_Y_AXIS_INTENSITY_PEAKS);

		ChartSupport.setAxisSettings(primaryAxisSettingsY, positionNode, pattern, gridLineStyleNode);
		primaryAxisSettingsY.setVisible(isShowAxis);

		ChartSupport.themeAxis(primaryAxisSettingsY, PeaksChart.class.getName() + ".YAxisResponse");
	}

	private void modifyXAxisMinutes() {

		IChartSettings chartSettings = getChartSettings();
		ISecondaryAxisSettings axisSettings = ChartSupport.getSecondaryAxisSettingsX(titleMinutes, chartSettings);

		String positionNode = PreferenceSupplier.P_POSITION_X_AXIS_MINUTES_PEAKS;
		String pattern = "0.00";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_X_AXIS_MINUTES_PEAKS;
		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_X_AXIS_MINUTES_PEAKS);
		boolean isShowAxisTitle = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_X_AXIS_TITLE_MINUTES);

		String title = preferenceStore.getString(PreferenceSupplier.P_TITLE_X_AXIS_MINUTES);

		if(isShowAxis) {
			if(axisSettings == null) {
				ISecondaryAxisSettings secondaryAxisSettingsX = new SecondaryAxisSettings(title, new MillisecondsToMinuteConverter());
				ChartSupport.setAxisSettings(secondaryAxisSettingsX, positionNode, pattern, gridLineStyleNode);
				ChartSupport.themeAxis(axisSettings, PeaksChart.class.getName() + ".XAxisMinutes");
				secondaryAxisSettingsX.setTitleVisible(isShowAxisTitle);
				chartSettings.getSecondaryAxisSettingsListX().add(secondaryAxisSettingsX);
			} else {
				ChartSupport.setAxisSettings(axisSettings, positionNode, pattern, gridLineStyleNode);
				ChartSupport.themeAxis(axisSettings, "XAxisMinutes");
				axisSettings.setTitle(title);
				axisSettings.setVisible(true);
				axisSettings.setTitleVisible(isShowAxisTitle);
			}
		} else {
			if(axisSettings != null) {
				axisSettings.setTitle(title);
				axisSettings.setVisible(false);
				axisSettings.setTitleVisible(isShowAxisTitle);
			}
		}
		/*
		 * Update the title to retrieve the correct axis.
		 */
		titleMinutes = title;
	}

	private void modifyYAxisRelativeResponse() {

		IChartSettings chartSettings = getChartSettings();
		ISecondaryAxisSettings axisSettings = ChartSupport.getSecondaryAxisSettingsY(titleRelativeIntensity, chartSettings);

		String positionNode = PreferenceSupplier.P_POSITION_Y_AXIS_RELATIVE_INTENSITY_PEAKS;
		String pattern = "0.00";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_Y_AXIS_RELATIVE_INTENSITY_PEAKS;
		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_Y_AXIS_RELATIVE_INTENSITY_PEAKS);
		boolean isShowAxisTitle = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_Y_AXIS_TITLE_RELATIVE_INTENSITY);

		String title = preferenceStore.getString(PreferenceSupplier.P_TITLE_Y_AXIS_RELATIVE_INTENSITY);

		if(isShowAxis) {
			if(axisSettings == null) {
				ISecondaryAxisSettings secondaryAxisSettingsY = new SecondaryAxisSettings(title, new PercentageConverter(SWT.VERTICAL, true));
				ChartSupport.setAxisSettings(secondaryAxisSettingsY, positionNode, pattern, gridLineStyleNode);
				ChartSupport.themeAxis(secondaryAxisSettingsY, PeaksChart.class.getName() + ".YAxisRelativeResponse");
				secondaryAxisSettingsY.setTitleVisible(isShowAxisTitle);
				chartSettings.getSecondaryAxisSettingsListY().add(secondaryAxisSettingsY);
			} else {
				ChartSupport.setAxisSettings(axisSettings, positionNode, pattern, gridLineStyleNode);
				ChartSupport.themeAxis(axisSettings, "YAxisRelativeResponse");
				axisSettings.setTitle(title);
				axisSettings.setVisible(true);
				axisSettings.setTitleVisible(isShowAxisTitle);
			}
		} else {
			if(axisSettings != null) {
				axisSettings.setTitle(title);
				ChartSupport.themeAxis(axisSettings, "YAxisRelativeResponse");
				axisSettings.setVisible(false);
				axisSettings.setTitleVisible(isShowAxisTitle);
			}
		}
		/*
		 * Update the title to retrieve the correct axis.
		 */
		titleRelativeIntensity = title;
	}
}
