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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataProperty {

	@XmlElement(name = "dataParameter")
	private DataParameter dataParameter;
	@XmlElement(name = "dataCalculation")
	private DataCalculation dataCalculation;
	@XmlAttribute(name = "dataPropertyId")
	private String dataPropertyId;

	public DataParameter getDataParameter() {

		return dataParameter;
	}

	public void setDataParameter(DataParameter dataParameter) {

		this.dataParameter = dataParameter;
	}

	public DataCalculation getDataCalculation() {

		return dataCalculation;
	}

	public void setDataCalculation(DataCalculation dataCalculation) {

		this.dataCalculation = dataCalculation;
	}

	public String getDataPropertyId() {

		return dataPropertyId;
	}

	public void setDataPropertyId(String dataPropertyId) {

		this.dataPropertyId = dataPropertyId;
	}
}