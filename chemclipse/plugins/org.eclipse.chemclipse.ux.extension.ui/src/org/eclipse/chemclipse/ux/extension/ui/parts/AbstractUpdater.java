/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - allow for data unloading
 * Lorenz Gerber - reset initalUpdate on unloading
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.chemclipse.model.notifier.UpdateNotifier;
import org.eclipse.chemclipse.support.events.IChemClipseEvents;
import org.eclipse.chemclipse.ux.extension.ui.model.IDataUpdateListener;
import org.eclipse.chemclipse.ux.extension.ui.support.DataUpdateSupport;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PreDestroy;

public abstract class AbstractUpdater<T extends Composite> {

	private T control = null;
	private boolean initialUpdate = true;
	private String topic = "";

	private DataUpdateSupport dataUpdateSupport;
	private IDataUpdateListener updateListener = (topic, objects) -> updateSelection(objects, topic);

	/**
	 * Create the part with the given main topic.
	 */
	protected AbstractUpdater(String topic, DataUpdateSupport dataUpdateSupport) {

		this(topic, null, dataUpdateSupport);
	}

	/**
	 * Create the part with the given main topic and the main control.
	 */
	protected AbstractUpdater(String topic, T control, DataUpdateSupport dataUpdateSupport) {

		this.topic = topic;
		this.dataUpdateSupport = dataUpdateSupport;
		dataUpdateSupport.add(updateListener);
		setControl(control);
		subscribeAdditionalTopics();
	}

	public List<Object> getUpdates(String topic) {

		return dataUpdateSupport != null ? dataUpdateSupport.getUpdates(topic) : Collections.emptyList();
	}

	@Focus
	public void setFocus() {

		if(initialUpdate) {
			if(updateSelection(dataUpdateSupport.getUpdates(topic), topic)) {
				initialUpdate = false;
			}
		}
	}

	@PreDestroy
	protected void preDestroy() {

		dataUpdateSupport.remove(updateListener);
		UpdateNotifier.update(IChemClipseEvents.TOPIC_PART_CLOSED, getClass().getSimpleName());
	}

	protected void setControl(T control) {

		this.control = control;
	}

	/**
	 * Return the control of this part.
	 * This could be null if it has been not set yet.
	 */
	protected T getControl() {

		return control;
	}

	/**
	 * Overwrite, if additional topics shall be added.
	 */
	protected void subscribeAdditionalTopics() {

	}

	protected void subscribeAdditionalTopic(String topic, String property) {

		dataUpdateSupport.subscribe(topic, property);
	}

	protected void subscribeAdditionalTopic(String topic, String[] properties) {

		dataUpdateSupport.subscribe(topic, properties);
	}

	/**
	 * Implement to update the object of the given topic.
	 * If consuming the topic was successful, return true.
	 */
	protected abstract boolean updateData(List<Object> objects, String topic);

	/**
	 * Tidy up persisted data.
	 */
	protected void unloadData() {

		dataUpdateSupport.clearObjects();
		initialUpdate = true;
	}

	/**
	 * Returns whether this topic shall be consumed or not.
	 */
	protected boolean isUpdateTopic(String topic) {

		return this.topic.equals(topic);
	}

	private boolean updateSelection(List<Object> objects, String topic) {

		/*
		 * Enforce an update in case of an editor close event.
		 */
		if(DataUpdateSupport.isVisible(control) || topic.matches(IChemClipseEvents.EDITOR_CLOSE_REGEX)) {
			if(isUpdateTopic(topic)) {
				return updateData(objects, topic);
			}
		}

		return false;
	}
}
