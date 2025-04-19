/*******************************************************************************
 * Copyright (c) 2008, 2025 Lablicate GmbH.
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

import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class ChromatogramExportRunnable implements IRunnableWithProgress {

	private File data;
	private File file;
	private IChromatogramMSD chromatogram;
	private ISupplier supplier;

	public ChromatogramExportRunnable(File file, IChromatogramMSD chromatogram, ISupplier supplier) {

		this.file = file;
		this.chromatogram = chromatogram;
		this.supplier = supplier;
	}

	/**
	 * Returns the written chromatogram file or null.
	 */
	public File getData() {

		return data;
	}

	@Override
	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			IProcessingInfo<File> processingInfo = ChromatogramConverterMSD.getInstance().convert(file, chromatogram, supplier.getId(), monitor);
			ProcessingInfoPartSupport.getInstance().update(processingInfo);
			data = processingInfo.getProcessingResult();
		} finally {
			monitor.done();
		}
	}
}
