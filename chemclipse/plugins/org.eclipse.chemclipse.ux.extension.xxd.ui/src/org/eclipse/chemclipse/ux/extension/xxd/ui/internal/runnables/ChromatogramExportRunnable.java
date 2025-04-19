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
 * Alexander Kerner - Generics
 *******************************************************************************/
package org.eclipse.chemclipse.ux.extension.xxd.ui.internal.runnables;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.chemclipse.csd.converter.chromatogram.ChromatogramConverterCSD;
import org.eclipse.chemclipse.csd.model.core.IChromatogramCSD;
import org.eclipse.chemclipse.fsd.converter.chromatogram.ChromatogramConverterFSD;
import org.eclipse.chemclipse.fsd.model.core.IChromatogramFSD;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.model.types.DataType;
import org.eclipse.chemclipse.msd.converter.chromatogram.ChromatogramConverterMSD;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.processing.converter.ISupplier;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.ui.support.ProcessingInfoPartSupport;
import org.eclipse.chemclipse.wsd.converter.chromatogram.ChromatogramConverterWSD;
import org.eclipse.chemclipse.wsd.model.core.IChromatogramWSD;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

public class ChromatogramExportRunnable implements IRunnableWithProgress {

	private File data;
	private File file;
	private IChromatogram chromatogram;
	private ISupplier supplier;
	private DataType dataType;

	public ChromatogramExportRunnable(File file, IChromatogram chromatogram, ISupplier supplier, DataType dataType) {

		this.file = file;
		this.chromatogram = chromatogram;
		this.supplier = supplier;
		this.dataType = dataType;
	}

	public File getData() {

		return data;
	}

	@Override
	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		try {
			monitor.beginTask("Export Chromatogram", IProgressMonitor.UNKNOWN);
			IProcessingInfo<File> processingInfo = null;
			switch(dataType) {
				case MSD_NOMINAL:
				case MSD_TANDEM:
				case MSD_HIGHRES:
				case MSD:
					if(chromatogram instanceof IChromatogramMSD chromatogramMSD) {
						processingInfo = ChromatogramConverterMSD.getInstance().convert(file, chromatogramMSD, supplier.getId(), monitor);
					}
					break;
				case CSD:
					if(chromatogram instanceof IChromatogramCSD chromatogramCSD) {
						processingInfo = ChromatogramConverterCSD.getInstance().convert(file, chromatogramCSD, supplier.getId(), monitor);
					}
					break;
				case WSD:
					if(chromatogram instanceof IChromatogramWSD chromatogramWSD) {
						processingInfo = ChromatogramConverterWSD.getInstance().convert(file, chromatogramWSD, supplier.getId(), monitor);
					}
					break;
				case FSD:
					if(chromatogram instanceof IChromatogramFSD chromatogramFSD) {
						processingInfo = ChromatogramConverterFSD.getInstance().convert(file, chromatogramFSD, supplier.getId(), monitor);
					}
					break;
				default:
					// Do nothing
			}

			if(processingInfo != null) {
				ProcessingInfoPartSupport.getInstance().update(processingInfo);
				data = processingInfo.getProcessingResult();
			}
		} finally {
			monitor.done();
		}
	}
}
