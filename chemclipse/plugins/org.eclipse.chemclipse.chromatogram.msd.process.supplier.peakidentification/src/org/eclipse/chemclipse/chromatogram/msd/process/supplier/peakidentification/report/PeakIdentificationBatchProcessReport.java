/*******************************************************************************
 * Copyright (c) 2011, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.report;

import org.eclipse.chemclipse.msd.model.core.IPeaksMSD;
import org.eclipse.chemclipse.msd.model.core.PeaksMSD;

public class PeakIdentificationBatchProcessReport implements IPeakIdentificationBatchProcessReport {

	private IPeaksMSD peaks;

	public PeakIdentificationBatchProcessReport() {

		peaks = new PeaksMSD();
	}

	@Override
	public IPeaksMSD getPeaks() {

		return peaks;
	}
}
