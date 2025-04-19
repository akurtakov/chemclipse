/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.impl;

import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.settings.AbstractBaselineDetectorSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class DeleteSettings extends AbstractBaselineDetectorSettings {

	@JsonProperty(value = "Delete Completely", defaultValue = "false")
	@JsonPropertyDescription(value = "If false, the baseline of the selected range will be deleted.")
	private boolean deleteCompletely;

	public boolean isDeleteCompletely() {

		return deleteCompletely;
	}

	public void setDeleteCompletely(boolean deleteCompletely) {

		this.deleteCompletely = deleteCompletely;
	}
}
