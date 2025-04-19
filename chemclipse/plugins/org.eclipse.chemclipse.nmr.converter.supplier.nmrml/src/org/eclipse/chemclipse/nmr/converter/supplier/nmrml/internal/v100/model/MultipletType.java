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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultipletType", propOrder = {"atoms", "multiplicity", "peakList"})
public class MultipletType {

	@XmlElement(required = true)
	protected AtomRefsType atoms;
	@XmlElement(required = true)
	protected CVTermType multiplicity;
	protected PeakListType peakList;
	@XmlAttribute(name = "center", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String center;

	public AtomRefsType getAtoms() {

		return atoms;
	}

	public void setAtoms(AtomRefsType value) {

		this.atoms = value;
	}

	public CVTermType getMultiplicity() {

		return multiplicity;
	}

	public void setMultiplicity(CVTermType value) {

		this.multiplicity = value;
	}

	public PeakListType getPeakList() {

		return peakList;
	}

	public void setPeakList(PeakListType value) {

		this.peakList = value;
	}

	public String getCenter() {

		return center;
	}

	public void setCenter(String value) {

		this.center = value;
	}
}
