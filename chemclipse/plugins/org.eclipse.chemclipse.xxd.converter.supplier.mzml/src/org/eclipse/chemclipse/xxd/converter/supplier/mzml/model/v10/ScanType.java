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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The instrument's 'run time' parameters; common to the whole of this spectrum.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScanType", propOrder = {"scanWindowList"})
public class ScanType extends ParamGroupType {

	@XmlElement(required = true)
	protected ScanWindowListType scanWindowList;
	@XmlAttribute(name = "instrumentConfigurationRef")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	protected Object instrumentConfigurationRef;

	public ScanWindowListType getScanWindowList() {

		return scanWindowList;
	}

	public void setScanWindowList(ScanWindowListType value) {

		this.scanWindowList = value;
	}

	public Object getInstrumentConfigurationRef() {

		return instrumentConfigurationRef;
	}

	public void setInstrumentConfigurationRef(Object value) {

		this.instrumentConfigurationRef = value;
	}
}
