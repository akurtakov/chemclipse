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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v13.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Information on a dye.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dyeType", propOrder = {"description", "dyeChemistry"})
public class DyeType {

	protected String description;
	@XmlSchemaType(name = "string")
	protected DyeChemistryType dyeChemistry;
	@XmlAttribute(name = "id", required = true)
	protected String id;

	public String getDescription() {

		return description;
	}

	public void setDescription(String value) {

		this.description = value;
	}

	public DyeChemistryType getDyeChemistry() {

		return dyeChemistry;
	}

	public void setDyeChemistry(DyeChemistryType value) {

		this.dyeChemistry = value;
	}

	public String getId() {

		return id;
	}

	public void setId(String value) {

		this.id = value;
	}
}
