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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuantifiedCompoundType", propOrder = {"concentration", "clusterList", "peakList"})
public class QuantifiedCompoundType extends ChemicalCompoundType {

	@XmlElement(required = true)
	protected ValueWithUnitType concentration;
	protected ClusterListType clusterList;
	protected PeakListType peakList;

	public ValueWithUnitType getConcentration() {

		return concentration;
	}

	public void setConcentration(ValueWithUnitType value) {

		this.concentration = value;
	}

	public ClusterListType getClusterList() {

		return clusterList;
	}

	public void setClusterList(ClusterListType value) {

		this.clusterList = value;
	}

	public PeakListType getPeakList() {

		return peakList;
	}

	public void setPeakList(PeakListType value) {

		this.peakList = value;
	}
}
