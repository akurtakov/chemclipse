/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Matthias Mailänder - add label
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.peak.detector.model;

import org.eclipse.chemclipse.support.text.ILabel;

public enum Threshold implements ILabel {
	OFF(1, "Off"), //
	LOW(2, "Low"), //
	MEDIUM(3, "Medium"), //
	HIGH(4, "High");

	private int threshold;
	private String label;

	private Threshold(int threshold, String label) {

		this.threshold = threshold;
		this.label = label;
	}

	public int getThreshold() {

		return threshold;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}