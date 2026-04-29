/*******************************************************************************
 * Copyright (c) 2012, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.chemclipse.chromatogram.xxd.report.settings.IChromatogramReportSettings;
import org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.internal.support.SpecificationValidator;
import org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.io.ReportWriter1;
import org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.chromatogram.xxd.report.supplier.txt.settings.ReportSettings1;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public class Report1 extends AbstractReport {

	private static final Logger logger = Logger.getLogger(Report1.class);

	@Override
	public IProcessingInfo<File> report(File file, boolean append, List<IChromatogram> chromatograms, IChromatogramReportSettings settings, IProgressMonitor monitor) {

		file = SpecificationValidator.validateSpecification(file);
		IProcessingInfo<File> processingInfo = super.validate(file);

		if(!processingInfo.hasErrorMessages()) {
			ReportWriter1 chromatogramReport = new ReportWriter1();
			try {
				chromatogramReport.generate(file, append, chromatograms, monitor);
				processingInfo.setProcessingResult(file);
			} catch(IOException e) {
				logger.warn(e);
				processingInfo.addErrorMessage("Chromatogram Report", "The report couldn't be created. An error occured.");
			}
		}

		return processingInfo;
	}

	@Override
	public IProcessingInfo<File> generate(File file, boolean append, IChromatogram chromatogram, IProgressMonitor monitor) {

		List<IChromatogram> chromatograms = getChromatogramList(chromatogram);
		ReportSettings1 settings = PreferenceSupplier.getReportSettings1();
		return report(file, append, chromatograms, settings, monitor);
	}

	@Override
	public IProcessingInfo<File> generate(File file, boolean append, List<IChromatogram> chromatograms, IProgressMonitor monitor) {

		ReportSettings1 settings = PreferenceSupplier.getReportSettings1();
		return report(file, append, chromatograms, settings, monitor);
	}
}
