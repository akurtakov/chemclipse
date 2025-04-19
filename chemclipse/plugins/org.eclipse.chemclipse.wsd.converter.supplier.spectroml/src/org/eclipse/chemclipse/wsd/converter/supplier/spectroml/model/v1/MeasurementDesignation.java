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
public class MeasurementDesignation {

	@XmlElement(name = "identifier")
	private String identifier;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "owner")
	private Owner owner;
	@XmlElement(name = "laboratoryReference")
	private String laboratoryReference;
	@XmlElement(name = "comment")
	private String comment;

	public String getIdentifier() {

		return identifier;
	}

	public void setIdentifier(String identifier) {

		this.identifier = identifier;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public Owner getOwner() {

		return owner;
	}

	public void setOwner(Owner owner) {

		this.owner = owner;
	}

	public String getLaboratoryReference() {

		return laboratoryReference;
	}

	public void setLaboratoryReference(String laboratoryReference) {

		this.laboratoryReference = laboratoryReference;
	}

	public String getComment() {

		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}
}