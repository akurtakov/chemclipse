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
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakIdentificationBatchJob;

public interface IPeakIdentificationBatchJobWriter {

	/**
	 * Writes the peak identification batch job to the given file.
	 * 
	 * @param file
	 * @param peakIdentificationBatchJob
	 * @param monitor
	 * @throws FileNotFoundException
	 * @throws FileIsNotWriteableException
	 * @throws IOException
	 * @throws XMLStreamException
	 */
	void writeBatchProcessJob(File file, IPeakIdentificationBatchJob peakIdentificationBatchJob, IProgressMonitor monitor) throws FileNotFoundException, FileIsNotWriteableException, IOException, XMLStreamException;
}
