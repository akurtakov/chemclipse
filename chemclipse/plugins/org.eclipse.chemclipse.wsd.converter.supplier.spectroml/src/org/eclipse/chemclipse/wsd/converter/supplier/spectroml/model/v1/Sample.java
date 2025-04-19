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

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Sample {

	@XmlElement(name = "sampleDescription")
	private List<SampleDescription> sampleDescriptionList;
	@XmlElement(name = "sampleProperty")
	private List<SampleProperty> samplePropertyList;

	public List<SampleDescription> getSampleDescriptionList() {

		return sampleDescriptionList;
	}

	public void setSampleDescriptionList(List<SampleDescription> sampleDescriptionList) {

		this.sampleDescriptionList = sampleDescriptionList;
	}

	public List<SampleProperty> getSamplePropertyList() {

		return samplePropertyList;
	}

	public void setSamplePropertyList(List<SampleProperty> samplePropertyList) {

		this.samplePropertyList = samplePropertyList;
	}
}
