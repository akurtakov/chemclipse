/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
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
import org.eclipse.chemclipse.ux.extension.ui.model.IDataUpdateListener;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.IExtendedPartUI;
import org.eclipse.chemclipse.ux.extension.ui.swt.ISettingsHandler;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Feature;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IAnalysisSettings;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.ISamplesPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d.FoldChangePlot;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.help.HelpContext;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.preferences.PreferencePage;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.preferences.PreferencePageLoadingPlot;
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

public class ExtendedFoldChangePlot extends Composite implements IExtendedPartUI {

	private static final String FOLD_CHANGE_GROUP_NONE = "--";
	private AtomicReference<FoldChangePlot> plotControl = new AtomicReference<>();
	private AtomicReference<ComboViewer> comboViewerGroup1 = new AtomicReference<>();
	private AtomicReference<ComboViewer> comboViewerGroup2 = new AtomicReference<>();
	private EvaluationPCA evaluationPCA = null;
	private Composite control;
	private ISamplesPCA<IVariable, ISample> samples = null;
	private ArrayList<String> groups = new ArrayList<>();

	public ExtendedFoldChangePlot(Composite parent, int style) {

		super(parent, style);
		createControl();
		DataUpdateSupport dataUpdateSupport = Activator.getDefault().getDataUpdateSupport();
		dataUpdateSupport.add(new IDataUpdateListener() {

			@Override
			public void update(String topic, List<Object> objects) {

				if(evaluationPCA != null) {
					if(DataUpdateSupport.isVisible(control)) {
						if(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_LIST_VARIABLE.equals(topic) || IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_PLOT_VARIABLE.equals(topic)) {
							if(objects.size() == 1) {
								Object object = objects.get(0);
								ArrayList<IVariable> selectedVariables = new ArrayList<>();
								if(object instanceof Object[] values) {
									for(int i = 0; i < values.length; i++) {
										if(values[i] instanceof Feature) {
											Feature feature = (Feature)values[i];
											selectedVariables.add(feature.getVariable());
										}
									}
								}
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
		updateFoldChangeGroups();
		updateInput();
	}

	public void updateInput() {

		updateWidgets();
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

		groups.add(FOLD_CHANGE_GROUP_NONE);
		comboViewerGroup1.get().setInput(groups);
		comboViewerGroup2.get().setSelection(new StructuredSelection(FOLD_CHANGE_GROUP_NONE));
	}

	private void createToolbarMain(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalAlignment = SWT.END;
		composite.setLayoutData(gridData);
		composite.setLayout(new GridLayout(4, false));
		createComboViewerGroup1(this);
		createComboViewerGroup2(this);
		createSettingsButton(composite);
		createButtonHelp(composite, HelpContext.FOLD_CHANGE_PLOT);
	}

	private void createComboViewerGroup1(Composite parent) {

		ComboViewer comboViewer = new EnhancedComboViewer(parent, SWT.BORDER | SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
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
		combo.setToolTipText("Group one for comparison");
		GridData gridData = new GridData();
		gridData.widthHint = 250;
		combo.setLayoutData(gridData);
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if(samples != null) {
					IAnalysisSettings analysisSettings = samples.getAnalysisSettings();
					if(analysisSettings != null) {
						analysisSettings.setComparisonGroup1(comboViewer.getStructuredSelection().getFirstElement().toString());
					}
				}
			}
		});
		comboViewerGroup1.set(comboViewer);
	}

	private void createComboViewerGroup2(Composite parent) {

		ComboViewer comboViewer = new EnhancedComboViewer(parent, SWT.BORDER | SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
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
		combo.setToolTipText("Group two for comparison");
		GridData gridData = new GridData();
		gridData.widthHint = 250;
		combo.setLayoutData(gridData);
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if(samples != null) {
					IAnalysisSettings analysisSettings = samples.getAnalysisSettings();
					if(analysisSettings != null) {
						analysisSettings.setComparisonGroup2(comboViewer.getStructuredSelection().getFirstElement().toString());
					}
				}
			}
		});
		comboViewerGroup2.set(comboViewer);
	}

	private void createPlot(Composite parent) {

		FoldChangePlot plot = new FoldChangePlot(parent, SWT.BORDER);
		plot.setLayoutData(new GridData(GridData.FILL_BOTH));
		plotControl.set(plot);
	}

	private void createSettingsButton(Composite parent) {

		createSettingsButton(parent, Arrays.asList(PreferencePage.class, PreferencePageLoadingPlot.class), new ISettingsHandler() {

			@Override
			public void apply(Display display) {

				applySettings();
			}
		});
	}

	private void applySettings() {

		updatePlot("group1", "group2");
	}

	private void updateWidgets() {

	}

	private void updatePlot(String group1, String group2) {

		FoldChangePlot plot = plotControl.get();
		plot.deleteSeries();
		if(evaluationPCA != null) {
			plot.setInput(evaluationPCA, group1, group2);
		} else {
			plot.setInput(null, group1, group2);
		}
	}

	private void updateFoldChangeGroups() {

		groups.clear();
		groups.add(FOLD_CHANGE_GROUP_NONE);
		if(samples != null) {
			for(ISample sample : samples.getSamples()) {
				if(sample.getGroupName() == null) {
					logger.warn("Fix GroupName (must not be null): " + sample);
					sample.setGroupName("");
				}
			}
			/*
			 * Map Group Names
			 */
			groups.addAll(samples.getSamples().stream().map(x -> x.getGroupName()).distinct().toList());
		}
	}
}
