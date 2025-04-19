/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamGroupType", propOrder = {"referenceableParamGroupRef", "cvParam", "cvParamWithUnit", "cvTerm", "userParam"})
@XmlSeeAlso({ContactType.class, SourceFileType.class, PulseSequenceType.class, InstrumentConfigurationType.class})
public class ParamGroupType {

	protected List<ReferenceableParamGroupRefType> referenceableParamGroupRef;
	protected List<CVParamType> cvParam;
	protected List<CVParamWithUnitType> cvParamWithUnit;
	protected List<CVTermType> cvTerm;
	protected List<UserParamType> userParam;

	public List<ReferenceableParamGroupRefType> getReferenceableParamGroupRef() {

		if(referenceableParamGroupRef == null) {
			referenceableParamGroupRef = new ArrayList<ReferenceableParamGroupRefType>();
		}
		return this.referenceableParamGroupRef;
	}

	public List<CVParamType> getCvParam() {

		if(cvParam == null) {
			cvParam = new ArrayList<CVParamType>();
		}
		return this.cvParam;
	}

	public List<CVParamWithUnitType> getCvParamWithUnit() {

		if(cvParamWithUnit == null) {
			cvParamWithUnit = new ArrayList<CVParamWithUnitType>();
		}
		return this.cvParamWithUnit;
	}

	public List<CVTermType> getCvTerm() {

		if(cvTerm == null) {
			cvTerm = new ArrayList<CVTermType>();
		}
		return this.cvTerm;
	}

	public List<UserParamType> getUserParam() {

		if(userParam == null) {
			userParam = new ArrayList<UserParamType>();
		}
		return this.userParam;
	}
}
