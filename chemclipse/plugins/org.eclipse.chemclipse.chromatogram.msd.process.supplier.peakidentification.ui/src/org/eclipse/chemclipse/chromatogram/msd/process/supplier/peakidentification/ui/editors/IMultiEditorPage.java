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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.ui.editors;

import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakIdentificationBatchJob;

/**
 * @author Dr. Philip Wenig
 * 
 */
public interface IMultiEditorPage {

	/**
	 * Returns the page index.
	 * 
	 * @return int
	 */
	int getPageIndex();

	/**
	 * Dispose.
	 */
	void dispose();

	/**
	 * Sets the batch job.
	 * 
	 * @param peakIdentificationBatchJob
	 */
	void setPeakIdentificationBatchJob(IPeakIdentificationBatchJob peakIdentificationBatchJob);

	/**
	 * Set the focus.
	 */
	void setFocus();
}