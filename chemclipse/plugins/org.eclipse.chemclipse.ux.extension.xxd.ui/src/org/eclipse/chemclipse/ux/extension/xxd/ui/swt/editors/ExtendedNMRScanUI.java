/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Christoph Läubrich - rework for new datamodel and processor support
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt.editors;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;
import org.eclipse.chemclipse.nmr.model.core.AcquisitionParameter;
import org.eclipse.chemclipse.nmr.model.core.IMeasurementFID;
import org.eclipse.chemclipse.nmr.model.core.ISpectrumMeasurement;
import org.eclipse.chemclipse.nmr.model.selection.IDataNMRSelection;
import org.eclipse.chemclipse.nmr.model.selection.IDataNMRSelection.ChangeType;
import org.eclipse.chemclipse.swt.ui.support.Colors;
import org.eclipse.chemclipse.ux.extension.xxd.ui.charts.ChartNMR;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtchart.extensions.core.AbstractAxisScaleConverter;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.linecharts.ILineSeriesData;
import org.eclipse.swtchart.extensions.linecharts.ILineSeriesSettings;
import org.eclipse.swtchart.extensions.linecharts.LineSeriesData;

public class ExtendedNMRScanUI implements PropertyChangeListener {

	private static final String SERIES_ID = "NMR";
	private ChartNMR chartNMR;
	private IDataNMRSelection dataNMRSelection;

	public ExtendedNMRScanUI(Composite parent) {

		chartNMR = new ChartNMR(parent, SWT.NONE, () -> dataNMRSelection.getMeasurement());
		IChartSettings chartSettings = chartNMR.getChartSettings();
		chartSettings.setCreateMenu(true);
		chartSettings.setEnableRangeSelector(false);
		chartSettings.setShowRangeSelectorInitially(false);
		chartNMR.applySettings(chartSettings);
	}

	public void update(IDataNMRSelection scanNMR) {

		if(dataNMRSelection != null) {
			dataNMRSelection.removeObserver(this);
		}
		this.dataNMRSelection = scanNMR;
		updateScan();
		scanNMR.addObserver(this);
	}

	public void suspendUpdate(boolean suspend) {

		chartNMR.getBaseChart().suspendUpdate(suspend);
	}

	public void updateScan() {

		boolean wasSuspend = chartNMR.getBaseChart().isUpdateSuspended();
		if(!wasSuspend) {
			suspendUpdate(true);
		}
		try {
			chartNMR.deleteSeries();
			if(dataNMRSelection != null) {
				IComplexSignalMeasurement<?> measurement = getCurrentMeasurement();
				AcquisitionParameter acquisitionParameter;
				boolean enableArea;
				if(measurement instanceof ISpectrumMeasurement spectrumMeasurement) {
					acquisitionParameter = spectrumMeasurement.getAcquisitionParameter();
					chartNMR.setPPMconverter(new AbstractAxisScaleConverter() {

						@Override
						public double convertToSecondaryUnit(double primaryValue) {

							return acquisitionParameter.toPPM(BigDecimal.valueOf(primaryValue)).doubleValue();
						}

						@Override
						public double convertToPrimaryUnit(double secondaryValue) {

							return acquisitionParameter.toHz(BigDecimal.valueOf(secondaryValue)).doubleValue();
						}
					});
					chartNMR.modifyChart(false);
					enableArea = true;
				} else if(measurement instanceof IMeasurementFID fidMeasurement) {
					acquisitionParameter = fidMeasurement.getAcquisitionParameter();
					chartNMR.setPPMconverter(null);
					chartNMR.modifyChart(true);
					enableArea = false;
				} else {
					chartNMR.setPPMconverter(null);
					return;
				}
				List<ILineSeriesData> lineSeriesDataList = new ArrayList<>();
				ILineSeriesData lineSeriesData = new LineSeriesData(ChartNMR.createSignalSeries(SERIES_ID, measurement.getSignals()));
				ILineSeriesSettings lineSeriesSettings = lineSeriesData.getSettings();
				lineSeriesSettings.setEnableArea(enableArea);
				lineSeriesSettings.setLineColor(Colors.RED);
				lineSeriesDataList.add(lineSeriesData);
				chartNMR.addSeriesData(lineSeriesDataList);
			}
		} finally {
			if(!wasSuspend) {
				suspendUpdate(false);
			}
		}
	}

	private IComplexSignalMeasurement<?> getCurrentMeasurement() {

		return dataNMRSelection.getMeasurement();
	}

	public Control getControl() {

		return chartNMR;
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

		Object arg = propertyChangeEvent.getNewValue();
		if(arg == ChangeType.SELECTION_CHANGED) {
			Display.getDefault().asyncExec(this::updateScan);
		}
	}
}