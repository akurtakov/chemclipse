/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.integrator.supplier.trapezoid.settings;

import org.eclipse.chemclipse.chromatogram.xxd.integrator.core.settings.chromatogram.AbstractChromatogramIntegrationSettings;
import org.eclipse.chemclipse.support.settings.DoubleSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChromatogramIntegrationSettings extends AbstractChromatogramIntegrationSettings {

	@JsonProperty(value = "Scale Factor", defaultValue = "1.0")
	@JsonPropertyDescription(value = "To enable a comparison of the area with other systems, a scale factor can be used.")
	@DoubleSettingsProperty(minValue = Double.MIN_VALUE, maxValue = Double.MAX_VALUE)
	private double scaleFactor = 1.0d;

	public double getScaleFactor() {

		return scaleFactor;
	}

	public void setScaleFactor(double scaleFactor) {

		this.scaleFactor = scaleFactor;
	}
}