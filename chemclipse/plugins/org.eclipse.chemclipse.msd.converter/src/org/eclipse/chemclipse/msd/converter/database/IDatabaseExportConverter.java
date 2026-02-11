/*******************************************************************************
 * Copyright (c) 2018, 2026 Lablicate GmbH.
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
package org.eclipse.chemclipse.msd.converter.database;

import java.io.File;

import org.eclipse.chemclipse.converter.core.IExportConverter;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IDatabaseExportConverter extends IExportConverter {

	/**
	 * Exports the mass spectrum to the given file.
	 */
	IProcessingInfo<File> convert(File file, IScanMSD massSpectrum, boolean append, IProgressMonitor monitor);

	/**
	 * Exports the mass spectra to the given file.
	 */
	IProcessingInfo<File> convert(File file, IMassSpectra massSpectra, boolean append, IProgressMonitor monitor);

	/**
	 * Checks the mass spectrum instance and throws an exception if the mass
	 * spectrum is null.
	 */
	IProcessingInfo<File> validate(IScanMSD massSpectrum);

	/**
	 * Checks the mass spectra instance and throws an exception if the mass
	 * spectrum is null.
	 */
	IProcessingInfo<File> validate(IMassSpectra massSpectra);
}