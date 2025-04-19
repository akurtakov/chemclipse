/*******************************************************************************
 * Copyright (c) 2022, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.peaks.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class DeleteQuantitationReferencesFilterSettings {

	@JsonProperty(value = "Delete Quantitation References", defaultValue = "")
	@JsonPropertyDescription(value = "If empty, all references are deleted. Otherwise the specified reference if available.")
	private String quantitationReference = "";

	public String getQuantitationReference() {

		return quantitationReference;
	}

	public void setQuantitationReference(String quantitationReference) {

		this.quantitationReference = quantitationReference;
	}
}