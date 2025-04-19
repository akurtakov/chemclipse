/*******************************************************************************
 * Copyright (c) 2016, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.core.chromatogram;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.settings.IChromatogramCalculatorSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;

public abstract class AbstractChromatogramCalculator implements IChromatogramCalculator {

	private static final String DESCRIPTION = "Chromatogram Calculator";

	@Override
	public IProcessingInfo<?> validate(IChromatogramSelection chromatogramSelection, IChromatogramCalculatorSettings chromatogramCalculatorSettings) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessages(validateChromatogramSelection(chromatogramSelection));
		processingInfo.addMessages(validateCalculatorSettings(chromatogramCalculatorSettings));
		return processingInfo;
	}

	/**
	 * Validates that chromatogram selection and the stored chromatogram are not
	 * null.
	 * 
	 * @param chromatogramSelection
	 * @return {@link IProcessingInfo}
	 */
	private IProcessingInfo<?> validateChromatogramSelection(IChromatogramSelection chromatogramSelection) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		if(chromatogramSelection == null) {
			processingInfo.addErrorMessage(DESCRIPTION, "The chromatogram selection is not valid.");
		} else {
			if(chromatogramSelection.getChromatogram() == null) {
				processingInfo.addErrorMessage(DESCRIPTION, "The chromatogram is not valid.");
			}
		}
		return processingInfo;
	}

	/**
	 * Validates that the filter settings are not null.
	 * 
	 * @param chromatogramFilterSettings
	 * @return {@link IProcessingInfo}
	 */
	private IProcessingInfo<?> validateCalculatorSettings(IChromatogramCalculatorSettings chromatogramFilterSettings) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		if(chromatogramFilterSettings == null) {
			processingInfo.addErrorMessage(DESCRIPTION, "The calculator settings are not valid.");
		}
		return processingInfo;
	}
}
