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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstrumentConfigurationType", propOrder = {"componentList", "softwareRef"})
public class InstrumentConfigurationType extends ParamGroupType {

	private ComponentListType componentList;

	private SoftwareRefType softwareRef;

	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	private String id;

	@XmlAttribute(name = "scanSettingsRef")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	private Object scanSettingsRef;

	public ComponentListType getComponentList() {

		return componentList;
	}

	public void setComponentList(ComponentListType value) {

		this.componentList = value;
	}

	public SoftwareRefType getSoftwareRef() {

		return softwareRef;
	}

	public void setSoftwareRef(SoftwareRefType value) {

		this.softwareRef = value;
	}

	public String getId() {

		return id;
	}

	public void setId(String value) {

		this.id = value;
	}

	public Object getScanSettingsRef() {

		return scanSettingsRef;
	}

	public void setScanSettingsRef(Object value) {

		this.scanSettingsRef = value;
	}
}
