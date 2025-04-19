/*******************************************************************************
 * Copyright (c) 2021, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.xxd.ui.runnables;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.tsd.converter.chromatogram.ChromatogramConverterTSD;
import org.eclipse.chemclipse.tsd.model.core.IChromatogramTSD;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class ImportRunnableTSD implements IRunnableWithProgress {

	private static final Logger logger = Logger.getLogger(ImportRunnableTSD.class);
	//
	private File file;
	private IChromatogramTSD chromatogramTSD = null;

	public ImportRunnableTSD(File file) {

		this.file = file;
	}

	public IChromatogramTSD getChromatogram() {

		return chromatogramTSD;
	}

	@Override
	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask("Import Chromatogram", IProgressMonitor.UNKNOWN);
			IProcessingInfo<IChromatogramTSD> processingInfo = ChromatogramConverterTSD.getInstance().convert(file, monitor);
			chromatogramTSD = processingInfo.getProcessingResult();
		} catch(Exception e) {
			logger.error(e);
		} finally {
			monitor.done();
		}
	}
}
