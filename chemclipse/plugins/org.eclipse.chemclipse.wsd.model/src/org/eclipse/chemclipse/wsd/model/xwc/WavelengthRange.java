/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.model.xwc;

import java.util.Objects;

public class WavelengthRange implements IWavelengthRange {

	private double startWavelength;
	private double stopWavelength;

	public WavelengthRange(double startWavelength, double stopWavelength) {
		if(startWavelength > stopWavelength) {
			double tmp = startWavelength;
			startWavelength = stopWavelength;
			stopWavelength = tmp;
		}
		if(startWavelength < MIN_WAVELENGTH || startWavelength > MAX_WAVELENGTH) {
			startWavelength = MIN_WAVELENGTH;
		}
		if(stopWavelength > MAX_WAVELENGTH || stopWavelength < MIN_WAVELENGTH) {
			stopWavelength = MAX_WAVELENGTH;
		}
		this.startWavelength = startWavelength;
		this.stopWavelength = stopWavelength;
	}

	@Override
	public double getStartWavelength() {

		return startWavelength;
	}

	@Override
	public double getStopWavelength() {

		return stopWavelength;
	}

	@Override
	public boolean equals(Object other) {

		if(this == other) {
			return true;
		}
		if(other == null) {
			return false;
		}
		if(this.getClass() != other.getClass()) {
			return false;
		}
		WavelengthRange otherRange = (WavelengthRange)other;
		return getStartWavelength() == otherRange.getStartWavelength() && getStopWavelength() == otherRange.getStopWavelength();
	}

	@Override
	public int hashCode() {

		return Objects.hash(startWavelength, stopWavelength);
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append("[");
		builder.append("startWavelength=" + getStartWavelength());
		builder.append(",");
		builder.append("stopWavelength=" + getStopWavelength());
		builder.append("]");
		return builder.toString();
	}
}
