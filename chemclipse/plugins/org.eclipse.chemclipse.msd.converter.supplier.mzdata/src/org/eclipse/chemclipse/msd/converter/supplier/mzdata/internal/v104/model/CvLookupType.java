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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v104.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cvLookupType")
public class CvLookupType {

	@XmlAttribute(name = "cvLabel", required = true)
	protected String cvLabel;
	@XmlAttribute(name = "fullName")
	protected String fullName;
	@XmlAttribute(name = "version", required = true)
	protected String version;
	@XmlAttribute(name = "address", required = true)
	@XmlSchemaType(name = "anyURI")
	protected String address;

	public String getCvLabel() {

		return cvLabel;
	}

	public void setCvLabel(String value) {

		this.cvLabel = value;
	}

	public String getFullName() {

		return fullName;
	}

	public void setFullName(String value) {

		this.fullName = value;
	}

	public String getVersion() {

		return version;
	}

	public void setVersion(String value) {

		this.version = value;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String value) {

		this.address = value;
	}
}
