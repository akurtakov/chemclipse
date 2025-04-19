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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.io;

import java.io.File;
import java.io.IOException;

import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakIdentificationBatchJob;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IPeakIdentificationBatchJobReader {

	/**
	 * Reads the file and returns an IPeakIdentificationBatchJob instance.
	 * 
	 * @param file
	 * @param monitor
	 * @return {@link IPeakIdentificationBatchJob}
	 * @throws IOException
	 */
	IPeakIdentificationBatchJob read(File file, IProgressMonitor monitor) throws IOException;
}
