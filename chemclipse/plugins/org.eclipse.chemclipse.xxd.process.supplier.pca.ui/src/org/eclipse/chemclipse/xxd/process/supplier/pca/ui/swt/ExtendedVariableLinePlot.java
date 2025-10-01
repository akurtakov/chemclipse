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
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.support.ui.provider.AbstractLabelProvider;
import org.eclipse.chemclipse.support.ui.swt.EnhancedComboViewer;
import org.eclipse.chemclipse.swt.ui.notifier.UpdateNotifierUI;
import org.eclipse.chemclipse.ux.extension.ui.model.IDataUpdateListener;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.IExtendedPartUI;
import org.eclipse.chemclipse.ux.extension.ui.swt.ISettingsHandler;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IEvaluation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResult;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d.VariableLinePlot;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.help.HelpContext;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.preferences.PreferencePage;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.preferences.PreferencePageFoldChangePlot;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support.FeatureColumnLabels;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swtchart.IAxis;
import org.eclipse.swtchart.Range;
import org.eclipse.swtchart.extensions.core.IChartSettings;

public class ExtendedVariableLinePlot extends Composite implements IExtendedPartUI {

	private static final String VARIABLE_LINE_PLOT_SELECT_NONE = "--";
	private AtomicReference<VariableLinePlot> plotControl = new AtomicReference<>();
	private AtomicReference<ComboViewer> comboViewerVariables = new AtomicReference<>();
	private AtomicReference<ComboViewer> comboViewerCategoryLabelType = new AtomicReference<>();
	private AtomicReference<Spinner> spinnerControlFontSize = new AtomicReference<>();
	private IEvaluation<IVariable, ISample, IResult> evaluation = null;
	private Composite control;
	private ISamplesPCA<IVariable, ISample> samples = null;
	private ArrayList<String> variables = new ArrayList<>();
	private String lastVariableSelection = VARIABLE_LINE_PLOT_SELECT_NONE;

	public ExtendedVariableLinePlot(Composite parent, int style) {

		super(parent, style);
		createControl();
		DataUpdateSupport dataUpdateSupport = Activator.getDefault().getDataUpdateSupport();
		dataUpdateSupport.add(new IDataUpdateListener() {

			@Override
			public void update(String topic, List<Object> objects) {

				if(evaluation != null) {
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
								evaluation.setHighlightedSamples(samples);
								setInput(evaluation);
							}
						}
					}
				}
			}
		});
	}

	public void setInput(IEvaluation<IVariable, ISample, IResult> evaluation) {

		this.evaluation = evaluation;
		if(this.evaluation != null) {
			this.samples = evaluation.getSamples();
		}
		updateInput();
	}

	public void updateInput() {

		if(samples != null) {
			IAnalysisSettings analysisSettings = samples.getAnalysisSettings();
			updateWidgets(analysisSettings);
		}
		applySettings();
	}

	private void createControl() {

		setLayout(new GridLayout(1, true));

		createToolbarMain(this);
		createPlot(this);
		initialize();
		control = this;
	}

	private void initialize() {

		variables.add(VARIABLE_LINE_PLOT_SELECT_NONE);
		comboViewerVariables.get().setInput(variables);
	}

	private void createToolbarMain(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalAlignment = SWT.END;
		composite.setLayoutData(gridData);
		composite.setLayout(new GridLayout(7, false));

		createComboViewerCategoryLabelType(composite);
		createLabel(composite, "Font Size");
		createSpinnerFontSize(composite);
		createLabel(composite, "Variable:");
		createComboViewerVariable(composite);
		createSettingsButton(composite);
		createButtonHelp(composite, HelpContext.FOLD_CHANGE_PLOT);
	}

	private Label createLabel(Composite parent, String text) {

		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		return label;
	}

	private void createComboViewerCategoryLabelType(Composite parent) {

		ComboViewer comboViewer = new EnhancedComboViewer(parent, SWT.READ_ONLY);
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new AbstractLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof FeatureColumnLabels featureColumnLabel) {
					return featureColumnLabel.label();
				}
				return null;
			}
		});
		Combo combo = comboViewer.getCombo();
		combo.setToolTipText("Select Column Label");
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object object = comboViewer.getStructuredSelection().getFirstElement();
				if(object instanceof FeatureColumnLabels featureColumnLabel) {
					if(evaluation != null) {
						if(featureColumnLabel.equals(FeatureColumnLabels.SAMPLENAMES)) {
							plotControl.get().setCategoryLabelType(FeatureColumnLabels.SAMPLENAMES);
							updateInput();
						} else {
							plotControl.get().setCategoryLabelType(FeatureColumnLabels.GROUPNAMES);
							updateInput();
						}
					}
				}
			}
		});

		comboViewer.setInput(FeatureColumnLabels.values());
		comboViewer.setSelection(new StructuredSelection(FeatureColumnLabels.SAMPLENAMES));

		comboViewerCategoryLabelType.set(comboViewer);
	}

	private void createSpinnerFontSize(Composite parent) {

		Spinner spinner = new Spinner(parent, SWT.BORDER);
		spinner.setToolTipText("Font Size X-Axis");
		spinner.setMinimum(PreferenceSupplier.MIN_VARIABLE_LINE_PLOT_XAXIS_FONT_SIZE);
		spinner.setIncrement(1);
		spinner.setSelection(PreferenceSupplier.DEF_VARIABLE_LINE_PLOT_XAXIS_FONT_SIZE);
		spinner.setMaximum(PreferenceSupplier.MAX_VARIABLE_LINE_PLOT_XAXIS_FONT_SIZE);
		spinner.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if(samples != null) {
					IAnalysisSettings analysisSettings = samples.getAnalysisSettings();
					if(analysisSettings != null) {
						analysisSettings.setVariableLinePlotFontSize(spinner.getSelection());
						updateInput();
					}
				}
			}
		});
		spinnerControlFontSize.set(spinner);
	}

	private void createComboViewerVariable(Composite parent) {

		ComboViewer comboViewer = new EnhancedComboViewer(parent, SWT.BORDER | SWT.READ_ONLY);

		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new AbstractLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof String value) {
					return value;
				} else {
					return "";
				}
			}
		});
		Combo combo = comboViewer.getCombo();
		combo.setToolTipText("Variable to plot");
		GridData gridData = new GridData();
		gridData.widthHint = 350;
		combo.setLayoutData(gridData);
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if(samples != null) {
					IAnalysisSettings analysisSettings = samples.getAnalysisSettings();
					if(analysisSettings != null) {
						analysisSettings.setVariableLinePlotVariable(comboViewer.getStructuredSelection().getFirstElement().toString());
						UpdateNotifierUI.update(e.display, IChemClipseEvents.TOPIC_PCA_UPDATE_GROUPS, comboViewer.getStructuredSelection().getFirstElement().toString());
					}
				}
			}
		});
		comboViewerVariables.set(comboViewer);
	}

	private void createPlot(Composite parent) {

		VariableLinePlot plot = new VariableLinePlot(parent, SWT.BORDER);
		plot.setLayoutData(new GridData(GridData.FILL_BOTH));

		IChartSettings chartSettings = plot.getChartSettings();
		plot.applySettings(chartSettings);
		plotControl.set(plot);

	}

	private void createSettingsButton(Composite parent) {

		createSettingsButton(parent, Arrays.asList(PreferencePage.class, PreferencePageFoldChangePlot.class), new ISettingsHandler() {

			@Override
			public void apply(Display display) {

				applySettings();
			}
		});
	}

	private void applySettings() {

		String variable = comboViewerVariables.get().getStructuredSelection().getFirstElement().toString();
		if(variable != null) {
			updatePlot(variable);
		}

	}

	private void updateWidgets(IAnalysisSettings analysisSettings) {

		updateVariables();
		updateComboViewerVariables(analysisSettings);

	}

	private void updateComboViewerVariables(IAnalysisSettings analysisSettings) {

		comboViewerVariables.get().setInput(variables);
		String selection = VARIABLE_LINE_PLOT_SELECT_NONE;
		if(analysisSettings != null) {
			String variableName = analysisSettings.getVariableLinePlotVariable();
			if(variables.contains(variableName)) {
				selection = variableName;
			}
		}
		comboViewerVariables.get().setSelection(new StructuredSelection(selection));
	}

	private void updateVariables() {

		variables.clear();
		variables.add(VARIABLE_LINE_PLOT_SELECT_NONE);
		if(samples != null) {
			for(IVariable variable : samples.getVariables()) {
				if(variable.getClassification() == null) {
					logger.warn("Fix VariableLinePlotVariable (must not be null); " + variable);
					variable.setDescription("");
				}
			}

			variables.addAll(samples.getVariables().stream().map(x -> x.getValue() + " " + x.getDescription()).toList());
		}
	}

	private void updatePlot(String variable) {

		boolean keepRange = true;
		if(lastVariableSelection.equals(VARIABLE_LINE_PLOT_SELECT_NONE) || !lastVariableSelection.equals(variable)) {
			keepRange = false;
		}
		lastVariableSelection = variable;
		VariableLinePlot plot = plotControl.get();
		IAxis xAxis = plot.getBaseChart().getAxisSet().getXAxis(0);
		Range range = new Range(xAxis.getRange().lower, xAxis.getRange().upper);
		plot.deleteSeries();
		if(evaluation != null) {
			plot.setInput(evaluation, variable);
		} else {
			plot.setInput(null, variable);
		}
		if(keepRange) {
			xAxis.setRange(range);
		}

	}

}
