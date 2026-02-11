/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.fsd.model.core.implementation;

import org.eclipse.chemclipse.fsd.model.core.IPeakModelFSD;
import org.eclipse.chemclipse.fsd.model.core.IScanFSD;
import org.eclipse.chemclipse.model.core.IPeakIntensityValues;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.exceptions.PeakException;
import org.eclipse.chemclipse.model.implementation.PeakModel;

public abstract class AbstractPeakModelFSD extends PeakModel implements IPeakModelFSD {

	private static final long serialVersionUID = 5414428882503370445L;

	protected AbstractPeakModelFSD(IScan peakMaximum, IPeakIntensityValues peakIntensityValues, float startBackgroundIntensity, float stopBackgroundIntensity) throws IllegalArgumentException, PeakException {

		super(peakMaximum, peakIntensityValues, startBackgroundIntensity, stopBackgroundIntensity);
	}

	@Override
	public IScanFSD getPeakMaximum() {

		return (IScanFSD)super.getPeakMaximum();
	}

	@Override
	public IScanFSD getPeakScan(int retentionTime) {

		return (IScanFSD)super.getPeakScan(retentionTime);
	}
}
