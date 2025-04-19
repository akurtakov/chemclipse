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
package org.eclipse.chemclipse.swt.ui.support;

import org.eclipse.swt.graphics.Color;

public interface IColorScheme {

	/**
	 * Returns the size.
	 * 
	 * @return int
	 */
	int size();

	/**
	 * Returns the next color.
	 * 
	 * @return Color
	 */
	Color getNextColor();

	/**
	 * Returns the previous color.
	 * 
	 * @return Color
	 */
	Color getPreviousColor();

	/**
	 * Return the color, given by number.
	 * 
	 * @param i
	 * @return Color
	 */
	Color getColor(int i);

	/**
	 * Resets the color scheme to the initial color.
	 */
	void reset();

	/**
	 * Return the current color.
	 * 
	 * @param i
	 * @return Color
	 */
	Color getColor();

	/**
	 * Selects the next color.
	 * It can be fetched on demand by getColor();
	 */
	void incrementColor();

	/**
	 * Runs the increment color operation x times.
	 * The next color can be fetched on demand by getColor();
	 */
	void incrementColor(int steps);
}