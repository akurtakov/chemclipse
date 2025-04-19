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

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Measurement {

	@XmlElement(name = "measurementDescription")
	private List<MeasurementDescription> measurementDescriptionList;
	@XmlElement(name = "measurementProperty")
	private List<MeasurementProperty> measurementPropertyList;

	public List<MeasurementDescription> getMeasurementDescriptionList() {

		return measurementDescriptionList;
	}

	public void setMeasurementDescriptionList(List<MeasurementDescription> measurementDescriptionList) {

		this.measurementDescriptionList = measurementDescriptionList;
	}

	public List<MeasurementProperty> getMeasurementPropertyList() {

		return measurementPropertyList;
	}

	public void setMeasurementPropertyList(List<MeasurementProperty> measurementPropertyList) {

		this.measurementPropertyList = measurementPropertyList;
	}
}