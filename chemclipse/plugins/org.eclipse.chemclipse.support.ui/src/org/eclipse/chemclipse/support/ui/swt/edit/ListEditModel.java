/*******************************************************************************
 * Copyright (c) 2019, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.ui.swt.edit;

import java.util.Collection;

public interface ListEditModel<T> {

	/**
	 * fetches the current (not edited) list of items, these should not contain items that where edited or deleted
	 * 
	 * @return the list all current items
	 */
	Collection<? extends T> list();

	/**
	 * Edit the given item
	 * 
	 * @return <code>true</code> if item was edited <code>false</code> otherwise
	 */
	default boolean edit(T item) {

		return false;
	}

	/**
	 * notifies about the delete of the given item from the edit list
	 */
	default void delete(T item) {

	}

	/**
	 * attempts to create a new item
	 * 
	 * @return the new item or <code>null</code> if no item could be created
	 */
	default T create() {

		return null;
	}

	default boolean canEdit(T item) {

		return false;
	}

	default boolean canDelete(T item) {

		return false;
	}

	default boolean canCreate() {

		return false;
	}
}
