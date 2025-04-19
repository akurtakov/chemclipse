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

/**
 * Defines the position of (0,0) and offers the conversion options.
 */
public enum PageBase {
	BOTTOM_LEFT(0.0f, 0.0f, false, false), // Default by PDFBox
	TOP_LEFT(0.0f, 1.0f, false, true); // Convenient for reports

	/*
	 * The factor of width and height.
	 */
	private float factorWidth;
	private float factorHeight;
	private boolean subtractWidth;
	private boolean subtractHeight;

	private PageBase(float factorWidth, float factorHeight, boolean subtractWidth, boolean subtractHeight) {
		this.factorWidth = factorWidth;
		this.factorHeight = factorHeight;
		this.subtractWidth = subtractWidth;
		this.subtractHeight = subtractHeight;
	}

	public float getFactorWidth() {

		return factorWidth;
	}

	public float getFactorHeight() {

		return factorHeight;
	}

	public boolean isSubtractWidth() {

		return subtractWidth;
	}

	public boolean isSubtractHeight() {

		return subtractHeight;
	}
}
