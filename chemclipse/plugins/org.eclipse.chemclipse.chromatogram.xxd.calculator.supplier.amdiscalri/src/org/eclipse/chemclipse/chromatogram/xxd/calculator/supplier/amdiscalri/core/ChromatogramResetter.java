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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.core;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.core.chromatogram.AbstractChromatogramCalculator;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.settings.IChromatogramCalculatorSettings;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.impl.RetentionIndexCalculator;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.settings.ResetterSettings;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramResetter extends AbstractChromatogramCalculator {

	@Override
	public IProcessingInfo<?> applyCalculator(IChromatogramSelection chromatogramSelection, IChromatogramCalculatorSettings chromatogramCalculatorSettings, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();

		if(chromatogramCalculatorSettings instanceof ResetterSettings resetterSettings) {
			RetentionIndexCalculator calculator = new RetentionIndexCalculator();
			IProcessingInfo<?> calculatorInfo = calculator.resetIndices(chromatogramSelection, resetterSettings);
			chromatogramSelection.getChromatogram().setDirty(true);
			processingInfo.addMessages(calculatorInfo);
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<?> applyCalculator(IChromatogramSelection chromatogramSelection, IProgressMonitor monitor) {

		ResetterSettings resetterSettings = PreferenceSupplier.getChromatogramResetterSettings();
		return applyCalculator(chromatogramSelection, resetterSettings, monitor);
	}
}
