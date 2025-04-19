/*******************************************************************************
 * Copyright (c) 2017, 2025 Lablicate GmbH.
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

public class ReportPeak implements IReportPeak {

	private int retentionTime;
	private int startRetentionTime;
	private int stopRetentionTime;
	private double area;
	private String substance = "";
	private String units = "";

	@Override
	public int getRetentionTime() {

		return retentionTime;
	}

	@Override
	public void setRetentionTime(int retentionTime) {

		this.retentionTime = retentionTime;
	}

	@Override
	public int getStartRetentionTime() {

		return startRetentionTime;
	}

	@Override
	public void setStartRetentionTime(int startRetentionTime) {

		this.startRetentionTime = startRetentionTime;
	}

	@Override
	public int getStopRetentionTime() {

		return stopRetentionTime;
	}

	@Override
	public void setStopRetentionTime(int stopRetentionTime) {

		this.stopRetentionTime = stopRetentionTime;
	}

	@Override
	public double getArea() {

		return area;
	}

	@Override
	public void setArea(double area) {

		this.area = area;
	}

	@Override
	public String getSubstance() {

		return substance;
	}

	@Override
	public void setSubstance(String substance) {

		this.substance = substance;
	}

	@Override
	public String getUnits() {

		return units;
	}

	@Override
	public void setUnits(String units) {

		this.units = units;
	}

	@Override
	public String toString() {

		return "Peak [retentionTime=" + retentionTime + ", startRetentionTime=" + startRetentionTime + ", stopRetentionTime=" + stopRetentionTime + ", area=" + area + ", substance=" + substance + ", units=" + units + "]";
	}
}
