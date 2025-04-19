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

public interface IPeakProcessEntry {

	/**
	 * Return the processor id.
	 * 
	 * @return String
	 */
	String getProcessorId();

	/**
	 * Set the processor id.
	 * 
	 * @param processorId
	 */
	void setProcessorId(String processorId);

	/**
	 * Report results.
	 * 
	 * @return boolean
	 */
	boolean isReport();

	/**
	 * Set the report status.
	 * 
	 * @param report
	 * @return boolean
	 */
	void setReport(boolean report);
}
