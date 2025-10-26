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

public class TraceGenericDelta extends AbstractTrace {

	private double delta = 0.0d;

	public boolean isUseRange() {

		return delta > 0;
	}

	public double getDelta() {

		return delta;
	}

	/**
	 * Delta must be >= 0.
	 * 
	 * @param delta
	 * @return {@link TraceGenericDelta}
	 */
	public TraceGenericDelta setDelta(double delta) {

		if(delta >= 0) {
			this.delta = delta;
		}
		return this;
	}

	public double getStartValue() {

		return getValue() - delta;
	}

	public double getStopValue() {

		return getValue() + delta;
	}

	public boolean matches(double value) {

		return value >= getStartValue() && value <= getStopValue();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getValue());
		if(getDelta() > 0 && getValue() > 0) {
			builder.append(ITrace.INFIX_RANGE_STANDARD);
			builder.append(getDelta());
		}
		builder.append(getScaleFactorAsString());

		return builder.toString();
	}
}