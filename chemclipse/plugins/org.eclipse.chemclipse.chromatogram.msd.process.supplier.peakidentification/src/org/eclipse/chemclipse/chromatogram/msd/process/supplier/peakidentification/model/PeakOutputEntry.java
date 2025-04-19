/*******************************************************************************
 * Copyright (c) 2012, 2025 Lablicate GmbH.
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

public class PeakOutputEntry implements IPeakOutputEntry {

	private String outputFolder = "";
	private String converterId = "";

	/**
	 * Set the output file path and the converter id.
	 * 
	 * @param outputFile
	 * @param converterId
	 */
	public PeakOutputEntry(String outputFolder, String converterId) {
		if(outputFolder != null && converterId != null) {
			this.outputFolder = outputFolder;
			this.converterId = converterId;
		}
	}

	@Override
	public String getOutputFolder() {

		return outputFolder;
	}

	@Override
	public String getConverterId() {

		return converterId;
	}
}
