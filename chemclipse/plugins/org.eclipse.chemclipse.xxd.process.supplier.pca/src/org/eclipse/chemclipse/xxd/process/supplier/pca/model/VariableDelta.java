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
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.Objects;

import org.eclipse.chemclipse.model.statistics.IVariable;

public class VariableDelta {

	private IVariable variable = null;
	private double deltaX = 0;
	private double deltaY = 0;
	private double distance = 0;

	public VariableDelta(IVariable variable, double deltaX, double deltaY) {

		this.variable = variable;
		this.deltaX = Math.abs(deltaX);
		this.deltaY = Math.abs(deltaY);
		this.distance = Math.sqrt(Math.pow(this.deltaX, 2) + Math.pow(this.deltaY, 2));
	}

	public IVariable getVariable() {

		return variable;
	}

	public double getDeltaX() {

		return deltaX;
	}

	public double getDeltaY() {

		return deltaY;
	}

	public double getDistance() {

		return distance;
	}

	@Override
	public int hashCode() {

		return Objects.hash(variable);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		VariableDelta other = (VariableDelta)obj;
		return Objects.equals(variable, other.variable);
	}

	@Override
	public String toString() {

		return "FeatureDelta [IVariable=" + variable + ", deltaX=" + deltaX + ", deltaY=" + deltaY + ", distance=" + distance + "]";
	}

}
