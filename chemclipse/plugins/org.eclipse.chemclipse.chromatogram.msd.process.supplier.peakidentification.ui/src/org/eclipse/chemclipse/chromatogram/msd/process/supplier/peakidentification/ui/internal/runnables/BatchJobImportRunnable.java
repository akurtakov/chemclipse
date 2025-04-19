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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import org.eclipse.chemclipse.converter.exceptions.FileIsEmptyException;
import org.eclipse.chemclipse.converter.exceptions.FileIsNotReadableException;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.io.IPeakIdentificationBatchJobReader;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.io.PeakIdentificationBatchJobReader;
import org.eclipse.chemclipse.chromatogram.msd.process.supplier.peakidentification.model.IPeakIdentificationBatchJob;

/**
 * @author Dr. Philip Wenig
 * 
 */
public class BatchJobImportRunnable implements IRunnableWithProgress {

	private File file;
	private IPeakIdentificationBatchJob peakIdentificationBatchJob = null;

	public BatchJobImportRunnable(File file) {
		this.file = file;
	}

	public IPeakIdentificationBatchJob getPeakIdentificationBatchJob() {

		return peakIdentificationBatchJob;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		IPeakIdentificationBatchJobReader reader = new PeakIdentificationBatchJobReader();
		try {
			peakIdentificationBatchJob = reader.read(file, monitor);
		} catch(FileNotFoundException e) {
			throw new InterruptedException("The file " + file.getPath() + " couldn't be found.");
		} catch(FileIsNotReadableException e) {
			throw new InterruptedException("The file " + file.getPath() + " is not readable.");
		} catch(FileIsEmptyException e) {
			throw new InterruptedException("The file " + file.getPath() + " is empty.");
		} catch(IOException e) {
			throw new InterruptedException("An I/O error has occured using the file " + file.getPath());
		}
	}
}
