/*******************************************************************************
 * Copyright (c) 2015, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v32.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.Duration;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"parentFile", "msInstrument", "dataProcessing", "separation", "spotting", "scan", "sha1"})
@XmlRootElement(name = "msRun")
public class MsRun {

	@XmlElement(required = true)
	private List<ParentFile> parentFile;
	private List<MsInstrument> msInstrument;
	@XmlElement(required = true)
	private List<DataProcessing> dataProcessing;
	private Separation separation;
	private Spotting spotting;
	@XmlElement(required = true)
	private List<Scan> scan;
	private String sha1;
	@XmlAttribute(name = "scanCount")
	@XmlSchemaType(name = "positiveInteger")
	private BigInteger scanCount;
	@XmlAttribute(name = "startTime")
	private Duration startTime;
	@XmlAttribute(name = "endTime")
	private Duration endTime;

	public List<ParentFile> getParentFile() {

		if(parentFile == null) {
			parentFile = new ArrayList<>();
		}
		return this.parentFile;
	}

	public List<MsInstrument> getMsInstrument() {

		if(msInstrument == null) {
			msInstrument = new ArrayList<>();
		}
		return this.msInstrument;
	}

	public List<DataProcessing> getDataProcessing() {

		if(dataProcessing == null) {
			dataProcessing = new ArrayList<>();
		}
		return this.dataProcessing;
	}

	public Separation getSeparation() {

		return separation;
	}

	public void setSeparation(Separation value) {

		this.separation = value;
	}

	public Spotting getSpotting() {

		return spotting;
	}

	public void setSpotting(Spotting value) {

		this.spotting = value;
	}

	public List<Scan> getScan() {

		if(scan == null) {
			scan = new ArrayList<>();
		}
		return this.scan;
	}

	public String getSha1() {

		return sha1;
	}

	public void setSha1(String value) {

		this.sha1 = value;
	}

	public BigInteger getScanCount() {

		return scanCount;
	}

	public void setScanCount(BigInteger value) {

		this.scanCount = value;
	}

	public Duration getStartTime() {

		return startTime;
	}

	public void setStartTime(Duration value) {

		this.startTime = value;
	}

	public Duration getEndTime() {

		return endTime;
	}

	public void setEndTime(Duration value) {

		this.endTime = value;
	}
}
