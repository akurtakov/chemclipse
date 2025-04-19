/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.nmr.converter.supplier.nmrml.internal.v100.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChemicalCompoundType", propOrder = {"identifierList", "structure"})
@XmlSeeAlso({QuantifiedCompoundType.class})
public class ChemicalCompoundType {

	protected CompoundIdentifierListType identifierList;
	protected CompoundStructureType structure;
	@XmlAttribute(name = "name")
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	public CompoundIdentifierListType getIdentifierList() {

		return identifierList;
	}

	public void setIdentifierList(CompoundIdentifierListType value) {

		this.identifierList = value;
	}

	public CompoundStructureType getStructure() {

		return structure;
	}

	public void setStructure(CompoundStructureType value) {

		this.structure = value;
	}

	public String getName() {

		return name;
	}

	public void setName(String value) {

		this.name = value;
	}
}
