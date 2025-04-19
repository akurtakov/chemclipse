/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v22.model;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ontologyEntryType")
@XmlSeeAlso({MsManufacturer.class, MsMassAnalyzer.class})
public class OntologyEntry implements Serializable {

	private static final long serialVersionUID = 220L;
	@XmlAttribute(name = "category", required = true)
	private String category;
	@XmlAttribute(name = "value", required = true)
	private String theValue;

	public String getCategory() {

		return category;
	}

	public void setCategory(String value) {

		this.category = value;
	}

	public String getTheValue() {

		return theValue;
	}

	public void setTheValue(String value) {

		this.theValue = value;
	}
}
