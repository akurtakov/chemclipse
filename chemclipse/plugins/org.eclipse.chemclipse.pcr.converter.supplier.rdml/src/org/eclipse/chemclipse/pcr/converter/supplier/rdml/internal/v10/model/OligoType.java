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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v10.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oligoType", propOrder = {"threePrimeTag", "fivePrimeTag", "sequence"})
public class OligoType {

	protected String threePrimeTag;
	protected String fivePrimeTag;
	@XmlElement(required = true)
	protected String sequence;

	public String getThreePrimeTag() {

		return threePrimeTag;
	}

	public void setThreePrimeTag(String value) {

		this.threePrimeTag = value;
	}

	public String getFivePrimeTag() {

		return fivePrimeTag;
	}

	public void setFivePrimeTag(String value) {

		this.fivePrimeTag = value;
	}

	public String getSequence() {

		return sequence;
	}

	public void setSequence(String value) {

		this.sequence = value;
	}
}
