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

import org.eclipse.chemclipse.support.text.ValueFormat;

/**
 * GC-MS/MS
 * LC-MS/MS
 * ...
 */
public class TraceTandemMSD extends AbstractTrace {

	private Double daughterMZ = 0.0d;
	private Double collisionEnergy = 0.0d;

	public int getParentMZ() {

		return getValueAsInt();
	}

	public void setParentMZ(double mz) {

		setValue(mz);
	}

	public double getDaughterMZ() {

		return daughterMZ;
	}

	public void setDaughterMZ(double daughterMZ) {

		this.daughterMZ = daughterMZ;
	}

	public int getCollisionEnergy() {

		return collisionEnergy.intValue();
	}

	public void setCollisionEnergy(double collisionEnergy) {

		this.collisionEnergy = collisionEnergy;
	}

	@Override
	public int hashCode() {

		return Objects.hash(getValue(), daughterMZ, collisionEnergy);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		TraceTandemMSD other = (TraceTandemMSD)obj;
		return Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(other.getValue()) && //
				Double.doubleToLongBits(daughterMZ) == Double.doubleToLongBits(other.daughterMZ) && //
				Double.doubleToLongBits(collisionEnergy) == Double.doubleToLongBits(other.collisionEnergy);
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getParentMZ());
		builder.append(" > ");
		builder.append(ValueFormat.getDecimalFormatEnglish("0.0").format(getDaughterMZ()));
		builder.append(" @");
		builder.append(getCollisionEnergy());
		builder.append(getScaleFactorAsString());

		return builder.toString();
	}
}