/*******************************************************************************
 * Copyright (c) 2019, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Christoph Läubrich - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.msd.filter.core.massspectrum;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.osgi.service.component.annotations.Component;

@Component(service = IProcessTypeSupplier.class)
public class PeakMassSpectrumFilterProcessTypeSupplier extends AbstractChromatogramSelectionMassSpectrumFilterProcessTypeSupplier {

	public PeakMassSpectrumFilterProcessTypeSupplier() {

		super(ICategories.PEAK_MASS_SPECTRUM_FILTER, "mzfilter.msd.peak.", new Function<IChromatogramSelection, List<IScanMSD>>() {

			@Override
			public List<IScanMSD> apply(IChromatogramSelection chromatogramSelection) {

				List<IScanMSD> massspectras = new ArrayList<>();
				List<?> peaks = chromatogramSelection.getChromatogram().getPeaks(chromatogramSelection);
				for(Object object : peaks) {
					if(object instanceof IPeakMSD peakMSD) {
						massspectras.add(peakMSD.getExtractedMassSpectrum());
					}
				}
				return massspectras;
			}
		});
	}
}
