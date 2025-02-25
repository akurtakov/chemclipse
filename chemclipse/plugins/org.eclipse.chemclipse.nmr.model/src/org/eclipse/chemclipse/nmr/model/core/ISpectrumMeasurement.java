/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.nmr.model.core;

import java.util.List;

import org.eclipse.chemclipse.model.core.IComplexSignalMeasurement;

public interface ISpectrumMeasurement extends IComplexSignalMeasurement<ISpectrumSignal> {

	/**
	 * 
	 * @return the Acquisition Parameter for this spectral measurement
	 */
	AcquisitionParameter getAcquisitionParameter();

	/**
	 * Contains the signals of this {@link ISpectrumMeasurement}, ordered with the highest ppm value first
	 * 
	 * @return the signals that makes up this {@link ISpectrumMeasurement}
	 */
	@Override
	List<? extends ISpectrumSignal> getSignals();
}
