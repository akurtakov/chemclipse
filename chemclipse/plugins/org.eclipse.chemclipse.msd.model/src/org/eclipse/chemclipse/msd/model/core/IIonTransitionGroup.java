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
package org.eclipse.chemclipse.msd.model.core;

import java.io.Serializable;
import java.util.List;

public interface IIonTransitionGroup extends Serializable {

	void add(IIonTransition ionTransition);

	void remove(IIonTransition ionTransition);

	boolean contains(IIonTransition ionTransition);

	/**
	 * Returns the ion transition.
	 * The index is 0 based.
	 * May return null.
	 * 
	 * @param index
	 * @return {@link IIonTransition}
	 */
	IIonTransition get(int index);

	/**
	 * Returns the ion transition.
	 * May return null.
	 * 
	 * @param ionTransition
	 * @return {@link IIonTransition}
	 */
	IIonTransition get(IIonTransition ionTransition);

	List<IIonTransition> getIonTransitions();

	int size();
}
