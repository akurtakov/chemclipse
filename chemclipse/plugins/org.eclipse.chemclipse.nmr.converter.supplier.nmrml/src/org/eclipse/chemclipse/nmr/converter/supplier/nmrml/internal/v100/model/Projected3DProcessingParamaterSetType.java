/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.converter.supplier.nmrml.internal.v100.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Projected3DProcessingParamaterSetType")
public class Projected3DProcessingParamaterSetType {

	@XmlAttribute(name = "projectionAngle")
	protected Double projectionAngle;
	@XmlAttribute(name = "positiveProjectionMethod")
	protected Boolean positiveProjectionMethod;

	public Double getProjectionAngle() {

		return projectionAngle;
	}

	public void setProjectionAngle(Double value) {

		this.projectionAngle = value;
	}

	public Boolean isPositiveProjectionMethod() {

		return positiveProjectionMethod;
	}

	public void setPositiveProjectionMethod(Boolean value) {

		this.positiveProjectionMethod = value;
	}
}
