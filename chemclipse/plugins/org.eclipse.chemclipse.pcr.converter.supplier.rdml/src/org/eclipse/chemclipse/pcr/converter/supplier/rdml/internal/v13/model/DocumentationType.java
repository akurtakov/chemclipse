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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * These elements should be used if the same description applies to many samples,
 * targets or experiments.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentationType", propOrder = {})
public class DocumentationType {

	protected String text;
	@XmlAttribute(name = "id", required = true)
	protected String id;

	public String getText() {

		return text;
	}

	public void setText(String value) {

		this.text = value;
	}

	public String getId() {

		return id;
	}

	public void setId(String value) {

		this.id = value;
	}
}
