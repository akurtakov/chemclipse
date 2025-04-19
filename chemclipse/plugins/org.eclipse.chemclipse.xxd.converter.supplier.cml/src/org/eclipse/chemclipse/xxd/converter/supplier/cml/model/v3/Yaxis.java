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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"array"})
public class Yaxis {

	@XmlElement(name = "array")
	protected Array array;
	@XmlAttribute(name = "multiplierToData")
	protected Double multiplierToData;

	public Array getArray() {

		return array;
	}

	public void setArray(Array array) {

		this.array = array;
	}

	public Double getMultiplierToData() {

		return multiplierToData;
	}

	public void setMultiplierToData(Double multiplierToData) {

		this.multiplierToData = multiplierToData;
	}
}
