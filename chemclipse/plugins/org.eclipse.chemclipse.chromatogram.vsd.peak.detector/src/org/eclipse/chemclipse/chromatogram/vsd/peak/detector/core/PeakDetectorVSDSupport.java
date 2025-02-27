/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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