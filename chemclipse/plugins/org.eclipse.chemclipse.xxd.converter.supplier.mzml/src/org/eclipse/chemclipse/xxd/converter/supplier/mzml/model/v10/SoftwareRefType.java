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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Reference to a previously defined software element
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoftwareRefType")
public class SoftwareRefType {

	@XmlAttribute(name = "ref", required = true)
	@XmlSchemaType(name = "IDREF")
	protected String ref;

	public String getRef() {

		return ref;
	}

	public void setRef(String value) {

		this.ref = value;
	}
}
