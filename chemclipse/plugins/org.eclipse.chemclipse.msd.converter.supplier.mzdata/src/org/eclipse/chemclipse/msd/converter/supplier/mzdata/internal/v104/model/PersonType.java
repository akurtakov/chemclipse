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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personType", propOrder = {"name", "institution", "contactInfo"})
public class PersonType {

	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	protected String institution;
	protected String contactInfo;

	public String getName() {

		return name;
	}

	public void setName(String value) {

		this.name = value;
	}

	public String getInstitution() {

		return institution;
	}

	public void setInstitution(String value) {

		this.institution = value;
	}

	public String getContactInfo() {

		return contactInfo;
	}

	public void setContactInfo(String value) {

		this.contactInfo = value;
	}
}
