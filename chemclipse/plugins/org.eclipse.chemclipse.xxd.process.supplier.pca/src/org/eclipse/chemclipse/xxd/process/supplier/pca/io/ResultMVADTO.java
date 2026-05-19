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
package org.eclipse.chemclipse.xxd.process.supplier.pca.io;

/**
 * The {@code sampleIndex} field references the position of the corresponding
 * sample in the {@link SamplesDTO#getSamples()} list, avoiding object
 * references across the JSON tree.
 */
public class ResultMVADTO {

	private int sampleIndex;
	private boolean displayed = true;
	private double[] scoreVector;
	private double errorMetric;
	private double[] sampleData;
	private boolean selected;

	public int getSampleIndex() {

		return sampleIndex;
	}

	public void setSampleIndex(int sampleIndex) {

		this.sampleIndex = sampleIndex;
	}

	public boolean isDisplayed() {

		return displayed;
	}

	public void setDisplayed(boolean displayed) {

		this.displayed = displayed;
	}

	public double[] getScoreVector() {

		return scoreVector;
	}

	public void setScoreVector(double[] scoreVector) {

		this.scoreVector = scoreVector;
	}

	public double getErrorMetric() {

		return errorMetric;
	}

	public void setErrorMetric(double errorMetric) {

		this.errorMetric = errorMetric;
	}

	public double[] getSampleData() {

		return sampleData;
	}

	public void setSampleData(double[] sampleData) {

		this.sampleData = sampleData;
	}

	public boolean isSelected() {

		return selected;
	}

	public void setSelected(boolean selected) {

		this.selected = selected;
	}
}
