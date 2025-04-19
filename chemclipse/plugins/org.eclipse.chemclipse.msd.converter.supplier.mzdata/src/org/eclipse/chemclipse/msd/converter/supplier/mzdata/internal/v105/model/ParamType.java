/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v105.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paramType", propOrder = {"cvParamOrUserParam"})
@XmlSeeAlso({DescriptionType.class, Acquisition.class, SpectrumInstrument.class})
public class ParamType {

	@XmlElements({@XmlElement(name = "cvParam", type = CvParamType.class), @XmlElement(name = "userParam", type = UserParamType.class)})
	private List<Object> cvParamOrUserParam;

	public List<Object> getCvParamOrUserParam() {

		if(cvParamOrUserParam == null) {
			cvParamOrUserParam = new ArrayList<Object>();
		}
		return this.cvParamOrUserParam;
	}
}
