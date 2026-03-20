/*******************************************************************************
 * Copyright (c) 2020, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.savitzkygolay.settings;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty.Validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ChromatogramFilterSettingsWSD extends ChromatogramFilterSettings {

	private static final Logger logger = Logger.getLogger(ChromatogramFilterSettingsWSD.class);

	@JsonProperty(value = "Order", defaultValue = "2")
	@JsonPropertyDescription(value = "Order p of the polynomial to be fitted: Integer in the range from 2 to 5")
	@IntSettingsProperty(minValue = 2, maxValue = 5)
	private int order = 2;

	@JsonProperty(value = "Width", defaultValue = "5")
	@JsonPropertyDescription(value = "Filter width, odd integer in the range from 5 to 51")
	@IntSettingsProperty(minValue = 5, maxValue = 51, validation = Validation.ODD_NUMBER)
	private int width = 5;

	@Override
	public int getDerivative() {

		return 0;
	}

	@Override
	public void setDerivative(int derivative) {

		if(derivative != 0) {
			logger.warn("Derivative is not supported");
		}
	}

	@Override
	public int getOrder() {

		return order;
	}

	@Override
	public void setOrder(int order) {

		this.order = order;
	}

	@Override
	public int getWidth() {

		return width;
	}

	@Override
	public void setWidth(int width) {

		this.width = width;
	}
}
