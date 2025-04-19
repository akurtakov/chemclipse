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
package org.eclipse.chemclipse.model.quantitation;

import java.io.Serializable;

public interface IIdentificationWindow extends Serializable {

	/**
	 * Returns the negative deviation.
	 * 
	 * @return float
	 */
	float getAllowedNegativeDeviation();

	/**
	 * Sets the negative deviation.
	 * Allowed values >= 0
	 * 
	 * @param allowedNegativeDeviation
	 */
	void setAllowedNegativeDeviation(float allowedNegativeDeviation);

	/**
	 * Returns the positive deviation.
	 * 
	 * @return float
	 */
	float getAllowedPositiveDeviation();

	/**
	 * Sets the positive deviation.
	 * Allowed values >= 0
	 * 
	 * @param allowedPositiveDeviation
	 */
	void setAllowedPositiveDeviation(float allowedPositiveDeviation);
}
