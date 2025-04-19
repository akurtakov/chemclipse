/*******************************************************************************
 * Copyright (c) 2018, 2025 Lablicate GmbH.
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
package org.eclipse.chemclipse.ux.extension.pcr.ui.runnables;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.pcr.converter.core.PlateConverterPCR;
import org.eclipse.chemclipse.pcr.model.core.IPlate;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.chemclipse.ux.extension.pcr.ui.l10n.ExtensionMessages;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class PCRExportRunnable implements IRunnableWithProgress {

	private static final Logger logger = Logger.getLogger(PCRExportRunnable.class);
	//
	private File file;
	private IPlate plate;
	private ISupplier supplier;
	private File data = null;

	public PCRExportRunnable(File file, IPlate plate, ISupplier supplier) {

		this.file = file;
		this.plate = plate;
		this.supplier = supplier;
	}

	public File getData() {

		return data;
	}

	@Override
	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask(ExtensionMessages.exportPlate, IProgressMonitor.UNKNOWN);
			IProcessingInfo<File> processingInfo = PlateConverterPCR.convert(file, plate, supplier.getId(), monitor);
			ProcessingInfoPartSupport.getInstance().update(processingInfo);
			data = processingInfo.getProcessingResult();
		} catch(Exception e) {
			logger.error(e);
		} finally {
			monitor.done();
		}
	}
}
