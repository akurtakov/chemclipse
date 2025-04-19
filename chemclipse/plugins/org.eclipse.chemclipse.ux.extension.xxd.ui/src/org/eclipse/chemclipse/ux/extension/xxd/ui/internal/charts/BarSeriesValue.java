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
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.charts;

import org.eclipse.swt.graphics.Point;

public class BarSeriesValue {

	private double x;
	private double y;
	private Point point;

	public BarSeriesValue(double x, double y, Point point) {
		this.x = x;
		this.y = y;
		this.point = point;
	}

	public double getX() {

		return x;
	}

	public double getY() {

		return y;
	}

	public Point getPoint() {

		return point;
	}
}
