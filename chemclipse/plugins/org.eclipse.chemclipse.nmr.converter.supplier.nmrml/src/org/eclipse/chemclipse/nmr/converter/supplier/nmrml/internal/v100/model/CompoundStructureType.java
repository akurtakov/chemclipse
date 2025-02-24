/*******************************************************************************
 *  Copyright (c) 2021, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.converter.supplier.nmrml.internal.v100.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompoundStructureType", propOrder = {"atomList", "bondList"})
public class CompoundStructureType {

	@XmlElement(required = true)
	protected AtomListType atomList;
	@XmlElement(required = true)
	protected BondListType bondList;

	public AtomListType getAtomList() {

		return atomList;
	}

	public void setAtomList(AtomListType value) {

		this.atomList = value;
	}

	public BondListType getBondList() {

		return bondList;
	}

	public void setBondList(BondListType value) {

		this.bondList = value;
	}
}
