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

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "primingMethodType")
@XmlEnum
public enum PrimingMethodType {

	@XmlEnumValue("oligo-dt")
	OLIGO_DT("oligo-dt"), //
	@XmlEnumValue("random")
	RANDOM("random"), //
	@XmlEnumValue("target-specific")
	TARGET_SPECIFIC("target-specific"), //
	@XmlEnumValue("oligo-dt and random")
	OLIGO_DT_AND_RANDOM("oligo-dt and random"), //
	@XmlEnumValue("other")
	OTHER("other");

	private final String value;

	PrimingMethodType(String v) {

		value = v;
	}

	public String value() {

		return value;
	}

	public static PrimingMethodType fromValue(String v) {

		for(PrimingMethodType c : PrimingMethodType.values()) {
			if(c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
