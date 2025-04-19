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

public class ClassifierAddFilterSettings {

	@JsonProperty(value = "Classification", defaultValue = "")
	@JsonPropertyDescription(value = "This is the classification that shall be set.")
	private String classification = "";
	@JsonProperty(value = "Skip Classified Peaks", defaultValue = "true")
	@JsonPropertyDescription(value = "Skip peaks that have been classified already.")
	private boolean skipClassifiedPeak = true;

	public String getClassification() {

		return classification;
	}

	public void setClassification(String classification) {

		this.classification = classification;
	}

	public boolean isSkipClassifiedPeak() {

		return skipClassifiedPeak;
	}

	public void setSkipClassifiedPeak(boolean skipClassifiedPeak) {

		this.skipClassifiedPeak = skipClassifiedPeak;
	}
}