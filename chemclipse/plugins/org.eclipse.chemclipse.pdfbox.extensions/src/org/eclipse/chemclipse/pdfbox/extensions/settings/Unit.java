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

public enum Unit {
	PT(1.0f), //
	MM(2.83465f), //
	CM(28.3465f), //
	INCH(72.0f);

	private float factor;

	private Unit(float factor) {
		this.factor = factor;
	}

	public float getFactor() {

		return factor;
	}
}
