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

import org.eclipse.chemclipse.chromatogram.csd.peak.detector.settings.IPeakDetectorSettingsCSD;
import org.eclipse.chemclipse.chromatogram.peak.detector.core.AbstractPeakDetectorSupplier;

public class PeakDetectorCSDSupplier extends AbstractPeakDetectorSupplier<IPeakDetectorSettingsCSD> implements IPeakDetectorCSDSupplier {

	public PeakDetectorCSDSupplier(String id, String description, String peakDetectorName) {
		super(id, description, peakDetectorName);
	}

	@Override
	public Class<? extends IPeakDetectorSettingsCSD> getSettingsClass() {

		return super.getSettingsClass();
	}
}
