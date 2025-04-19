/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 * Philip Wenig - editor toolbar
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.ui.swt;

/**
 * Interface an UI can implement to state that it has a toolbar that can be switched on/off
 */
public interface IToolbarConfig {

	/**
	 * Set the toolbar visible according to the visible parameter
	 * 
	 * @param visible
	 */
	void setToolbarVisible(boolean visible);

	boolean isToolbarVisible();

	/**
	 * set the toolbar info visible according to the visible parameter if there is a toolbar info
	 * 
	 * @param visible
	 */
	default void setToolbarInfoVisible(boolean visible) {

	}

	/**
	 * 
	 * @return <code>true</code> if this ui has a toolbar info
	 */
	default boolean hasToolbarInfo() {

		return false;
	}
}