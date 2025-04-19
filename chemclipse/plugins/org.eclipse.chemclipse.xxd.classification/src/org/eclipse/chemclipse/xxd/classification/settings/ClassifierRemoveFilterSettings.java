/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.classification.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ClassifierRemoveFilterSettings {

	@JsonProperty(value = "Classification", defaultValue = "")
	@JsonPropertyDescription(value = "If empty, all classifications are removed.")
	private String classification = "";
	@JsonProperty(value = "Case Sensitive", defaultValue = "false")
	@JsonPropertyDescription(value = "Search case sensitive or ignore the case.")
	private boolean caseSensitive = false;

	public String getClassification() {

		return classification;
	}

	public void setClassification(String classification) {

		this.classification = classification;
	}

	public boolean isCaseSensitive() {

		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {

		this.caseSensitive = caseSensitive;
	}
}