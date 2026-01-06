/*******************************************************************************
 * Copyright (c) 2021, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.nmr.converter.supplier.nmrml.internal.v100.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumListType", propOrder = {"spectrum1D", "spectrumMultiD"})
public class SpectrumListType {

	protected List<Spectrum1DType> spectrum1D;
	protected List<SpectrumMultiDType> spectrumMultiD;

	public List<Spectrum1DType> getSpectrum1D() {

		if(spectrum1D == null) {
			spectrum1D = new ArrayList<>();
		}
		return this.spectrum1D;
	}

	public List<SpectrumMultiDType> getSpectrumMultiD() {

		if(spectrumMultiD == null) {
			spectrumMultiD = new ArrayList<>();
		}
		return this.spectrumMultiD;
	}
}
