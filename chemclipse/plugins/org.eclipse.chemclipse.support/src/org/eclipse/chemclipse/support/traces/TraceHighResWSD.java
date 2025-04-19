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
package org.eclipse.chemclipse.support.traces;

/**
 * HPLC-DAD
 * ...
 */
public class TraceHighResWSD extends TraceGenericDelta {

	public double getWavelength() {

		return getValue();
	}

	public void setWavelength(double wavelength) {

		setValue(wavelength);
	}

	public double getStartWavelength() {

		return getStartValue();
	}

	public double getStopWavelength() {

		return getStopValue();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getWavelength());
		if(getDelta() > 0 && getWavelength() > 0) {
			builder.append(ITrace.INFIX_RANGE_STANDARD);
			builder.append(getDelta());
		}
		builder.append(getScaleFactorAsString());
		//
		return builder.toString();
	}
}