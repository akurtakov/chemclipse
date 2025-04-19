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
package org.eclipse.chemclipse.pcr.converter.supplier.rdml.internal.v12.model;

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This step keeps a constant temperature on the heat block.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "temperatureType", propOrder = {"temperature", "duration", "temperatureChange", "durationChange", "measure", "ramp"})
public class TemperatureType {

	protected float temperature;
	@XmlElement(required = true)
	@XmlSchemaType(name = "positiveInteger")
	protected BigInteger duration;
	protected float temperatureChange;
	protected int durationChange;
	@XmlSchemaType(name = "string")
	protected MeasureType measure;
	protected float ramp;

	public float getTemperature() {

		return temperature;
	}

	public void setTemperature(float value) {

		this.temperature = value;
	}

	public BigInteger getDuration() {

		return duration;
	}

	public void setDuration(BigInteger value) {

		this.duration = value;
	}

	public float getTemperatureChange() {

		return temperatureChange;
	}

	public void setTemperatureChange(float value) {

		this.temperatureChange = value;
	}

	public int getDurationChange() {

		return durationChange;
	}

	public void setDurationChange(int value) {

		this.durationChange = value;
	}

	public MeasureType getMeasure() {

		return measure;
	}

	public void setMeasure(MeasureType value) {

		this.measure = value;
	}

	public float getRamp() {

		return ramp;
	}

	public void setRamp(float value) {

		this.ramp = value;
	}
}
