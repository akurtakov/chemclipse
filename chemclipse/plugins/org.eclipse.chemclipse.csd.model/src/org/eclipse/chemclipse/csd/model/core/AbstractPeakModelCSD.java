/*******************************************************************************
 * Copyright (c) 2014, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.csd.model.core;

import org.eclipse.chemclipse.model.core.IPeakIntensityValues;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.exceptions.PeakException;
import org.eclipse.chemclipse.model.implementation.PeakModel;

public abstract class AbstractPeakModelCSD extends PeakModel implements IPeakModelCSD {

	private static final long serialVersionUID = 1580595192753292038L;

	protected AbstractPeakModelCSD(IScan peakMaximum, IPeakIntensityValues peakIntensityValues, float startBackgroundAbundance, float stopBackgroundAbundance) throws IllegalArgumentException, PeakException {

		super(peakMaximum, peakIntensityValues, startBackgroundAbundance, stopBackgroundAbundance);
	}
}