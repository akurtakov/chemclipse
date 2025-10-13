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

import org.eclipse.chemclipse.ux.extension.xxd.ui.preferences.PreferenceSupplier;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.extensions.axisconverter.PercentageConverter;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISecondaryAxisSettings;
import org.eclipse.swtchart.extensions.core.SecondaryAxisSettings;
import org.eclipse.swtchart.extensions.linecharts.LineChart;

public class CalibrationChart extends LineChart {

	public static final String TITLE_X_AXIS_CONCENTRATION = "Concentration";
	public static final String TITLE_Y_AXIS_RESPONSE = "Response";
	public static final String TITLE_Y_AXIS_RELATIVE_RESPONSE = "Relative Response [%]";

	public CalibrationChart() {

		super();
		initialize();
	}

	public CalibrationChart(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	public void setConcentrationLabel(String concentrationUnit) {

		IChartSettings chartSettings = getChartSettings();
		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		String title = TITLE_X_AXIS_CONCENTRATION;
		if(concentrationUnit != null && !"".equals(concentrationUnit)) {
			title += " [" + concentrationUnit + "]";
		}
		primaryAxisSettingsX.setTitle(title);
		applySettings(chartSettings);
	}

	private void initialize() {

		IChartSettings chartSettings = getChartSettings();

		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setHorizontalSliderVisible(false);
		chartSettings.setVerticalSliderVisible(false);
		chartSettings.getRangeRestriction().setZeroX(true);
		chartSettings.getRangeRestriction().setZeroY(true);
		chartSettings.setCreateMenu(true);

		modifyAxes(true);
	}

	public void modifyAxes(boolean applySettings) {

		modifyXAxisConcentration();
		modifyYAxisResponse();
		modifyYAxisRelativeResponse();

		if(applySettings) {
			IChartSettings chartSettings = getChartSettings();
			applySettings(chartSettings);
		}
	}

	private void modifyXAxisConcentration() {

		IChartSettings chartSettings = getChartSettings();
		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		primaryAxisSettingsX.setTitle(TITLE_X_AXIS_CONCENTRATION);

		String positionNode = PreferenceSupplier.P_POSITION_X_AXIS_CONCENTRATION_CALIBRATION;
		String pattern = "0.0##";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_X_AXIS_CONCENTRATION_CALIBRATION;

		ChartSupport.setAxisSettings(primaryAxisSettingsX, positionNode, pattern, gridLineStyleNode);

		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_X_AXIS_CONCENTRATION_CALIBRATION);
		primaryAxisSettingsX.setVisible(isShowAxis);

		ChartSupport.themeAxis(primaryAxisSettingsX, CalibrationChart.class.getName() + ".XAxisConcentration");
	}

	private void modifyYAxisResponse() {

		IChartSettings chartSettings = getChartSettings();
		IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
		primaryAxisSettingsY.setTitle(TITLE_Y_AXIS_RESPONSE);

		String positionNode = PreferenceSupplier.P_POSITION_Y_AXIS_RESPONSE_CALIBRATION;
		String pattern = "0.0#E0";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_Y_AXIS_RESPONSE_CALIBRATION;
		ChartSupport.setAxisSettings(primaryAxisSettingsY, positionNode, pattern, gridLineStyleNode);

		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_Y_AXIS_RESPONSE_CALIBRATION);
		primaryAxisSettingsY.setVisible(isShowAxis);

		ChartSupport.themeAxis(primaryAxisSettingsY, CalibrationChart.class.getName() + ".YAxisResponse");
	}

	private void modifyYAxisRelativeResponse() {

		IChartSettings chartSettings = getChartSettings();
		ISecondaryAxisSettings axisSettings = ChartSupport.getSecondaryAxisSettingsY(TITLE_Y_AXIS_RELATIVE_RESPONSE, chartSettings);

		String positionNode = PreferenceSupplier.P_POSITION_Y_AXIS_RELATIVE_RESPONSE_CALIBRATION;
		String pattern = "0.00";
		String gridLineStyleNode = PreferenceSupplier.P_GRIDLINE_STYLE_Y_AXIS_RELATIVE_RESPONSE_CALIBRATION;
		boolean isShowAxis = ChartSupport.getBoolean(PreferenceSupplier.P_SHOW_Y_AXIS_RELATIVE_RESPONSE_CALIBRATION);

		if(isShowAxis) {
			if(axisSettings == null) {
				ISecondaryAxisSettings secondaryAxisSettingsY = new SecondaryAxisSettings(TITLE_Y_AXIS_RELATIVE_RESPONSE, new PercentageConverter(SWT.VERTICAL, true));
				ChartSupport.setAxisSettings(secondaryAxisSettingsY, positionNode, pattern, gridLineStyleNode);
				ChartSupport.themeAxis(secondaryAxisSettingsY, CalibrationChart.class.getName() + ".YAxisRelativeResponse");
				chartSettings.getSecondaryAxisSettingsListY().add(secondaryAxisSettingsY);
			} else {
				ChartSupport.setAxisSettings(axisSettings, positionNode, pattern, gridLineStyleNode);
				ChartSupport.themeAxis(axisSettings, CalibrationChart.class.getName() + ".YAxisRelativeResponse");
				axisSettings.setVisible(true);
			}
		} else {
			if(axisSettings != null) {
				axisSettings.setVisible(false);
			}
		}
	}
}
