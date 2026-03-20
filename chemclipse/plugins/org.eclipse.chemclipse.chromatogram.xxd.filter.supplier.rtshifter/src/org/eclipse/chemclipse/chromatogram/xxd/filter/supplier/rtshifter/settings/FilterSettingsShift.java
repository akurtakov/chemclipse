/*******************************************************************************
 * Copyright (c) 2011, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.filter.supplier.rtshifter.settings;

import org.eclipse.chemclipse.chromatogram.filter.settings.AbstractChromatogramFilterSettings;
import org.eclipse.chemclipse.support.settings.IntSettingsProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class FilterSettingsShift extends AbstractChromatogramFilterSettings {

	@JsonProperty(value = "Shift Retention Time [ms]", defaultValue = "0")
	@JsonPropertyDescription(value = "Set retention time shift.")
	@IntSettingsProperty(minValue = Integer.MIN_VALUE, maxValue = Integer.MAX_VALUE)
	private int millisecondsShift = 0;

	@JsonProperty(value = "Shift All Scans", defaultValue = "true")
	@JsonPropertyDescription(value = "Set shift all scans.")
	private boolean shiftAllScans = true;

	public FilterSettingsShift() {

		// Default constructor is needed, see filter extension point: filterSettings=
	}

	public FilterSettingsShift(int millisecondsToShift, boolean shiftAllScans) {

		this.millisecondsShift = millisecondsToShift;
		this.shiftAllScans = shiftAllScans;
	}

	public int getMillisecondsShift() {

		return millisecondsShift;
	}

	public void setMillisecondsShift(int millisecondsShift) {

		this.millisecondsShift = millisecondsShift;
	}

	public boolean isShiftAllScans() {

		return shiftAllScans;
	}

	public void setShiftAllScans(boolean shiftAllScans) {

		this.shiftAllScans = shiftAllScans;
	}
}
