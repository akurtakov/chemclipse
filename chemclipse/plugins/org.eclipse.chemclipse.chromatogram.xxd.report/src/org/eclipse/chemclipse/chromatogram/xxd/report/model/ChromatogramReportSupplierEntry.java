/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.report.model;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class ChromatogramReportSupplierEntry implements IChromatogramReportSupplierEntry {

	private String reportFolderOrFile = "";
	private String reportSupplierId = "";

	/**
	 * Set the output file path and the converter id.
	 */
	public ChromatogramReportSupplierEntry(String reportFolderOrFile, String converterId) {
		if(reportFolderOrFile != null && converterId != null) {
			this.reportFolderOrFile = reportFolderOrFile;
			this.reportSupplierId = converterId;
		}
	}

	@Override
	public String getReportFolderOrFile() {

		return reportFolderOrFile;
	}

	@Override
	public String getReportSupplierId() {

		return reportSupplierId;
	}
}
