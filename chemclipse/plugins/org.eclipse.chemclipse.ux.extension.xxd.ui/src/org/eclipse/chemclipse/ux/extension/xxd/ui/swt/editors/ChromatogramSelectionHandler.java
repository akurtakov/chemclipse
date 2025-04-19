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
package org.eclipse.chemclipse.ux.extension.xxd.ui.swt.editors;

import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swtchart.extensions.core.BaseChart;
import org.eclipse.swtchart.extensions.core.ICustomSelectionHandler;
import org.eclipse.swtchart.Range;

public class ChromatogramSelectionHandler implements ICustomSelectionHandler {

	private ExtendedChromatogramUI extendedChromatogramUI;

	public ChromatogramSelectionHandler(ExtendedChromatogramUI extendedChromatogramUI) {
		this.extendedChromatogramUI = extendedChromatogramUI;
	}

	
	@Override
	public void handleUserSelection(Event event) {

		IChromatogramSelection chromatogramSelection = extendedChromatogramUI.getChromatogramSelection();
		if(chromatogramSelection != null) {
			/*
			 * Get the range.
			 */
			BaseChart baseChart = extendedChromatogramUI.getChromatogramChart().getBaseChart();
			Range rangeX = baseChart.getAxisSet().getXAxis(BaseChart.ID_PRIMARY_X_AXIS).getRange();
			Range rangeY = baseChart.getAxisSet().getYAxis(BaseChart.ID_PRIMARY_Y_AXIS).getRange();
			//
			int startRetentionTime = (int)rangeX.lower;
			int stopRetentionTime = (int)rangeX.upper;
			float startAbundance = (float)rangeY.lower;
			float stopAbundance = (float)rangeY.upper;
			//
			extendedChromatogramUI.setChromatogramSelectionRange(startRetentionTime, stopRetentionTime, startAbundance, stopAbundance);
		}
	}
}
