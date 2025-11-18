/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.scan.model.BufferOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsBufferIdentifier extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Buffer Option", defaultValue = "BUFFER_TARGERTS")
	@JsonPropertyDescription(value = "Select the buffer operation.")
	private BufferOption bufferOption = BufferOption.BUFFER_TARGERTS;

	public BufferOption getBufferOption() {

		return bufferOption;
	}

	public void setBufferOption(BufferOption bufferOption) {

		this.bufferOption = bufferOption;
	}
}