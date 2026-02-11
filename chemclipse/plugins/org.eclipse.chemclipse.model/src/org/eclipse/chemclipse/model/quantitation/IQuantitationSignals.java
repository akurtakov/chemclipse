/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

import java.io.Serializable;
import java.util.List;
import java.util.NavigableSet;

public interface IQuantitationSignals extends NavigableSet<IQuantitationSignal>, Serializable {

	/**
	 * Returns the list of selected signals.
	 */
	List<Double> getSelectedSignals();

	/**
	 * Set isUse = false to all stored signals.
	 */
	void deselectAllSignals();

	/**
	 * Set isUse = true to all stored signals.
	 */
	void selectAllSignals();

	/**
	 * Set isUse = true to the given signal.
	 */
	void selectSignal(double signal);
}
