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

import org.eclipse.chemclipse.chromatogram.peak.detector.core.AbstractPeakDetectorSupplier;
import org.eclipse.chemclipse.chromatogram.vsd.peak.detector.settings.IPeakDetectorSettingsVSD;

public class PeakDetectorVSDSupplier extends AbstractPeakDetectorSupplier<IPeakDetectorSettingsVSD> implements IPeakDetectorVSDSupplier {

	public PeakDetectorVSDSupplier(String id, String description, String peakDetectorName) {

		super(id, description, peakDetectorName);
	}

	@Override
	public Class<? extends IPeakDetectorSettingsVSD> getSettingsClass() {

		return super.getSettingsClass();
	}
}