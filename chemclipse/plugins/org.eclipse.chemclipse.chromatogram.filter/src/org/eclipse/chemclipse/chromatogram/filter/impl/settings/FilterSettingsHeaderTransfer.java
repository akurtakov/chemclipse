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
package org.eclipse.chemclipse.chromatogram.filter.impl.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.model.core.support.HeaderField;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsHeaderTransfer extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Header Field (Source)", defaultValue = "DATA_NAME")
	@JsonPropertyDescription(value = "The content of the given header field shall be transfered.")
	private HeaderField headerFieldSource = HeaderField.DATA_NAME;
	@JsonProperty(value = "Header Field (Sink)", defaultValue = "DATA_NAME")
	@JsonPropertyDescription(value = "The content of the source shall be transfered here.")
	private HeaderField headerFieldSink = HeaderField.DATA_NAME;

	public HeaderField getHeaderFieldSource() {

		return headerFieldSource;
	}

	public void setHeaderFieldSource(HeaderField headerFieldSource) {

		this.headerFieldSource = headerFieldSource;
	}

	public HeaderField getHeaderFieldSink() {

		return headerFieldSink;
	}

	public void setHeaderFieldSink(HeaderField headerFieldSink) {

		this.headerFieldSink = headerFieldSink;
	}
}