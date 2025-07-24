/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.filter.chromatogram.settings;

import org.eclipse.chemclipse.support.settings.DoubleSettingsProperty;
import org.eclipse.chemclipse.xxd.filter.model.CoordinateOption;
import org.eclipse.chemclipse.xxd.filter.model.RangeOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class DeleteScansByRangeFilterSettings {

	@JsonProperty(value = "Coordinate Option", defaultValue = "NONE")
	@JsonPropertyDescription(value = "Use the given coordinate selection.")
	private CoordinateOption coordinateOption = CoordinateOption.NONE;
	@JsonProperty(value = "Range Option", defaultValue = "NONE")
	@JsonPropertyDescription(value = "Scans matching the given range will be deleted.")
	private RangeOption rangeOption = RangeOption.NONE;
	@JsonProperty(value = "Coordinate", defaultValue = "0")
	@JsonPropertyDescription(value = "Use the given coordinate.")
	@DoubleSettingsProperty(minValue = 0)
	private double coordinateValue = 0.0d;

	public CoordinateOption getCoordinateOption() {

		return coordinateOption;
	}

	public void setCoordinateOption(CoordinateOption coordinateOption) {

		this.coordinateOption = coordinateOption;
	}

	public RangeOption getRangeOption() {

		return rangeOption;
	}

	public void setRangeOption(RangeOption rangeOption) {

		this.rangeOption = rangeOption;
	}

	public double getCoordinateValue() {

		return coordinateValue;
	}

	public void setCoordinateValue(double coordinateValue) {

		this.coordinateValue = coordinateValue;
	}
}