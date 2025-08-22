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
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.image.ui.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.swt.SWT;
import org.eclipse.swtchart.extensions.core.BaseChart;
import org.eclipse.swtchart.extensions.marker.LabelMarker;

public class ScanLabelMarker extends LabelMarker {

	public ScanLabelMarker(BaseChart baseChart, int indexSeries, List<IScan> scans) {

		super(baseChart);
		List<String> labels = getScanLabels(scans);
		setLabels(labels, indexSeries, SWT.HORIZONTAL);
	}

	private List<String> getScanLabels(List<IScan> scans) {

		List<String> labels = new ArrayList<>();

		if(scans != null) {
			for(int i = 1; i <= scans.size(); i++) {
				labels.add("S" + i);
			}
		}

		return labels;
	}
}
