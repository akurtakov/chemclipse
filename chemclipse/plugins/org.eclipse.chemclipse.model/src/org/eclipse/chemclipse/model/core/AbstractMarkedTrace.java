/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.core;

import java.util.Objects;

public abstract class AbstractMarkedTrace implements IMarkedTrace {

	private double trace = ISignal.TOTAL_INTENSITY;
	private int magnification = 1;

	public AbstractMarkedTrace(double trace) {

		this(trace, 1);
	}

	public AbstractMarkedTrace(double trace, int magnification) {

		this.trace = trace;
		this.magnification = magnification;
	}

	@Override
	public double getTrace() {

		return trace;
	}

	@Override
	public void setTrace(double trace) {

		this.trace = trace;
	}

	@Override
	public int getMagnification() {

		return magnification;
	}

	@Override
	public void setMagnification(int magnification) {

		this.magnification = magnification;
	}

	@Override
	public int hashCode() {

		return Objects.hash(magnification, trace);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		AbstractMarkedTrace other = (AbstractMarkedTrace)obj;
		return magnification == other.magnification && Double.doubleToLongBits(trace) == Double.doubleToLongBits(other.trace);
	}

	@Override
	public String toString() {

		return "AbstractMarkedTrace [trace=" + trace + ", magnification=" + magnification + "]";
	}
}