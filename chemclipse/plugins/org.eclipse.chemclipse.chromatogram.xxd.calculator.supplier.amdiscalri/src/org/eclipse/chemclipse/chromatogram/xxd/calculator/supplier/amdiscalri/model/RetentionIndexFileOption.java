/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl.CalibrationFile;
import org.eclipse.chemclipse.support.text.ILabel;

public enum RetentionIndexFileOption implements ILabel {

	CAL(CalibrationFile.FILTER_NAME, CalibrationFile.FILE_EXTENSION);

	private String label = "";
	private String extension = "";

	private RetentionIndexFileOption(String label, String extension) {

		this.label = label;
		this.extension = extension;
	}

	@Override
	public String label() {

		return label;
	}

	public String extension() {

		return extension;
	}

	public static String[][] getOptions() {

		return ILabel.getOptions(values());
	}
}