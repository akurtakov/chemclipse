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
package org.eclipse.chemclipse.msd.model.noise;

import org.eclipse.chemclipse.model.support.IAnalysisSegment;
import org.eclipse.chemclipse.msd.model.core.ICombinedMassSpectrum;

public class NoiseSegmentMSD implements INoiseSegmentMSD {

	private IAnalysisSegment analysisSegment;
	private ICombinedMassSpectrum noiseMassSpectrum;

	public NoiseSegmentMSD(IAnalysisSegment analysisSegment, ICombinedMassSpectrum noiseMassSpectrum) {

		this.analysisSegment = analysisSegment;
		this.noiseMassSpectrum = noiseMassSpectrum;
	}

	@Override
	public IAnalysisSegment getAnalysisSegment() {

		return analysisSegment;
	}

	@Override
	public ICombinedMassSpectrum getNoiseMassSpectrum() {

		return noiseMassSpectrum;
	}
}
