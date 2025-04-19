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
package org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.ui.internal.runnables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import org.eclipse.chemclipse.converter.exceptions.FileIsNotWriteableException;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.io.PeakIdentificationBatchJobWriter;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakIdentificationBatchJob;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class BatchJobExportRunnable implements IRunnableWithProgress {

	private File file;
	private IPeakIdentificationBatchJob peakIdentificationBatchJob;

	public BatchJobExportRunnable(File file, IPeakIdentificationBatchJob peakIdentificationBatchJob) {
		this.file = file;
		this.peakIdentificationBatchJob = peakIdentificationBatchJob;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		PeakIdentificationBatchJobWriter writer = new PeakIdentificationBatchJobWriter();
		try {
			writer.writeBatchProcessJob(file, peakIdentificationBatchJob, monitor);
		} catch(FileNotFoundException e) {
			throw new InterruptedException("The file " + file.getPath() + " couldn't be found.");
		} catch(FileIsNotWriteableException e) {
			throw new InterruptedException("The file " + file.getPath() + " is not writable.");
		} catch(IOException e) {
			throw new InterruptedException("The file " + file.getPath() + " makes problems.");
		} catch(XMLStreamException e) {
			throw new InterruptedException("There is a problem writing the file " + file.getPath());
		}
	}
}
