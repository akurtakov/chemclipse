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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceableParamGroupListType", propOrder = {"referenceableParamGroup"})
public class ReferenceableParamGroupListType {

	@XmlElement(required = true)
	protected List<ReferenceableParamGroupType> referenceableParamGroup;

	public List<ReferenceableParamGroupType> getReferenceableParamGroup() {

		if(referenceableParamGroup == null) {
			referenceableParamGroup = new ArrayList<ReferenceableParamGroupType>();
		}
		return this.referenceableParamGroup;
	}
}
