/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.vsd.peak.detector.core;

import org.eclipse.chemclipse.chromatogram.peak.detector.core.AbstractPeakDetectorSupport;
import org.eclipse.chemclipse.chromatogram.peak.detector.exceptions.NoPeakDetectorAvailableException;

public class PeakDetectorVSDSupport extends AbstractPeakDetectorSupport<IPeakDetectorVSDSupplier> implements IPeakDetectorVSDSupport {

	public PeakDetectorVSDSupport() {

		super();
	}

	@Override
	public IPeakDetectorVSDSupplier getPeakDetectorSupplier(String id) throws NoPeakDetectorAvailableException {

		return getSupplier(id);
	}
}