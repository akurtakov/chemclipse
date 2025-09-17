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
 * Matthias Mailänder - initial API and implementation
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.charts;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.eclipse.chemclipse.support.ui.workbench.PreferencesSupport;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.chemclipse.ux.extension.xxd.ui.l10n.ExtensionMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.IAxis.Position;
import org.eclipse.swtchart.LineStyle;
import org.eclipse.swtchart.extensions.axisconverter.PercentageConverter;
import org.eclipse.swtchart.extensions.core.IAxisSettings;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IPrimaryAxisSettings;
import org.eclipse.swtchart.extensions.core.ISecondaryAxisSettings;
import org.eclipse.swtchart.extensions.core.SecondaryAxisSettings;
import org.eclipse.swtchart.extensions.linecharts.LineChart;

public class ChartFSD extends LineChart {

	public ChartFSD() {

		super();
		initialize();
	}

	public ChartFSD(Composite parent, int style) {

		super(parent, style);
		initialize();
	}

	private void initialize() {

		createChartSettings();
	}

	private void createChartSettings() {

		/*
		 * Chart Settings
		 */
		IChartSettings chartSettings = getChartSettings();
		chartSettings.setOrientation(SWT.HORIZONTAL);
		chartSettings.setHorizontalSliderVisible(true);
		chartSettings.setVerticalSliderVisible(false);
		chartSettings.getRangeRestriction().setZeroX(false);
		chartSettings.getRangeRestriction().setZeroY(false);
		chartSettings.getRangeRestriction().setForceZeroMinY(false);

		String yLabel = ExtensionMessages.intensity;
		setPrimaryAxisSetProcessed(chartSettings, yLabel);
		addSecondaryAxisSetProcessed(chartSettings, yLabel);
		applySettings(chartSettings);
	}

	private void setPrimaryAxisSetProcessed(IChartSettings chartSettings, String yLabel) {

		IPrimaryAxisSettings primaryAxisSettingsX = chartSettings.getPrimaryAxisSettingsX();
		primaryAxisSettingsX.setTitle(ExtensionMessages.wavelength);
		primaryAxisSettingsX.setDecimalFormat(new DecimalFormat(("0.0##"), new DecimalFormatSymbols(Locale.ENGLISH)));
		primaryAxisSettingsX.setVisible(true);
		setGridColor(primaryAxisSettingsX);

		IPrimaryAxisSettings primaryAxisSettingsY = chartSettings.getPrimaryAxisSettingsY();
		primaryAxisSettingsY.setTitle(yLabel);
		primaryAxisSettingsY.setDecimalFormat(new DecimalFormat(("0.0#E0"), new DecimalFormatSymbols(Locale.ENGLISH)));
		primaryAxisSettingsY.setGridLineStyle(LineStyle.NONE);
		primaryAxisSettingsY.setVisible(true);
		setGridColor(primaryAxisSettingsY);
	}

	private void addSecondaryAxisSetProcessed(IChartSettings chartSettings, String yLabel) {

		deleteSecondaryAxes(chartSettings);
		/*
		 * Y
		 */
		ISecondaryAxisSettings secondaryAxisSettingsY = new SecondaryAxisSettings("Relative " + yLabel + " [%]", new PercentageConverter(SWT.VERTICAL, true));
		secondaryAxisSettingsY.setPosition(Position.Secondary);
		secondaryAxisSettingsY.setDecimalFormat(new DecimalFormat(("0.00"), new DecimalFormatSymbols(Locale.ENGLISH)));
		chartSettings.getSecondaryAxisSettingsListY().add(secondaryAxisSettingsY);
	}

	private void deleteSecondaryAxes(IChartSettings chartSettings) {

		chartSettings.getSecondaryAxisSettingsListX().clear();
		chartSettings.getSecondaryAxisSettingsListY().clear();
	}

	private void setGridColor(IAxisSettings axisSettings) {

		if(PreferencesSupport.isDarkTheme()) {
			axisSettings.setGridColor(Colors.getColor(new RGB(64, 64, 64)));
		} else {
			axisSettings.setGridColor(Colors.GRAY);
		}
	}
}
