/*******************************************************************************
 * Copyright (c) 2023, 2026 Lablicate GmbH.
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

import org.eclipse.chemclipse.chromatogram.vsd.peak.detector.settings.IPeakDetectorSettingsVSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.vsd.model.core.selection.IChromatogramSelectionVSD;
import org.eclipse.core.runtime.IProgressMonitor;

public class AbstractPeakDetectorVSDSignal extends AbstractPeakDetectorVSD {

	@Override
	public IProcessingInfo<?> detect(IChromatogramSelectionVSD chromatogramSelection, IPeakDetectorSettingsVSD peakDetectorSettings, IProgressMonitor monitor) {

		return new ProcessingInfo<>();
	}
}