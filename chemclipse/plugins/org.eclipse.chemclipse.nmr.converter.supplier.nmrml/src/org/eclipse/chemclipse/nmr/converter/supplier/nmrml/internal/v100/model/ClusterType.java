/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.nmr.converter.supplier.nmrml.internal.v100.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterType", propOrder = {"peakList"})
public class ClusterType {

	@XmlElement(required = true)
	protected PeakListType peakList;
	@XmlAttribute(name = "center")
	@XmlSchemaType(name = "anySimpleType")
	protected String center;
	@XmlAttribute(name = "shift")
	@XmlSchemaType(name = "anySimpleType")
	protected String shift;

	public PeakListType getPeakList() {

		return peakList;
	}

	public void setPeakList(PeakListType value) {

		this.peakList = value;
	}

	public String getCenter() {

		return center;
	}

	public void setCenter(String value) {

		this.center = value;
	}

	public String getShift() {

		return shift;
	}

	public void setShift(String value) {

		this.shift = value;
	}
}
