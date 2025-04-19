/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - comments
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.support;

import java.lang.ref.SoftReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.chemclipse.ux.extension.ui.support.ObjectChangedListener.ChangeType;

public abstract class AbstractNotifications<T> {

	private Set<ObjectChangedListener<? super T>> listeners = new CopyOnWriteArraySet<>();
	private SoftReference<T> selectedObject;

	public void addObjectChangedListener(ObjectChangedListener<? super T> listener) {

		listeners.add(listener);
		T object = getSelection();
		if(object != null) {
			listener.objectChanged(ChangeType.SELECTED, object, null);
		}
	}

	public void removeObjectChangedListener(ObjectChangedListener<? super T> listener) {

		listeners.remove(listener);
		T object = getSelection();
		if(object != null) {
			listener.objectChanged(ChangeType.SELECTED, null, object);
		}
	}

	public void created(T object) {

		for(ObjectChangedListener<? super T> listener : listeners) {
			listener.objectChanged(ChangeType.CREATED, object, null);
		}
	}

	public void updated(T newObject, T oldObject) {

		for(ObjectChangedListener<? super T> listener : listeners) {
			listener.objectChanged(ChangeType.CHANGED, newObject, oldObject);
		}
	}

	public void select(T selection) {

		T object = getSelection();
		//
		if(selection == null) {
			selectedObject = null;
		} else {
			selectedObject = new SoftReference<T>(selection);
		}
		//
		for(ObjectChangedListener<? super T> listener : listeners) {
			listener.objectChanged(ChangeType.SELECTED, selection, object);
		}
	}

	public T getSelection() {

		if(selectedObject == null) {
			return null;
		}
		return selectedObject.get();
	}
}
