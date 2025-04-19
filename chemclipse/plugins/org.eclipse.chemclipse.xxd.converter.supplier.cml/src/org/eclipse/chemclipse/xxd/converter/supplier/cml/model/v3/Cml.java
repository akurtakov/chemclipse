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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cml")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"spectrum"})
public class Cml {

	@XmlElement(name = "spectrum")
	protected Spectrum spectrum;

	public void setSpectrum(Spectrum spectrum) {

		this.spectrum = spectrum;
	}

	public Spectrum getSpectrum() {

		return spectrum;
	}
}
