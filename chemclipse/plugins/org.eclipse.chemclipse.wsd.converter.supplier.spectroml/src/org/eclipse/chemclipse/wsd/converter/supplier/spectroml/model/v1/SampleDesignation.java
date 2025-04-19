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
package org.eclipse.chemclipse.wsd.converter.supplier.spectroml.model.v1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SampleDesignation {

	@XmlElement(name = "identifier")
	private String identifier;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "owner")
	private Owner owner;
	@XmlElement(name = "location")
	private Location location;
	@XmlElement(name = "casNumber")
	private String casNumber;
	@XmlElement(name = "formula")
	private String formula;
	@XmlElement(name = "storageMethod")
	private String storageMethod;
	@XmlElement(name = "disposalMethod")
	private String disposalMethod;
	@XmlElement(name = "comment")
	private String comment;

	public String getIdentifier() {

		return identifier;
	}

	public void setIdentifier(String identifier) {

		this.identifier = identifier;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Owner getOwner() {

		return owner;
	}

	public void setOwner(Owner owner) {

		this.owner = owner;
	}

	public Location getLocation() {

		return location;
	}

	public void setLocation(Location location) {

		this.location = location;
	}

	public String getCasNumber() {

		return casNumber;
	}

	public void setCasNumber(String casNumber) {

		this.casNumber = casNumber;
	}

	public String getFormula() {

		return formula;
	}

	public void setFormula(String formula) {

		this.formula = formula;
	}

	public String getStorageMethod() {

		return storageMethod;
	}

	public void setStorageMethod(String storageMethod) {

		this.storageMethod = storageMethod;
	}

	public String getDisposalMethod() {

		return disposalMethod;
	}

	public void setDisposalMethod(String disposalMethod) {

		this.disposalMethod = disposalMethod;
	}

	public String getComment() {

		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}
}
