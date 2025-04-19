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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v12.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * These elements should be used to annotate samples by setting a
 * property and a value. A property could be sex, the value M or F.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annotationType", propOrder = {})
public class AnnotationType {

	@XmlElement(required = true)
	protected String property;
	@XmlElement(required = true)
	protected String value;

	public String getProperty() {

		return property;
	}

	public void setProperty(String value) {

		this.property = value;
	}

	public String getValue() {

		return value;
	}

	public void setValue(String value) {

		this.value = value;
	}
}
