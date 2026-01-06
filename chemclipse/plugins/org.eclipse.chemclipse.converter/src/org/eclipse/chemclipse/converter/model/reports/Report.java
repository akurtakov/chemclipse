/*******************************************************************************
 * Copyright (c) 2017, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.converter.model.reports;

import java.util.ArrayList;
import java.util.List;

public class Report<T extends IReportPeak> implements IReport<T> {

	private int reportNumber;
	private String name;
	private double totalArea;
	private int numberOfExpectedPeaks;
	private List<T> reportPeaks;

	public Report() {

		reportPeaks = new ArrayList<>();
	}

	@Override
	public int getReportNumber() {

		return reportNumber;
	}

	@Override
	public void setReportNumber(int reportNumber) {

		this.reportNumber = reportNumber;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public void setName(String name) {

		this.name = name;
	}

	@Override
	public double getTotalArea() {

		return totalArea;
	}

	@Override
	public void setTotalArea(double totalArea) {

		this.totalArea = totalArea;
	}

	@Override
	public double getCalculatedTotalArea() {

		double calculatedTotalArea = 0.0d;
		for(T reportPeak : reportPeaks) {
			calculatedTotalArea += reportPeak.getArea();
		}
		return calculatedTotalArea;
	}

	@Override
	public int getNumberOfExpectedPeaks() {

		return numberOfExpectedPeaks;
	}

	@Override
	public void setNumberOfExpectedPeaks(int numberOfExpectedPeaks) {

		this.numberOfExpectedPeaks = numberOfExpectedPeaks;
	}

	@Override
	public List<T> getReportPeaks() {

		return reportPeaks;
	}

	/**
	 * This is a cross-check to validate that the
	 * data has been imported correctly.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isVerfied() {

		return totalArea == getCalculatedTotalArea();
	}
}
