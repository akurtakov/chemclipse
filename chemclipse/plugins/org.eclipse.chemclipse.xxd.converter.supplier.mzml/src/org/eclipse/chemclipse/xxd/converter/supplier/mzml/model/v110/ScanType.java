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
package org.eclipse.chemclipse.xxd.converter.supplier.mzml.model.v110;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScanType", propOrder = {"scanWindowList"})
public class ScanType extends ParamGroupType {

	private ScanWindowListType scanWindowList;
	@XmlAttribute(name = "spectrumRef")
	private String spectrumRef;
	@XmlAttribute(name = "sourceFileRef")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	private Object sourceFileRef;
	@XmlAttribute(name = "externalSpectrumID")
	private String externalSpectrumID;
	@XmlAttribute(name = "instrumentConfigurationRef")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	private Object instrumentConfigurationRef;

	public ScanWindowListType getScanWindowList() {

		return scanWindowList;
	}

	public void setScanWindowList(ScanWindowListType value) {

		this.scanWindowList = value;
	}

	public String getSpectrumRef() {

		return spectrumRef;
	}

	public void setSpectrumRef(String value) {

		this.spectrumRef = value;
	}

	public Object getSourceFileRef() {

		return sourceFileRef;
	}

	public void setSourceFileRef(Object value) {

		this.sourceFileRef = value;
	}

	public String getExternalSpectrumID() {

		return externalSpectrumID;
	}

	public void setExternalSpectrumID(String value) {

		this.externalSpectrumID = value;
	}

	public Object getInstrumentConfigurationRef() {

		return instrumentConfigurationRef;
	}

	public void setInstrumentConfigurationRef(Object value) {

		this.instrumentConfigurationRef = value;
	}
}
