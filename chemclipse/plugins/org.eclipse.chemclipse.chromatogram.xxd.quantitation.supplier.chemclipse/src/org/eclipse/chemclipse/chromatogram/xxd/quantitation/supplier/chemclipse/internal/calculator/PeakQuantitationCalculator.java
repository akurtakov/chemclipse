/*******************************************************************************
 * Copyright (c) 2013, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.quantitation.supplier.chemclipse.internal.calculator;

import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.quantitation.settings.IPeakQuantifierSettings;
import org.eclipse.chemclipse.msd.model.core.IPeakMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class PeakQuantitationCalculator {

	public IProcessingInfo<?> quantify(List<IPeakMSD> peaks, IPeakQuantifierSettings peakQuantifierSettings, IProgressMonitor monitor) {

		IProcessingInfo<?> processingInfo = new ProcessingInfo<>();
		return processingInfo;
	}
}
