/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.support;

import org.eclipse.chemclipse.numeric.core.IPoint;
import org.eclipse.chemclipse.numeric.equations.LinearEquation;

public interface ITwoPoints {

	/**
	 * Returns the first point.
	 * 
	 * @return IPoint
	 */
	IPoint getPoint1();

	/**
	 * Returns the second point.
	 * 
	 * @return IPoint
	 */
	IPoint getPoint2();

	/**
	 * Returns a linear equation, which can describe the two points.
	 * 
	 * @return {@link LinearEquation}
	 */
	LinearEquation getLinearEquation();

	/**
	 * Returns the slope between both points.
	 * 
	 * @return double
	 */
	double getSlope();
}
