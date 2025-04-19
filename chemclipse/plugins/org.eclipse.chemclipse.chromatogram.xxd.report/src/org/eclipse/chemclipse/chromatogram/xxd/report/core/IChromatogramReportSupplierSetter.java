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
package org.eclipse.chemclipse.chromatogram.xxd.report.core;

public interface IChromatogramReportSupplierSetter extends IChromatogramReportSupplier {

	/**
	 * Sets the supplier id like
	 * "org.eclipse.chemclipse.chromatogram.xxd.report.supplier.peaks".
	 * 
	 * @param id
	 */
	void setId(final String id);

	/**
	 * Sets the description of the report supplier.
	 * 
	 * @param description
	 */
	void setDescription(final String description);

	/**
	 * Set the filter name to be shown in the FileDialog.
	 * 
	 * @param filterName
	 */
	void setFilterName(final String filterName);

	/**
	 * Sets the file extension, e.g. Peak Report (.pdf).
	 * 
	 * @param fileExtension
	 */
	void setFileExtension(final String fileExtension);

	/**
	 * Sets the default file name, e.g. PeakReport.pdf.
	 * 
	 * @param fileName
	 */
	void setFileName(final String fileName);
}
