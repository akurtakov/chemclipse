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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v13.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Due to the frequent occurrence of this element, names are kept short.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dpAmpCurveType", propOrder = {"cyc", "tmp", "fluor"})
public class DpAmpCurveType {

	protected float cyc;
	protected Float tmp;
	protected float fluor;

	public float getCyc() {

		return cyc;
	}

	public void setCyc(float value) {

		this.cyc = value;
	}

	public Float getTmp() {

		return tmp;
	}

	public void setTmp(Float value) {

		this.tmp = value;
	}

	public float getFluor() {

		return fluor;
	}

	public void setFluor(float value) {

		this.fluor = value;
	}
}
