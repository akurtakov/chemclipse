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

@XmlType(name = "spectrumTypeType", namespace = "http://www.xml-cml.org/schema")
@XmlEnum
public enum SpectrumType {

	@XmlEnumValue("infrared")
	INFRARED("infrared"), //
	@XmlEnumValue("IR")
	IR("IR"), //
	@XmlEnumValue("massSpectrum")
	MASS_SPECTRUM("massSpectrum"), //
	NMR("NMR"), //
	@XmlEnumValue("UV/VIS")
	UV_VIS("UV/VIS"), //
	@XmlEnumValue("other")
	OTHER("other");

	private final String value;

	SpectrumType(String v) {

		value = v;
	}

	public String value() {

		return value;
	}

	public static SpectrumType fromValue(String v) {

		for(SpectrumType c : SpectrumType.values()) {
			if(c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
