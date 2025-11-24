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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v10;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Description of the way in which a particular software was used.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataProcessingType", propOrder = {"processingMethod"})
public class DataProcessingType {

	@XmlElement(required = true)
	protected List<ProcessingMethodType> processingMethod;
	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "softwareRef", required = true)
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	protected SoftwareType softwareRef;

	public List<ProcessingMethodType> getProcessingMethod() {

		if(processingMethod == null) {
			processingMethod = new ArrayList<>();
		}
		return this.processingMethod;
	}

	public String getId() {

		return id;
	}

	public void setId(String value) {

		this.id = value;
	}

	public SoftwareType getSoftwareRef() {

		return softwareRef;
	}

	public void setSoftwareRef(SoftwareType value) {

		this.softwareRef = value;
	}
}
