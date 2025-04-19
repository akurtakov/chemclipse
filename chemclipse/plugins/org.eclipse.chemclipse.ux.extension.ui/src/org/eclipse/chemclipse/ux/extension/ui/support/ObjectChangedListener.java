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
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.support;

public interface ObjectChangedListener<T> {

	enum ChangeType {
		CREATED, CHANGED, DELETED, SELECTED
	}

	/**
	 * notifies the listener about a change in the object state
	 * 
	 * @param type
	 *            the type of change
	 * @param newObject
	 *            the new object (might be <code>null</code> e.g in case of {@link ChangeType#DELETED})
	 * @param oldObject
	 *            the old object (might be <code>null</code> e.g in case of {@link ChangeType#CREATED})
	 */
	void objectChanged(ChangeType type, T newObject, T oldObject);
}
