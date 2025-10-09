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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import org.eclipse.chemclipse.support.text.ValueFormat;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swtchart.IAxis;
import org.eclipse.swtchart.IAxis.Position;
import org.eclipse.swtchart.LineStyle;
import org.eclipse.swtchart.extensions.axisconverter.MillisecondsToMinuteConverter;
import org.eclipse.swtchart.extensions.axisconverter.PercentageConverter;
import org.eclipse.swtchart.extensions.core.BaseChart;
import org.eclipse.swtchart.extensions.core.IAxisSettings;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISecondaryAxisSettings;
import org.eclipse.swtchart.extensions.core.SecondaryAxisSettings;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.themes.ITheme;
import org.eclipse.ui.themes.IThemeManager;

public class ChartSupport {

	private static IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();

	/*
	 * Use private method only.
	 */
	private ChartSupport() {

	}

	public static void setPrimaryAxisSet(IChartSettings chartSettings, String xAxisTitle, boolean xAxisVisible, String yAxisTitle) {

		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		primaryAxisSettingsX.setTitle(xAxisTitle);
		primaryAxisSettingsX.setDecimalFormat(new DecimalFormat(("0.0##"), new DecimalFormatSymbols(Locale.ENGLISH)));
		primaryAxisSettingsX.setVisible(xAxisVisible);

		IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
		primaryAxisSettingsY.setTitle(yAxisTitle);
		primaryAxisSettingsY.setDecimalFormat(new DecimalFormat(("0.0##E0"), new DecimalFormatSymbols(Locale.ENGLISH)));
	}

	public static void clearSecondaryAxes(IChartSettings chartSettings) {

		chartSettings.getSecondaryAxisSettingsListX().clear();
		chartSettings.getSecondaryAxisSettingsListY().clear();
	}

	public static void addSecondaryAxisX(IChartSettings chartSettings, String xAxisTitle) {

		ISecondaryAxisSettings secondaryAxisSettingsX = new SecondaryAxisSettings(xAxisTitle, new MillisecondsToMinuteConverter());
		secondaryAxisSettingsX.setPosition(Position.Primary);
		secondaryAxisSettingsX.setDecimalFormat(new DecimalFormat(("0.00#"), new DecimalFormatSymbols(Locale.ENGLISH)));
		chartSettings.getSecondaryAxisSettingsListX().add(secondaryAxisSettingsX);
	}

	public static void addSecondaryAxisY(IChartSettings chartSettings, String yAxisTitle) {

		ISecondaryAxisSettings secondaryAxisSettingsY = new SecondaryAxisSettings(yAxisTitle, new PercentageConverter(SWT.VERTICAL, true));
		secondaryAxisSettingsY.setPosition(Position.Secondary);
		secondaryAxisSettingsY.setDecimalFormat(new DecimalFormat(("0.00#"), new DecimalFormatSymbols(Locale.ENGLISH)));
		chartSettings.getSecondaryAxisSettingsListY().add(secondaryAxisSettingsY);
	}

	public static void setAxisSettingsExtended(IAxisSettings axisSettings, String positionNode, String patternNode, String gridLineStyleNode) {

		String pattern = preferenceStore.getString(patternNode);
		setAxisSettings(axisSettings, positionNode, pattern, gridLineStyleNode);
	}

	public static void setAxisSettings(IAxisSettings axisSettings, String positionNode, String pattern, String gridLineStyleNode) {

		Position position = Position.valueOf(preferenceStore.getString(positionNode));
		LineStyle gridLineStyle = LineStyle.valueOf(preferenceStore.getString(gridLineStyleNode));
		setAxisSettings(axisSettings, position, pattern, gridLineStyle);
	}

	public static void setAxisSettings(IAxisSettings axisSettings, Position position, String decimalPattern, LineStyle gridLineStyle) {

		if(axisSettings != null) {
			axisSettings.setPosition(position);
			axisSettings.setDecimalFormat(ValueFormat.getDecimalFormatEnglish(decimalPattern));
			axisSettings.setGridLineStyle(gridLineStyle);
		}
	}

	public static ISecondaryAxisSettings getSecondaryAxisSettingsX(String title, IChartSettings chartSettings) {

		return getSecondaryAxisSettings(chartSettings.getSecondaryAxisSettingsListX(), title);
	}

	public static ISecondaryAxisSettings getSecondaryAxisSettingsY(String title, IChartSettings chartSettings) {

		return getSecondaryAxisSettings(chartSettings.getSecondaryAxisSettingsListY(), title);
	}

	/**
	 * May return null
	 * 
	 * @param baseChart
	 * @param title
	 * @return {@link IAxis}
	 */
	public static IAxis getAxisX(BaseChart baseChart, String title) {

		return getAxis(baseChart.getAxisSet().getXAxes(), title);
	}

	/**
	 * May return null
	 * 
	 * @param baseChart
	 * @param title
	 * @return {@link IAxis}
	 */
	public static IAxis getAxisY(BaseChart baseChart, String title) {

		return getAxis(baseChart.getAxisSet().getYAxes(), title);
	}

	// TODO: this is very bad for l10n
	public static ISecondaryAxisSettings getSecondaryAxisSettings(List<ISecondaryAxisSettings> secondaryAxisSettingsList, String title) {

		ISecondaryAxisSettings secondaryAxisSettings = null;

		for(ISecondaryAxisSettings secondaryAxisSetting : secondaryAxisSettingsList) {
			if(title.equals(secondaryAxisSetting.getTitle())) {
				secondaryAxisSettings = secondaryAxisSetting;
			}
		}

		return secondaryAxisSettings;
	}

	public static boolean getBoolean(String preferenceName) {

		return preferenceStore.getBoolean(preferenceName);
	}

	private static IAxis getAxis(IAxis[] axes, String title) {

		for(IAxis axis : axes) {
			if(axis.getTitle().getText().equals(title)) {
				return axis;
			}
		}

		return null;
	}

	public static void themeAxis(IAxisSettings axisSettings, String part) {

		IThemeManager themeManager = PlatformUI.getWorkbench().getThemeManager();
		ITheme currentTheme = themeManager.getCurrentTheme();

		ColorRegistry colorRegistry = currentTheme.getColorRegistry();
		Color color = colorRegistry.get(ChromatogramChart.class.getName() + "." + part + ".LineColor");
		axisSettings.setColor(color);

		Color gridColor = colorRegistry.get(ChromatogramChart.class.getName() + "." + part + ".GridColor");
		axisSettings.setGridColor(gridColor);

		FontRegistry fontRegistry = currentTheme.getFontRegistry();
		Font font = fontRegistry.get(ChromatogramChart.class.getName() + "." + part + ".Font");
		axisSettings.setTitleFont(font);
	}
}