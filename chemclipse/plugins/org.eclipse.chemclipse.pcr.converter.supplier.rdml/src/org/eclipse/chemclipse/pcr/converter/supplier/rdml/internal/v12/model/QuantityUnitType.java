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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v12.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "quantityUnitType")
@XmlEnum
public enum QuantityUnitType {

	@XmlEnumValue("cop")
	COP("cop"), //
	@XmlEnumValue("fold")
	FOLD("fold"), //
	@XmlEnumValue("dil")
	DIL("dil"), //
	@XmlEnumValue("ng")
	NG("ng"), //
	@XmlEnumValue("nMol")
	N_MOL("nMol"), //
	@XmlEnumValue("other")
	OTHER("other");

	private final String value;

	QuantityUnitType(String v) {

		value = v;
	}

	public String value() {

		return value;
	}

	public static QuantityUnitType fromValue(String v) {

		for(QuantityUnitType c : QuantityUnitType.values()) {
			if(c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
