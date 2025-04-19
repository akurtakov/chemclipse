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

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This step forms a temperature gradient across the PCR block.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gradientType", propOrder = {"highTemperature", "lowTemperature", "duration", "temperatureChange", "durationChange", "measure", "ramp"})
public class GradientType {

	protected float highTemperature;
	protected float lowTemperature;
	@XmlElement(required = true)
	@XmlSchemaType(name = "positiveInteger")
	protected BigInteger duration;
	protected Float temperatureChange;
	protected Integer durationChange;
	@XmlSchemaType(name = "string")
	protected MeasureType measure;
	protected Float ramp;

	public float getHighTemperature() {

		return highTemperature;
	}

	public void setHighTemperature(float value) {

		this.highTemperature = value;
	}

	public float getLowTemperature() {

		return lowTemperature;
	}

	public void setLowTemperature(float value) {

		this.lowTemperature = value;
	}

	public BigInteger getDuration() {

		return duration;
	}

	public void setDuration(BigInteger value) {

		this.duration = value;
	}

	public Float getTemperatureChange() {

		return temperatureChange;
	}

	public void setTemperatureChange(Float value) {

		this.temperatureChange = value;
	}

	public Integer getDurationChange() {

		return durationChange;
	}

	public void setDurationChange(Integer value) {

		this.durationChange = value;
	}

	public MeasureType getMeasure() {

		return measure;
	}

	public void setMeasure(MeasureType value) {

		this.measure = value;
	}

	public Float getRamp() {

		return ramp;
	}

	public void setRamp(Float value) {

		this.ramp = value;
	}
}
