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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.idx.model.v112;

import org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v110.MzMLType;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"mzML", "indexList", "indexListOffset", "fileChecksum"})
@XmlRootElement(name = "indexedmzML")
public class IndexedMzML {

	@XmlElement(required = true)
	protected MzMLType mzML;

	@XmlElement(required = true)
	protected IndexListType indexList;

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long indexListOffset;

	@XmlElement(required = true)
	protected String fileChecksum;

	public MzMLType getMzML() {

		return mzML;
	}

	public void setMzML(MzMLType value) {

		this.mzML = value;
	}

	public IndexListType getIndexList() {

		return indexList;
	}

	public void setIndexList(IndexListType value) {

		this.indexList = value;
	}

	public Long getIndexListOffset() {

		return indexListOffset;
	}

	public void setIndexListOffset(Long value) {

		this.indexListOffset = value;
	}

	public String getFileChecksum() {

		return fileChecksum;
	}

	public void setFileChecksum(String value) {

		this.fileChecksum = value;
	}
}
