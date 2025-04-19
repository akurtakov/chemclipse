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

public interface IPeakOutputEntry {

	/**
	 * Returns the output folder.
	 * 
	 * @return String
	 */
	String getOutputFolder();

	/**
	 * Returns the converter id.
	 * 
	 * @return String
	 */
	String getConverterId();
}
