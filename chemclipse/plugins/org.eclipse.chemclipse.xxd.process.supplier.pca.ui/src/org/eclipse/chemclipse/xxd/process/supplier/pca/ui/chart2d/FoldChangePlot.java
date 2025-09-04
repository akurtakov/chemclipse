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
 * Lorenz Gerber- initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d;

import java.util.List;

import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support.SeriesConverter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtchart.extensions.scattercharts.IScatterSeriesData;

public class FoldChangePlot extends AbstractPlotPCA {

	public FoldChangePlot(Composite parent, int style) {

		super(parent, style, "Fold Change Plot");
	}

	public void setInput(EvaluationPCA evaluationPCA, String group1, String group2) {

		deleteSeries();
		if(evaluationPCA != null) {
			IResultsMVA resultsPCA = evaluationPCA.getResults();
			List<IScatterSeriesData> series;
			series = SeriesConverter.foldChangeToSeries(resultsPCA, group1, group2);
			addSeriesData(series);
		}
		redraw();
	}

}
