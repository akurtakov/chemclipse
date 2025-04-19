/*******************************************************************************
 * Copyright (c) 2015, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.csd.filter.core.chromatogram;

import org.eclipse.chemclipse.chromatogram.csd.filter.l10n.Messages;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.csd.model.core.selection.IChromatogramSelectionCSD;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;

/**
 * @author Philip Wenig
 */
public abstract class AbstractChromatogramFilterCSD implements IChromatogramFilterCSD {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> validate(IChromatogramSelectionCSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessages(validateChromatogramSelection(chromatogramSelection));
		processingInfo.addMessages(validateFilterSettings(chromatogramFilterSettings));
		return processingInfo;
	}

	// --------------------------------------------private methods
	/**
	 * Validates that chromatogram selection and the stored chromatogram are not
	 * null.
	 * 
	 * @param chromatogramSelection
	 * @return {@link IProcessingInfo}
	 */
	private IProcessingInfo<IChromatogramFilterResult> validateChromatogramSelection(IChromatogramSelectionCSD chromatogramSelection) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		if(chromatogramSelection == null) {
			processingInfo.addErrorMessage(ICategories.CHROMATOGRAM_FILTER, Messages.invalidChromatogramSelection);
		} else {
			if(chromatogramSelection.getChromatogram() == null) {
				processingInfo.addErrorMessage(ICategories.CHROMATOGRAM_FILTER, Messages.invalidChromatogram);
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
	private IProcessingInfo<IChromatogramFilterResult> validateFilterSettings(IChromatogramFilterSettings chromatogramFilterSettings) {

		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		if(chromatogramFilterSettings == null) {
			processingInfo.addErrorMessage(ICategories.CHROMATOGRAM_FILTER, Messages.invalidFilterSettings);
		}
		return processingInfo;
	}
	// --------------------------------------------private methods
}
