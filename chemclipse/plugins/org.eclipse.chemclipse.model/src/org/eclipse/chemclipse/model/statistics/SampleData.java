/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 * Philip Wenig - improvements
 *******************************************************************************/
package org.eclipse.chemclipse.model.statistics;

public class SampleData<T> implements ISampleData<T> {

	private double data;
	private T dataObject;
	private double normalizedData;

	public SampleData() {
		this.data = Double.NaN;
		this.normalizedData = Double.NaN;
		this.dataObject = null;
	}

	public SampleData(double data, T data2) {
		this();
		this.data = data;
		this.dataObject = data2;
		this.normalizedData = data;
	}

	@Override
	public double getData() {

		return data;
	}

	@Override
	public T getDataObject() {

		return dataObject;
	}

	@Override
	public double getModifiedData() {

		return normalizedData;
	}

	@Override
	public void setModifiedData(double normalizedData) {

		this.normalizedData = normalizedData;
	}
}
