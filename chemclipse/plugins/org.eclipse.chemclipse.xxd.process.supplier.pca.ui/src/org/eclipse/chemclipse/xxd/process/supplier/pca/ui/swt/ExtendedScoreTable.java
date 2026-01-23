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
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.swt;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.ux.extension.ui.model.IDataUpdateListener;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.chemclipse.ux.extension.ui.swt.IExtendedPartUI;
import org.eclipse.chemclipse.xxd.process.supplier.pca.model.EvaluationPCA;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.Activator;
import org.eclipse.chemclipse.xxd.process.supplier.pca.ui.chart2d.ScoreTable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class ExtendedScoreTable extends Composite implements IExtendedPartUI {

	private AtomicReference<ScoreTable> listControl = new AtomicReference<>();
	private EvaluationPCA evaluationPCA;
	private Composite control;

	public ExtendedScoreTable(Composite parent, int style) {

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
								if(object instanceof EvaluationPCA) {
									EvaluationPCA evaluation = (EvaluationPCA)object;
									setInput(evaluation);
								}
							}
						}
					}
				}

			}

		});
	}

	@Override
	public boolean setFocus() {

		updateOnFocus();
		return true;
	}

	public void setInput(EvaluationPCA evaluationPCA) {

		this.evaluationPCA = evaluationPCA;
		updateTable();
	}

	public void updateTable() {

		if(listControl.get() != null && !listControl.get().isDisposed()) {
			listControl.get().setInput(evaluationPCA);
		}
	}

	private void createControl() {

		setLayout(new GridLayout(1, true));
		createScoreTable(this);
		control = this;
		layout(true, true);
	}

	private void createScoreTable(Composite parent) {

		ScoreTable scoreTable = new ScoreTable(parent, SWT.NONE);
		scoreTable.setLayoutData(new GridData(GridData.FILL_BOTH));
		listControl.set(scoreTable);
	}

	@Override
	public void update() {

		updateTable();
	}

	private void updateOnFocus() {

		DataUpdateSupport dataUpdateSupport = Activator.getDefault().getDataUpdateSupport();
		List<Object> objects = dataUpdateSupport.getUpdates(getLastTopic(dataUpdateSupport.getTopics()));

		if(!objects.isEmpty()) {
			Object object = objects.get(0);
			if(object instanceof EvaluationPCA evaluation) {
				setInput(evaluation);
				updateTable();
			}
		}
	}

	private String getLastTopic(List<String> topics) {

		Collections.reverse(topics);
		for(String topic : topics) {
			if(topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_RESULT)) {
				return topic;
			}
			if(topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_SELECTION)) {
				return topic;
			}
		}

		return "";
	}
}
