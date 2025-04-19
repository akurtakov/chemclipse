/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jan Holy - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.csd.peak.detector.core;

import org.eclipse.chemclipse.chromatogram.peak.detector.core.AbstractPeakDetectorSupport;
import org.eclipse.chemclipse.chromatogram.peak.detector.exceptions.NoPeakDetectorAvailableException;

public class PeakDetectorCSDSupport extends AbstractPeakDetectorSupport<IPeakDetectorCSDSupplier> implements IPeakDetectorCSDSupport {

	public PeakDetectorCSDSupport() {
		super();
	}

	@Override
	public IPeakDetectorCSDSupplier getPeakDetectorSupplier(String peakDetectorId) throws NoPeakDetectorAvailableException {

		return getSupplier(peakDetectorId);
	}
}
