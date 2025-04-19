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
package org.eclipse.chemclipse.chromatogram.msd.peak.detector.core;

import org.eclipse.chemclipse.chromatogram.msd.peak.detector.settings.IPeakDetectorSettingsMSD;
import org.eclipse.chemclipse.chromatogram.peak.detector.core.AbstractPeakDetectorSupplier;

public class PeakDetectorMSDSupplier extends AbstractPeakDetectorSupplier<IPeakDetectorSettingsMSD> implements IPeakDetectorMSDSupplier {

	public PeakDetectorMSDSupplier(String id, String description, String peakDetectorName) {
		super(id, description, peakDetectorName);
	}

	@Override
	public Class<? extends IPeakDetectorSettingsMSD> getSettingsClass() {

		return super.getSettingsClass();
	}
}
