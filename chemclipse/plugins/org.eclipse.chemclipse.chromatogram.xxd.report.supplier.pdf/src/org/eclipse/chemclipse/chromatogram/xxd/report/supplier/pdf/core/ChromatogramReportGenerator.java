/*******************************************************************************
 * Copyright (c) 2024, 2025 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Matthias Mailänder - initial API and implementation
 *******************************************************************************/
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.pdf.core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.report.chromatogram.AbstractChromatogramReportGenerator;
import org.eclipse.chemclipse.chromatogram.xxd.report.settings.IChromatogramReportSettings;
import org.eclipse.chemclipse.chromatogram.xxd.report.supplier.pdf.io.ReportWriter;
import org.eclipse.chemclipse.chromatogram.xxd.report.supplier.pdf.settings.ReportSettings;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class ChromatogramReportGenerator extends AbstractChromatogramReportGenerator {

	private static final Logger logger = Logger.getLogger(ChromatogramReportGenerator.class);

	@Override
	public IProcessingInfo<?> generate(File file, boolean append, IChromatogram chromatogram, IChromatogramReportSettings chromatogramReportSettings, IProgressMonitor monitor) {

		IProcessingInfo<File> processingInfo = super.validate(file);
		ReportWriter reportWriter = new ReportWriter();
		try {
			if(chromatogramReportSettings instanceof ReportSettings reportSettings) {
				reportWriter.generate(file, append, chromatogram, reportSettings, monitor);
			}
		} catch(IOException e) {
			logger.warn(e);
			processingInfo.addErrorMessage("PDF Report", "Failed to generate report.", e);
		}
		return null;
	}

	@Override
	public IProcessingInfo<?> generate(File file, boolean append, IChromatogram chromatogram, IProgressMonitor monitor) {

		return generate(file, append, chromatogram, new ReportSettings(), monitor);
	}

	@Override
	public IProcessingInfo<?> generate(File file, boolean append, List<IChromatogram> chromatograms, IChromatogramReportSettings chromatogramReportSettings, IProgressMonitor monitor) {

		throw new UnsupportedOperationException();
	}

	@Override
	public IProcessingInfo<?> generate(File file, boolean append, List<IChromatogram> chromatograms, IProgressMonitor monitor) {

		throw new UnsupportedOperationException();
	}
}