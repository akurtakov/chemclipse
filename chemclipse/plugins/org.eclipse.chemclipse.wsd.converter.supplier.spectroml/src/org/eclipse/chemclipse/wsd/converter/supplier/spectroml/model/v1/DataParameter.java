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
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.wsd.converter.supplier.spectroml.model.v1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataParameter {

	@XmlElement(name = "axisLabel")
	private AxisLabel axisLabel;
	@XmlElement(name = "axisUnit")
	private AxisUnit axisUnit;
	@XmlElement(name = "minimumValue")
	private MinimumValue minimumValue;
	@XmlElement(name = "maximumValue")
	private MaximumValue maximumValue;
	@XmlElement(name = "comment")
	private String comment;

	public AxisLabel getAxisLabel() {

		return axisLabel;
	}

	public void setAxisLabel(AxisLabel axisLabel) {

		this.axisLabel = axisLabel;
	}

	public AxisUnit getAxisUnit() {

		return axisUnit;
	}

	public void setAxisUnit(AxisUnit axisUnit) {

		this.axisUnit = axisUnit;
	}

	public MinimumValue getMinimumValue() {

		return minimumValue;
	}

	public void setMinimumValue(MinimumValue minimumValue) {

		this.minimumValue = minimumValue;
	}

	public MaximumValue getMaximumValue() {

		return maximumValue;
	}

	public void setMaximumValue(MaximumValue maximumValue) {

		this.maximumValue = maximumValue;
	}

	public String getComment() {

		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}
}