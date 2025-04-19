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
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactType")
public class ContactType extends ParamGroupType {

	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "fullname", required = true)
	protected String fullname;
	@XmlAttribute(name = "url")
	@XmlSchemaType(name = "anyURI")
	protected String url;
	@XmlAttribute(name = "address")
	protected String address;
	@XmlAttribute(name = "organization")
	protected String organization;
	@XmlAttribute(name = "email", required = true)
	protected String email;

	public String getId() {

		return id;
	}

	public void setId(String value) {

		this.id = value;
	}

	public String getFullname() {

		return fullname;
	}

	public void setFullname(String value) {

		this.fullname = value;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl(String value) {

		this.url = value;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String value) {

		this.address = value;
	}

	public String getOrganization() {

		return organization;
	}

	public void setOrganization(String value) {

		this.organization = value;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String value) {

		this.email = value;
	}
}
