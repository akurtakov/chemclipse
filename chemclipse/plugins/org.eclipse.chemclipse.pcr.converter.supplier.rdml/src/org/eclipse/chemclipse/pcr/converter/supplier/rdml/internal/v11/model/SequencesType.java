/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v11.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sequencesType", propOrder = {"forwardPrimer", "reversePrimer", "probe1", "probe2", "amplicon"})
public class SequencesType {

	protected OligoType forwardPrimer;
	protected OligoType reversePrimer;
	protected OligoType probe1;
	protected OligoType probe2;
	protected OligoType amplicon;

	public OligoType getForwardPrimer() {

		return forwardPrimer;
	}

	public void setForwardPrimer(OligoType value) {

		this.forwardPrimer = value;
	}

	public OligoType getReversePrimer() {

		return reversePrimer;
	}

	public void setReversePrimer(OligoType value) {

		this.reversePrimer = value;
	}

	public OligoType getProbe1() {

		return probe1;
	}

	public void setProbe1(OligoType value) {

		this.probe1 = value;
	}

	public OligoType getProbe2() {

		return probe2;
	}

	public void setProbe2(OligoType value) {

		this.probe2 = value;
	}

	public OligoType getAmplicon() {

		return amplicon;
	}

	public void setAmplicon(OligoType value) {

		this.amplicon = value;
	}
}
