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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class RetentionIndexRecalculatorSettings {

	@JsonProperty(value = "Reference Chromatograms", defaultValue = "true")
	@JsonPropertyDescription("Process all referenced chromatograms.")
	private boolean processReferenceChromatograms = true;

	public boolean isProcessReferenceChromatograms() {

		return processReferenceChromatograms;
	}

	public void setProcessReferenceChromatograms(boolean processReferenceChromatograms) {

		this.processReferenceChromatograms = processReferenceChromatograms;
	}
}