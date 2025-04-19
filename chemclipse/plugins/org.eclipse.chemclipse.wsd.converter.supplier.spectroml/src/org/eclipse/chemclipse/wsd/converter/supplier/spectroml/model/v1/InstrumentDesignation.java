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
public class InstrumentDesignation {

	@XmlElement(name = "identifier")
	private String identifier;
	@XmlElement(name = "manufacturer")
	private String manufacturer;
	@XmlElement(name = "model")
	private String model;
	@XmlElement(name = "owner")
	private String owner;
	@XmlElement(name = "location")
	private Location location;
	@XmlElement(name = "comment")
	private String comment;

	public String getIdentifier() {

		return identifier;
	}

	public void setIdentifier(String identifier) {

		this.identifier = identifier;
	}

	public String getManufacturer() {

		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {

		this.manufacturer = manufacturer;
	}

	public String getModel() {

		return model;
	}

	public void setModel(String model) {

		this.model = model;
	}

	public String getOwner() {

		return owner;
	}

	public void setOwner(String owner) {

		this.owner = owner;
	}

	public Location getLocation() {

		return location;
	}

	public void setLocation(Location location) {

		this.location = location;
	}

	public String getComment() {

		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}
}
