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
package org.eclipse.chemclipse.ux.extension.msd.ui.internal.support;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.msd.converter.massspectrum.MassSpectrumConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class MassSpectrumImportRunnable implements IRunnableWithProgress {

	private static final Logger logger = Logger.getLogger(MassSpectrumImportRunnable.class);
	private File file;
	private IMassSpectra massSpectra;

	public MassSpectrumImportRunnable(File file) {

		this.file = file;
	}

	public IMassSpectra getMassSpectra() {

		return massSpectra;
	}

	@Override
	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask("Import Mass Spectrum", IProgressMonitor.UNKNOWN);
			IProcessingInfo<IMassSpectra> processingInfo = MassSpectrumConverter.convert(file, monitor);
			ProcessingInfoPartSupport.getInstance().update(processingInfo);
			massSpectra = processingInfo.getProcessingResult();
		} catch(Exception e) {
			/*
			 * Exceptions: FileNotFoundException
			 * FileIsNotReadableException FileIsEmptyException
			 */
			logger.warn(e);
		} finally {
			monitor.done();
		}
	}
}
