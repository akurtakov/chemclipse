/*******************************************************************************
 * Copyright (c) 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.core;

public class LongDataLine {

	private String sampleName;
	private String sampleDetails;
	private String variableName;
	private String variableNameLong;
	private double value;
	private String groupName;
	private String description;

	public LongDataLine(String sampleName, String sampleDetails, String variableName, String variableNameLong, double value, String groupName, String description) {

		this.sampleName = sampleName;
		this.sampleDetails = sampleDetails;
		this.variableName = variableName;
		this.variableNameLong = variableNameLong;
		this.value = value;
		this.groupName = groupName;
		this.description = description;
	}

	public String getSampleName() {

		return sampleName;
	}

	public String getSampleDetails() {

		return sampleDetails;
	}

	public String getVariableName() {

		return variableName;
	}

	public String getVariableNameLong() {

		return variableNameLong;
	}

	public double getValue() {

		return value;
	}

	public String getGroupName() {

		return groupName;
	}

	public String getDescription() {

		return description;
	}
}
