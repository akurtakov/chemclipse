/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v11.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This element can be used to assign a publisher and id to the RDML file.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rdmlIdType", propOrder = {"publisher", "serialNumber", "md5Hash"})
public class RdmlIdType {

	@XmlElement(required = true)
	protected String publisher;
	@XmlElement(required = true)
	protected String serialNumber;
	@XmlElement(name = "MD5Hash")
	protected String md5Hash;

	public String getPublisher() {

		return publisher;
	}

	public void setPublisher(String value) {

		this.publisher = value;
	}

	public String getSerialNumber() {

		return serialNumber;
	}

	public void setSerialNumber(String value) {

		this.serialNumber = value;
	}

	public String getMD5Hash() {

		return md5Hash;
	}

	public void setMD5Hash(String value) {

		this.md5Hash = value;
	}
}
