/*******************************************************************************
 * Copyright (c) 2010, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.filter.supplier.denoising.result;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.filter.result.AbstractChromatogramFilterResult;
import org.eclipse.chemclipse.chromatogram.filter.result.ResultStatus;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;

public class DenoisingFilterResult extends AbstractChromatogramFilterResult implements IDenoisingFilterResult {

	private List<ICombinedMassSpectrum> noiseMassSpectra;

	public DenoisingFilterResult(ResultStatus resultStatus, String description) {

		super(resultStatus, description);
		this.noiseMassSpectra = new ArrayList<>();
	}

	public DenoisingFilterResult(ResultStatus resultStatus, String description, List<ICombinedMassSpectrum> noiseMassSpectra) {

		super(resultStatus, description);
		if(noiseMassSpectra != null) {
			this.noiseMassSpectra = noiseMassSpectra;
		} else {
			this.noiseMassSpectra = new ArrayList<>();
		}
	}

	@Override
	public List<ICombinedMassSpectrum> getNoiseMassSpectra() {

		return noiseMassSpectra;
	}
}
