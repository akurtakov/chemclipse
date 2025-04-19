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
package org.eclipse.chemclipse.wsd.converter.supplier.spectroml.model.v1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SampleProperty {

	@XmlElement(name = "sampleAttribute")
	private SampleAttribute sampleAttribute;
	@XmlElement(name = "sampleParameter")
	private SampleParameter sampleParameter;
	@XmlAttribute(name = "samplePropertyId")
	private String samplePropertyId;

	public SampleAttribute getSampleAttribute() {

		return sampleAttribute;
	}

	public void setSampleAttribute(SampleAttribute sampleAttribute) {

		this.sampleAttribute = sampleAttribute;
	}

	public SampleParameter getSampleParameter() {

		return sampleParameter;
	}

	public void setSampleParameter(SampleParameter sampleParameter) {

		this.sampleParameter = sampleParameter;
	}

	public String getSamplePropertyId() {

		return samplePropertyId;
	}

	public void setSamplePropertyId(String samplePropertyId) {

		this.samplePropertyId = samplePropertyId;
	}
}