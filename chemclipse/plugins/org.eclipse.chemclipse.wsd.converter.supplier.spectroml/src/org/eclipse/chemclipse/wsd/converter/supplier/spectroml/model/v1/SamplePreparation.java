/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.wsd.converter.supplier.spectroml.model.v1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SamplePreparation {

	@XmlElement(name = "procedureMethod")
	private String procedureMethod;
	@XmlElement(name = "timeStamp")
	private TimeStamp timeStamp;
	@XmlElement(name = "operator")
	private Operator operator;
	@XmlElement(name = "supplier")
	private Supplier supplier;
	@XmlElement(name = "preparationDescription")
	private String preparationDescription;
	@XmlElement(name = "comment")
	private String comment;

	public String getProcedureMethod() {

		return procedureMethod;
	}

	public void setProcedureMethod(String procedureMethod) {

		this.procedureMethod = procedureMethod;
	}

	public TimeStamp getTimeStamp() {

		return timeStamp;
	}

	public void setTimeStamp(TimeStamp timeStamp) {

		this.timeStamp = timeStamp;
	}

	public Operator getOperator() {

		return operator;
	}

	public void setOperator(Operator operator) {

		this.operator = operator;
	}

	public Supplier getSupplier() {

		return supplier;
	}

	public void setSupplier(Supplier supplier) {

		this.supplier = supplier;
	}

	public String getPreparationDescription() {

		return preparationDescription;
	}

	public void setPreparationDescription(String preparationDescription) {

		this.preparationDescription = preparationDescription;
	}

	public String getComment() {

		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}
}
