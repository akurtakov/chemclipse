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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumMultiDType", propOrder = {"firstDimensionProcessingParameterSet", "higherDimensionProcessingParameterSet", "projected3DProcessingParamaterSet"})
public class SpectrumMultiDType extends SpectrumType {

	@XmlElement(required = true)
	protected FirstDimensionProcessingParameterSetType firstDimensionProcessingParameterSet;
	@XmlElement(required = true)
	protected List<HigherDimensionProcessingParameterSetType> higherDimensionProcessingParameterSet;
	protected Projected3DProcessingParamaterSetType projected3DProcessingParamaterSet;

	public FirstDimensionProcessingParameterSetType getFirstDimensionProcessingParameterSet() {

		return firstDimensionProcessingParameterSet;
	}

	public void setFirstDimensionProcessingParameterSet(FirstDimensionProcessingParameterSetType value) {

		this.firstDimensionProcessingParameterSet = value;
	}

	public List<HigherDimensionProcessingParameterSetType> getHigherDimensionProcessingParameterSet() {

		if(higherDimensionProcessingParameterSet == null) {
			higherDimensionProcessingParameterSet = new ArrayList<>();
		}
		return this.higherDimensionProcessingParameterSet;
	}

	public Projected3DProcessingParamaterSetType getProjected3DProcessingParamaterSet() {

		return projected3DProcessingParamaterSet;
	}

	public void setProjected3DProcessingParamaterSet(Projected3DProcessingParamaterSetType value) {

		this.projected3DProcessingParamaterSet = value;
	}
}
