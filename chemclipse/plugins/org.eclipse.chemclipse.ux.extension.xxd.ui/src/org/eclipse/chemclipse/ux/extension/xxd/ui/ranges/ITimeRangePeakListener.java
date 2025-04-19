/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.ranges;

public interface ITimeRangePeakListener {

	/**
	 * The start/stop coordinates are fired as soon as the user has
	 * activated the peak detection via CTRL + mouse button selection.
	 * 
	 * @param xStart
	 * @param yStart
	 * @param xStop
	 * @param yStop
	 */
	void update(int xStart, int yStart, int xStop, int yStop);
}