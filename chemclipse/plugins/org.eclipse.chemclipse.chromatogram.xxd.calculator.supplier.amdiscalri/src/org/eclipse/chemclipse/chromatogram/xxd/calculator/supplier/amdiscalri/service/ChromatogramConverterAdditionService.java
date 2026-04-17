/*******************************************************************************
 * Copyright (c) 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.service;

import java.io.File;

import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.io.AMDISConverter;
import org.eclipse.chemclipse.chromatogram.xxd.calculator.supplier.amdiscalri.preferences.PreferenceSupplier;
import org.eclipse.chemclipse.converter.services.IChromatogramConverterAdditionService;
import org.eclipse.chemclipse.logging.core.Logger;
import org.eclipse.chemclipse.model.columns.ISeparationColumnIndices;
import org.eclipse.chemclipse.model.core.IChromatogram;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;

public class ChromatogramConverterAdditionService implements IChromatogramConverterAdditionService {

	private static final Logger logger = Logger.getLogger(ChromatogramConverterAdditionService.class);

	@Override
	public String getName() {

		return "AMDIS Calibration File Autoloader";
	}

	@Override
	public String getVersion() {

		Bundle bundle = FrameworkUtil.getBundle(getClass());
		Version version = bundle.getVersion();
		return version.getMajor() + "." + version.getMinor() + "." + version.getMicro();
	}

	@Override
	public String getDescription() {

		return "This service tries to apply a calibration file from the same folder.";
	}

	@Override
	public void parseAdditionalData(IChromatogram chromatogram) {

		if(!PreferenceSupplier.isParseRetentionIndexDataAMDIS()) {
			return;
		}

		if(chromatogram == null) {
			return;
		}

		logger.info("Searching for AMDIS calibration file.");

		File file = chromatogram.getFile();
		File directory = getDirectory(file);
		if(directory != null && directory.exists()) {
			parseCalibrationAMDIS(chromatogram, directory);
		}
	}

	private File getDirectory(File file) {

		File directory = null;
		if(file != null) {
			if(file.isFile()) {
				directory = file.getParentFile();
			} else {
				directory = file;
			}
		}

		return directory;
	}

	private void parseCalibrationAMDIS(IChromatogram chromatogram, File directory) {

		if(PreferenceSupplier.isParseRetentionIndexDataAMDIS()) {
			String fileName = PreferenceSupplier.isUseChromatogramNameAMDIS() ? chromatogram.getName() : PreferenceSupplier.getDefaultNameAMDIS();
			File file = getFile(directory, fileName, ".cal");

			if(file != null) {
				AMDISConverter amdisConverter = new AMDISConverter();
				IProcessingInfo<ISeparationColumnIndices> processingInfo = amdisConverter.parseRetentionIndices(file);
				ISeparationColumnIndices separationColumnIndices = processingInfo.getProcessingResult();
				chromatogram.getSeparationColumnIndices().putAll(separationColumnIndices);
			}
		}
	}

	private File getFile(File directory, String fileName, String fileExtension) {

		if(directory.exists()) {
			for(File file : directory.listFiles()) {
				if(file.isFile()) {
					String name = file.getName().toLowerCase();
					if(name.endsWith(fileExtension.toLowerCase()) && name.startsWith(fileName.toLowerCase())) {
						return file;
					}
				}
			}
		}

		return null;
	}
}
