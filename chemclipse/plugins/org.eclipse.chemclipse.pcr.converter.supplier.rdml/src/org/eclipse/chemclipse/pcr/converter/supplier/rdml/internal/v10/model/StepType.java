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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v10.model;

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stepType", propOrder = {"nr", "description", "temperature", "gradient", "loop", "pause", "lidOpen"})
public class StepType {

	@XmlElement(required = true)
	@XmlSchemaType(name = "positiveInteger")
	protected BigInteger nr;
	protected String description;
	protected TemperatureType temperature;
	protected GradientType gradient;
	protected LoopType loop;
	protected PauseType pause;
	protected LidOpenType lidOpen;

	public BigInteger getNr() {

		return nr;
	}

	public void setNr(BigInteger value) {

		this.nr = value;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String value) {

		this.description = value;
	}

	public TemperatureType getTemperature() {

		return temperature;
	}

	public void setTemperature(TemperatureType value) {

		this.temperature = value;
	}

	public GradientType getGradient() {

		return gradient;
	}

	public void setGradient(GradientType value) {

		this.gradient = value;
	}

	public LoopType getLoop() {

		return loop;
	}

	public void setLoop(LoopType value) {

		this.loop = value;
	}

	public PauseType getPause() {

		return pause;
	}

	public void setPause(PauseType value) {

		this.pause = value;
	}

	public LidOpenType getLidOpen() {

		return lidOpen;
	}

	public void setLidOpen(LidOpenType value) {

		this.lidOpen = value;
	}
}
