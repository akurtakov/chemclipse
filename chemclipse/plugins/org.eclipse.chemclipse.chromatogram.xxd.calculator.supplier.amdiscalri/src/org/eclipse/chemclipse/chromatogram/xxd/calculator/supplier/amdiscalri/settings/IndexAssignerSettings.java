/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.model.RetentionIndexAssigner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class IndexAssignerSettings {

	@JsonProperty(value = "Retention Index Assigner", defaultValue = "")
	@JsonPropertyDescription("The list of retention index mappings.")
	private RetentionIndexAssigner retentionIndexAssigner = new RetentionIndexAssigner();

	public RetentionIndexAssigner getRetentionIndexAssigner() {

		return retentionIndexAssigner;
	}

	public void setRetentionIndexAssigner(RetentionIndexAssigner retentionIndexAssigner) {

		this.retentionIndexAssigner = retentionIndexAssigner;
	}
}