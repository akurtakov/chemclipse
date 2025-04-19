/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
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

public interface IPageBaseConverter {

	/**
	 * Position x (pt) - default (0,0) left bottom
	 * pageWidth (pt)
	 * x (pt)
	 * 
	 * @param pageWidth
	 * @param x
	 * @return float
	 */
	float getPositionX(float pageWidth, float x);

	/**
	 * 
	 * Position y (pt) - default 0,0 left bottom
	 * pageHeight (pt)
	 * y (pt)
	 *
	 * @param pageHeight
	 * @param y
	 * @return float
	 */
	float getPositionY(float pageHeight, float y);
}
