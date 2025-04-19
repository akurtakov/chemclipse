/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.core.chromatogram;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.settings.IChromatogramCalculatorSettings;

public class ChromatogramCalculatorSupplier implements IChromatogramCalculatorSupplier {

	private String id = "";
	private String description = "";
	private String calculatorName = "";
	private Class<? extends IChromatogramCalculatorSettings> settingsClass;

	@Override
	public String getDescription() {

		return description;
	}

	/**
	 * Sets the description of the chromatogram calculator supplier.
	 * 
	 * @param description
	 */
	protected void setDescription(String description) {

		if(description != null) {
			this.description = description;
		}
	}

	@Override
	public String getCalculatorName() {

		return calculatorName;
	}

	/**
	 * Sets the name of the chromatogram calculator supplier.
	 * 
	 * @param calculatorName
	 */
	protected void setCalculatorName(String calculatorName) {

		if(calculatorName != null) {
			this.calculatorName = calculatorName;
		}
	}

	@Override
	public String getId() {

		return id;
	}

	/**
	 * Sets the chromatogram filter supplier id like
	 * "org.eclipse.chemclipse.chromatogram.msd.calculator.supplier.ri".
	 * 
	 * @param id
	 */
	protected void setId(String id) {

		if(id != null) {
			this.id = id;
		}
	}

	@Override
	public Class<? extends IChromatogramCalculatorSettings> getSettingsClass() {

		return this.settingsClass;
	}

	protected void setSettingsClass(Class<? extends IChromatogramCalculatorSettings> settingsClass) {

		this.settingsClass = settingsClass;
	}

	@Override
	public boolean equals(Object other) {

		if(other == null) {
			return false;
		}
		if(this == other) {
			return true;
		}
		if(this.getClass() != other.getClass()) {
			return false;
		}
		IChromatogramCalculatorSupplier otherSupplier = (IChromatogramCalculatorSupplier)other;
		return id.equals(otherSupplier.getId()) && description.equals(otherSupplier.getDescription()) && calculatorName.equals(otherSupplier.getCalculatorName());
	}

	@Override
	public int hashCode() {

		return 7 * id.hashCode() + 11 * description.hashCode() + 13 * calculatorName.hashCode();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append("[");
		builder.append("id=" + id);
		builder.append(",");
		builder.append("description=" + description);
		builder.append(",");
		builder.append("calculatorName=" + calculatorName);
		builder.append("]");
		return builder.toString();
	}
}
