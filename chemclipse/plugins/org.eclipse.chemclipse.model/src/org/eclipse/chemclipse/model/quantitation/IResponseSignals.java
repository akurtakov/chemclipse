/*******************************************************************************
 * Copyright (c) 2013, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.quantitation;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.eclipse.chemclipse.numeric.equations.IQuadraticEquation;
import org.eclipse.chemclipse.numeric.equations.LinearEquation;

/**
 * This must be a list, cause it could contains more than one
 * value for a specific signal.
 */
public interface IResponseSignals extends List<IResponseSignal>, Serializable {

	/**
	 * Returns the linear equation.
	 */
	LinearEquation getLinearEquation(double signal, boolean isCrossZero);

	/**
	 * Returns the quadratic equation.
	 */
	IQuadraticEquation getQuadraticEquation(double signal, boolean isCrossZero);

	/**
	 * Returns the average factor to calculate the unknown concentration
	 * of a known intensity.
	 * 
	 * factor = Concentration Average / Intensity Average
	 * 
	 * Concentration Unknown = factor * Intensity Unknown
	 */
	double getAverageFactor(double signal, boolean isCrossZero);

	double getMinResponseValue(double signal);

	double getMaxResponseValue(double signal);

	/**
	 * Returns the min response value of the stored concentration response entries.
	 * Or 0 if none value is stored.
	 */
	double getMinResponseValue();

	/**
	 * Returns the max response value of the stored concentration response entries.
	 * Or 0 if none value is stored.
	 */
	double getMaxResponseValue();

	/**
	 * Returns the set of used signals.
	 */
	Set<Double> getSignalSet();

	/**
	 * Returns the list of concentration response entries,
	 * denoted by the given signal.
	 */
	List<IResponseSignal> getList(double signal);
}