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

@XmlType(name = "peakMultiplicityType", namespace = "http://www.xml-cml.org/schema")
@XmlEnum
public enum PeakMultiplicityType {

	@XmlEnumValue("singlet")
	SINGLET("singlet"), //
	@XmlEnumValue("doublet")
	DOUBLET("doublet"), //
	@XmlEnumValue("triplet")
	TRIPLET("triplet"), //
	@XmlEnumValue("quartet")
	QUARTET("quartet"), //
	@XmlEnumValue("quintet")
	QUINTET("quintet"), //
	@XmlEnumValue("sextuplet")
	SEXTUPLET("sextuplet"), //
	@XmlEnumValue("multiplet")
	MULTIPLET("multiplet"), //
	@XmlEnumValue("other")
	OTHER("other");

	private final String value;

	PeakMultiplicityType(String v) {

		value = v;
	}

	public String value() {

		return value;
	}

	public static PeakMultiplicityType fromValue(String v) {

		for(PeakMultiplicityType c : PeakMultiplicityType.values()) {
			if(c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
