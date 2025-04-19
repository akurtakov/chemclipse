/*******************************************************************************
 * Copyright (c) 2020, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.impl;

import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.core.AbstractBaselineDetector;
import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.settings.IBaselineDetectorSettings;
import org.eclipse.chemclipse.model.baseline.IBaselineModel;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class BaselineDelete extends AbstractBaselineDetector {

	@Override
	public IProcessingInfo<?> setBaseline(IChromatogramSelection chromatogramSelection, IBaselineDetectorSettings baselineDetectorSettings, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo = super.validate(chromatogramSelection, baselineDetectorSettings, monitor);
		if(!processingInfo.hasErrorMessages()) {
			if(baselineDetectorSettings instanceof DeleteSettings deleteSettings) {
				IChromatogram chromatogram = chromatogramSelection.getChromatogram();
				IBaselineModel baselineModel = chromatogram.getBaselineModel();
				if(deleteSettings.isDeleteCompletely()) {
					baselineModel.removeBaseline();
				} else {
					int startRetentionTime = chromatogramSelection.getStartRetentionTime();
					int stopRetentionTime = chromatogramSelection.getStopRetentionTime();
					baselineModel.removeBaseline(startRetentionTime, stopRetentionTime);
				}
			}
		}
		return processingInfo;
	}
}