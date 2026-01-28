/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.xpass.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChromatogramFilterNominalizeSettings extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Process Referenced Chromatograms", defaultValue = "true")
	@JsonPropertyDescription("Referenced chromatgrams will be also processed.")
	private boolean processReferencedChromatograms = true;

	public boolean isProcessReferencedChromatograms() {

		return processReferencedChromatograms;
	}

	public void setProcessReferencedChromatograms(boolean processReferencedChromatograms) {

		this.processReferencedChromatograms = processReferencedChromatograms;
	}
}