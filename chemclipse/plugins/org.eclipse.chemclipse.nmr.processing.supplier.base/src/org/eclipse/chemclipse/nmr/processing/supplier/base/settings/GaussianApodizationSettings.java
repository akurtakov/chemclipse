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
 * Alexander Stark - initial API and implementation
 * Philip Wenig - get rid of system settings
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.processing.supplier.base.settings;

import org.eclipse.chemclipse.support.settings.DoubleSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GaussianApodizationSettings {

	@JsonProperty(value = "Gaussian Line Broadening Factor", defaultValue = "0.0")
	@DoubleSettingsProperty()
	private double gaussianLineBroadeningFactor = 0;

	public void setGaussianLineBroadeningFactor(double gaussianLineBroadeningFactor) {

		this.gaussianLineBroadeningFactor = gaussianLineBroadeningFactor;
	}

	public double getGaussianLineBroadeningFactor() {

		return gaussianLineBroadeningFactor;
	}

	@Override
	public String toString() {

		return "GaussianApodizationSettings [gaussianLineBroadeningFactor=" + gaussianLineBroadeningFactor + "]";
	}
}