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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v10.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "measureType")
@XmlEnum
public enum MeasureType {

	@XmlEnumValue("real time")
	REAL_TIME("real time"), @XmlEnumValue("meltcurve")
	MELTCURVE("meltcurve");

	private final String value;

	MeasureType(String v) {

		value = v;
	}

	public String value() {

		return value;
	}

	public static MeasureType fromValue(String v) {

		for(MeasureType c : MeasureType.values()) {
			if(c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
