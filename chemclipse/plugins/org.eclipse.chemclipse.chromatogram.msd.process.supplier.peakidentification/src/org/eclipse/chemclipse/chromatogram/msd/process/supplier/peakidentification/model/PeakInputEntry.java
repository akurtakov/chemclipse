/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model;

import java.io.File;

public class PeakInputEntry implements IPeakInputEntry {

	private String inputFile = "";

	/**
	 * Set the peak input file.
	 * 
	 * @param inputFile
	 */
	public PeakInputEntry(String inputFile) {
		if(inputFile != null) {
			this.inputFile = inputFile;
		}
	}

	@Override
	public String getInputFile() {

		return inputFile;
	}

	@Override
	public String getName() {

		File file = new File(inputFile);
		return file.getName();
	}
}
