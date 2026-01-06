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
package org.eclipse.chemclipse.msd.converter.supplier.mzxml.internal.v21.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"plate", "robot"})
public class Spotting implements Serializable {

	private static final long serialVersionUID = 210L;
	@XmlElement(required = true)
	private List<Plate> plate;
	private Robot robot;

	public List<Plate> getPlate() {

		if(plate == null) {
			plate = new ArrayList<>();
		}
		return this.plate;
	}

	public Robot getRobot() {

		return robot;
	}

	public void setRobot(Robot value) {

		this.robot = value;
	}
}
