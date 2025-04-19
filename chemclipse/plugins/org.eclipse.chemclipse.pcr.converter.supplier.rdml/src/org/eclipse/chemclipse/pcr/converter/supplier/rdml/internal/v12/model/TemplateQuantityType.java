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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "templateQuantityType", propOrder = {"conc", "nucleotide"})
public class TemplateQuantityType {

	protected float conc;
	@XmlElement(required = true)
	@XmlSchemaType(name = "string")
	protected NucleotideType nucleotide;

	public float getConc() {

		return conc;
	}

	public void setConc(float value) {

		this.conc = value;
	}

	public NucleotideType getNucleotide() {

		return nucleotide;
	}

	public void setNucleotide(NucleotideType value) {

		this.nucleotide = value;
	}
}
