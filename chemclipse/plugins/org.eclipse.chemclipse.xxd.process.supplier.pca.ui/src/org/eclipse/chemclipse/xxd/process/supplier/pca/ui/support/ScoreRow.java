/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Lorenz Gerber - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.ui.support;

public class ScoreRow {

	private final String sampleName;
	private final String groupName;
	private final String classification;
	private final String description;
	private final double[] scores;

	public ScoreRow(String sampleName, String groupName, String classification, String description, double[] scores) {

		this.sampleName = sampleName;
		this.groupName = groupName;
		this.classification = classification;
		this.description = description;
		this.scores = scores;
	}

	public String getSampleName() {

		return sampleName;
	}

	public String getGroupName() {

		return groupName;
	}

	public String getClassification() {

		return classification;
	}

	public String getDescription() {

		return description;
	}

	public double[] getScores() {

		return scores;
	}

}
