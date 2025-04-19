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
public class DataCalculation {

	@XmlElement(name = "scaleFactor")
	private ScaleFactor scaleFactor;
	@XmlElement(name = "numberPoints")
	private NumberPoints numberPoints;
	@XmlElement(name = "pointIncrement")
	private PointIncrement pointIncrement;
	@XmlElement(name = "startValue")
	private StartValue startValue;
	@XmlElement(name = "comment")
	private String comment;

	public ScaleFactor getScaleFactor() {

		return scaleFactor;
	}

	public void setScaleFactor(ScaleFactor scaleFactor) {

		this.scaleFactor = scaleFactor;
	}

	public NumberPoints getNumberPoints() {

		return numberPoints;
	}

	public void setNumberPoints(NumberPoints numberPoints) {

		this.numberPoints = numberPoints;
	}

	public PointIncrement getPointIncrement() {

		return pointIncrement;
	}

	public void setPointIncrement(PointIncrement pointIncrement) {

		this.pointIncrement = pointIncrement;
	}

	public StartValue getStartValue() {

		return startValue;
	}

	public void setStartValue(StartValue startValue) {

		this.startValue = startValue;
	}

	public String getComment() {

		return comment;
	}

	public void setComment(String comment) {

		this.comment = comment;
	}
}