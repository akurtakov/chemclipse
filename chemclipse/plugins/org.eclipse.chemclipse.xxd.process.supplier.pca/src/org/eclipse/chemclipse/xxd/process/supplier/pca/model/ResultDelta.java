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
 * Philip Wenig - initial API and implementation
 * Lorenz Gerber - add distance
 *******************************************************************************/
package org.eclipse.chemclipse.xxd.process.supplier.pca.model;

import java.util.Objects;

public class ResultDelta {

	private IResultMVA resultPCA = null;
	private double deltaX = 0;
	private double deltaY = 0;
	private double distance = 0;

	public ResultDelta(IResultMVA resultPCA, double deltaX, double deltaY) {

		this.resultPCA = resultPCA;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		this.distance = Math.sqrt(Math.pow(this.deltaX, 2) + Math.pow(this.deltaY, 2));
	}

	public IResultMVA getResultPCA() {

		return resultPCA;
	}

	public double getDeltaX() {

		return deltaX;
	}

	public double getDeltaY() {

		return deltaY;
	}

	public double getDistance() {

		return distance;
	}

	@Override
	public int hashCode() {

		return Objects.hash(resultPCA);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		ResultDelta other = (ResultDelta)obj;
		return Objects.equals(resultPCA, other.resultPCA);
	}

	@Override
	public String toString() {

		return "ResultDelta [resultPCA=" + resultPCA + ", deltaX=" + deltaX + ", deltaY=" + deltaY + ", distance=" + distance + "]";
	}
}