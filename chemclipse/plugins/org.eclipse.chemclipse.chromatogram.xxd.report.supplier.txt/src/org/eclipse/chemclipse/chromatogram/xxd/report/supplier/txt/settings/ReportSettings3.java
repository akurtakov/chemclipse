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
 * Christoph Läubrich - extend configuration
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.settings;

import org.eclipse.chemclipse.chromatogram.xxd.report.settings.DefaultChromatogramReportSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ReportSettings3 extends DefaultChromatogramReportSettings {

	@JsonProperty(value = "Print Header", defaultValue = "true")
	@JsonPropertyDescription(value = "Include the header in the report.")
	private boolean printHeader = true;

	public boolean isPrintHeader() {

		return printHeader;
	}

	public void setPrintHeader(boolean printHeader) {

		this.printHeader = printHeader;
	}
}