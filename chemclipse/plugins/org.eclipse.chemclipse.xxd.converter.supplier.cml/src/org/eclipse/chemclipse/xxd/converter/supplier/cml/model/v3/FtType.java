/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.cml.model.v3;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "ftType", namespace = "http://www.xml-cml.org/schema")
@XmlEnum
public enum FtType {

	@XmlEnumValue("raw")
	RAW("raw"), //
	@XmlEnumValue("transformed")
	TRANSFORMED("transformed"), //
	@XmlEnumValue("none")
	NONE("none"), //
	@XmlEnumValue("other")
	OTHER("other");

	private final String value;

	FtType(String v) {

		value = v;
	}

	public String value() {

		return value;
	}

	public static FtType fromValue(String v) {

		for(FtType c : FtType.values()) {
			if(c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
