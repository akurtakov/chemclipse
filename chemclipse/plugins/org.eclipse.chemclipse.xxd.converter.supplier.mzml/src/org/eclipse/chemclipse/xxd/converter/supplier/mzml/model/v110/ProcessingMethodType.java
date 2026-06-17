/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v110;

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessingMethodType")
public class ProcessingMethodType extends ParamGroupType {

	@XmlAttribute(name = "order", required = true)
	@XmlSchemaType(name = "nonNegativeInteger")
	private BigInteger order;

	@XmlAttribute(name = "softwareRef", required = true)
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	private Object softwareRef;

	public BigInteger getOrder() {

		return order;
	}

	public void setOrder(BigInteger value) {

		this.order = value;
	}

	public Object getSoftwareRef() {

		return softwareRef;
	}

	public void setSoftwareRef(Object value) {

		this.softwareRef = value;
	}
}
