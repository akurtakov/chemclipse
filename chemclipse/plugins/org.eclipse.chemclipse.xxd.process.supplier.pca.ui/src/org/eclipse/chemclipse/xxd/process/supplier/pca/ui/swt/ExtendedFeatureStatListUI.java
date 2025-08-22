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
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.model.statistics.ISample;
import org.eclipse.chemclipse.model.statistics.IVariable;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.support.updates.IUpdateListener;
import org.eclipse.chemclipse.swt.ui.notifier.UpdateNotifierUI;
import org.eclipse.chemclipse.ux.extension.ui.model.IDataUpdateListener;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.IExtendedPartUI;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.Feature;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.FeatureDataMatrix;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IEvaluation;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.IResult;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;

public class ExtendedFeatureStatListUI extends Composite implements IExtendedPartUI {

	private AtomicReference<FeatureStatListUI> listControl = new AtomicReference<>();

	private IEvaluation<IVariable, ISample, IResult> evaluation = null;
	private FeatureDataMatrix featureDataMatrix = null;

	private Composite control;

	public ExtendedFeatureStatListUI(Composite parent, int style) {

		super(parent, style);
		createControl();

		DataUpdateSupport dataUpdateSupport = Activator.getDefault().getDataUpdateSupport();
		dataUpdateSupport.add(new IDataUpdateListener() {

			@Override
			public void update(String topic, List<Object> objects) {

				if(evaluation != null) {
					if(DataUpdateSupport.isVisible(control)) {
						if(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_PLOT_VARIABLE.equals(topic)) {
							if(objects.size() == 1) {
								Object object = objects.get(0);
								ArrayList<Feature> features = new ArrayList<>();
								if(object instanceof Object[] values) {
									int length = values.length;
									for(int i = 0; i < length; i++) {
										if(values[i] instanceof Feature feature) {
											features.add(feature);
										}
									}
									if(features.size() >= 0) {
										List<IVariable> test = evaluation.getSamples().getVariables();
										test.forEach(x -> x.setVisualSelected(false));
										for(Feature feature : features) {
											feature.getVariable().setVisualSelected(true);
										}
										listControl.get().setSelection(new StructuredSelection(features));
										if(features.size() > 0) {
											listControl.get().reveal(features.get(0));
										}
									}
								}
							}
						}
					}
				}
			}
		});
	}

	public void setInput(IEvaluation<IVariable, ISample, IResult> evaluation) {

		if(doUpdate(evaluation)) {
			this.evaluation = evaluation;
			updateInput(true);
		}
	}

	private void updateInput(boolean updateFeatures) {

		if(updateFeatures) {
			featureDataMatrix = evaluation != null ? evaluation.getFeatureDataMatrix() : null;
		}
		updateInput();
	}

	private void createControl() {

		setLayout(new GridLayout(1, true));
		createList(this);
	}

	private void createList(Composite parent) {

		FeatureStatListUI featureStatListUI = new FeatureStatListUI(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.VIRTUAL);
		Table table = featureStatListUI.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		featureStatListUI.setUpdateListener(new IUpdateListener() {

			@Override
			public void update() {

				UpdateNotifierUI.update(Display.getDefault(), IChemClipseEvents.TOPIC_PCA_UPDATE_FEATURES, evaluation);
			}
		});

		listControl.set(featureStatListUI);
	}

	private boolean doUpdate(IEvaluation<IVariable, ISample, IResult> evaluation) {

		return this.evaluation != evaluation;
	}

	private void updateInput() {

		listControl.get().clear();

		getDisplay().asyncExec(() -> {
			updateWidgets();
		});
	}

	private void updateWidgets() {

		FeatureStatListUI featureStatListUI = listControl.get();
		featureStatListUI.clearColumns();
		featureStatListUI.setInput(featureDataMatrix);
	}
}
