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
 * Alexander Kerner - initial API and implementation
 * Philip Wenig - add elements for combo support
 * Matthias Mailänder - add labels
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.peak.detector.core;

import org.eclipse.chemclipse.support.text.ILabel;

public enum FilterMode implements ILabel {
	INCLUDE("Inclusive"), //
	EXCLUDE("Exclusive");

	private String label;

	private FilterMode(String label) {

		this.label = label;
	}

	@Override
	public String label() {

		return label;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}