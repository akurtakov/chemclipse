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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeakType")
public class PeakType {

	@XmlAttribute(name = "center", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String center;
	@XmlAttribute(name = "amplitude")
	@XmlSchemaType(name = "anySimpleType")
	protected String amplitude;
	@XmlAttribute(name = "width")
	@XmlSchemaType(name = "anySimpleType")
	protected String width;

	public String getCenter() {

		return center;
	}

	public void setCenter(String value) {

		this.center = value;
	}

	public String getAmplitude() {

		return amplitude;
	}

	public void setAmplitude(String value) {

		this.amplitude = value;
	}

	public String getWidth() {

		return width;
	}

	public void setWidth(String value) {

		this.width = value;
	}
}
