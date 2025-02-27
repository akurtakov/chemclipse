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

	@Override
	public IProcessingInfo<?> detect(IChromatogramSelectionVSD chromatogramSelection, IProgressMonitor monitor) {

		return new ProcessingInfo<>();
	}
}