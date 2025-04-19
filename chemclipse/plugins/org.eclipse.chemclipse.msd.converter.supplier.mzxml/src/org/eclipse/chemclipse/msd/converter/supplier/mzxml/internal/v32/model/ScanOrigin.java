/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v32.model;

import java.io.Serializable;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ScanOrigin implements Serializable {

	private static final long serialVersionUID = 320L;
	@XmlAttribute(name = "parentFileID", required = true)
	private String parentFileID;
	@XmlAttribute(name = "num", required = true)
	@XmlSchemaType(name = "nonNegativeInteger")
	private BigInteger num;

	public String getParentFileID() {

		return parentFileID;
	}

	public void setParentFileID(String value) {

		this.parentFileID = value;
	}

	public BigInteger getNum() {

		return num;
	}

	public void setNum(BigInteger value) {

		this.num = value;
	}
}
