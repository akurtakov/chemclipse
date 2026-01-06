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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v105.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"precursor"})
public class PrecursorList {

	@XmlElement(required = true)
	private List<PrecursorType> precursor;
	@XmlAttribute(name = "count", required = true)
	private int count;

	public List<PrecursorType> getPrecursor() {

		if(precursor == null) {
			precursor = new ArrayList<>();
		}
		return this.precursor;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int value) {

		this.count = value;
	}
}