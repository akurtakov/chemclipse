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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v13.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This element is intended for digital PCR data.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partitionsType", propOrder = {"volume", "endPtTable", "data"})
public class PartitionsType {

	protected float volume;
	protected String endPtTable;
	@XmlElement(required = true)
	protected List<PartitionDataType> data;

	public float getVolume() {

		return volume;
	}

	public void setVolume(float value) {

		this.volume = value;
	}

	public String getEndPtTable() {

		return endPtTable;
	}

	public void setEndPtTable(String value) {

		this.endPtTable = value;
	}

	public List<PartitionDataType> getData() {

		if(data == null) {
			data = new ArrayList<>();
		}
		return this.data;
	}
}
