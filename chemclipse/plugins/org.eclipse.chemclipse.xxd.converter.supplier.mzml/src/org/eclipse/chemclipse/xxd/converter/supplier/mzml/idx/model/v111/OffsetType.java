/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.idx.model.v111;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OffsetType", propOrder = {"value"})
public class OffsetType {

	@XmlValue
	protected long value;

	@XmlAttribute(name = "idRef", required = true)
	protected String idRef;

	@XmlAttribute(name = "spotID")
	protected String spotID;

	@XmlAttribute(name = "scanTime")
	protected Double scanTime;

	public long getValue() {

		return value;
	}

	public void setValue(long value) {

		this.value = value;
	}

	public String getIdRef() {

		return idRef;
	}

	public void setIdRef(String value) {

		this.idRef = value;
	}

	public String getSpotID() {

		return spotID;
	}

	public void setSpotID(String value) {

		this.spotID = value;
	}

	public Double getScanTime() {

		return scanTime;
	}

	public void setScanTime(Double value) {

		this.scanTime = value;
	}
}
