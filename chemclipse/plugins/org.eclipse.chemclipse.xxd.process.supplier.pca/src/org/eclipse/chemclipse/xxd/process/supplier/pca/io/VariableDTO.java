/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.process.supplier.pca.io;

/**
 * Flat DTO for all IVariable implementations. The {@code type} field is the
 * class simple name used as a discriminator (e.g. "RetentionTime",
 * "RetentionIndex", "MassToChargeRatio", "PeakNumber", "Target").
 */
public class VariableDTO {

	private String type;
	private String description;
	private boolean selected;
	private String classification;
	// type-specific fields
	private int retentionTime;
	private int retentionIndex;
	private double mz;
	private int peakNumber;
	private String target;

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public boolean isSelected() {

		return selected;
	}

	public void setSelected(boolean selected) {

		this.selected = selected;
	}

	public String getClassification() {

		return classification;
	}

	public void setClassification(String classification) {

		this.classification = classification;
	}

	public int getRetentionTime() {

		return retentionTime;
	}

	public void setRetentionTime(int retentionTime) {

		this.retentionTime = retentionTime;
	}

	public int getRetentionIndex() {

		return retentionIndex;
	}

	public void setRetentionIndex(int retentionIndex) {

		this.retentionIndex = retentionIndex;
	}

	public double getMz() {

		return mz;
	}

	public void setMz(double mz) {

		this.mz = mz;
	}

	public int getPeakNumber() {

		return peakNumber;
	}

	public void setPeakNumber(int peakNumber) {

		this.peakNumber = peakNumber;
	}

	public String getTarget() {

		return target;
	}

	public void setTarget(String target) {

		this.target = target;
	}
}
