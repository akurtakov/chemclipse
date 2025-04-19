/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.model.core;

/**
 * Extends the {@link ISignal} interface by means of providing access to the complex part of a signal
 * 
 * @author Christoph Läubrich
 *
 */
public interface IComplexSignal extends ISignal {

	/**
	 * 
	 * @return the imaginary part of the y-component
	 */
	public double getImaginaryY();

	default double getMagnitudeY() {

		double i = getImaginaryY();
		double r = getY();
		return Math.sqrt(r * r + i * i);
	}

	default double getPhase() {

		double i = getImaginaryY();
		double r = getY();
		double p = i / r;
		return Math.atan(p);
	}
}
