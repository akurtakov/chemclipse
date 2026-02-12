/*******************************************************************************
 * Copyright (c) 2008, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.updates;

/**
 * Classes can add themselves to each chromatogram instance as listeners.<br/>
 * They must implement the interface {@link IChromatogramUpdateListener}.<br/>
 * The controller of the graphical representation of the chromatogram, for
 * instance, can add himself to the chromatogram model as a listener.<br/>
 * Each time some values has been changed, e.g. abundance of mass spectrum x,
 * the controller will be informed, that the model has been edited.
 * 
 * @see IChromatogramUpdateListener
 */
public interface IUpdater {

	/**
	 * Adds a IChromatogramUpdateListener to the chromatogram.<br/>
	 * This could be for example an GUI controller.
	 * 
	 * @param listener
	 */
	void addChromatogramUpdateListener(IChromatogramUpdateListener listener);

	/**
	 * Removes a IChromatogramUpdateListener from the chromatogram.<br/>
	 * This could be for example an GUI controller.
	 * 
	 * @param listener
	 */
	void removeChromatogramUpdateListener(IChromatogramUpdateListener listener);
}
