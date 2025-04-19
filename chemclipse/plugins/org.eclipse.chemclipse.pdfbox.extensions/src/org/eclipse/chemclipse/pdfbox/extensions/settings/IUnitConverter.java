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
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.pdfbox.extensions.settings;

public interface IUnitConverter {

	/**
	 * Returns the conversion factor to pt.
	 * 
	 * @return float
	 */
	float getFactor();

	/**
	 * Converts the given value to pt.
	 * 
	 * @param value
	 * @return float
	 */
	float convertToPt(float value);

	/**
	 * Converts the given value (pt) to the unit of this converter.
	 * 
	 * @param value
	 * @return
	 */
	float convertFromPt(float value);
}
