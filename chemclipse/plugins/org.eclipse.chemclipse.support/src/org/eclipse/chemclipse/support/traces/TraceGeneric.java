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

public class TraceGeneric extends AbstractTrace {

	public int getTrace() {

		return getValueAsInt();
	}

	@Override
	public int hashCode() {

		return Objects.hash(getValue());
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		TraceGeneric other = (TraceGeneric)obj;
		return Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(other.getValue());
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getTrace());
		builder.append(getScaleFactorAsString());

		return builder.toString();
	}
}