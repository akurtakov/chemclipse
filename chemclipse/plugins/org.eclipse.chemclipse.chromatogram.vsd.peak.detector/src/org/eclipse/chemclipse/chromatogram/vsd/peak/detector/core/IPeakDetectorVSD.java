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

import org.eclipse.chemclipse.chromatogram.peak.detector.core.IPeakDetector;
import org.eclipse.chemclipse.chromatogram.vsd.peak.detector.settings.IPeakDetectorSettingsVSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.vsd.model.core.selection.IChromatogramSelectionVSD;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IPeakDetectorVSD extends IPeakDetector {

	IProcessingInfo<?> detect(IChromatogramSelectionVSD chromatogramSelection, IPeakDetectorSettingsVSD peakDetectorSettings, IProgressMonitor monitor);

	default IProcessingInfo<?> detect(IChromatogramSelectionVSD chromatogramSelection, IProgressMonitor monitor) {

		return detect(chromatogramSelection, null, monitor);
	}
}