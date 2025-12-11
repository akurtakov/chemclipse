/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.model.wavelengths;

import java.util.Collection;
import java.util.Set;

import org.eclipse.chemclipse.model.core.IMarkedTraces;

public interface IMarkedWavelengths extends IMarkedTraces<IMarkedWavelength> {

	/**
	 * Returns the set of wavelengths.
	 * 
	 * @return Set<Double>
	 */
	Set<Float> getWavelengths();

	/**
	 * Adds the ion range with magnification factor = 1.
	 * 
	 * @param wavelength
	 */
	void add(float... wavelength);

	void add(Collection<? extends Number> wavelengths);
}
