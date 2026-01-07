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
@XmlType(name = "QuantifiedCompoundListType", propOrder = {"quantifiedCompound"})
public class QuantifiedCompoundListType {

	@XmlElement(required = true)
	protected List<QuantifiedCompoundType> quantifiedCompound;

	public List<QuantifiedCompoundType> getQuantifiedCompound() {

		if(quantifiedCompound == null) {
			quantifiedCompound = new ArrayList<>();
		}
		return this.quantifiedCompound;
	}
}
