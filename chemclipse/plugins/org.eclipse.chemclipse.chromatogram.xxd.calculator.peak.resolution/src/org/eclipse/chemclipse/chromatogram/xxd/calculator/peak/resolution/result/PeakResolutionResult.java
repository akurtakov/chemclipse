/*******************************************************************************
 * Copyright (c) 2023, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.result;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.AbstractChromatogramClassifierResult;
import org.eclipse.chemclipse.chromatogram.xxd.classifier.result.ResultStatus;
import org.eclipse.chemclipse.model.core.IPeakResolution;

public class PeakResolutionResult extends AbstractChromatogramClassifierResult implements IPeakResolutionResult {

	private List<IPeakResolution> peakResolutions = new ArrayList<>();

	public PeakResolutionResult(ResultStatus resultStatus, String description) {

		super(resultStatus, description);
	}

	@Override
	public List<IPeakResolution> getPeakResolutions() {

		return peakResolutions;
	}
}