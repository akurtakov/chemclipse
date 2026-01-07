/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v104.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adminType", propOrder = {"sampleName", "sampleDescription", "sourceFile", "contact"})
public class AdminType {

	@XmlElement(required = true)
	protected String sampleName;
	protected DescriptionType sampleDescription;
	protected SourceFileType sourceFile;
	@XmlElement(required = true)
	protected List<PersonType> contact;

	public String getSampleName() {

		return sampleName;
	}

	public void setSampleName(String value) {

		this.sampleName = value;
	}

	public DescriptionType getSampleDescription() {

		return sampleDescription;
	}

	public void setSampleDescription(DescriptionType value) {

		this.sampleDescription = value;
	}

	public SourceFileType getSourceFile() {

		return sourceFile;
	}

	public void setSourceFile(SourceFileType value) {

		this.sourceFile = value;
	}

	public List<PersonType> getContact() {

		if(contact == null) {
			contact = new ArrayList<>();
		}
		return this.contact;
	}
}
