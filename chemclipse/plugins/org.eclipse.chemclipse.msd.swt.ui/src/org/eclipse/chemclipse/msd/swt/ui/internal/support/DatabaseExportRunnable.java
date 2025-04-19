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
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.msd.swt.ui.internal.support;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.msd.converter.database.DatabaseConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class DatabaseExportRunnable implements IRunnableWithProgress {

	private File data;
	private File file;
	private IMassSpectra massSpectra;
	private ISupplier supplier;

	public DatabaseExportRunnable(File file, IMassSpectra massSpectra, ISupplier supplier) {

		this.file = file;
		this.massSpectra = massSpectra;
		this.supplier = supplier;
	}

	/**
	 * Returns the written database file or null.
	 */
	public File getData() {

		return data;
	}

	@Override
	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask("Export Mass Spectra", IProgressMonitor.UNKNOWN);
			IProcessingInfo<File> processingInfo = DatabaseConverter.convert(file, massSpectra, false, supplier.getId(), monitor);
			ProcessingInfoPartSupport.getInstance().update(processingInfo);
			data = processingInfo.getProcessingResult();
		} finally {
			monitor.done();
		}
	}
}
