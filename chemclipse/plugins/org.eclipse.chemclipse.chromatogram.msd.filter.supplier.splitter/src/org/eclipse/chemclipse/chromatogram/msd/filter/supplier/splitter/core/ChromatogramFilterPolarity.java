/*******************************************************************************
 * Copyright (c) 2025, 2026 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.splitter.core;

import org.eclipse.chemclipse.chromatogram.filter.result.ChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.IChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.chromatogram.filter.settings.IChromatogramFilterSettings;
import org.eclipse.chemclipse.chromatogram.msd.filter.core.chromatogram.AbstractChromatogramFilterMSD;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.Polarity;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.msd.model.implementation.ChromatogramMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramFilterPolarity extends AbstractChromatogramFilterMSD {

	@Override
	public IProcessingInfo<IChromatogramFilterResult> applyFilter(IChromatogramSelectionMSD chromatogramSelection, IChromatogramFilterSettings chromatogramFilterSettings, IProgressMonitor monitor) {

		IProcessingInfo<IChromatogramFilterResult> validation = validate(chromatogramSelection, chromatogramFilterSettings);
		IProcessingInfo<IChromatogramFilterResult> processingInfo = new ProcessingInfo<>();
		processingInfo.addMessages(validation);

		if(!processingInfo.hasErrorMessages()) {
			IChromatogram chromatogram = chromatogramSelection.getChromatogram();
			if(chromatogram instanceof IChromatogramMSD chromatogramMSD) {
				splitByPolarity(chromatogramMSD);
			}
			chromatogramSelection.getChromatogram().setDirty(true);
			processingInfo.setProcessingResult(new ChromatogramFilterResult(ResultStatus.OK, "The chromatogram was splitted into polarity reference chromatograms."));
		}
		return processingInfo;
	}

	private void splitByPolarity(IChromatogramMSD chromatogramMSD) {

		IChromatogramMSD chromatogramReferenceMSD = new ChromatogramMSD();
		chromatogramReferenceMSD.setConverterId(chromatogramMSD.getConverterId());

		chromatogramMSD.getScans().removeIf(scan -> {
			if(scan instanceof IRegularMassSpectrum massSpectrum && massSpectrum.getPolarity() == Polarity.NEGATIVE) {
				chromatogramReferenceMSD.addScan(massSpectrum);
				return true; // remove from chromatogramMSD
			}
			return false;
		});

		chromatogramMSD.addReferencedChromatogram(chromatogramReferenceMSD);
	}
}