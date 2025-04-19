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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A quantity is always defined by its value and its unit.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quantityType", propOrder = {"value", "unit"})
public class QuantityType {

	protected float value;
	@XmlElement(required = true)
	@XmlSchemaType(name = "string")
	protected QuantityUnitType unit;

	public float getValue() {

		return value;
	}

	public void setValue(float value) {

		this.value = value;
	}

	public QuantityUnitType getUnit() {

		return unit;
	}

	public void setUnit(QuantityUnitType value) {

		this.unit = value;
	}
}
