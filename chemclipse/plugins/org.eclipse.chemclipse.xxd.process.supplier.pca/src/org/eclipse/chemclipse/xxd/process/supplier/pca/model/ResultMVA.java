/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 * Jan Holy - implementation
 * Lorenz Gerber - add select
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import org.eclipse.chemclipse.model.statistics.ISample;

public class ResultMVA implements IResultMVA {

	private ISample sample;
	private boolean isDisplayed;
	private double[] scoreVector;
	private double errorMetric;
	private double[] sampleData;
	private boolean isSelected;

	public ResultMVA(ISample sample) {

		this.isDisplayed = true;
		this.sample = sample;
		this.isSelected = false;
	}

	@Override
	public double[] getScoreVector() {

		return scoreVector;
	}

	@Override
	public double getErrorMetric() {

		return errorMetric;
	}

	@Override
	public ISample getSample() {

		return sample;
	}

	@Override
	public double[] getSampleData() {

		return sampleData;
	}

	@Override
	public boolean isDisplayed() {

		return isDisplayed;
	}

	@Override
	public void setDisplayed(boolean displayed) {

		this.isDisplayed = displayed;
	}

	@Override
	public void setScoreVector(double[] scoreVector) {

		this.scoreVector = scoreVector;
	}

	@Override
	public void setErrorMetric(double errorMetric) {

		this.errorMetric = errorMetric;
	}

	@Override
	public void setSampleData(double[] sampleData) {

		this.sampleData = sampleData;
	}

	@Override
	public void toggleSelected() {

		if(this.isSelected) {
			this.isSelected = false;
		} else {
			this.isSelected = true;
		}
	}

	@Override
	public boolean isSelected() {

		return this.isSelected;
	}

	@Override
	public void setCrossValidations(double[] crossValidation) {

	}

	@Override
	public void setCumulativeCrossValidations(double[] cumulativeCrossValidation) {

	}
}