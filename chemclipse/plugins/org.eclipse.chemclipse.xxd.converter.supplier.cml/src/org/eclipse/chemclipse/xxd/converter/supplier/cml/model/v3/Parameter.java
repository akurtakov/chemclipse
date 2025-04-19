/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.xxd.converter.supplier.cml.model.v3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Parameter {

	@XmlAttribute(name = "dictRef")
	protected String dictRef;
	@XmlAttribute(name = "title")
	protected String title;
	@XmlValue
	protected String value;

	public String getDictRef() {

		return dictRef;
	}

	public void setDictRef(String value) {

		this.dictRef = value;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String value) {

		this.title = value;
	}

	public String getValue() {

		return value;
	}

	public void setValue(String value) {

		this.value = value;
	}
}
