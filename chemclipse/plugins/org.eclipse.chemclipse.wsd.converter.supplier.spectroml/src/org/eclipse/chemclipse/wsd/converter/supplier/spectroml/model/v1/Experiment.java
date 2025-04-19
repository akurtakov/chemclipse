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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Experiment {

	@XmlElement(name = "file")
	private File file;
	@XmlElement(name = "instrument")
	private Instrument instrument;
	@XmlElement(name = "sample")
	private Sample sample;
	@XmlElement(name = "measurement")
	private Measurement measurement;
	@XmlElement(name = "data")
	private Data data;
	@XmlAttribute(name = "type")
	private String type;
	@XmlAttribute(name = "language")
	private String language;
	@XmlAttribute(name = "experimentId")
	private String experimentId;

	public File getFile() {

		return file;
	}

	public void setFile(File file) {

		this.file = file;
	}

	public Instrument getInstrument() {

		return instrument;
	}

	public void setInstrument(Instrument instrument) {

		this.instrument = instrument;
	}

	public Sample getSample() {

		return sample;
	}

	public void setSample(Sample sample) {

		this.sample = sample;
	}

	public Measurement getMeasurement() {

		return measurement;
	}

	public void setMeasurement(Measurement measurement) {

		this.measurement = measurement;
	}

	public Data getData() {

		return data;
	}

	public void setData(Data data) {

		this.data = data;
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getLanguage() {

		return language;
	}

	public void setLanguage(String language) {

		this.language = language;
	}

	public String getExperimentId() {

		return experimentId;
	}

	public void setExperimentId(String experimentId) {

		this.experimentId = experimentId;
	}
}