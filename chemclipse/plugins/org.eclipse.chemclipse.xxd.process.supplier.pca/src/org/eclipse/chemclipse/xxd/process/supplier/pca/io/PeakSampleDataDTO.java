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

public class PeakSampleDataDTO {

	private double data = Double.NaN;
	private double normalizedData = Double.NaN;

	public double getData() {

		return data;
	}

	public void setData(double data) {

		this.data = data;
	}

	public double getNormalizedData() {

		return normalizedData;
	}

	public void setNormalizedData(double normalizedData) {

		this.normalizedData = normalizedData;
	}
}
