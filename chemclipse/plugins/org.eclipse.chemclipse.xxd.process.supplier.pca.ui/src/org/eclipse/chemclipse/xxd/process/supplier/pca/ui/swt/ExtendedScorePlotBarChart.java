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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.ux.extension.ui.model.IDataUpdateListener;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.IExtendedPartUI;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResultsMVA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d.ScorePlotBarChart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swtchart.extensions.core.BaseChart;
import org.eclipse.swtchart.extensions.core.IChartSettings;
import org.eclipse.swtchart.extensions.core.IMouseSupport;
import org.eclipse.swtchart.extensions.events.IHandledEventProcessor;

public class ExtendedScorePlotBarChart extends Composite implements IExtendedPartUI {

	private AtomicReference<ScorePlotBarChart> chartControl = new AtomicReference<>();
	private Combo comboPrincipalComponent;
	private EvaluationPCA evaluationPCA = null;
	private int currentPC = 0;
	private Composite control;
	@SuppressWarnings("unused")
	private ISamplesPCA<IVariable, ISample> samples = null;

	public ExtendedScorePlotBarChart(Composite parent, int style) {

		super(parent, style);
		createControl();
		DataUpdateSupport dataUpdateSupport = Activator.getDefault().getDataUpdateSupport();
		dataUpdateSupport.add(new IDataUpdateListener() {

			@Override
			public void update(String topic, List<Object> objects) {

				if(evaluationPCA != null) {
					if(DataUpdateSupport.isVisible(control)) {
						if(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_SAMPLE.equals(topic)) {
							if(objects.size() == 1) {
								Object object = objects.get(0);
								ArrayList<ISample> samples = new ArrayList<>();
								if(object instanceof Object[] values) {
									for(int i = 0; i < values.length; i++) {
										if(values[i] instanceof ISample) {
											samples.add((ISample)values[i]);
										}
									}
								}
								evaluationPCA.setHighlightedSamples(samples);
								setInput(evaluationPCA);
							}
						}
					}

				}
			}
		});
	}

	public void setInput(EvaluationPCA evaluationPCA) {

		this.evaluationPCA = evaluationPCA;
		if(this.evaluationPCA != null) {
			samples = evaluationPCA.getSamples();
		}
		updatePlot();
	}

	public void updatePlot() {

		updateWidgets();
		applySettings();
	}

	private void createControl() {

		setLayout(new GridLayout(1, true));
		createToolbarMain(this);
		createChart(this);
		control = this;
	}

	private void createToolbarMain(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalAlignment = SWT.END;
		composite.setLayoutData(gridData);
		composite.setLayout(new GridLayout(2, false));

		createPCSelector(composite);
	}

	private void createPCSelector(Composite parent) {

		Label label = new Label(parent, SWT.NONE);
		label.setText("Principal Component:");

		comboPrincipalComponent = new Combo(parent, SWT.READ_ONLY);
		comboPrincipalComponent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		comboPrincipalComponent.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				currentPC = comboPrincipalComponent.getSelectionIndex();
				updateChart();
			}
		});
	}

	private void createChart(Composite parent) {

		ScorePlotBarChart chart = new ScorePlotBarChart(parent, SWT.BORDER);
		chart.setLayoutData(new GridData(GridData.FILL_BOTH));

		IChartSettings chartSettings = chart.getChartSettings();
		chartSettings.addHandledEventProcessor(new IHandledEventProcessor() {

			@Override
			public int getEvent() {

				return IMouseSupport.EVENT_MOUSE_MOVE;
			}

			@Override
			public int getButton() {

				return IMouseSupport.MOUSE_BUTTON_NONE;
			}

			@Override
			public int getStateMask() {

				return SWT.NONE;
			}

			@Override
			public void handleEvent(BaseChart baseChart, Event event) {

				if(evaluationPCA != null) {

					// Convert pixel coordinates to data coordinates
					double xValue = baseChart.getAxisSet().getXAxis(BaseChart.ID_PRIMARY_X_AXIS).getDataCoordinate(event.x);

					// Create list of sample-score pairs
					IResultsMVA results = evaluationPCA.getResults();
					List<IResultMVA> resultList = results.getPcaResultList();
					List<SampleScore> sampleScores = new ArrayList<>();
					for(IResultMVA result : resultList) {
						ISample sample = result.getSample();
						double[] scoreMatrix = result.getScoreVector();

						if(currentPC < scoreMatrix.length) {
							double score = scoreMatrix[currentPC];
							String sampleName = sample.getSampleName();
							sampleScores.add(new SampleScore(sampleName, score));
						}
					}

					// Sort by score value (descending: positive to negative)
					sampleScores.sort(Comparator.comparingDouble(SampleScore::getScore).reversed());

					int barIndex = (int)Math.round(xValue);

					if(barIndex >= 0 && barIndex < sampleScores.size()) {
						String sampleName = sampleScores.get(barIndex).getSampleName();
						String tooltip = "Sample: " + sampleName + "\nValue: " + String.format("%.2f", sampleScores.get(barIndex).getScore());
						baseChart.getPlotArea().setToolTipText(tooltip);
					} else {
						baseChart.getPlotArea().setToolTipText(null);
					}
				}
			}

		});

		chart.applySettings(chartSettings);

		chartControl.set(chart);
	}

	private void updateWidgets() {

		if(evaluationPCA != null) {
			IAnalysisSettings analysisSettings = evaluationPCA.getSamples().getAnalysisSettings();
			updatePCCombo(analysisSettings);
		} else {
			comboPrincipalComponent.removeAll();
		}
	}

	private void updatePCCombo(IAnalysisSettings analysisSettings) {

		comboPrincipalComponent.removeAll();

		if(evaluationPCA != null && analysisSettings != null) {
			int numberOfPCs = analysisSettings.getNumberOfPrincipalComponents();
			double[] explainedVariances = evaluationPCA.getResults().getExplainedVariances();

			int maxPCs = Math.min(numberOfPCs, explainedVariances.length);

			for(int i = 0; i < maxPCs; i++) {
				String label = String.format("PC%d (%.1f%%)", i + 1, explainedVariances[i] * 100);
				comboPrincipalComponent.add(label);
			}

			if(maxPCs > 0) {
				int selectedIndex = Math.min(currentPC, maxPCs - 1);
				comboPrincipalComponent.select(selectedIndex);
				currentPC = selectedIndex;
			}
		}
	}

	private void updateChart() {

		ScorePlotBarChart chart = chartControl.get();
		if(chart != null) {
			if(evaluationPCA != null) {
				chart.setInput(evaluationPCA, comboPrincipalComponent.getSelectionIndex());
			} else {
				chart.setInput(null, 0);
			}
		}
	}

	private void applySettings() {

		updateChart();
	}

	@Override
	public void update() {

		updatePlot();
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