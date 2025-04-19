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
package org.eclipse.chemclipse.msd.converter.supplier.mzdata.internal.v104.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataProcessingType", propOrder = {"software", "processingMethod"})
public class DataProcessingType {

	@XmlElement(required = true)
	protected DataProcessingType.Software software;
	protected ParamType processingMethod;

	public DataProcessingType.Software getSoftware() {

		return software;
	}

	public void setSoftware(DataProcessingType.Software value) {

		this.software = value;
	}

	public ParamType getProcessingMethod() {

		return processingMethod;
	}

	public void setProcessingMethod(ParamType value) {

		this.processingMethod = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Software extends SoftwareType {
	}
}
