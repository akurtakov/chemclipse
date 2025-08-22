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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.ui.provider;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.peak.resolution.result.IPeakResolutionResult;
import org.eclipse.chemclipse.model.core.IMeasurementResult;
import org.eclipse.chemclipse.model.core.IPeakResolution;
import org.eclipse.jface.viewers.IStructuredContentProvider;

public class PeakResolutionResultsContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {

		if(inputElement instanceof IMeasurementResult) {
			IMeasurementResult<?> measurementResult = (IMeasurementResult<?>)inputElement;
			Object object = measurementResult.getResult();
			if(object instanceof IPeakResolutionResult result) {
				List<IPeakResolution> peakResolutions = result.getPeakResolutions();
				return peakResolutions.toArray();
			}
		}

		return new Object[0];
	}
}
