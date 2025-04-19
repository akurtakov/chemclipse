/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.core;

import org.eclipse.chemclipse.chromatogram.xxd.baseline.detector.settings.IBaselineDetectorSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.IProcessingMessage;
import org.eclipse.chemclipse.processing.core.MessageType;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingMessage;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class AbstractBaselineDetector implements IBaselineDetector {

	private static final String ERROR_DESCRIPTION = "Baseline Detector";

	@Override
	public IProcessingInfo<?> validate(IChromatogramSelection chromatogramSelection, IBaselineDetectorSettings baselineDetectorSettings, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		if(chromatogramSelection == null) {
			IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, ERROR_DESCRIPTION, "The chromatogram selection is invalid.");
			processingInfo.addMessage(processingMessage);
		} else {
			if(chromatogramSelection.getChromatogram() == null) {
				IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, ERROR_DESCRIPTION, "The chromatogram is invalid.");
				processingInfo.addMessage(processingMessage);
			}
		}
		/*
		 * Settings
		 */
		if(baselineDetectorSettings == null) {
			IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, ERROR_DESCRIPTION, "The baseline detector settings are invalid.");
			processingInfo.addMessage(processingMessage);
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<?> validate(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		if(chromatogramSelection == null) {
			IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, ERROR_DESCRIPTION, "The chromatogram selection is invalid.");
			processingInfo.addMessage(processingMessage);
		} else {
			if(chromatogramSelection.getChromatogram() == null) {
				IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, ERROR_DESCRIPTION, "The chromatogram is invalid.");
				processingInfo.addMessage(processingMessage);
			}
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo<?> validate(IBaselineDetectorSettings baselineDetectorSettings, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		/*
		 * Settings
		 */
		if(baselineDetectorSettings == null) {
			IProcessingMessage processingMessage = new ProcessingMessage(MessageType.ERROR, ERROR_DESCRIPTION, "The baseline detector settings are invalid.");
			processingInfo.addMessage(processingMessage);
		}
		return processingInfo;
	}
}