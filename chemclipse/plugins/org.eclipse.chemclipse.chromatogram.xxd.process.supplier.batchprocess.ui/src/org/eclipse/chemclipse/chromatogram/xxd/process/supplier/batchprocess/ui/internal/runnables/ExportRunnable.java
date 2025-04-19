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
package org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.ui.internal.runnables;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.io.JobWriter;
import org.eclipse.chemclipse.chromatogram.xxd.process.supplier.batchprocess.model.BatchProcessJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class ExportRunnable implements IRunnableWithProgress {

	private File file;
	private BatchProcessJob batchProcessJob;

	public ExportRunnable(File file, BatchProcessJob batchProcessJob) {

		this.file = file;
		this.batchProcessJob = batchProcessJob;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			JobWriter jobWriter = new JobWriter();
			jobWriter.writeBatchProcessJob(file, batchProcessJob, monitor);
		} catch(Exception e) {
			throw new InterruptedException("Failed to process the file: " + file.getPath() + ".");
		}
	}
}