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

import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.model.selection.IChromatogramSelection;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.ICategories;
import org.eclipse.chemclipse.processing.supplier.IProcessTypeSupplier;
import org.osgi.service.component.annotations.Component;

@Component(service = IProcessTypeSupplier.class)
public class ScanMassSpectrumFilterProcessTypeSupplier extends AbstractChromatogramSelectionMassSpectrumFilterProcessTypeSupplier {

	public ScanMassSpectrumFilterProcessTypeSupplier() {

		super(ICategories.SCAN_MASS_SPECTRUM_FILTER, "mzfilter.msd.scan.", new Function<IChromatogramSelection, List<IScanMSD>>() {

			@Override
			public List<IScanMSD> apply(IChromatogramSelection chromatogramSelection) {

				List<IScanMSD> massspectras = new ArrayList<>();
				IChromatogram chromatogram = chromatogramSelection.getChromatogram();
				int startScan = chromatogram.getScanNumber(chromatogramSelection.getStartRetentionTime());
				int stopScan = chromatogram.getScanNumber(chromatogramSelection.getStopRetentionTime());
				for(int scanIndex = startScan; scanIndex <= stopScan; scanIndex++) {
					IScan scan = chromatogram.getScan(scanIndex);
					if(scan instanceof IScanMSD scanMSD) {
						massspectras.add(scanMSD);
					}
				}
				return massspectras;
			}
		});
	}
}
