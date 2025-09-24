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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.parts;

import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.ux.extension.ui.parts.AbstractPart;
import org.eclipse.chemclipse.ux.extension.xxd.ui.Activator;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractPartPCA<T extends Composite> extends AbstractPart<T> {

	private static final String TOPIC = IChemClipseEvents.TOPIC_PCA_UPDATE_SELECTION;

	protected AbstractPartPCA(Composite parent) {

		super(parent, TOPIC, Activator.getDefault().getDataUpdateSupport());
	}

	/**
	 * Overwrite, if additional topics shall be added.
	 */
	@Override
	protected void subscribeAdditionalTopics() {

		subscribeAdditionalTopic(TOPIC, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_COLORSCHEME, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_FEATURES, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_LABELS, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_RESULT, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_GROUPS, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_EDITOR_PCA_CLOSE, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_SAMPLE, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_LIST_VARIABLE, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_STATLIST_VARIABLE, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_PLOT_VARIABLE, IChemClipseEvents.EVENT_BROKER_DATA);
		subscribeAdditionalTopic(IChemClipseEvents.TOPIC_PCA_UPDATE_HIGHLIGHT_FOLDCHANGE_VARIABLE, IChemClipseEvents.EVENT_BROKER_DATA);
	}

	@Override
	protected boolean isUpdateTopic(String topic) {

		return isUpdateSelection(topic) || isUpdateColorSchemeEvent(topic) || isUpdateFeaturesEvent(topic) || isUpdateLabelsEvent(topic) || isUpdateResultEvent(topic) || isUpdateGroupsEvent(topic) || isUnloadEvent(topic);
	}

	protected boolean isUpdateSelection(String topic) {

		return TOPIC.equals(topic);
	}

	protected boolean isUpdateColorSchemeEvent(String topic) {

		return topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_COLORSCHEME);
	}

	protected boolean isUpdateFeaturesEvent(String topic) {

		return topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_FEATURES);
	}

	protected boolean isUpdateLabelsEvent(String topic) {

		return topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_LABELS);
	}

	protected boolean isUpdateResultEvent(String topic) {

		return topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_RESULT);
	}

	protected boolean isUpdateGroupsEvent(String topic) {

		return topic.equals(IChemClipseEvents.TOPIC_PCA_UPDATE_GROUPS);
	}

	protected boolean isUnloadEvent(String topic) {

		return topic.equals(IChemClipseEvents.TOPIC_EDITOR_PCA_CLOSE);
	}
}
