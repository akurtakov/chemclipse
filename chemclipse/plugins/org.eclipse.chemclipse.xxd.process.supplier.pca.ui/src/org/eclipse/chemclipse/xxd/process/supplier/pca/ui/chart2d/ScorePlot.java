/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - getting rid of JavaFX
 * Lorenz Gerber - add sample highlighting
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support.SeriesConverter;
import org.eclipse.swt.widgets.Composite;

public class ScorePlot extends AbtractPlotPCA {

	private final Map<ISample, IResultPCA> extractedResults = new HashMap<>();

	public ScorePlot(Composite parent, int style) {

		super(parent, style, "Score Plot");
	}

	public void setInput(EvaluationPCA<IVariable, ISample, IResultPCA> evaluationPCA, int pcX, int pcY) {

		deleteSeries();
		if(evaluationPCA != null) {
			IResultsPCA<IResultPCA, ?> resultsPCA = evaluationPCA.getResults();
			List<ISample> highlightedSamples = evaluationPCA.getHighlightedSamples();
			addSeriesData(SeriesConverter.sampleToSeries(resultsPCA, highlightedSamples, pcX, pcY, extractedResults));
		}
		redraw();
	}
}
