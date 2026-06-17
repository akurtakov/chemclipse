/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v110;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChromatogramListType", propOrder = {"chromatogram"})
public class ChromatogramListType {

	@XmlElement(required = true)
	private List<ChromatogramType> chromatogram;

	@XmlAttribute(name = "count", required = true)
	@XmlSchemaType(name = "nonNegativeInteger")
	private BigInteger count;

	@XmlAttribute(name = "defaultDataProcessingRef", required = true)
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	private Object defaultDataProcessingRef;

	public List<ChromatogramType> getChromatogram() {

		if(chromatogram == null) {
			chromatogram = new ArrayList<>();
		}
		return this.chromatogram;
	}

	public BigInteger getCount() {

		return count;
	}

	public void setCount(BigInteger value) {

		this.count = value;
	}

	public Object getDefaultDataProcessingRef() {

		return defaultDataProcessingRef;
	}

	public void setDefaultDataProcessingRef(Object value) {

		this.defaultDataProcessingRef = value;
	}
}
