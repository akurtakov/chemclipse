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
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A single chromatogram.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChromatogramType", propOrder = {"binaryDataArrayList"})
public class ChromatogramType extends ParamGroupType {

	@XmlElement(required = true)
	protected BinaryDataArrayListType binaryDataArrayList;
	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "nativeID", required = true)
	protected String nativeID;
	@XmlAttribute(name = "index", required = true)
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger index;
	@XmlAttribute(name = "defaultArrayLength", required = true)
	protected int defaultArrayLength;
	@XmlAttribute(name = "dataProcessingRef")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	protected Object dataProcessingRef;

	public BinaryDataArrayListType getBinaryDataArrayList() {

		return binaryDataArrayList;
	}

	public void setBinaryDataArrayList(BinaryDataArrayListType value) {

		this.binaryDataArrayList = value;
	}

	public String getId() {

		return id;
	}

	public void setId(String value) {

		this.id = value;
	}

	public String getNativeID() {

		return nativeID;
	}

	public void setNativeID(String value) {

		this.nativeID = value;
	}

	public BigInteger getIndex() {

		return index;
	}

	public void setIndex(BigInteger value) {

		this.index = value;
	}

	public int getDefaultArrayLength() {

		return defaultArrayLength;
	}

	public void setDefaultArrayLength(int value) {

		this.defaultArrayLength = value;
	}

	public Object getDataProcessingRef() {

		return dataProcessingRef;
	}

	public void setDataProcessingRef(Object value) {

		this.dataProcessingRef = value;
	}
}
