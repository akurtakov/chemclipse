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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v104.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supDescType", propOrder = {"supDataDesc", "sourceFile"})
public class SupDescType {

	protected DescriptionType supDataDesc;
	protected List<SourceFileType> sourceFile;
	@XmlAttribute(name = "supDataArrayRef", required = true)
	protected int supDataArrayRef;

	public DescriptionType getSupDataDesc() {

		return supDataDesc;
	}

	public void setSupDataDesc(DescriptionType value) {

		this.supDataDesc = value;
	}

	public List<SourceFileType> getSourceFile() {

		if(sourceFile == null) {
			sourceFile = new ArrayList<>();
		}
		return this.sourceFile;
	}

	public int getSupDataArrayRef() {

		return supDataArrayRef;
	}

	public void setSupDataArrayRef(int value) {

		this.supDataArrayRef = value;
	}
}
