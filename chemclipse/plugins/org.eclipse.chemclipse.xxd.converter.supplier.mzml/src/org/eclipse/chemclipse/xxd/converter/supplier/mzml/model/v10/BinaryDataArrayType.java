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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v10;

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The structure into which encoded binary data goes. Byte ordering is always little endian (Intel style). Computers using a different endian style must convert to/from little endian when writing/reading mzML
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryDataArrayType", propOrder = {"binary"})
public class BinaryDataArrayType extends ParamGroupType {

	@XmlElement(required = true)
	protected byte[] binary;
	@XmlAttribute(name = "arrayLength")
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger arrayLength;
	@XmlAttribute(name = "dataProcessingRef")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	protected Object dataProcessingRef;
	@XmlAttribute(name = "encodedLength", required = true)
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger encodedLength;

	public byte[] getBinary() {

		return binary;
	}

	public void setBinary(byte[] value) {

		this.binary = value;
	}

	public BigInteger getArrayLength() {

		return arrayLength;
	}

	public void setArrayLength(BigInteger value) {

		this.arrayLength = value;
	}

	public Object getDataProcessingRef() {

		return dataProcessingRef;
	}

	public void setDataProcessingRef(Object value) {

		this.dataProcessingRef = value;
	}

	public BigInteger getEncodedLength() {

		return encodedLength;
	}

	public void setEncodedLength(BigInteger value) {

		this.encodedLength = value;
	}
}
