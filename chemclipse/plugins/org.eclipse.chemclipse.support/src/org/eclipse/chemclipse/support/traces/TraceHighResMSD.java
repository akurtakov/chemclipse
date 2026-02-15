/*******************************************************************************
 * Copyright (c) 2024, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.support.traces;

import java.util.Objects;

/**
 * Orbitrap
 * TOF
 * ...
 */
public class TraceHighResMSD extends TraceGenericDelta {

	public double getMZ() {

		return getValue();
	}

	public void setMZ(double mz) {

		setValue(mz);
	}

	public double getStartMZ() {

		return getStartValue();
	}

	public double getStopMZ() {

		return getStopValue();
	}

	public int getPPM() {

		int ppm = 0;
		if(getDelta() > 0 && getMZ() > 0) {
			ppm = (int)Math.round((getDelta() / getMZ()) * ITrace.MILLION);
		}

		return ppm;
	}

	public void setPPM(int ppm) {

		setDelta(getMZ() * ppm / ITrace.MILLION);
	}

	@Override
	public int hashCode() {

		return Objects.hash(getValue(), getDelta());
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		TraceHighResMSD other = (TraceHighResMSD)obj;
		return Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(other.getValue()) && //
				Double.doubleToLongBits(getDelta()) == Double.doubleToLongBits(other.getDelta());
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getMZ());
		int ppm = getPPM();
		if(ppm >= 1) {
			builder.append(ITrace.INFIX_RANGE_STANDARD);
			builder.append(ppm);
			builder.append(ITrace.POSTFIX_UNIT_PPM);
		}
		builder.append(getScaleFactorAsString());

		return builder.toString();
	}
}