/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.ui.explorer;

public interface ISelectionView {

	/**
	 * Returns whether the part is visible or not.
	 * 
	 * @return boolean
	 */
	boolean isPartVisible();

	/**
	 * Unsubscribes the chromatogram selection updates.
	 */
	void unsubscribe();

	/**
	 * Checks if the part is visible and the document is not null.
	 * 
	 * @param chromatogramSelection
	 */
	boolean doUpdate(Object document);
}
